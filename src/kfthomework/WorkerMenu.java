/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfthomework;

import java.util.Scanner;

/**
 *
 * @author mhorvath
 */
public class WorkerMenu {
    public static void chooseWorkerMenu(){
    while(true){
            WorkerMenu.printWorkerMenu();
            Scanner keyboard = new Scanner(System.in);
            byte menupont = keyboard.nextByte();
            switch (menupont) {
                case 0: {
                    WorkerMenu.addNewWorker();
                    break;
                }
                case 1: {
                    WorkerMenu.listAllWorkers();
                    break;
                }
                case 2: {
                    WorkerMenu.doWork();
                    break;
                }
                case 3: {                                
                    return;
                }
            }
        }
    }
    public static void addNewWorker(){
        String name, dateOfBirth;
        Gender gender=new Gender();
        byte genderChoose;
        int money,salary;
        Scanner keyboard = new Scanner(System.in);
        System.out.println();
        System.out.println("New Worker:");
        System.out.println();
        System.out.println("name:      ");
        name=keyboard.next();
        System.out.println("date of birth:     ");
        dateOfBirth=keyboard.next();
        System.out.println("gender(0-woman,1-man):     ");
            genderChoose=keyboard.nextByte();
            switch(genderChoose){
                case 0:{
                    gender.setGenderToWoman();
                    break;
                }
                case 1:{
                    gender.setGenderToMan();
                    break;
                }
                default:{
                    System.out.println("error: invalid gender");
                }
                    
            }
        System.out.println("money:     ");
        money=keyboard.nextInt();
        System.out.println("salary:     ");
        salary=keyboard.nextInt();
        new Worker(name,dateOfBirth,gender,money,salary);
        System.out.println();
        System.out.println("New Worker created");
    }
    public static void listAllWorkers(){
        Worker.printListOfWorkers(Worker.listAll());
    }
    public static void doWork(){
        Scanner keyboard = new Scanner(System.in);
        int workerID;
        System.out.println("Choose witch worker should work!");
        listAllWorkers();
        System.out.println("Worker ID: ");
        workerID=keyboard.nextInt();
        Worker.listAll().forEach((workerInList)->{
            if(workerInList.getWorkerID()==workerID){
            workerInList.doWork();
            }
        });
        
    }
    public static void printWorkerMenu(){
        System.out.println();
        System.out.println("WORKER MENU:");
        System.out.println();
        System.out.println("      0: Add new worker");
        System.out.println("      1: List all workers");
        System.out.println("      2: Do work");
        System.out.println("      3: Quit to main");
        System.out.println();
    }
}
