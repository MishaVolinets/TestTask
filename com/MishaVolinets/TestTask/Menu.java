package com.MishaVolinets.TestTask;

import com.MishaVolinets.TestTask.University.Teacher;

import java.util.Scanner;

/**
 * Created by misha on 14.09.16.
 */


public class Menu {
    private Scanner sc = new Scanner(System.in);
    private int choice;
    private static boolean status = true;

    Menu(){
        System.out.println("\tHello");
        do {
            mainMenu();
        }while (status);
    }
    public void mainMenu(){
        System.out.println("1.User menu;");
        System.out.println("2.Create new teacher;");
        System.out.println("9.Exit");

        if(sc.hasNextInt())
            choice = sc.nextInt();


        if(choice == 1)
            userMenu();

        if(choice == 9)
            status = false;
    }

    public void userMenu(){
        System.out.println("\t User Menu");

        System.out.println("Please choice teacher: ");
        Teacher.printTeachers();
        System.out.println("100 - Back");
        if(sc.hasNextInt())
            choice = sc.nextInt();

        if(choice == 9)
            mainMenu();

    }

    // Продовжуй доробляти меню.
}
