/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mhorvath
 */
public class Library {
    private static final Logger LOGGER = Logger.getLogger("myLogger");
    private static Library theLibrary;
    private static List<LibraryItem> libraryItemList;
    private static List<AdminListItem> adminList ;
    private Library() {    
        
    }

    public static Library getInstance() {
        if (null == theLibrary) {
            theLibrary = new Library();
            Library.libraryItemList= new ArrayList<>();
            Library.adminList = new ArrayList<>();
        }
        return theLibrary;
    }

    public List<LibraryItem> getLibraryItemList(){
        return Library.libraryItemList;
    }
    
    public List<AdminListItem> getAdminList(){
        return adminList;
    }
            
    public void borrow(String customerName, LibraryItem itemToBorrow) {
        if (Library.libraryItemList.contains(itemToBorrow)) {
            if (!this.isBorrowed(itemToBorrow)) {
                Date now = Calendar.getInstance().getTime();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
                String dateTimeOfBorrow = formatter.format(now);
                AdminListItem newBorrow = new AdminListItem(itemToBorrow, customerName, dateTimeOfBorrow, true);
                LOGGER.log(Level.INFO, "new admninlist item "+newBorrow.getiD()+" at "+newBorrow.getDateTime()+": "+itemToBorrow.getiD()+" "+itemToBorrow.getName()+" "+itemToBorrow.getListItemType().toString()+"borrowed by"+customerName);
                Library.adminList.add(newBorrow);
            } else {
                throw new AlreadyBorrowedLibraryItemException();
            }
        } else {
            throw new NotExistingLibraryItemException();
        }
    }

    
    
    public void itemReturn(String customerName, LibraryItem itemToReturn) {
        if (!Library.libraryItemList.contains(itemToReturn)) {
            throw new NotExistingLibraryItemException();
        }
        if (!this.isBorrowed(itemToReturn)) {
            throw new NotBorrowedException();
        }
        String lastCustomerName = "";
        for (AdminListItem adminItem : adminList) {
            if (adminItem.getAdminlistLibraryItem().equals(itemToReturn)) {
                lastCustomerName = adminItem.getCustomerName();
            }
        }
        if (lastCustomerName == customerName) {
            Date now = Calendar.getInstance().getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
            String dateTimeOfReturn = formatter.format(now);
            AdminListItem newReturn = new AdminListItem(itemToReturn, customerName, dateTimeOfReturn, false);
            adminList.add(newReturn);
        } else {
            throw new NotBorrowedByThisPersonException();
        }

    }

    public void addNewLibraryItem(LibraryItem newLibraryItem) {
        Library.libraryItemList.add(newLibraryItem);
    }

    public List<LibraryItem> getLibraryItems() {
        return Library.libraryItemList;
    }

    public List<AdminListItem> getAdminListItems() {
        return Library.adminList;
    }

    public boolean isBorrowed(LibraryItem itemToCheck) {
        int borrownumber = 0;
        int returnnumber = 0;
        for (AdminListItem adminlistItem : adminList) {
            if (adminlistItem.getAdminlistLibraryItem().equals(itemToCheck) && (adminlistItem.getIsBorrowing())) {
                borrownumber++;
            }
        }
        for (AdminListItem adminlistItem : adminList) {
            if (adminlistItem.getAdminlistLibraryItem().equals(itemToCheck) && (!adminlistItem.getIsBorrowing())) {
                returnnumber++;
            }
        }
        return !(borrownumber == 0 || borrownumber < returnnumber);        
    }
}

