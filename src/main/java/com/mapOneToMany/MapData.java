package com.mapOneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapData {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // Creating question
        Question question = new Question();
        question.setQuestionId(101);
        question.setQuestion("What is Java?");

        // Creating answer
        Answer answer = new Answer();
        answer.setAnswerId(111);
        answer.setAnswer("Java is a programming language");
        answer.setQuestion(question);

        // Creating answer
        Answer answer1 = new Answer();
        answer1.setAnswerId(112);
        answer1.setAnswer("With the help of Java we can create software");
        answer1.setQuestion(question);

        // Creating answer
        Answer answer2 = new Answer();
        answer2.setAnswerId(113);
        answer2.setAnswer("Java is a platform independent language");
        answer2.setQuestion(question);

        // Creating answer
        Answer answer3 = new Answer();
        answer3.setAnswerId(114);
        answer3.setAnswer("Java is a high level language");
        answer3.setQuestion(question);


       //List of answer
        List<Answer> list = new ArrayList<Answer>();
        list.add(answer);
        list.add(answer1);
        list.add(answer2);
        list.add(answer3);

        question.setAnswers(list);



        

        //=== Saving data ===

        Session session = factory.openSession();
        session.beginTransaction();

        session.save(question);
        session.save(answer);
        session.save(answer1);
        session.save(answer2);
        session.save(answer3);

        session.getTransaction().commit();

        // get data
        Question q = session.get(Question.class, 101);
        System.out.println(q.getQuestion());
        System.out.println(q.getQuestionId());
        List<Answer> ans = q.getAnswers();
        for (Answer a : ans) {
            System.out.println(a.getAnswer()  +"===================================");
        }

        session.close();
        factory.close();




    }
}
