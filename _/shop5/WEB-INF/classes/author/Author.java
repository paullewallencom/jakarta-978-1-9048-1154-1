package author;
import java.sql.*;
import org.apache.struts.action.ActionForm;
import tools.*;

public class Author
{
   private String name = "";
   private String firstname = "";
   private int id = -1;
   private static PropertiesSingleton config;

   public Author()
   {  config = PropertiesSingleton.getInstance();    }

   public Author(int id) throws SQLException
   {
      this();
      this.id = id;
      load();
   }

   public void setname(String name)
   { this.name = name; }

   public void setFirstname(String firstname)
   { this.firstname = firstname; }
   public void setId(int id)
   { this.id = id; }
   public String getName()
   { return name; }
   public String getFirstname()
   { return firstname; }
   public int getId()
   { return id; }

   private Connection createConnection() throws SQLException
   {
      if (id < 1) { throw new SQLException(
      "Please provide an ID!"); }
      try {
         Class.forName(config.getProperty("db.db"));
      }catch(ClassNotFoundException ex)
      { throw new SQLException("Could not load DB Driver!"); }
      Connection connection =
         DriverManager.getConnection(
         config.getProperty("db.driver"),
         config.getProperty("db.user"),
         config.getProperty("db.password"));
      return connection;
   }

   public void create() throws SQLException
   {
      String sql = "INSERT INTO author (id, Firstname, Name)"
         + "VALUES(" + id + ", '" + firstname + "', '" +name+ "')";
      createConnection().createStatement().execute(sql);
   }

   public void store() throws SQLException
   {
      String sql = "UPDATE author SET "
         + "Firstname='" + firstname + "', Name='" + name + "' "
         + "WHERE id=" + id;
      createConnection().createStatement().execute(sql);
   }

   private void load() throws SQLException
   {
      String sql = "SELECT * FROM author WHERE id=" + id;
      ResultSet r = createConnection().
         createStatement().executeQuery(sql);
      if (r.next())
      {
        name    = r.getString("Name");
        firstname = r.getString("Firstname");
      }
      else { throw new SQLException("No author with id="
        + id + " found!"); }
   }
}

