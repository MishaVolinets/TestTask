package com.MishaVolinets.TestTask.University;

public abstract class UniversityMember{ //Абстрактний клас для того, щоб від нього не можна було створювати об'єкти

    private String firstName;
    private String lastName;
    private String fatherName; //По батькові
    private String status; //Статус(Студент або викладач)
    private int age;

    public UniversityMember(String _firstName, String _lastName, String _fatherName, int _age){
        firstName = _firstName;
        lastName = _lastName;
        fatherName = _fatherName;
        age = _age;
    }

    public UniversityMember(){
        this(null,null,null,0);
    }

    public String toString(){
        return status + ": " + lastName + " " + firstName + " " +fatherName + ", age - " + age;
    }

    //Getters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public int getAge(){
        return age;
    }

    public String getStatus(){
        return status;
    }
    //Setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setAge(int age){

        this.age = age;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
