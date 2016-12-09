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
public class MainMenu {
    public static void printMainMenu(){
        System.out.println();
        System.out.println("MAIN MENU:");
        System.out.println();
        System.out.println("      0: Company menu");
        System.out.println("      1: Boss menu");
        System.out.println("      2: Worker menu");
        System.out.println("      3: Quit");
        System.out.println();
    }
    public static void chooseMenuPont(){
            MainMenu.printMainMenu();
            Scanner keyboard =new Scanner(System.in);
            byte menupont=keyboard.nextByte();    
            switch(menupont){
                case 0:{
                    CompanyMenu.chooseCompanyMenu();
                    break;
                }
                case 1:{
                    BossMenu.chooseBossMenu();
                    break;
                }
                case 2:{
                    WorkerMenu.chooseWorkerMenu();
                    break;
                }
                case 3:{
                    return;
                }
            }        
    }
}
