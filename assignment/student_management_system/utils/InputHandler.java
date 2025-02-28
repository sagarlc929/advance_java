package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String getString() {
        try {

            return br.readLine();
        } catch (IOException e) {
            System.out.println("Error while reading from console.\n Details:");
            e.printStackTrace();
            return "";
        }
    }

    public static int getInt() {
        try {

            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("Error while reading from console.\n Details:");
            e.printStackTrace();
            return 0;
        }
    }
}
