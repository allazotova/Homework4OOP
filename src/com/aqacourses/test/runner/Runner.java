package com.aqacourses.test.runner;

import com.aqacourses.test.student.Student;
import com.aqacourses.test.student.StudentMogilyanka;
import com.aqacourses.test.student.StudentNki;
import com.aqacourses.test.student.StudentPed;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
/*
        // Create instance of NKI student
        StudentNki studentNki = new StudentNki();

        // Imagine that GUI opens
        studentNki.openGui();

        // Parse data
        List<String> data = studentNki.parseData();

        // Write data to 'DB'
        studentNki.writeToDb(data);

        // Clear list for reusing
        data.clear();

        // Create instance of Mogilyanka student
        StudentMogilyanka studentMogilyanka = new StudentMogilyanka();

        // Imagine that GUI opens one more time
        studentMogilyanka.openGui();

        // Parse data again
        data = studentMogilyanka.parseData();

        // Write data to another 'DB'
        studentMogilyanka.writeToDb(data);

        // Clear list for reusing
        data.clear();

        // Create instance of Pedin student
        StudentPed studentPed = new StudentPed();

        // Imagine that GUI opens one more time
        studentPed.openGui();

        // Parse data again
        data = studentPed.parseData();

        // Write data to another 'DB'
        studentPed.writeToDb(data);

        // It's possible to create instance of class in that way
        // using inheritance
        //Student student1 = new StudentMogilyanka();ata.get(2)
        //Student student2 = new StudentNki();  */
        Student student3 = new StudentPed();
        List<String> data = ((StudentPed) student3).parseFile("/Users/alla/Documents/ped.txt");
        System.out.println(data);
        if(student3.checkStudentInfo(data)) {
            ((StudentPed) student3).writeToDb(data);
        }

    }

    // Overloading as is
    private void setId(int id) {

    }

    private void setId(String id) {

    }

    private void setId(String idString, int id) {

    }

    private void setId() {

    }

}
