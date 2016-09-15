package com.MishaVolinets.TestTask.University;


import com.MishaVolinets.TestTask.Exceptions.CourseValueException;
import com.MishaVolinets.TestTask.Exceptions.NameInputException;

import java.util.ArrayList;

public class Student extends UniversityMember {

    private int course;// Курс на якому навчається студент
    public static ArrayList<Student> allStudents = new ArrayList<Student>();
    public Student(String firstName,String lastName,String fatherName,int age, int _course) throws  CourseValueException,NameInputException{
        super(firstName,lastName,fatherName,age);
        setStatus("Student");
        setCourse(_course);
    }

    public Student() throws NameInputException{//Конструктор за умовчуванням
        super();
        setStatus(null);
        course = -1;
    }

    public Student(Student st) throws CourseValueException, NameInputException{
        this(st.getFirstName(),st.getLastName(),st.getFatherName(),st.getAge(),st.getCourse());
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
