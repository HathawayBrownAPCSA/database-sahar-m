/**
 * Tests the book class.
 *
 * @author Sahar Maleki & APCSA @ HB (starter code for LibraryTask)
 * @version 2/13/22
 */

import java.util.Scanner;

public class BooksTester
{
    
    public static void main (String[] args)
    {
    //NEW CODE (takes .csv file input)
    Library books = new Library("reading.csv");
    System.out.println(books);
    }
}