package com.MishaVolinets.TestTask.University;

import com.MishaVolinets.TestTask.Exceptions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class Teacher extends UniversityMember {

    private String subject;
    private ArrayList<Student> students = new ArrayList<>(20);

    public static ArrayList<Teacher> teachers = new ArrayList<>();

    public Teacher(String firstName,String lastName,String fatherName, int age, String _subject) throws NameInputException{
        super(firstName,lastName,fatherName,age);
        setStatus("Teacher");
        subject = _subject;
    }

    public void addStudent(Student student){
        students.add(student);
        Student.allStudents.add(student);
    }

    public boolean removeStudent(String firstName, String lastName, String fatherName){
        try {
            Student rmStd = findStudent(firstName,lastName,fatherName);
            students.remove(rmStd);
            Student.allStudents.remove(rmStd);
            return true;
        }catch (StudentNotFoundException ex){
            System.out.println("Sorry, but this student not exist");
            return false;
        }
    }

    private Student findStudent(String firstName, String lastName, String fatherName) throws StudentNotFoundException{
        for(Student ob : students)
            if(ob.getFirstName().equals(firstName))
                if(ob.getLastName().equals(lastName))
                    if(ob.getFatherName().equals(fatherName))
                        return ob;
        throw new StudentNotFoundException();
    }

    public static ArrayList<Student> sortStudent(ArrayList<Student> _students){
        ArrayList<Student> arStud = _students;

        arStud.sort((Student firstStudent, Student secondStudent) ->{

            return firstStudent.getLastName().compareTo(secondStudent.getLastName());
        });

        return arStud;
    }


    public static void printTeachers(){
        for(int i = 0;i<teachers.size();i++)
            System.out.println((i+1) + ". "+ teachers.get(i).getFirstName() + " " + teachers.get(i).getLastName());
    }

    public String toString(){
        return super.toString() + ", teach \"" + subject + "\"";
    }

    public String getSubject() {
        return subject;
    }

    public void printStudents(){
        for(int i = 0;i < students.size();i++)
            System.out.println((i+1) + ". " + students.get(i));
    }
    public void printSortedStudents(){
        ArrayList<Student> students = sortStudent(this.students);
        for(int i = 0;i < students.size();i++)
            System.out.println(" " + (i+1) + ". " + students.get(i));
    }
    public static void printAll(){
        for(int i = 0;i<teachers.size();i++){
            System.out.println((i+1) + ". " + teachers.get(i));
            teachers.get(i).printSortedStudents();
            System.out.println();
        }
    }
}
