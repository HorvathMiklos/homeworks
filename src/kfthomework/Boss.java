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
public class Boss extends Person {
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
    public int getBossID(){
        return this.bossID;
    }
    @Override
    public void doWork(){
        System.out.println(this.name+" made some work, so "+this.gender.genderTextHisHer()+" company will have a great future!");
    }
    @Override
    public List<Person> listAll(){
        List<Person> ListOfAllBosses = new ArrayList<>();
        Boss.allBosses.forEach((OneOfTheBossesOfTheCompany) -> {
            ListOfAllBosses.add(OneOfTheBossesOfTheCompany);
        });
        return ListOfAllBosses;
    }
    public void printListOfBosses(List<Boss> bossList){
        System.out.println("---------------------------------------------------------");
        bossList.forEach((bossToPrint)->{ 
            
            System.out.print("ID:               ");
            System.out.print(bossToPrint.bossID);
            System.out.print("name:             ");
            System.out.print(bossToPrint.name);
            System.out.print("gender:           ");
            System.out.print(bossToPrint.gender.genderText());
            System.out.print("date of birth:    ");
            System.out.print(bossToPrint.dateOfBirth);
            System.out.print("money:            ");
            System.out.print(bossToPrint.money+" HUF");
            System.out.print("salary:           ");
            System.out.print(bossToPrint.salary+" HUF");
            System.out.println("---------------------------------------------------------");
            });
    }
    public void requestFireEmployee(Worker LazyWorker, Company CompanyOfLazyWorker){
        if(CompanyOfLazyWorker.listCompanyBosses().contains(this)){
            LazyWorker.increaseTheChanceOfGettingFired();
            System.out.println(this.name+" say: "+LazyWorker.name+" is very lazy we should fire "+LazyWorker.gender.qenderTextHimHer()+"!!!");
        }
        else{
            System.out.println("error: "+this.name+" is not boss of "+LazyWorker.name+" so "+this.gender.genderTextHeShe()+"can't reqvest to fire "+LazyWorker.gender.qenderTextHimHer());
            System.out.println("       They don't even work for the same company");
        }
    }
}
