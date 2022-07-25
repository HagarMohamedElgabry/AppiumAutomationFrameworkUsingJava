/**
 * CommandReader class is class responsible for executing any Command .
 *
 * @author Hagar Abdelsamad Elgabry
 */

package com.appium.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandReader {

    public static void executeCommand(String command) throws IOException {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Process getProcessCommand(String command) throws IOException{
        return  Runtime.getRuntime().exec(command);
    }

    public static String execCmd(String cmd) throws IOException {
        java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

}
