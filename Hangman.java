//Connor Lee
import java.util.Scanner;
import java.util.ArrayList;

public class Hangman
{
  public static void main(String[] args){
    String playerAnswer = "_ _ _ _ _ ";
    ArrayList<String> guesses = new ArrayList<String>();//string that is the letters guessed already, used to address people guessing the same letter twice
    ArrayList<String> show = new ArrayList<String>();//string that is the letters guessed already, used to show player what he already guessed
    int lives = 10;//int that subtracts when one guesses wrong
    int right = 0;//int that adds when one guesses right
    int past = 0;//int that counts if player guessed same letter twice
    int amount = 1;//if past is greater than amount, the player guessed the same letter twice. ahs to start with 1 instead of 0 to work
    Boolean notGuessed = true;
    Scanner input = new Scanner(System.in);
    HangmanAnswer hma = new HangmanAnswer();//takes the random answer from HangmanAnswer
    System.out.print("Please guess one letter at a time. What is your guess?");
    while (right != 5 && lives != 0)//if right = 5, player wins. if lives = 0, player loses. 
    { 
      String guess = input.nextLine();
      guesses.add(guess);
      amount++;
      {
        for (int i = 0; i < guesses.size(); i++)//runs loop to check for duplicate letter
        {
          if (guess.equals(guesses.get(i)))//This is for when the person guesses the same letter twice
          { 
            past++;
          }
        }
        if (past > amount)
        {
          notGuessed = false;//if past is greater than amount, the player guessed the same letter twice. 
          System.out.print("You already picked " + guess + " ! Pick another.");
          past = 0;//resets past and amount so it can scan the word every guess. 
          amount = 0;
        } 
        else if (notGuessed = true)//if player didnt guess the same letter, the below happens
        {                     
          int found = hma.getAnswer().indexOf(guess);
          if (found == -1)
          {
            lives--;//if they guessed wrong, it would return -1 and it would subtract a life. 
            {
              if (lives == 1)
              {
                System.out.print("Sorry, wrong answer. You have " + lives + " life left. ");
                System.out.println(playerAnswer);
                System.out.print("What is your next guess?");
                System.out.print("So far, you chose " + show);
                guesses.add(guess);
                show.add(guess);
              }
              else if (lives == 0)//if lives = 0, the player loses. It prints out the correct word. 
              {
                System.out.print("You didn't guess the word. It was " + hma.getAnswer() + ".");
              }
              else 
              {
                System.out.print("Sorry, wrong answer. You have " + lives + " lives left. ");
                System.out.println(playerAnswer);//returns if player guesses wrong. Prints how much lives there are left. 
                System.out.print("What is your next guess?");
                show.add(guess);
                System.out.print(" So far, you chose " + show);
                guesses.add(guess);
              }
            }      
          }
          else 
          {
            right ++;
            if (right == 5)//when right = 5, the player wins. This prints out the correct word. 
            {
              playerAnswer = playerAnswer.substring(0, found * 2) + guess + playerAnswer.substring(found * 2 + 1);
              System.out.print("Good Job!You guessed " + playerAnswer + " correctly!");
            }  
            else
            {
              if (guess.equals("a") || guess.equals("e") || guess.equals("i") || guess.equals("o") || guess.equals("u"))
              {
                System.out.print("Correct, there is an " + guess + " in the word. ");//for when player is wrong with a vowel
                playerAnswer = playerAnswer.substring(0, found * 2) + guess + playerAnswer.substring(found * 2 + 1);
                System.out.print(playerAnswer);
                System.out.print("What is your next guess?");
                show.add(guess);//adds guess to show, the displayed past guesses
                System.out.print(" So far, you chose " + show);
                guesses.add(guess);
              }
              else 
              {
                System.out.print("Correct, there is a " + guess + " in the word. ");//if player guesses correct with something other than a vowel, returns this
                playerAnswer = playerAnswer.substring(0, found * 2) + guess + playerAnswer.substring(found * 2 + 1);
                System.out.print(playerAnswer);
                System.out.print("What is your next guess?");
                show.add(guess);
                guesses.add(guess);
                System.out.print(" So far, you chose " + show);
              }
            }
          }   
        }
      }
    }
  }
}







