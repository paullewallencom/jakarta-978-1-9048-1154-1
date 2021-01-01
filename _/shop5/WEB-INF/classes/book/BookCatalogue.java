package book;

import java.sql.*;
import java.util.*;

public class BookCatalogue
{
   /** SortedSet is sorted by title. */
   private SortedSet books = Collections.synchronizedSortedSet(new TreeSet());
   /**The List is not sorted,it allows us to sort it by,
      e.g. Price.*/
   private List list = Collections.synchronizedList(new ArrayList());
   private static tools.PropertiesSingleton config;
   private java.util.logging.Logger logger =
      tools.LoggerInitiator.getLogger();

   public BookCatalogue() throws SQLException
   {
      config = tools.PropertiesSingleton.getInstance();
      load();
   }

   public void addBook(Book book)
   {
      list.add(book);
      books.add(book);
   }

   public Iterator getBooks() { return books.iterator(); }
   public Iterator getPriceSortedBooks()
   {
      sortByPrice();
      return list.iterator();
   }


   /** Required for the display of Taglib. */
   public List getList() {
      return this.list;
   }


   /**
      Sorted the books by Price, shellSort time comsuming: n^(6/5))
   */
   private void sortByPrice()
   {
      int[] incremented = { 7,3,1};
      for (int i = 0; i < incremented.length; i++)
      {
         int increment = incremented[i];
         for (int z = 0; z < list.size(); z++)
         {
            Book temp = (Book)list.get(z);
            int location = z;
            while ((location - increment >= 0)
               && (temp.getPrice() <
               ((Book)list.get(location - increment)).getPrice()) )
            {
               list.set(location, list.get(location - increment));
               location -= increment;
            }// while
            list.set(location, temp);
         }// for z
      } // for incremented
   }

   public Book getBook(int i) { return (Book)list.get(i); }

   public int countBooks()
   { return list.size(); }


   private Connection createConnection() throws SQLException
   {
      try {
         Class.forName(config.getProperty("db.db"));
      }catch(ClassNotFoundException ex)
      { throw new SQLException("Could not load DB Driver!"); }
      Connection connection =
      DriverManager.getConnection(config.getProperty("db.driver"),
      config.getProperty("db.user"), config.getProperty("db.password"));
      return connection;
   }

   private void load() throws SQLException
   {
      String sql = "select * from Author, Book where "
         + "Author.id=Book.author order by Book.titel";
      ResultSet r = createConnection().createStatement().executeQuery(sql);
      logger.info("Load:" + sql);
      while (r.next())
      {
        String titel = r.getString("Titel");
        logger.info("have row:" + titel);
        Book b = new Book();
        b.setTitel(titel);
        b.setAuthor(r.getInt("Author"));
        b.setIsbn(r.getInt("ISBN"));
        b.setPrice(r.getInt("Price"));
        b.setAuthorName(r.getString("Name") + ", " + r.getString("Firstname"));
        addBook(b);
      }
   }
}