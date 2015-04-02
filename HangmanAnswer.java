
import java.util.Scanner;

public class Answer
{ 
  
  Scanner in;
  ArrayList<String> words = new ArrayList<String>();
  public Answer()
  { // loads in contents of words into new ArrayList
    int counter = 0;
    try
    {
      in = new Scanner(new File("words.txt"));
// in = new Scanner(new File("~/Documents/words.txt"));
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
// find a five-letter word and copy it into instance variable
  }
  
  public void play()
  {
    //
    System.out.println("ready.");
  }
}
String random = 