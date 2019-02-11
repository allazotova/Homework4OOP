package com.aqacourses.test.student;

import com.aqacourses.test.interfaces.ParseFileInterface;
import com.aqacourses.test.interfaces.WriteToDbInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentPed extends Student implements ParseFileInterface, WriteToDbInterface {

    private FileWriter fileWriter;
    private PrintWriter printWriter;

    @Override
    public List<String> parseFile(String pathToFile) {

        List<String> data = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(pathToFile));) {

            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                data.add(name);
            }

            String surname = scanner.nextLine();
            if (!surname.isEmpty()) {
                data.add(surname);
            }

            String age = scanner.nextLine();
            if (!age.isEmpty()) {
                data.add(age);
            }

            String sex = scanner.nextLine();
            if (!sex.isEmpty()) {
                data.add(sex);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return data;

    }

    @Override
    public void writeToDb(List<String> data) {
        try {
            openConnectionToDb();
            if (validateData(data)) {
                for (String datum : data) {
                    printWriter.println(getDate() + " - " + datum);
                }
                printWriter.print("=====================\n");
                System.out.println("All data is written to MS SQL DB");
                closeConnectionToDb();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Open connection to MySQL DB
     */
    private void openConnectionToDb() throws IOException {
        String path = "/Users/alla/Documents/student.txt";
        fileWriter = new FileWriter(path);
        printWriter = new PrintWriter(fileWriter);
    }

    /**
     * CLose connection to MySQL DB
     */
    private void closeConnectionToDb() throws IOException {
        printWriter.close();
        fileWriter.close();
        System.out.println("Close connection to MS SQL DB");
    }
}

