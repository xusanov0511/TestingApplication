package com.company.testingsystem.client.ui;

import com.company.testingsystem.client.util.ScannerUtil;
import com.company.testingsystem.server.dto.Result;
import com.company.testingsystem.server.dto.SubjectDTO;
import com.company.testingsystem.server.model.User;
import com.company.testingsystem.server.service.SubjectService;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Set;

public class SubjectUI {

    public void addSubject() {
        System.out.print("Enter subject name: ");
        String subjectName = ScannerUtil.SCANNER_STR.nextLine();

        SubjectService subjectService = new SubjectService();
        SubjectDTO subjectDTO = new SubjectDTO(subjectName);
        Result result = subjectService.addSubject(subjectDTO);
        System.out.println(result);
    }

    public Set<String> showSubjects() {
        SubjectService subjectService = new SubjectService();
        Set<String> subjects = subjectService.getSubjects();
        int i = 1;
        for (String subject : subjects) {
            System.out.println(i++ + ". -> " + subject);
        }
        return subjects;
    }

    public void chooseSubject(User sessionUser) {
        //todo
    }

    public void showHistory(User sessionUser) {
        //todo
    }
}
