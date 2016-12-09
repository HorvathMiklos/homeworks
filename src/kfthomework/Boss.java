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
    Boss(String name,String dateOfBirth,Gender gender,int money,int salary){
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
    
    public static List<Boss> listAll(){
        List<Boss> ListOfAllBosses = new ArrayList<>();
        for(Boss OneOfTheBossesOfTheCompany : Boss.allBosses){
            ListOfAllBosses.add(OneOfTheBossesOfTheCompany);
        }
        return ListOfAllBosses;
    }
    public static void printListOfBosses(List<Boss> bossList){
        System.out.println("---------------------------------------------------------");
        for(Boss bossToPrint : bossList){ 
            
            System.out.print("ID:               ");
            System.out.println(bossToPrint.bossID);
            System.out.print("name:             ");
            System.out.println(bossToPrint.name);
            System.out.print("gender:           ");
            System.out.println(bossToPrint.gender.genderText());
            System.out.print("date of birth:    ");
            System.out.println(bossToPrint.dateOfBirth);
            System.out.print("money:            ");
            System.out.println(bossToPrint.money+" HUF");
            System.out.print("salary:           ");
            System.out.println(bossToPrint.salary+" HUF");
            System.out.println();
            System.out.println("---------------------------------------------------------");
            }
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
