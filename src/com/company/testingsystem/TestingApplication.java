package com.company.testingsystem;

import com.company.testingsystem.client.ui.AuthUI;
import com.company.testingsystem.client.util.ScannerUtil;
import com.company.testingsystem.server.repository.Database;

public class TestingApplication {
    static {
        Database.loadData();
    }
    public static void main(String[] args) {

        System.out.println("Welcome Testing System");
        while(true){
            System.out.println("1️⃣. Login");
            System.out.println("2️⃣. Sign up");
            System.out.println("0️⃣. Exit");
            System.out.print("➡: ");

            String cmd = ScannerUtil.SCANNER_STR.nextLine();

            AuthUI authUI = new AuthUI();
            switch (cmd) {
                case "0" -> {return;}
                case "1" -> authUI.login();
                case "2" -> authUI.signUp();
                default -> System.out.println("Wrong input, Try again");
            }
        }
    }
}