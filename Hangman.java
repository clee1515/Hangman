import java.util.Scanner;
import java.util.ArrayList;

public class Hangman
{
  public static void main(String[] args){
    String playerAnswer = "_ _ _ _ _ ";
    ArrayList<String> guesses = new ArrayList<String>();
    int lives = 10;
    int right = 0;
    int past = 0;
    int amount = 1;
    Boolean notGuessed = true;
    Scanner input = new Scanner(System.in);
    HangmanAnswer hma = new HangmanAnswer();
    System.out.print("What is your guess?");
    while (right != 5 && lives != 0)
    { 
      String guess = input.nextLine();
      guesses.add(guess);
      amount++;
      {
        for (int i = 0; i < guesses.size(); i++)
        {
          if (guess.equals(guesses.get(i)))
          { 
            past++;
          }
        }
        if (past > amount)
        {
          notGuessed = false;
          System.out.print("You already picked " + guess + " ! Pick another.");
          past = 0;
          amount = 0;
        } 
        else if (notGuessed = true)
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
                System.out.print("What is your next guess?");
                guesses.add(guess);
              }
              else if (lives == 0)
              {
                System.out.print("You didn't guess the word. It was " + hma.getAnswer() + ".");
              }
              else 
              {
                System.out.print("Sorry, wrong answer. You have " + lives + " lives left. ");
                System.out.println(playerAnswer);
                System.out.print("What is your next guess?");
                guesses.add(guess);
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
              if (guess.equals("a") || guess.equals("e") || guess.equals("i") || guess.equals("o") || guess.equals("u"))
              {
                System.out.print("Correct, there is an " + guess + " in the word. ");
                playerAnswer = playerAnswer.substring(0, found * 2) + guess + playerAnswer.substring(found * 2 + 1);
                System.out.print(playerAnswer);
                System.out.print("What is your next guess?");
                guesses.add(guess);
              }
              else 
              {
                System.out.print("Correct, there is a " + guess + " in the word. ");
                playerAnswer = playerAnswer.substring(0, found * 2) + guess + playerAnswer.substring(found * 2 + 1);
                System.out.print(playerAnswer);
                System.out.print("What is your next guess?");
                guesses.add(guess);
              }
            }
          }   
        }
      }
    }
  }
}







