/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfthomework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mhorvath
 */
public class BossMenu {
    public static void chooseBossMenu(){
        while(true){
            BossMenu.printBossMenu();
            Scanner keyboard = new Scanner(System.in);
            byte menupont = keyboard.nextByte();
            switch (menupont) {
                case 0: {
                    BossMenu.addNewBoss();
                    break;
                }
                case 1: {
                    BossMenu.listAllBosses();
                    break;
                }
                case 2: {
                    BossMenu.doWork();
                    break;
                }
                case 3: {
                    BossMenu.requestFire();
                    break;
                }
                case 4: {                
                    return;
                }
            }
        }
    }
    public static void addNewBoss(){
        String name, dateOfBirth;
        Gender gender=new Gender();
        byte genderChoose;
        int money,salary;
        Scanner keyboard = new Scanner(System.in);
        System.out.println();
        System.out.println("New Boss:");
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
        new Boss(name,dateOfBirth,gender,money,salary);
        System.out.println();
        System.out.println("New Boss created");
    }
    public static void listAllBosses(){
        Boss.printListOfBosses(Boss.listAll());
    }
    public static void doWork(){
        Scanner keyboard = new Scanner(System.in);
        int bossID;
        System.out.println("Choose witch boss should work!");
        listAllBosses();
        System.out.println("Boss ID: ");
        bossID=keyboard.nextInt();
        for(Boss bossInList : Boss.listAll()){
        if(bossInList.getBossID()==bossID){
            bossInList.doWork();
            }
        }
        /*
        Worker.listAll().forEach((bossInList)->{
            if(bossInList.getWorkerID()==bossID){
            bossInList.doWork();
            }
        });
        */
    }
    public static void requestFire() {
        Scanner keyboard = new Scanner(System.in);
        byte bossID;       
        System.out.println("Choose boss by ID");
        Boss.printListOfBosses(Boss.listAll());
        System.out.println("Boss ID: ");
        bossID = keyboard.nextByte();
        for(Boss angryBoss : Boss.listAll()){
            if (angryBoss.getBossID() == bossID) {
                List<Worker> workersUnderAngryBoss = new ArrayList<>();
                for(Company companyInList: Company.listAll()){
                    if (companyInList.listCompanyBosses().contains(angryBoss)) {
                        for(Worker workerInList:companyInList.listCompanyWorkers()){
                            workersUnderAngryBoss.add(workerInList);
                        }
                    }
                }
                System.out.println("Choose worker by ID: ");
                Worker.printListOfWorkers(workersUnderAngryBoss);
                System.out.println("Worker ID: ");
                byte workerID= keyboard.nextByte();
                for(Worker workerInList : workersUnderAngryBoss){
                    if(workerInList.getWorkerID()==workerID){
                        angryBoss.requestFireEmployee(workerInList, workerInList.employeer);
                    }
                }
            }
        }
        
        

    }
    public static void printBossMenu(){
        System.out.println();
        System.out.println("BOSS MENU:");
        System.out.println();
        System.out.println("      0: Add new boss");
        System.out.println("      1: List all bosses");
        System.out.println("      2: Do work");
        System.out.println("      3: Request Fire");
        System.out.println("      4: Quit to main");
        System.out.println();
    }
}
