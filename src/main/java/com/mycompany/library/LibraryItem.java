/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library;

/**
 *
 * @author mhorvath
 */
public class LibraryItem {
    private int iD;
    private LibraryItemType listItemType;
    private String name;
    private static int nextID=0; 

    public LibraryItem(LibraryItemType listItemType, String name) {
        this.iD = nextID;
        this.listItemType = listItemType;
        this.name = name;
        nextID++;
        
    }

    public LibraryItemType getListItemType() {
        return listItemType;
    }

    public String getName() {
        return name;
    }

    public int getiD() {
        return iD;
    }

   

   
    
}
