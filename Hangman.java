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
       if (right == 5)
      {
        System.out.print("Good Job!You guessed " + playerAnswer + " correctly!");
      }
       
      else if (lives == 0)
      {
        System.out.print("Sorry, you didn't guess the word. It was " + playerAnswer + ".");
      }
     
      System.out.print("What is your guess?");
                         
      String guess = input.nextLine();
      
      {
        int found = hma.getAnswer().indexOf(guess);
        
        if (found == -1)
        {
          lives--;
          System.out.print("Sorry, wrong answer. You have " + lives + " lives left");
          System.out.println(playerAnswer);
        }
        
        else 
        {
          right ++;
          System.out.print("There is a " + guess + " in the word.");
          playerAnswer = playerAnswer.substring(0, found * 2) + guess + playerAnswer.substring(found * 2 + 1);
          System.out.print(playerAnswer);
        }
      }
      }
  }
}
  
  