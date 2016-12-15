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
public class AdminListItem {
    private static int nextID=0;
    private int iD;
    private LibraryItem adminlistLibraryItem;
    private String customerName;
    private String dateTime;
    private boolean isBorrowing;

    public AdminListItem(LibraryItem adminlistLibraryItem, String customerName, String dateTime, boolean isBorrowing) {
        this.iD = nextID;
        nextID++;
        this.adminlistLibraryItem = adminlistLibraryItem;
        this.customerName = customerName;
        this.dateTime = dateTime;
        this.isBorrowing = isBorrowing;
    }

    public LibraryItem getAdminlistLibraryItem() {
        return adminlistLibraryItem;
    }

    public String getCustomerName() {
        return customerName;
    }

    public boolean getIsBorrowing() {
        return isBorrowing;
    }

    public int getiD() {
        return iD;
    }

    public String getDateTime() {
        return dateTime;
    }
    
}
