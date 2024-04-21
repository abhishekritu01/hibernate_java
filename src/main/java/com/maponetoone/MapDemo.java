package com.maponetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // Creating question
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestion("What is Java?");


        // Creating answer
        Answer answer = new Answer();
        answer.setAnswerId(101);
        answer.setAnswer("Java is a programming language");
        answer.setQuestion(question);
        question.setAnswer(answer);

        // Creating question
        Question question1 = new Question();
        question1.setQuestionId(2);
        question1.setQuestion("What is Javascript ?");

        // Creating answer
        Answer answer1 = new Answer();
        answer1.setAnswerId(102);
        answer1.setAnswer("Javascript is a scripting language");
        answer1.setQuestion(question1);
        question1.setAnswer(answer1);

        //========================================================================================================
        Session session = factory.openSession();
        session.beginTransaction();

        session.save(question);
        session.save(question1);
        session.save(answer);
        session.save(answer1);


        session.getTransaction().commit();


        //========= fetching data from database ==========
        Question q = session.get(Question.class, 1);
        System.out.println(q.getQuestion());
        session.close();
        factory.close();
    }
}
