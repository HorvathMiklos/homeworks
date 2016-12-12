/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfthomework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author mhorvath
 */
public class Company {

    private int companyID;
    private static int nextCompanyID = 1;
    private int money;
    private String name;
    private String place;
    private String profile;
    private List<Boss> bosses = new ArrayList<>();
    private List<Worker> workers = new ArrayList<>();
    private static List<Company> allCompanies = new ArrayList<>();

    Company() {
        this.companyID = 0;
        this.name = null;
        this.place = null;
        this.profile = null;
        this.money = 0;

    }

    Company(String name, String place, String profile, int money) {
        this.companyID = Company.nextCompanyID;
        Company.nextCompanyID++;
        this.name = name;
        this.place = place;
        this.profile = profile;
        this.money = money;
        allCompanies.add(this);
    }

    public static List<Company> listAll() {
        return allCompanies;
    }

    public static void printListOfCompanies(List<Company> companyList) {
        System.out.println("---------------------------------------------------------");
        companyList.forEach((companyToPrint) -> {
            System.out.print("ID:               ");
            System.out.println(companyToPrint.companyID);
            System.out.print("name:             ");
            System.out.println(companyToPrint.name);
            System.out.print("place:            ");
            System.out.println(companyToPrint.place);
            System.out.print("pofile:           ");
            System.out.println(companyToPrint.profile);
            System.out.print("money:               ");
            System.out.println(companyToPrint.money);

            System.out.println("---------------------------------------------------------");
        });
    }

    public List<Worker> listCompanyWorkers() {
        return this.workers;
    }

    public List<Boss> listCompanyBosses() {
        return this.bosses;
    }

    public int getCompanyID() {
        return this.companyID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void employ(Person newEmployee) {
        if (newEmployee instanceof Worker) {
            if (!this.workers.contains((Worker) newEmployee)) {
                if (!((Worker) newEmployee).haveAJob()) {
                    this.workers.add((Worker) newEmployee);
                    System.out.println(((Worker) newEmployee).name + " got a new job in " + this.name);
                }
            } else {
                System.out.println(((Worker) newEmployee).name + " was already working for " + this.name);
            }
        }
        if (newEmployee instanceof Boss) {
            if (!this.bosses.contains((Boss) newEmployee)) {
                this.bosses.add((Boss) newEmployee);
                System.out.println(((Boss) newEmployee).name + " got a new job as a manager in " + this.name);
            } else {
                System.out.println(((Boss) newEmployee).name + " was already working for " + this.name);
            }
        }
    }

    public void fireEmployee(byte angerLevelOfCEO) {
        Iterator<Worker> i = workers.iterator();
        while (i.hasNext()) {
            Worker workerInDanger = i.next();
            if (workerInDanger.getFireingReqvests() > (10 - angerLevelOfCEO)) {
                i.remove();
                workerInDanger.looseJob();
                System.out.println(workerInDanger.name + " lost " + workerInDanger.gender.genderTextHisHer() + " job at " + this.name);
            } else {
                System.out.println(workerInDanger.name + " will come to work tomorow, " + workerInDanger.gender.genderTextHeShe() + "is happy.");
            }
        }

    }

    private void payEmployeesOnList(List<Person> employeeList) {
        for (Person employeeOnPayList : employeeList) {
            employeeOnPayList.receaveSalary();
            System.out.println(this.name + " have " + this.money + "HUF");
        }
    }

    public void payEmployees() {
        List<Person> payList = new ArrayList();
        for (Boss bossWhoDemandMoney : this.bosses) {
            payList.add(bossWhoDemandMoney);
        }
        for (Worker workerWhoDemandMoney : this.workers) {
            payList.add(workerWhoDemandMoney);
        }
        for (Person personOnPayList : payList) {
            if (this.money >= personOnPayList.getSalary()) {
                this.money = this.money - personOnPayList.getSalary();
                personOnPayList.receaveSalary();
            } else {
                System.out.println("This company don't have enough money to pay everybody on paylist");
            }
        }

    }
}
