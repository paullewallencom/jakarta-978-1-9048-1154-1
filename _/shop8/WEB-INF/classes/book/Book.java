package book;

import org.apache.struts.action.ActionForm;

/*
   A simple book.
   @author stephan@stephanwiesner.de
*/
public class Book implements Comparable
{
   private String titel = "";
   private int author = -1;
   private int isbn = -1;
   private int price = -1;
   private String authorName = "";

   /** Standard constructor. */
   public Book()   { }

   public void setTitel(String titel)
   { this.titel = titel; }
   public void setAuthor(int author)
   { this.author = author; }
   public void setIsbn(int isbn)
   { this.isbn = isbn; }
   public void setPrice(int price)
   { this.price = price; }
   public String getTitel()
   { return titel; }
   public int getAuthor()
   { return author; }
   public int getIsbn()
   { return isbn; }
   public int getPrice()
   { return price; }
   public void setAuthorName(String authorName) {
      this.authorName = authorName;
   }
   public String getAuthorName() {
      return authorName;
   }

   public int compareTo(Object fremdBook)
   {
      if (! (fremdBook instanceof Book) )
      { return 0; } // unbekannt, also kein Vergleich
      return this.titel.compareToIgnoreCase(
         ((Book)fremdBook).getTitel());
   }

}