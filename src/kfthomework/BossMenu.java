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
public class BossMenu {
    public static void chooseBossMenu(){
        while(true){
            BossMenu.chooseBossMenu();
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
        
    }
    public static void listAllBosses(){
        
    }
    public static void doWork(){
        
    }
    public static void requestFire(){
        
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
