import database.DbConnect;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        UserScore us = new UserScore();
        Scanner sc = new Scanner(System.in);
        ArrayList<Quiz> quiz = new ArrayList<Quiz>();
        ResultSet rs;


        System.out.print("Sign Up New User : ");
        String username = sc.nextLine();
        us.setUserName(username);

        System.out.println("Choose quiz Topic : ");
        System.out.println("(A) Football");
        System.out.println("(B) Movies");
        System.out.print("Answer : ");
        String answer = sc.nextLine();
        switch (answer) {
            case "A":
                System.out.println("User selected football.");
                String query = "SELECT * FROM `multichoiceQuiz`";
                rs = DbConnect.getFromDB(query);
                while (rs.next()) {
                    quiz.add(new MultichoiceQuiz(rs.getString("question"), rs.getString("answerA"), rs.getString("answerB"), rs.getString("answerC"), rs.getString("answerD"), rs.getString("correctAnswer")));
                }
                for (int i = 0; i < quiz.size(); i++){
                    MultichoiceQuiz mq = (MultichoiceQuiz) quiz.get(i);
                    System.out.println(mq.getQuestion());
                    System.out.println("(A) "+mq.getAnswerA());
                    System.out.println("(B) "+mq.getAnswerB());
                    System.out.println("(C) "+mq.getAnswerC());
                    System.out.println("(D) "+mq.getAnswerD());
                    answer = sc.nextLine();
                    if (answer.equals("A")){
                            if(mq.isCorrectAnswer("A")){
                                System.out.println("Correct Answer");
                                System.out.println("(A) Next Question");
                                System.out.println("(B) Exit Current Round");
                                answer = sc.nextLine();
                                if(answer.equals("A")){
                                    continue;
                                } else if(answer.equals("B")){
                                    break;
                                }
                            } else {
                                System.out.println("Incorrect Answer");
                                System.out.println("Exit Current Round");
                                break;
                            }
                            break;
                    } else if (answer.equals("B")){
                        if(mq.isCorrectAnswer("B")){
                            System.out.println("Correct Answer");
                            System.out.println("(A) Next Question");
                            System.out.println("(B) Exit Current Round");
                            answer = sc.nextLine();
                            if(answer.equals("A")){
                                continue;
                            } else if(answer.equals("B")){
                                break;
                            }
                        } else {
                            System.out.println("Incorrect Answer");
                            System.out.println("Exit Current Round");
                            break;
                        }
                        break;
                    } else if (answer.equals("C")){
                        if(mq.isCorrectAnswer("C")){
                            System.out.println("Correct Answer");
                            System.out.println("(A) Next Question");
                            System.out.println("(B) Exit Current Round");
                            answer = sc.nextLine();
                            if(answer.equals("A")){
                                continue;
                            } else if(answer.equals("B")){
                                break;
                            }
                        } else {
                            System.out.println("Incorrect Answer");
                            System.out.println("Exit Current Round");
                            break;
                        }
                        break;
                    } else if (answer.equals("D")){
                        if(mq.isCorrectAnswer("D")){
                            System.out.println("Correct Answer");
                            System.out.println("(A) Next Question");
                            System.out.println("(B) Exit Current Round");
                            answer = sc.nextLine();
                            if(answer.equals("A")){
                                continue;
                            } else if(answer.equals("B")){
                                break;
                            }
                        } else {
                            System.out.println("Incorrect Answer");
                            System.out.println("Exit Current Round");
                            break;
                        }
                        break;
                    }
                }
                break;
            case "B":
                System.out.println("User selected movies.");
                break;
        }


    }
}
