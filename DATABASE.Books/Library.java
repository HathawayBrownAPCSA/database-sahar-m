/**
 * Makes a list of books being read
 *
 * @author APCSA @ HB//Sahar Maleki
 * @version 2/13/22
 */

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Library
{
    ArrayList<Book> bookList;
    
    /**
     * Constructor for objects of class Library
     */
    public Library()
    {
        bookList = new ArrayList<Book>();
    }
    
      // Loads a list of Books from fileName 
      //***APCSA LibraryTask starter code 
  public Library(String fileName)
  {
    bookList = new ArrayList<Book>();
    //String fileName = "catalog.csv";
    
    // Open the file for input
    File file = new File(fileName);
    Scanner sourceFile = null;
    try
    {
        sourceFile = new Scanner(file);
    }
    catch (FileNotFoundException ex)
    {
        System.out.println("*** Cannot open " + fileName + " ***");
        System.exit(1);        // quit the program
    } 
    String dummy = sourceFile.nextLine();

    // Fill the Collection from the input file
    while (sourceFile.hasNext())
    {
      String str = sourceFile.nextLine();
      Book nextBook = new Book(str);
      insert(nextBook);
    }

    sourceFile.close();

     
  }
  
  /* inserts the new book into the lsit in the appropriate place
   * @param nextBook the book to insert in the list
   */
  public void insert(Book b)
  {
      if (bookList.size() == 0)
      {
          bookList.add(b);
      }
      else
      {
          int loc = bookList.size();
          while (loc > 0 && bookList.get(loc - 1).compareTo(b) > 0)
          {
              loc--;
          }
          bookList.add(loc,b);
      }
  }

  public void writeToFile(String fileName)
  {
    // Open the file for output
    File file = new File (fileName);
    PrintWriter outputFile = null;

    try
    {
      outputFile = new PrintWriter(file); 
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("*** Cannot create " + fileName);
    }
    
    // print the header
    outputFile.println("title, freePages, pageCount, percentAvail");
    for (Book b : bookList)
    {
      outputFile.println(b.toCSV());
    }
    
    outputFile.close();  // crucial to clse the file when you're done 
  }
  
  public ArrayList<Book> filter (String target)
  {
      ArrayList<Book> results = new ArrayList<Book>();
      
      for (Book b: bookList)
      {
          if (b.getPageCount() >= 0 || 
          b.getPercentAvail() >= 0 || 
          b.getTitle().indexOf(target) >= 0 || b.getFreePages() >= 0)
          {
              results.add(b);
          }
      }
      
      return results;
  }
  /** Writes the BookList with a new line between each Book */
  public String toString()
  {
    String result = "";
    for (Book b : bookList)
    {
      result += b + "\n";
    }
    return result;
  }
}
