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
public class Kft{
    private int kftID;
    private static int nextKftID=0;
    private String name;
    private String place;    
    private String profile;
    private List<Boss> bosses;
    private List<Worker> workers;
    private static List<Kft> allKfts= new ArrayList<>();
    public void Kft(String name,String place,String profile){
        this.kftID=Kft.nextKftID;
        Kft.nextKftID++;
        this.name=name;
        this.place=place;
        this.profile=profile;
        allKfts.add(this);
    }
    public String GetName(){
        return this.name;
    }
    public void SetName(String name){
        this.name=name;
    }
    public String GetPlace(){
        return this.place;
    }
    public void SetPlace(String place){
        this.place=place;
    }
    public String GetProfile(){
        return this.profile;
    }
    public void SetProfile(String profile){
        this.profile=profile;
    }
    public void Employ(People newEmployee){
    
    }
    public void FireEmployee(Worker LazyWorker){
    
    }
    public void PayEmployees(){}
    
}
