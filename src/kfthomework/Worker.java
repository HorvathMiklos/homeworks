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
public class Worker extends People{
    private int workerID;    
    private static int nextWorkerID=0;
    private int fireingReqvests;
    private static List<Worker> allWorkers= new ArrayList<>();
    public void Worker(String name,String dateOfBirth,Gender gender,int money,int salary){
        this.workerID=Worker.nextWorkerID;
        Worker.nextWorkerID++;
        this.fireingReqvests=0;
        this.name=name;
        this.dateOfBirth=dateOfBirth;
        this.gender=gender;
        this.money=money;
        this.salary=salary;
        allWorkers.add(this);
    }
    public int GetFireingReqvests(){
        return this.fireingReqvests;
    }
    public void IncreaseTheChanceOfGettingFired(){
        this.fireingReqvests++;
    }
   
    @Override
    public void DoWork(){
    }
    @Override
    public List<People> ListAll(){
    List<People> ListOfAllWorkers = new ArrayList<>();
        Worker.allWorkers.forEach((OneOfTheWorkersOfTheCompany) -> {
            ListOfAllWorkers.add(OneOfTheWorkersOfTheCompany);
        });
        return ListOfAllWorkers;
    }
}
