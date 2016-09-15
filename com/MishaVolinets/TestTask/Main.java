package com.MishaVolinets.TestTask;

import com.MishaVolinets.TestTask.Exceptions.NameInputException;
import com.MishaVolinets.TestTask.University.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        initialization();
        Menu m = new Menu();
    }


    public static void initialization(){
        /*
         * Для початку я добавив одного викладача з 5 студентами.
         * В самій програмі їх можа добавляти і видаляти,
         * але зміни збережені не будуть.
         */
        try {
            Teacher.teachers.add(new Teacher("Nataliya","Shingera","Yaroslavivna",32, "Introduction to Specialty"));
        } catch (NameInputException e) {
            e.printStackTrace();
        }

        Teacher firstTeacher = Teacher.teachers.get(0);
        try {
            firstTeacher.addStudent(new Student("Misha", "Volinets", "Yaroslavovich", 18, 2));
            firstTeacher.addStudent(new Student("Dmitro", "Rakochiy", "Ivanovich", 18, 2));
            firstTeacher.addStudent(new Student("Roman", "Lutcishin", "Bogdanovich", 19, 2));
            firstTeacher.addStudent(new Student("Steave", "Jobs", "Vasilovich", 24, 2));
            firstTeacher.addStudent(new Student("Vitaly", "Krushelnitsky", "Yuriyovich", 22, 5));
        }catch (com.MishaVolinets.TestTask.Exceptions.CourseValueException ex){
            ex.printStackTrace();
        } catch (NameInputException e) {
            e.printStackTrace();
        }
    }

}
