import java.util.Scanner;

public class L2 
{
    Question second = new Question();
    Question secondRight = new Question();
    
    Tools score = new Tools();
    Tools attempt = new Tools();
    
    public L2()
    {
        System.out.println("\nWelcome to Level 2");
        
        this.score.setScore(0);
        this.attempt.setAttempt(0);
        
        System.out.println("Your score is: " + score.getScore());
        
        //Question and Answer
        while (this.score.getScore() < 5)
        {   
            Tools num1 = new Tools();
            Tools num2 = new Tools();
            
            int x = num1.Random();
            int y = num2.Random();
            
            int answer = (x + y);
            
            Scanner input = new Scanner(System.in);
            
            second.setText("\nIs " + x + " + " + y + " less than 10? (Yes/No): ");
            second.display();
            
            if (answer < 10)
            {
                second.setAnswer("Yes");
                String choice = input.next();
                
                if (choice.equalsIgnoreCase(second.getAnswer()))
                {
                    System.out.println("Correct, " + x + " + " + y + " is less than 10");
                    
                    secondRight.setText("\nWhat is " + x + " + " + y + "? ");
                    secondRight.display();
                    int response = input.nextInt();
                    
                    if (response == answer)
                    {
                        score.addScore();
                        System.out.println("Correct, " + x + " + " + y + " = "+ answer);
                        System.out.println("Your score is: " + score.getScore() + "/5");
                    }
                    
                    if (response != answer)
                    {
                        score.removeScore();
                        attempt.addAttempt();
                        
                        System.out.println("Wrong, " + x + " + " + y + " = " + answer);
                        System.out.println("\nOne Attempt Left");
                        System.out.println("Your score is: " + score.getScore() + "/5");
                    }
                }
                
                if (choice.equalsIgnoreCase(second.getAnswer()) == false)
                {
                    score.removeScore();
                    attempt.addAttempt();
                    
                    System.out.println("Wrong, " + x + " + " + y + " is less than 10");
                    System.out.println("\nOne Attempt Left");
                    System.out.println("Your score is: " + score.getScore() + "/5");
                }
            }
            
            if (answer >= 10)
            {
                String choice = input.next();
                second.setAnswer("No");
                
                if (choice.equalsIgnoreCase(second.getAnswer()))
                {
                    System.out.println("Correct, " + x + " + " + y + " is greater than/equal to 10");
                    
                    secondRight.setText("\nWhat is " + x + " + " + y + "?: ");
                    secondRight.display();
                    
                    int response = input.nextInt();
                    
                    if (response == answer)
                    {
                        score.addScore();
                        
                        System.out.println("Correct, " + x + " + " + y + " = " + answer);
                        System.out.println("\nYour score is: " + score.getScore() + "/5");
                    }
                    
                    if (response != answer)
                    {
                        score.removeScore();
                        attempt.addAttempt();
                        
                        System.out.println("Wrong, " + x + " + " + y + " = " + answer);
                        System.out.println("\nOne Attempt Left");
                        System.out.println("Your score is: " + score.getScore() + "/5");
                    }
                }
                
                if (choice.equalsIgnoreCase(second.getAnswer()) == false)
                {
                    score.removeScore();
                    attempt.addAttempt();
                    
                    System.out.println("Wrong, " + x + " + " + y + " is greater than/equal to 10");
                    System.out.println("\nOne Attempt Left");
                    System.out.println("Your score is: " + score.getScore() + "/5");
                }
            }
            
            if (this.score.getScore() == 5)
            {
                System.out.println("\nAdvancing to Next Level");
            }
            
            if (this.attempt.getAttempt() == 2)
            {
                System.out.println("\n Out of Attempts, Game Over");
                break;
            }
        }
    }
}
