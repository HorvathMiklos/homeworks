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
public class Worker extends Person{
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
    public int getFireingReqvests(){
        return this.fireingReqvests;
    }
    public void increaseTheChanceOfGettingFired(){
        this.fireingReqvests++;
    }
    public void printListOfWorers(List<Worker> workerList){
        System.out.println("---------------------------------------------------------");
        workerList.forEach((workerToPrint)->{ 
            
            System.out.print("ID:               ");
            System.out.print(workerToPrint.workerID);
            System.out.print("name:             ");
            System.out.print(workerToPrint.name);
            System.out.print("gender:           ");
            System.out.print(workerToPrint.gender.genderText());
            System.out.print("date of birth:    ");
            System.out.print(workerToPrint.dateOfBirth);
            System.out.print("money:            ");
            System.out.print(workerToPrint.money+" HUF");
            System.out.print("salary:           ");
            System.out.print(workerToPrint.salary+" HUF");
            System.out.println("---------------------------------------------------------");
            });
    }
    @Override
    public void doWork(){
        System.out.println(this.name+" made some work, so "+this.gender.genderTextHisHer()+" boss is happy now!");
    }
    @Override
    public List<Person> listAll(){
    List<Person> ListOfAllWorkers = new ArrayList<>();
        Worker.allWorkers.forEach((OneOfTheWorkersOfTheCompany) -> {
            ListOfAllWorkers.add(OneOfTheWorkersOfTheCompany);
        });
        return ListOfAllWorkers;
    }
}
