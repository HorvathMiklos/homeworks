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
    private boolean isEmployed;
    private Company employeer=new Company();

    Worker(String name, String dateOfBirth, Gender gender, int money, int salary) {
        this.workerID=Worker.nextWorkerID;
        Worker.nextWorkerID++;
        this.fireingReqvests=0;
        this.name=name;
        this.dateOfBirth=dateOfBirth;
        this.gender=gender;
        this.money=money;
        this.salary=salary;
        this.isEmployed=false;
        this.employeer= new Company();
        allWorkers.add(this);
    }
    public int getWorkerID(){
        return this.workerID;
    }
    public Company getEmployer(){
        return this.employeer;
    }
    public int getFireingReqvests(){
        return this.fireingReqvests;
    }
    public void increaseTheChanceOfGettingFired(){
        this.fireingReqvests++;
    }
    public void looseJob(){
        this.isEmployed=false;
        this.employeer=null;
    }
    public void findJob(Company employeer){
        if(!this.isEmployed){
            this.isEmployed=true;
            this.employeer=employeer;
        }
        else{
            System.out.println(this.name+" already have a job so "+this.gender.genderTextHeShe()+"can't be employed again!");
        }
    }
    public boolean haveAJob(){
        return isEmployed;
    }
    public static void printListOfWorkers(List<Worker> workerList){
        System.out.println("---------------------------------------------------------");
        workerList.forEach((workerToPrint)->{ 
            
            System.out.print("ID:               ");
            System.out.println(workerToPrint.workerID);
            System.out.print("name:             ");
            System.out.println(workerToPrint.name);
            System.out.print("gender:           ");
            System.out.println(workerToPrint.gender.genderText());
            System.out.print("date of birth:    ");
            System.out.println(workerToPrint.dateOfBirth);
            System.out.print("money:            ");
            System.out.println(workerToPrint.money+" HUF");
            System.out.print("salary:           ");
            System.out.println(workerToPrint.salary+" HUF");
            System.out.println();
            System.out.println("---------------------------------------------------------");
            });
    }
    @Override
    public void doWork(){
        System.out.println(this.name+" made some work, so "+this.gender.genderTextHisHer()+" boss is happy now!");
    }
    
public static List<Worker> listAll(){
    List<Worker> ListOfAllWorkers = new ArrayList<>();
        for(Worker OneOfTheWorkersOfTheCompany:Worker.allWorkers){
            ListOfAllWorkers.add(OneOfTheWorkersOfTheCompany);
        }
        return ListOfAllWorkers;
    }
}
