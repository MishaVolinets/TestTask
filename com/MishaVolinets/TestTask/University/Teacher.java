package com.MishaVolinets.TestTask.University;

import com.MishaVolinets.TestTask.Exceptions.*;

import java.util.ArrayList;

public class Teacher extends UniversityMember {

    private String subject;
    private ArrayList<Student> students = new ArrayList<>(20);

    public static ArrayList<Teacher> teachers = new ArrayList<>();

    public Teacher(String firstName,String lastName,String fatherName, int age, String _subject){
        super(firstName,lastName,fatherName,age);
        setStatus("Teacher");
        subject = _subject;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(String firstName, String lastName, String fatherName){
        try {
            Student rmStd = findStudent(firstName,lastName,fatherName);
            students.remove(rmStd);
        }catch (StudentNotFoundException ex){
            System.out.println("Sorry, but this student not exist");
            return;
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
}
