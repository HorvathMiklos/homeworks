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
public abstract class People {
    
    protected String name;
    protected String dateOfBirth;
    protected Gender gender;
    
    protected int money;
    protected int salary;

    public abstract void DoWork();

    public abstract List<People> ListAll();

    public void ReceaveSalary() {

    }

    public String GetName() {
        return this.name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public String GetDateOfBirth() {
        return this.dateOfBirth;
    }

    public void SetDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public Gender GetGender(Gender gender){
        return this.gender;
    }
    
    public int GetMoney() {
        return this.money;
    }

    public void SetMoney(int money) {
        this.money = money;
    }

    public int GetSalary() {
        return this.salary;
    }

    public void SetSalary(int salary) {
        this.salary = salary;
    }

}
