package ru.mera.beyshatzade.postman;

public class Person {
    private String name;
    private String surname;
    public Person (String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    public String getname() {
        return name + " " +  surname;
    }
    public void setname(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}