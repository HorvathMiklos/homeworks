/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfthomework;

import java.util.List;

/**
 *
 * @author mhorvath
 */
public abstract class Person {
    
    protected String name;
    protected String dateOfBirth;
    protected Gender gender;
    
    protected int money;
    protected int salary;
    

    public abstract void doWork();
     
    
    public void receaveSalary() {
        this.money+=salary;
        System.out.println(this.name+" got salary, "+this.gender.genderTextHeShe()+"have "+this.money+"HUF now.");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public Gender getGender(Gender gender){
        return this.gender;
    }
    
    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
