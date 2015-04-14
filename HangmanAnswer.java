import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class HangmanAnswer
{ 
  Scanner in;
  ArrayList<String> words = new ArrayList<String>();
  String answer = "  ";
  boolean x = false;
  
  { // loads in contents of words into new ArrayList
    int counter = 0;
    try
    {
      in = new Scanner(new File("words.txt"));
      while(in.hasNext())
      {
        words.add(in.next());
        counter++;
      }
    }
    catch(IOException i)
    {
      System.out.println("Error: " + i.getMessage());
    }
    System.out.println(counter + " words loaded in.");
    System.out.println("Size of ArrayList: " + words.size());
    System.out.println(" ");//simply to make the above not visible, but still accessible
    System.out.println(" ");
    System.out.println(" ");
    System.out.println("Welcome to Hangman!");
    
    while (answer.length() != 5 || x == true)//if the found answer isn't 5 letters or has 2 of the same letter in it, the program finds a new word. 
    {
      int random = (int)(Math.random() * words.size());
      answer = words.get(random);
      x = false;
      for (int i = 0; i < answer.length(); i++)
      {
        for (int o = 0; o < answer.length(); o++)
        {
          if (o != i)
          {
            if (answer.substring(i,i+1).equals(answer.substring(o,o+1)))
            {
              x = true;//if there are two of the same letters, x becomes true. 
            }
          }
        }
      }
    }
    {
      String input = answer;
      String lower = input.toLowerCase();//the computer sees a capital letter and a lower case letter as two different characters, so I needed to make the word all lower case in order for it to work.
    }
  }
  public String getAnswer()
  {
    return answer.toLowerCase();
  }
}
