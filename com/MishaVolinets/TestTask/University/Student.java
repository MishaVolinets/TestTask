package com.MishaVolinets.TestTask.University;


import com.MishaVolinets.TestTask.Exceptions.CourseValueException;

public class Student extends UniversityMember {

    private int course;// Курс на якому навчається студент

    public Student(String firstName,String lastName,String fatherName,int age, int _course) throws  CourseValueException{
        super(firstName,lastName,fatherName,age);
        setStatus("Student");
        setCourse(_course);
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
        if(course<8)//Провіряє чи курс менший 8, якщо менший, то викидає помилку
            this.course = course;
        else
            throw new CourseValueException();
    }
}
