import java.util.Scanner;

public class Hangman
{
  public static void main(String[] args){
    String playerAnswer = "_ _ _ _ _ ";
    
    int lives = 10;
    int right = 0;
    
    Scanner input = new Scanner(System.in);
    HangmanAnswer hma = new HangmanAnswer();
    while (right != 5 && lives != 0)
    {  
      System.out.print("What is your guess?");
      String guess = input.nextLine();
      {
        int found = hma.getAnswer().indexOf(guess);
        
        if (found == -1)
        {
          lives--;
          {
            if (lives == 1)
          {
            System.out.print("Sorry, wrong answer. You have " + lives + " life left. ");
            System.out.println(playerAnswer);
          }
            
          else if (lives == 0)
          {
            System.out.print("You didn't guess the word. It was " + hma.getAnswer() + ".");
          }

          else 
            {
              System.out.print("Sorry, wrong answer. You have " + lives + " lives left. ");
              System.out.println(playerAnswer);
            }
          }    
         
        }
   
        
    else 
        {
          right ++;
          if (right == 5)
          {
            playerAnswer = playerAnswer.substring(0, found * 2) + guess + playerAnswer.substring(found * 2 + 1);
            System.out.print("Good Job!You guessed " + playerAnswer + " correctly!");
          }


          
          else
          {
            System.out.print("There is a(n) " + guess + " in the word. ");
            playerAnswer = playerAnswer.substring(0, found * 2) + guess + playerAnswer.substring(found * 2 + 1);
            System.out.print(playerAnswer);
          }
        }
      }
    }
  }
}

