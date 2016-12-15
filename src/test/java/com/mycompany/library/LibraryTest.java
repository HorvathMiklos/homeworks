/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mhorvath
 */
public class LibraryTest {

    public Library testLibrary = Library.getInstance();
    ;
    public Library firstTestLibrary;
    public Library secondTestLibrary;
    public LibraryItem existingLibraryItemForBorrowTest = new LibraryItem(LibraryItemType.BOOK, "dggrgt");
    public LibraryItem existingLibraryItemForReturnTest = new LibraryItem(LibraryItemType.MAGAZINE, "dsfvawvea");
    public LibraryItem existingLibraryItemForBorrowTestThrowsAlreadyBorrowed = new LibraryItem(LibraryItemType.BOOK, "klhik");
    public LibraryItem LibraryItemForAddNewLibraryItemTest = new LibraryItem(LibraryItemType.MAGAZINE, "dhdhdusi");
    public LibraryItem notExistingLibraryItem = new LibraryItem(LibraryItemType.BOOK, "sfgfgfsdgt");
    public LibraryItem notBorrowedExistingLibraryItem = new LibraryItem(LibraryItemType.MAGAZINE, "dhdhthdhd");
    public LibraryItem notBorrowedByThisCustomerExistingLibraryItem = new LibraryItem(LibraryItemType.BOOK, "srfgd");
    public LibraryItem existingLibraryItemForTestingIsBorrowed = new LibraryItem(LibraryItemType.MAGAZINE, "sgrhgr");
    public String customerNameOne = "dghdghdghvx";
    public String customerNameTwo = "SFBHDYFífdrg";

    public LibraryTest() {

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @Test
    public void testSingleton() {
        Library firstTestLibrary = Library.getInstance();
        Library secondTestLibrary = Library.getInstance();
        assertEquals(true, (firstTestLibrary == secondTestLibrary));
    }

    @Test
    public void testAddNewLibraryItem() {
        testLibrary.addNewLibraryItem(LibraryItemForAddNewLibraryItemTest);
        assertEquals(true, (testLibrary.getLibraryItems().contains(LibraryItemForAddNewLibraryItemTest)));
    }

    @Test
    public void testBorrow() {
        testLibrary.addNewLibraryItem(existingLibraryItemForBorrowTest);
        testLibrary.borrow(customerNameOne, existingLibraryItemForBorrowTest);
        assertEquals(existingLibraryItemForBorrowTest, testLibrary.getAdminListItems().get(testLibrary.getAdminListItems().size() - 1).getAdminlistLibraryItem());
        assertEquals(customerNameOne, testLibrary.getAdminListItems().get(testLibrary.getAdminListItems().size() - 1).getCustomerName());
        assertEquals(true, testLibrary.getAdminListItems().get(testLibrary.getAdminListItems().size() - 1).getIsBorrowing());
    }

    @Test(expected = AlreadyBorrowedLibraryItemException.class)
    public void testBorrowThrowsAlreadyBorrowedLibraryItemException() {
        testLibrary.addNewLibraryItem(existingLibraryItemForBorrowTestThrowsAlreadyBorrowed);
        testLibrary.borrow(customerNameOne, existingLibraryItemForBorrowTestThrowsAlreadyBorrowed);
        testLibrary.borrow(customerNameTwo, existingLibraryItemForBorrowTestThrowsAlreadyBorrowed);
    }

    @Test(expected = NotExistingLibraryItemException.class)
    public void testBorrowThrowsNotExistingLibraryItemException() {
        testLibrary.borrow(customerNameOne, notExistingLibraryItem);
    }

    @Test
    public void testItemReturn() {
        testLibrary.addNewLibraryItem(existingLibraryItemForReturnTest);
        testLibrary.borrow(customerNameOne, existingLibraryItemForReturnTest);
        testLibrary.itemReturn(customerNameOne, existingLibraryItemForReturnTest);
        assertEquals(existingLibraryItemForReturnTest, testLibrary.getAdminListItems().get(testLibrary.getAdminListItems().size() - 1).getAdminlistLibraryItem());
        assertEquals(customerNameOne, testLibrary.getAdminListItems().get(testLibrary.getAdminListItems().size() - 1).getCustomerName());
        assertEquals(false, testLibrary.getAdminListItems().get(testLibrary.getAdminListItems().size() - 1).getIsBorrowing());
    }

    @Test(expected = NotBorrowedException.class)
    public void testItemReturnThrowsNotBorrowedException() {
        testLibrary.addNewLibraryItem(notBorrowedExistingLibraryItem);
        testLibrary.itemReturn(customerNameOne, notBorrowedExistingLibraryItem);
    }

    @Test(expected = NotBorrowedByThisPersonException.class)
    public void testItemReturnThrowsNotBorrowedByThisPersonException() {
        testLibrary.addNewLibraryItem(notBorrowedByThisCustomerExistingLibraryItem);
        testLibrary.borrow(customerNameOne, notBorrowedByThisCustomerExistingLibraryItem);
        testLibrary.itemReturn(customerNameTwo, notBorrowedByThisCustomerExistingLibraryItem);
    }

    @Test(expected = NotExistingLibraryItemException.class)
    public void testItemReturnThrowsNotExistingLibraryItemException() {
        testLibrary.itemReturn(customerNameOne, notExistingLibraryItem);
    }

    @Test
    public void testIsBorrowed() {
        testLibrary.addNewLibraryItem(existingLibraryItemForTestingIsBorrowed);
        assertEquals(false, testLibrary.isBorrowed(existingLibraryItemForTestingIsBorrowed));
        testLibrary.borrow(customerNameOne, existingLibraryItemForTestingIsBorrowed);
        assertEquals(true, testLibrary.isBorrowed(existingLibraryItemForTestingIsBorrowed));
    }

}
