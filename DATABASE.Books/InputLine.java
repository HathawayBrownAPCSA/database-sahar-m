/** A line of input in Comma-Separated-Values (CSV) format.
 *  This class includes methods for extracting the next token
 *  from the input String, and for determining whether 
 *  there are any more tokens on the line.
 *
 * @author  APCS-A @ Hathaway Brown School
 * @version 2020-01
 */

public class InputLine
{
  private String input;

  /** Constructor initializes the InputLine with a String.
   *  PRECONDITION: str is in Comma-Separated-Values (csv) format.
   *
   *  @param   str a new InputString in csv format*/
  public InputLine(String str)
  {
    input = str;
  }

  /**  Determines whether the InputString has another token or not
   *
   *  @return true if there is another token on the InputString; false otherwise
   */
  public boolean hasNext()
  {
    return (input.length() > 0);
  }

  /** Returns the next token in InputString and removes it from
   *  the String.  Note: returns a String; you must convert
   *  it to a different data type if you need one.
   *  POSTCONDITION: the current token and following comma are
   *    removed from the InputString.
   *
   *  @return a String representing the next token on the InputString 
   */
   public String nextToken()
   {
     String token;
     if (input.charAt(0) == '\"')          // if it's open quote
     {
       int loc = input.indexOf('\"', 1);   // ends at close quote
       token = input.substring(1, loc);
       input = input.substring(loc + 2);
     }
     else    // look for comma
     {
       int loc = input.indexOf(",");
       if (loc == -1)
       {
         token = input;
         input = "";
       }
       else
       {
         token = input.substring(0, loc);
         input = input.substring(loc + 1);
       }

     }
     //System.out.println(input);
     return token;
   }
}
