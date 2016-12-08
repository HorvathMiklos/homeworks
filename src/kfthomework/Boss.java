/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfthomework;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mhorvath
 */
public class Boss extends People {
    private int bossID;
    private static int nextBossID=0;
    private static List<Boss> allBosses= new ArrayList<>();
    public void Boss(String name,String dateOfBirth,Gender gender,int money,int salary){
        this.bossID=Boss.nextBossID;
        Boss.nextBossID++;
        this.name=name;
        this.dateOfBirth=dateOfBirth;
        this.gender=gender;
        this.money=money;
        this.salary=salary;
        allBosses.add(this);
    }
    public int GetBossID(){
        return this.bossID;
    }
    @Override
    public void DoWork(){
    }
    @Override
    public List<People> ListAll(){
        List<People> ListOfAllBosses = new ArrayList<>();
        Boss.allBosses.forEach((OneOfTheBossesOfTheCompany) -> {
            ListOfAllBosses.add(OneOfTheBossesOfTheCompany);
        });
        return ListOfAllBosses;
    }
    public void RequestFireEmployee(Worker LazyWorker){
    
    }
}
