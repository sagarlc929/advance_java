package services;

import utils.ConsoleOutput;
import utils.Db;
import models.StudentModel;
import java.sql.*;

import models.TableModel;

public class StudentService {
    PreparedStatement preSta;
    Statement sta;
    String sql;
    Connection conn;

    public StudentService() {
        Db newDb = new Db();
        conn = newDb.getConnection();
    }

    public boolean saveNewStudent(StudentModel student) {
        try {

            String sql = "INSERT INTO student (id, name, age,course) VALUES (?,?,?,?);";
            preSta = conn.prepareStatement(sql);

            preSta.setInt(1, student.getId());
            preSta.setString(2, student.getName());
            preSta.setInt(3, student.getAge());
            preSta.setString(4, student.getCourse());
            preSta.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the PreparedStatement to prevent the resource leaks
            try {
                if (preSta != null) {
                    preSta.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public TableModel getAllStuTable() {
        ResultSet allStuResultSet = null;
        TableModel allStudentTable = new TableModel(); // Ensure it's initialized
        int rowCount = 0;

        try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT * FROM student;";
            allStuResultSet = stmt.executeQuery(sql); // Execute the query

            ResultSetMetaData metaData = allStuResultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Get row count
            if (allStuResultSet.last()) {
                rowCount = allStuResultSet.getRow();
                allStuResultSet.beforeFirst(); // Reset cursor to before the first row
            }

            // Initialize arrays
            String[] headings = new String[columnCount];
            String[] dataType = new String[columnCount];
            String[][] bodyData = new String[rowCount][columnCount];

            // Get column names and types
            for (int i = 0; i < columnCount; i++) { // Fix index range
                headings[i] = metaData.getColumnName(i + 1); // Column indexes start at 1
                dataType[i] = metaData.getColumnTypeName(i + 1);
            }

            // Fetch table data
            int rowIndex = 0;
            while (allStuResultSet.next()) {
                for (int colIndex = 0; colIndex < columnCount; colIndex++) {
                    bodyData[rowIndex][colIndex] = allStuResultSet.getString(colIndex + 1);
                }
                rowIndex++;
            }

            // Set table data
            allStudentTable.setTableHeadings(headings);
            allStudentTable.setTableData(bodyData);
            return allStudentTable;
        } catch (SQLException e) {
            System.out.println("Failed to fetch data.\nDetails:");
            e.printStackTrace();
        }

        return allStudentTable;
    }

    public boolean deleteStuWithId(int id) {
        int rowEffected = 0;
        try {

            String sql = "DELETE FROM student where id=?;";
            preSta = conn.prepareStatement(sql);

            preSta.setInt(1, id);
            rowEffected = preSta.executeUpdate();
            System.out.println(rowEffected);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rowEffected <= 0) {
            return false;
        }
        return true;
    }
}
