import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class HangmanAnswer
{ 
  Scanner in;
  ArrayList<String> words = new ArrayList<String>();
  String answer = "";
  
  public HangmanAnswer()
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
    
    while (answer.length() != 5)
    {
      int random = (int)(Math.random() * words.size());
      answer = words.get(random);
    }
    System.out.println(answer);
  }
  
  public String getAnswer()
  {
    return answer;
  }
}
