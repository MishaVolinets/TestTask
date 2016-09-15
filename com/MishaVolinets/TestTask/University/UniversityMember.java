package com.MishaVolinets.TestTask.University;

import com.MishaVolinets.TestTask.Exceptions.NameInputException;

public abstract class UniversityMember{ //Абстрактний клас для того, щоб від нього не можна було створювати об'єкти

    private String firstName;
    private String lastName;
    private String fatherName; //По батькові
    private String status; //Статус(Студент або викладач)
    private int age;

    public UniversityMember(String _firstName, String _lastName, String _fatherName, int _age) throws NameInputException{
        setFirstName(_firstName);
        setLastName(_lastName);
        setFatherName(_fatherName);
        age = _age;
    }

    public UniversityMember() throws NameInputException{
        this(null,null,null,0);
    }

    public String toString(){
        return status + ": " + lastName + " " + firstName + " " +fatherName + ", age - " + age;
    }

    private boolean isHaveNumber(String name){
        char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
        char[] arName = name.toCharArray();

        for(int i = 0;i < arName.length;i++)
            for(int j = 0;j<numbers.length;j++)
                if(arName[i] == numbers[j])
                    return true;
        return false;
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

    public void setFirstName(String firstName) throws NameInputException{
        if(!isHaveNumber(firstName))
            this.firstName = firstName;
        else throw new NameInputException();
    }

    public void setLastName(String lastName) throws NameInputException {
        if(!isHaveNumber(lastName))
            this.lastName = lastName;
        else throw new NameInputException();
    }

    public void setFatherName(String fatherName) throws NameInputException {
        if(!isHaveNumber(fatherName))
          this.fatherName = fatherName;
        else throw new NameInputException();
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setStatus(String status){
        this.status = status;
    }


}
