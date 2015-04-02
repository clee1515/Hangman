public class Hangman
{
  void print display()
  {
    for(string s : display)
    {
      if (s != null)
        system.out.print(s + " ");
      else 
        system.out.print("_")
    }
    system.out.println();