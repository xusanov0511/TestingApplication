package com.company.testingsystem.client.ui;

import com.company.testingsystem.client.util.ScannerUtil;
import com.company.testingsystem.server.dto.QuestionDTO;
import com.company.testingsystem.server.dto.Result;
import com.company.testingsystem.server.model.Question;
import com.company.testingsystem.server.service.QuestionService;
import com.company.testingsystem.server.service.SubjectService;

import java.util.*;

public class QuestionUI {

    public void addQuestion() {
        SubjectService subjectService = new SubjectService();
        QuestionService questionService = new QuestionService();
        Set<String> subjects = subjectService.getSubjects();
        if(subjects.isEmpty()){
            System.out.println("No subject ! ! !");
            return;
        }
        try {
            String subject = checkSubject();
            if(subject != null){
                System.out.print("Enter description: ");
                String description = ScannerUtil.SCANNER_STR.nextLine();

                System.out.print("Enter current answer: ");
                String ca = ScannerUtil.SCANNER_STR.nextLine();

                System.out.print("Enter 1-v: ");
                String v1 = ScannerUtil.SCANNER_STR.nextLine();

                System.out.println("Enter 2-v: ");
                String v2 = ScannerUtil.SCANNER_STR.nextLine();

                QuestionDTO questionDTO = new QuestionDTO(subject, description, ca, v1, v2);
                Result result = questionService.addQuestion(questionDTO);
                System.out.println(result);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String checkSubject() {
        SubjectService subjectService = new SubjectService();
        SubjectUI subjectUI = new SubjectUI();
        Set<String> strings = subjectUI.showSubjects();
        System.out.print("Enter index: ");
        int index = ScannerUtil.SCANNER_NUM.nextInt();
        if(subjectService.trueIndex(index)){
            int i = 1;
            for (String s : strings) {
                if(i++ == index) {
                    return s;
                }
            }
        }else{
            System.out.println("Wrong index");
            return null;
        }
        return null;
    }

    public void showQuestions() {
        QuestionService questionService = new QuestionService();
        SubjectUI subjectUI = new SubjectUI();
        try {
            String subject = checkSubject();
            List<Question> questionList = questionService.getQuestionList(subject);
            int i = 1;
            for (Question question : questionList) {
                System.out.println(i++ + ". -> " + question);
            }
        }catch (InputMismatchException e){
            e.printStackTrace();
        }
    }
}
