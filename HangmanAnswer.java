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
    
    while (answer.length() != 5 || x == true)
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
              x = true;
            }
          }
        }
      }
    }
    {
      String input = answer;
      String lower = input.toLowerCase();
      System.out.print(lower + "     ");
    }
  }
  public String getAnswer()
  {
    return answer.toLowerCase();
  }
}
