package com.company.testingsystem.client.ui;

import com.company.testingsystem.client.util.ScannerUtil;
import com.company.testingsystem.server.enums.Role;
import com.company.testingsystem.server.model.User;
import com.company.testingsystem.server.service.UserService;

import javax.security.auth.Subject;
import java.util.ArrayList;

public class UserUI {
    public void cabinet(User sessionUser) {
        if(sessionUser.getRole().equals(Role.STUDENT)){
            studentMenu(sessionUser);
        }else{
            teacherMenu(sessionUser);
        }
    }

    private void teacherMenu(User sessionUser) {
        SubjectUI subjectUI = new SubjectUI();
        QuestionUI questionUI = new QuestionUI();
        AuthUI authUI = new AuthUI();
        while(true) {
            System.out.println("""
                    1️⃣. Add subject
                    2️⃣. Show subject
                    3️⃣. Add question
                    4️⃣. Show question
                    5️⃣. Show users
                    6️⃣. Change password
                    0️⃣. Back
                    ➡:
                    """);

            String cmd = ScannerUtil.SCANNER_STR.nextLine();
            switch (cmd) {
                case "0" -> {return;}
                case "1" -> subjectUI.addSubject();                 //done
                case "2" -> subjectUI.showSubjects();               //done
                case "3" -> questionUI.addQuestion();               //todo
                case "4" -> questionUI.showQuestions();             //done
                case "5" -> showUsers();                            //done
                case "6" -> authUI.changePassword(sessionUser);     //done
            }
        }
    }

    private void showUsers() {
        UserService userService = new UserService();
        ArrayList<User> users = userService.getUserList();
        int i = 1;
        for (User user : users) {
            System.out.println(i++ + ". ->" + user.getName());
        }
    }

    public void studentMenu(User sessionUser) {
        SubjectUI subjectUI = new SubjectUI();
        QuestionUI questionUI = new QuestionUI();
        AuthUI authUI = new AuthUI();
        while(true) {
            System.out.println("""
                    1️⃣. Choose subject
                    2️⃣. Show subject
                    3️⃣. Show history
                    4️⃣. Change password
                    0️⃣. Back
                    ➡:
                    """);
            String cmd = ScannerUtil.SCANNER_STR.nextLine();
            switch (cmd) {
                case "0" -> {return;}
                case "1" -> subjectUI.chooseSubject(sessionUser);   // todo
                case "2" -> subjectUI.showSubjects();               // done
                case "3" -> subjectUI.showHistory(sessionUser);     // todo
                case "4" -> authUI.changePassword(sessionUser);     // done
            }
        }
    }
}
