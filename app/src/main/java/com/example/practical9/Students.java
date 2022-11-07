package com.example.practical9;

public class Students {
    private String name;
    private String enrollmentNumber;
    public Students(){}
    public Students(String name,String enrollmentNumber)
    {
        this.name=name;
        this.enrollmentNumber=enrollmentNumber;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }
    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }
}

