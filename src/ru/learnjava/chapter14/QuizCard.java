package ru.learnjava.chapter14;

/**
 * Created by belyakovvv1 on 13.07.2017.
 */
public class QuizCard {

    String question;
    String answer;

    public QuizCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
