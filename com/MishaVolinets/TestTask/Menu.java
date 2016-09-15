package com.MishaVolinets.TestTask;

import com.MishaVolinets.TestTask.Exceptions.CourseValueException;
import com.MishaVolinets.TestTask.University.Student;
import com.MishaVolinets.TestTask.University.Teacher;
import java.util.Scanner;


public class Menu {
    private Scanner sc = new Scanner(System.in);
    private int choice;
    private static boolean status = true;

    public Menu(){
        System.out.println("\tHello");
        do {
            mainMenu();
        }while (status);
    }
    public void mainMenu(){
        System.out.println("1.User menu;");
        System.out.println("2.Create new teacher;");
        System.out.println("3.Print all teacher and students");
        System.out.println("9.Exit");

        if(sc.hasNextInt())
            choice = sc.nextInt();


        if(choice == 1)
            choiceTeacherMenu();
        if(choice == 2)
            createTeacher();
        if(choice == 3)
            printTaS();
        if(choice == 9)
            status = false;
    }

    public void choiceTeacherMenu(){
        System.out.println("\t User Menu");

        System.out.println("Please choice teacher: ");
        Teacher.printTeachers();
        System.out.println("100 - Back");
        if(sc.hasNextInt())
            choice = sc.nextInt();

        if(choice > 0&&choice<Teacher.teachers.size())
            teacherMenu(choice);
        else if(choice != 100){
            System.out.println("Teacher at this number not exist");
            choiceTeacherMenu();
        }
        if(choice == 100)
            return;

    }
    public void teacherMenu(int teacherID){
        Teacher tch = Teacher.teachers.get(teacherID-1);
        System.out.println("Hello " + tch);
        System.out.println("Your students: ");
        tch.printSortedStudents();
        System.out.println("\n1.Add Student");
        System.out.println("2.Delte Student");
        System.out.println("100.Back");

        if(sc.hasNextInt())
            choice = sc.nextInt();

        if(choice == 1)
            addStudent(teacherID);
        else if(choice == 2)
            deleteStudent(teacherID);
        else if(choice == 100)
            choiceTeacherMenu();
        else
            System.out.println("Choice not Currect");
    }


    public void addStudent(int teacherID){

        Scanner sc = new Scanner(System.in);
        String firstName, lastName, fatherName;
        int age,course;

        System.out.println("Enter:\n");

        System.out.println("First Name: ");
        firstName = sc.nextLine();
        System.out.println("Last Name: ");
        lastName = sc.nextLine();
        System.out.println("Father Name: ");
        fatherName = sc.nextLine();
        System.out.println("Age: ");

        if(sc.hasNextInt())
            age=sc.nextInt();
        else {
            System.out.println("Age must be number");
            System.out.println("Try again");
            addStudent(teacherID);
            return;
        }

        System.out.println("Course: ");
        course = sc.nextInt();

        try {
            Teacher.teachers.get(teacherID-1).addStudent(new Student(firstName,lastName,fatherName,age,course));
        } catch (CourseValueException e) {
            System.out.println("Course must be less 8\n Try Again: ");
            addStudent(teacherID);
        }
        System.out.println("Student was added");
    }
    public void deleteStudent(int teacherID){
        Scanner sc = new Scanner(System.in);
        String firstName, lastName, fatherName;
        System.out.println("Enter: ");
        System.out.println("First Name: ");
        firstName = sc.nextLine();
        System.out.println("Last Name: ");
        lastName = sc.nextLine();
        System.out.println("Father Name: ");
        fatherName = sc.nextLine();

        if(Teacher.teachers.get(teacherID-1).removeStudent(firstName,lastName,fatherName))
            System.out.println("Student was deleted");

    }
    public void createTeacher(){
        String firstName,lastName,fatherName,subject;
        int age;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter ");
        System.out.println("First Name");
        firstName = sc.nextLine();
        System.out.println("Last Name: ");
        lastName = sc.nextLine();
        System.out.println("Father Name: ");
        fatherName = sc.nextLine();

        System.out.println("Subject: ");
        subject = sc.nextLine();

        System.out.println("Age: ");

        if(sc.hasNextInt())
            age=sc.nextInt();
        else {
            System.out.println("Age must be number");
            System.out.println("Try again");
            createTeacher();
            return;
        }

        Teacher.teachers.add(new Teacher(firstName,lastName,fatherName,age,subject));
        System.out.println("Teacher was added");
    }
    public void printTaS(){
        Teacher.printAll();
    }
}
