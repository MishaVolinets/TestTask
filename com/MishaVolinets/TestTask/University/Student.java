package com.MishaVolinets.TestTask.University;


import com.MishaVolinets.TestTask.Exceptions.CourseValueException;

public class Student extends UniversityMember {

    private int course;// Курс на якому навчається студент

    public Student(String firstName,String lastName,String fatherName,int age, int _course){
        super(firstName,lastName,fatherName,age);
        setStatus("Student");
        try {
            setCourse(_course);
        }catch (CourseValueException ex){
            System.out.println("Sorry, but course must be less 8\n Try again");
            return;
        }
    }

    public Student(){//Конструктор за умовчуванням
        super();
        setStatus(null);
        course = -1;
    }

    public String toString(){
        return super.toString() + ", lear at " + course + " course";
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) throws CourseValueException{
        if(course<7)
            this.course = course;
        else
            throw new CourseValueException();
    }
}
