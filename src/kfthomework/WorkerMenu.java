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
        
    }
    public static void listAllWorkers(){
        
    }
    public static void doWork(){
        
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
