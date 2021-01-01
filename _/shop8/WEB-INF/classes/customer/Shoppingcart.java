package customer;
import java.sql.*;
import java.util.Vector;

import tools.*;

/*
   @author stephan@stephanwiesner.de
*/
public class Shoppingcart
{
   private static PropertiesSingleton config;
   java.util.logging.Logger logger = LoggerInitiator.getLogger();

   /** Standard constructor. */
   public Shoppingcart()
   {  config = PropertiesSingleton.getInstance();  }



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


   public void add(int customer, int book, int count) throws SQLException
   {
      String sql = "INSERT INTO Shoppingcart (customer, book, count) "
         + "VALUES(" + customer + ", " + book + ", " + count + ")";
      logger.info(sql);
      createConnection().createStatement().execute(sql);
   }


   public Vector load(int customer) throws SQLException
   {
      Vector positions = new Vector();
      String sql = "SELECT Price, Name, Titel FROM Shoppingcart AS w, "
         + "Author, Book WHERE w.Customer=" + customer + " AND w.Book=Book.ISBN "
         + "and Book.Author=Author.id ORDER BY Author.id, Book.Titel";
      logger.info(sql);
      ResultSet r = createConnection().createStatement().executeQuery(sql);
      while (r.next())
      {
        ShoppingcartPosition wkp = new ShoppingcartPosition();
        wkp.setBook(r.getString("Titel"));
        wkp.setPrice( r.getInt("Price"));
        wkp.setAuthor(r.getString("Name"));
        positions.add(wkp);
      }
      return positions;
   }

}

