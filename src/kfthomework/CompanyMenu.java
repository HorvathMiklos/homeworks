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
    
    }
    public static void listAllCompanies(){
    
    }
    public static void listBossesOfACompany(){
    
    }
    public static void listWorkersOfACompany(){
    
    }
    public static void employ(){
    
    }
    public static void fire(){
    
    }
    public static void pay(){
    
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
