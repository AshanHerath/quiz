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

        System.out.println("Welcome To Quiz Game");
        System.out.println("(A) View Score Records");
        System.out.println("(B) Start New Game");
        String answer = sc.nextLine();

        switch (answer) {
            case "A":
                System.out.println("Welcome To Score Board");
                System.out.println("(A) View All Records");
                System.out.println("(B) Search By User");
                answer = sc.nextLine();

                switch (answer) {
                    case "A":
                        String query5 = "select * from score";
                        rs = DbConnect.getFromDB(query5);
                        System.out.println("Name || Marks");
                        while (rs.next()) {
                            System.out.println(rs.getString("user") + " || " + rs.getInt("score"));
                        }
                        break;
                    case "B":
                        System.out.println("Enter Username");
                        answer = sc.nextLine();

                        String query6 = "SELECT id, user, score, topic FROM score WHERE user='"+answer+"';";
                        rs = DbConnect.getFromDB(query6);
                        System.out.println("Name || Marks");
                        if(!rs.next())
                            System.out.println("No results found");
                        while (rs.next()) {
                            System.out.println(rs.getString("user") + " || " + rs.getInt("score"));
                        }
                        break;
                }


            case "B":
                System.out.print("Sign Up New User : ");
                String username = sc.nextLine();
                us.setUserName(username);

                System.out.println("Choose quiz Topic : ");
                System.out.println("(A) Football");
                System.out.println("(B) Movies");
                System.out.print("Answer : ");
                answer = sc.nextLine();
                switch (answer) {
                    case "A":
                        System.out.println("User selected football.");
                        String query = "SELECT * FROM `multichoiceQuiz`";
                        rs = DbConnect.getFromDB(query);
                        while (rs.next()) {
                            quiz.add(new MultichoiceQuiz(rs.getString("question"), rs.getString("answerA"), rs.getString("answerB"), rs.getString("answerC"), rs.getString("answerD"), rs.getString("correctAnswer")));
                        }
                        int facedQuizCount = 0;
                        for (int i = 0; i < quiz.size(); i++) {
                            ++facedQuizCount;
                            MultichoiceQuiz mq = (MultichoiceQuiz) quiz.get(i);
                            System.out.println(mq.getQuestion());
                            System.out.println("(A) " + mq.getAnswerA());
                            System.out.println("(B) " + mq.getAnswerB());
                            System.out.println("(C) " + mq.getAnswerC());
                            System.out.println("(D) " + mq.getAnswerD());
                            answer = sc.nextLine();
                            if (answer.equals("A")) {
                                if (mq.isCorrectAnswer("A")) {
                                    us.addMark(1);
                                    System.out.println("Correct Answer");
                                    System.out.println("Mr. " + us.getUserName() + ". Your score is " + us.getUserScore() + "/" + facedQuizCount);
                                    System.out.println("(A) Next Question");
                                    System.out.println("(B) Exit Current Round");
                                    answer = sc.nextLine();
                                    if (answer.equals("A")) {
                                        continue;
                                    } else if (answer.equals("B")) {
                                        break;
                                    }
                                } else {
                                    System.out.println("Incorrect Answer");
                                    System.out.println("Mr. " + us.getUserName() + ". Your score is " + us.getUserScore() + "/" + facedQuizCount);
                                    System.out.println("Exit Current Round");
                                    break;
                                }
                                break;
                            } else if (answer.equals("B")) {
                                if (mq.isCorrectAnswer("B")) {
                                    us.addMark(1);
                                    System.out.println("Correct Answer");
                                    System.out.println("Mr. " + us.getUserName() + ". Your score is " + us.getUserScore() + "/" + facedQuizCount);
                                    System.out.println("(A) Next Question");
                                    System.out.println("(B) Exit Current Round");
                                    answer = sc.nextLine();
                                    if (answer.equals("A")) {
                                        continue;
                                    } else if (answer.equals("B")) {
                                        break;
                                    }
                                } else {
                                    System.out.println("Incorrect Answer");
                                    System.out.println("Mr. " + us.getUserName() + ". Your score is " + us.getUserScore() + "/" + facedQuizCount);
                                    System.out.println("Exit Current Round");
                                    break;
                                }
                                break;
                            } else if (answer.equals("C")) {
                                if (mq.isCorrectAnswer("C")) {
                                    us.addMark(1);
                                    System.out.println("Correct Answer");
                                    System.out.println("Mr. " + us.getUserName() + ". Your score is " + us.getUserScore() + "/" + facedQuizCount);
                                    System.out.println("(A) Next Question");
                                    System.out.println("(B) Exit Current Round");
                                    answer = sc.nextLine();
                                    if (answer.equals("A")) {
                                        continue;
                                    } else if (answer.equals("B")) {
                                        break;
                                    }
                                } else {
                                    System.out.println("Incorrect Answer");
                                    System.out.println("Mr. " + us.getUserName() + ". Your score is " + us.getUserScore() + "/" + facedQuizCount);
                                    System.out.println("Exit Current Round");
                                    break;
                                }
                                break;
                            } else if (answer.equals("D")) {
                                if (mq.isCorrectAnswer("D")) {
                                    us.addMark(1);
                                    System.out.println("Correct Answer");
                                    System.out.println("Mr. " + us.getUserName() + ". Your score is " + us.getUserScore() + "/" + facedQuizCount);
                                    System.out.println("(A) Next Question");
                                    System.out.println("(B) Exit Current Round");
                                    answer = sc.nextLine();
                                    if (answer.equals("A")) {
                                        continue;
                                    } else if (answer.equals("B")) {
                                        break;
                                    }
                                } else {
                                    System.out.println("Incorrect Answer");
                                    System.out.println("Mr. " + us.getUserName() + ". Your score is " + us.getUserScore() + "/" + facedQuizCount);
                                    System.out.println("Exit Current Round");
                                    break;
                                }
                                break;
                            }
                        }
                        System.out.println("Mr. " + us.getUserName() + ". Your score is " + us.getUserScore() + "/" + facedQuizCount);
                        String query2 = "INSERT INTO `score`(`user`, `score`, `topic`) VALUES ('" + us.getUserName() + "','" + us.getUserScore() + "','Football')";
                        DbConnect.pushToDB(query2);
                        break;


                    case "B":
                        System.out.println("User selected movies.");
                        String query3 = "SELECT * FROM `binaryQuiz`";
                        rs = DbConnect.getFromDB(query3);
                        while (rs.next()) {
                            quiz.add(new BinaryChoiceQuiz(rs.getString("question"), Integer.toString(rs.getInt("correctAnswer"))));
                        }
                        int facedQuizCount1 = 0;
                        for (int i = 0; i < quiz.size(); i++) {
                            ++facedQuizCount1;
                            BinaryChoiceQuiz bc = (BinaryChoiceQuiz) quiz.get(i);
                            System.out.println(bc.getQuestion());
                            System.out.println("(A) YES");
                            System.out.println("(B) NO");
                            answer = sc.nextLine();
                            if (answer.equals("A")) {
                                if (bc.isCorrectAnswer("1")) {
                                    us.addMark(1);
                                    System.out.println("Correct Answer");
                                    System.out.println("Mr. " + us.getUserName() + ". Your score is " + us.getUserScore() + "/" + facedQuizCount1);
                                    System.out.println("(A) Next Question");
                                    System.out.println("(B) Exit Current Round");
                                    answer = sc.nextLine();
                                    if (answer.equals("A")) {
                                        continue;
                                    } else if (answer.equals("B")) {
                                        break;
                                    }
                                } else {
                                    System.out.println("Incorrect Answer");
                                    System.out.println("Mr. " + us.getUserName() + ". Your score is " + us.getUserScore() + "/" + facedQuizCount1);
                                    System.out.println("Exit Current Round");
                                    break;
                                }
                                break;
                            } else if (answer.equals("B")) {
                                if (bc.isCorrectAnswer("0")) {
                                    us.addMark(1);
                                    System.out.println("Correct Answer");
                                    System.out.println("Mr. " + us.getUserName() + ". Your score is " + us.getUserScore() + "/" + facedQuizCount1);
                                    System.out.println("(A) Next Question");
                                    System.out.println("(B) Exit Current Round");
                                    answer = sc.nextLine();
                                    if (answer.equals("A")) {
                                        continue;
                                    } else if (answer.equals("B")) {
                                        break;
                                    }
                                } else {
                                    System.out.println("Incorrect Answer");
                                    System.out.println("Mr. " + us.getUserName() + ". Your score is " + us.getUserScore() + "/" + facedQuizCount1);
                                    System.out.println("Exit Current Round");
                                    break;
                                }
                            }

                        }
                        System.out.println("Mr. " + us.getUserName() + ". Your score is " + us.getUserScore() + "/" + facedQuizCount1);
                        String query4 = "INSERT INTO `score`(`user`, `score`, `topic`) VALUES ('" + us.getUserName() + "','" + us.getUserScore() + "','Movies')";
                        DbConnect.pushToDB(query4);
                        break;

                }
                break;
        }


    }
}
