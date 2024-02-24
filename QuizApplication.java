package CodeSoft;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {

	

	
	    private static final int QUESTION_COUNT = 5;
	    private static final int TIME_LIMIT_PER_QUESTION = 30;

	    private int score = 0;
	    private int questionIndex = 0;
	    private String[][] questionsAndAnswers = {
	            {"Question 1: who is pesident of India ", "A. Amit shah", "B.Rahul Gandhi", "C. Narendra Modi", "D.Droupadi Murmu", "D"},
	            {"Question 2: Which of the following is a programming language?", "A. Java", "B. Mozilla", "C. Google", "D. Firefox", "A"},
	            {"Question 3: Which planet is closest to the Sun?", "A. Venus", "B. Mars", "C. Earth", "D. Mercury", "D"},
	            {"Question 4: What does a barometer measure?","A. Sound","B. Light","C. Atmospheric Pressure","D. Humidity","C"},
	            		
	            {"Question 5: Who painted the Mona Lisa?", "A. Leonardo da Vinci", "B. Michelangelo", "C. Raphael", "D. Donatello", "A"}
	    };

	    public void startGame() {
	        Timer timer = new Timer();
	        timer.schedule(new TimerTask() {
	            @Override
	            public void run() {
	                System.out.println("Time's up for this question!");
	                nextQuestion();
	            }
	        }, TIME_LIMIT_PER_QUESTION * 1000);

	        Scanner scanner = new Scanner(System.in);
	        while (questionIndex < QUESTION_COUNT) {
	            String[] question = questionsAndAnswers[questionIndex];
	            System.out.println(question[0]);
	            for (int i = 1; i <= 4; i++) {
	                System.out.println(question[i]);
	            }
	            System.out.print("Enter your answer (A/B/C/D): ");
	            String userAnswer = scanner.nextLine().toUpperCase();
	            if (userAnswer.equals(question[5])) {
	                score++;
	                System.out.println("Correct!");
	            } else {
	                System.out.println("Incorrect!");
	            }
	            nextQuestion();
	        }
	        timer.cancel();
	        displayResult();
	    }

	    private void nextQuestion() {
	        questionIndex++;
	        if (questionIndex < QUESTION_COUNT) {
	            System.out.println("Next question:");
	        }
	    }

	    private void displayResult() {
	        System.out.println("Quiz ended. Your score is: " + score + "/" + QUESTION_COUNT);
	    }

	    public static void main(String[] args) {
	    	QuizApplication quizGame = new QuizApplication();
	        quizGame.startGame();
	    }
	

		

	}


