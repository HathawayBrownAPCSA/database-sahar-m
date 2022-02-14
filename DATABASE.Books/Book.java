
/**
 * Represents a book for purchase*
 * @author Sahar Maleki
 * @version 2/13/22
 */

public class Book implements Comparable<Book>
{
    private String title;
    private int pageCount;
    private int freePages;
    private double percentAvail;
    
    // APCSA starter code
    public Book (String str)
  {
    InputLine bookInfo = new InputLine(str);

    String temp = bookInfo.nextToken();
    title = temp;
    
    temp = bookInfo.nextToken();
    pageCount = new Integer(temp);

    temp = bookInfo.nextToken();
    freePages = new Integer(temp);
    
    //temp = bookInfo.nextToken();
    percentAvail = (((double) freePages) / pageCount) * 100;
    percentAvail = ((int) (100 * percentAvail)) / 100.0;
  }
  
    /** The constructor initializes values for book title, page count, and the users current page.
     * it calculates the percent of the book the user has finished reading
     * 
     * @param t The title of the book
     * @param p The total page count of the book
     * @param c The number of pages of the book free on google books
     */
    public Book(String t, int c, int p)
    {
        title = t;
        freePages = c;
        pageCount = p;
        percentAvail = 100.0 * c / p;
        //= percentFree(c, p);
    }
        
    /** stores the users current page number
     * 
     * @param currentPage the number of pages of the book free on google books
     * @return currentPage the number of pages of the book free on google books
     */
    public int getFreePages()
    {
            return freePages;
    }
    
    /** stores the total page count of the book
     * 
     * @param pageCount the total number of pages in the book
     * @return pageCount the total number of pages in the book
     */
    public int getPageCount()
    {
        return pageCount;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    /** Returns an int with the parameter formatted as a percent, to get the percent of the book that the user can read for free 
     * 
     * @param percentFree the percent to be displayed
     * @return the percent of the book the user can read for free(as a double)
     
    private double percentFree(double free, double total)
    {
        double ans = (double) free / total;
        return ans * 100.0;
    }
    */
    
    public double getPercentAvail()
    {
        return percentAvail;
    }
    //APCSA starter code (libraryTask)
    //title,freePages,pageCount, percentAvail
  public String toCSV()
  {
    String result = "";
    result += title + "," ;
    result += withQuotes(title) + ",";
    result += freePages + "," + pageCount + "," + percentAvail;
    return result;
  }

  // If there is a comma in the string,
  // surrounds it with withQuotes
  private String withQuotes (String s)
  {
    if (s.indexOf(',') >= 0)
    {
      return "\"" + s + "\"";
    }
    else
    {
      return s;
    }
  }
  
  public String toString ()
  {
      return title + "\t" + freePages + "\t" + pageCount + "\t" + percentAvail + "\n";
  }
  
  public int compareTo(Book other)
  {
      return (this.title.compareTo(other.title));
      //return (this.freePages - other.freePages);
      //return (other.freePages - this.freePages);
  }
}
