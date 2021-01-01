package customer;

/*
   @author stephan@stephanwiesner.de
*/
public class ShoppingcartPosition
{
   private String book;
   private String author;
   private int price;


   /** Standard constructor. */
   public ShoppingcartPosition() { }

   public ShoppingcartPosition(String book, String author, int price)
   {
      this.book = book;
      this.author = author;
      this.price = price;
   }


   public void setBook(String book) {
      this.book = book;
   }
   public void setAuthor(String author) {
      this.author = author;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   public String getBook() {
      return book;
   }
   public String getAuthor() {
      return author;
   }
   public int getPrice() {
      return price;
   }


}

