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
public class CompanyMenu {

    public static void chooseCompanyMenu() {
        while(true){
            CompanyMenu.printCompanyMenu();
            Scanner keyboard = new Scanner(System.in);
            byte menupont = keyboard.nextByte();
            switch (menupont) {
                case 0: {
                    CompanyMenu.addNewCompany();
                    break;
                }
                case 1: {
                    CompanyMenu.listAllCompanies();
                    break;
                }
                case 2: {
                    CompanyMenu.listBossesOfACompany();
                    break;
                }
                case 3: {
                    CompanyMenu.listWorkersOfACompany();
                    break;
                }
                case 4: {
                    CompanyMenu.employ();
                    break;
                }
                case 5: {
                    CompanyMenu.fire();
                    break;
                }
                case 6: {
                    CompanyMenu.pay();
                    break;
                }
                case 7: {
                    return;
                }
            }
        }
    }
    public static void addNewCompany(){
        String name,place,profile;
        int money;
        Scanner keyboard = new Scanner(System.in);
        System.out.println();
        System.out.println("New Company:");
        System.out.println();
        System.out.println("name:      ");
        name=keyboard.nextLine();
        System.out.println("place:     ");
        place=keyboard.nextLine();
        System.out.println("profile:   ");
        profile=keyboard.nextLine();
        System.out.println("money:     ");
        money=keyboard.nextInt();
        new Company(name,place,profile,money);
        System.out.println();
        System.out.println("New Company created");
    }
    public static void listAllCompanies(){
        Company.printListOfCompanies(Company.listAll());
    }
    public static void listBossesOfACompany(){
        Scanner keyboard = new Scanner(System.in);
        int companyID;
        System.out.println("Select company by ID:");
        listAllCompanies();
        System.out.println("Company ID:");
        companyID=keyboard.nextInt();
        for(Company companyInList : Company.listAll()){
        if(companyInList.getCompanyID()==companyID){
                Boss.printListOfBosses(companyInList.listCompanyBosses());
            }
        }             
    }
    public static void listWorkersOfACompany(){
        Scanner keyboard = new Scanner(System.in);
        int companyID;
        System.out.println("Select company by ID:");
        listAllCompanies();
        System.out.println("Company ID:");
        companyID=keyboard.nextInt();
        for(Company companyInList : Company.listAll()){
            if(companyInList.getCompanyID()==companyID){
                Worker.printListOfWorkers(companyInList.listCompanyWorkers());
            }
        }       
    }

    public static void employ() {
        Scanner keyboard = new Scanner(System.in);
        printEmployMenu();
        byte newEmployeeType = keyboard.nextByte();
        if (newEmployeeType == 0) {
            int companyID;
            System.out.println("Select company by ID:");
            listAllCompanies();
            System.out.println("Company ID:");
            companyID = keyboard.nextInt();

            for (Company companyInList : Company.listAll()) {
                int bossID;
                if (companyInList.getCompanyID() == companyID) {
                    System.out.println("Select boss by ID");
                    BossMenu.listAllBosses();
                    System.out.println("BossID:");
                    bossID = keyboard.nextInt();
                    for (Boss bossInList : Boss.listAll()) {
                        if (bossInList.getBossID() == bossID) {

                            companyInList.employ(bossInList);
                        }
                    }
                }
            }
        }
        if (newEmployeeType == 1) {
            int companyID;
            System.out.println("Select company by ID:");
            listAllCompanies();
            System.out.println("Company ID:");
            companyID = keyboard.nextInt();

            for (Company companyInList : Company.listAll()) {
                int workerID;
                if (companyInList.getCompanyID() == companyID) {
                    System.out.println("Select worker by ID");
                    WorkerMenu.listAllWorkers();
                    System.out.println("WorkerID:");
                    workerID = keyboard.nextInt();
                    for (Worker workerInList : Worker.listAll()) {
                        if (workerInList.getWorkerID() == workerID) {
                            if (!workerInList.haveAJob()) {
                                companyInList.employ(workerInList);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void fire(){
        Scanner keyboard = new Scanner(System.in);
        int companyID;
        System.out.println("Select company by ID:");
        listAllCompanies();
        System.out.println("Company ID:");
        companyID=keyboard.nextInt();
        
        for(Company companyInList : Company.listAll()){
            byte angerLevelOfCEO;
            if(companyInList.getCompanyID()==companyID){
                System.out.println("How angry is the CEO? (0-10)");
                angerLevelOfCEO=keyboard.nextByte();
                companyInList.fireEmployee(angerLevelOfCEO);
            }
        }        
    }
    public static void pay(){
        Scanner keyboard = new Scanner(System.in);
        int companyID;
        System.out.println("Select company by ID:");
        listAllCompanies();
        System.out.println("Company ID:");
        companyID=keyboard.nextInt();
        for(Company companyInList : Company.listAll()){
            byte angerLevelOfCEO;
            if(companyInList.getCompanyID()==companyID){
               companyInList.payEmployees();
            }
        }
    }
    
    public static void printCompanyMenu(){
        System.out.println();
        System.out.println("COMPANY MENU:");
        System.out.println();
        System.out.println("      0: Add new company");
        System.out.println("      1: List all companies");
        System.out.println("      2: List bosses of a company");
        System.out.println("      3: List workers of a company");
        System.out.println("      4: Employ");
        System.out.println("      5: Fire");
        System.out.println("      6: Pay");
        System.out.println("      7: Quit to main");
        System.out.println();
    }
    public static void printEmployMenu(){
        System.out.println("EMPLOY MENU:");
        System.out.println();
        System.out.println("      0: Employ new boss");
        System.out.println("      1: Employ new worker");
    }
}
