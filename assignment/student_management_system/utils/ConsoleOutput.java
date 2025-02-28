package utils;

import models.TableModel;
import java.sql.*;

public class ConsoleOutput {
    public static void showSuccess(String message) {
        String successText = "Success";
        int offset = 5;
        int messageLength = message.length() + successText.length() + offset;
        for (int i = 0; i <= messageLength; i++) {
            System.out.print("*");
        }
        System.out.printf("\n* %s, %s *\n", successText, message);
        for (int i = 0; i <= messageLength; i++) {
            System.out.print("*");
        }
        System.out.print("\n");
    }

    public static void showError(String message) {
        String failedText = "Failed";
        int offset = 4;
        int messageLength = message.length() + failedText.length() + offset;
        for (int i = 0; i <= messageLength; i++) {
            System.out.print("#");
        }
        System.out.printf("\n# %s, %s #\n", failedText, message);
        for (int i = 0; i <= messageLength; i++) {
            System.out.println("#");
        }
        System.out.print("\n");
    }

    public static void showDataSetTable(TableModel tableData) {
        String[] headings = tableData.getTableHeadings();
        int colCount = headings.length;
        String[][] tableBody = tableData.getTableData();
        int rowCount = tableBody.length;
        System.out.println("***********************");
        for (int i = 0; i < colCount; i++) {
            System.out.printf("%s\t", headings[i]);
        }
        for (int i = 0; i < rowCount - 1; i++) {
            for (int j = 0; j < colCount; j++) {
                System.out.printf("%s\t", tableBody[i][j]);
            }
            System.out.println("");
        }
        for (int i = 0; i < colCount; i++) {
            System.out.printf("%s\t", headings[i]);
        }
        System.out.println("***********************");
    }

}
