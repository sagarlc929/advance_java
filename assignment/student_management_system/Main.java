import utils.InputHandler;
import models.StudentModel;
import services.StudentService;
import utils.ConsoleOutput;
import java.sql.*;
import models.TableModel;

class Main {
    public static void main(String[] args) {
        boolean cycleFlag = true;
        while (cycleFlag) {
            showOptions();
            int choice = InputHandler.getInt();
            if (choice == 0) {
                cycleFlag = false;
                System.out.println("Exiting...");
            } else {
                switch (choice) {
                    case 1 -> {
                        int id;
                        String name;
                        int age;
                        String course;
                        StudentModel newStu;
                        StudentService newStuService;
                        boolean isSavedNewStu;

                        System.out.print("Enter student id: ");
                        id = InputHandler.getInt();
                        System.out.print("Enter student name: ");
                        name = InputHandler.getString();
                        System.out.print("Enter student age: ");
                        age = InputHandler.getInt();
                        System.out.print("Enter student course: ");
                        course = InputHandler.getString();

                        newStu = new StudentModel(id, name, age, course);
                        newStuService = new StudentService();
                        isSavedNewStu = newStuService.saveNewStudent(newStu);
                        if (isSavedNewStu) {
                            ConsoleOutput.showSuccess("New student saved successfully.");
                        } else {
                            ConsoleOutput.showError("failed to save new student.");
                        }

                    }
                    case 2 -> {
                        StudentService newStuService;
                        newStuService = new StudentService();
                        TableModel allStudentTable;
                        allStudentTable = newStuService.getAllStuTable();
                        ConsoleOutput.showDataSetTable(allStudentTable);
                    }
                    case 3 -> {
                        int id;
                        boolean isSuccess;
                        StudentService newStudentService = new StudentService();
                        System.out.print("Enter student id: ");
                        id = InputHandler.getInt();
                        isSuccess = newStudentService.deleteStuWithId(id);
                        if (isSuccess) {
                            ConsoleOutput.showSuccess("Student with id:" + id + " deleted successfully.");
                        } else {
                            ConsoleOutput.showError("Failed to delete student with id:" + id);
                        }

                    }
                }
            }
        }
    }

    public static void showOptions() {
        String[] options = { "0. exit", "1. create user", "2. show all user",
                "3. delete user with id",
                "4. update with id" };
        System.out.println("<=== Student Management System ===>");
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose a option: ");
    }
}
