package customer;
import java.sql.*;
import tools.*;

/*
   @author stephan@stephanwiesner.de
*/
public class Customer
{
   private String name = "";
   private String firstname = "";
   private int id = -1;
   private String street;
   private String city;
   private String password;
   private String mail;
   private int housenumber;
   private int zipcode ;
   private static PropertiesSingleton config;
   java.util.logging.Logger logger = LoggerInitiator.getLogger();

   /** Standard constructor. */
   public Customer()
   {  config = PropertiesSingleton.getInstance();  }


   public Customer(String mail, String password) throws SQLException
   {
      this();
      this.mail =mail;
      this.password = password;
      load();
   }



   public void setName(String name)
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


   public void setStreet(String street) {
      this.street = street;
   }
   public void setCity(String city) {
      this.city = city;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public void setHousenumber(int housenumber) {
      this.housenumber = housenumber;
   }
   public void setZipcode(int zipcode) {
      this.zipcode = zipcode;
   }
   public String getStreet() {
      return street;
   }
   public String getCity() {
      return city;
   }
   public String getPassword() {
      return password;
   }
   public int getHousenumber() {
      return housenumber;
   }
   public int getZipcode() {
      return zipcode;
   }
   public void setMail(String mail) {
      this.mail = mail;
   }
   public String getMail() {
      return mail;
   }


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


   public void create() throws SQLException
   {
      String sql = "INSERT INTO Customer (firstname, name, street, housenumber, "
         + "zipcode, city, password, mail) "
         + "VALUES('" + firstname + "', '" + name
         + "', '" + street + "', " + housenumber
         + ", " + zipcode + ", " + "'" + city + "', '"
         + password + "', '" + mail + "')";
      logger.info(sql);
      createConnection().createStatement().execute(sql);
   }


   private void load() throws SQLException
   {
      String sql = "SELECT * FROM Customer WHERE Mail='" + mail
         + "' AND Password='" + password + "'";
      logger.info(sql);
      ResultSet r = createConnection().createStatement().executeQuery(sql);
      if (r.next())
      {
        id    = r.getInt("id");
        name    = r.getString("Name");
        firstname = r.getString("Firstname");
        street = r.getString("Street");
        housenumber = r.getInt("Housenumber");
        zipcode    = r.getInt("ZIPCODE");
      }
      else { throw new SQLException("No customer with id=" + id + " found!"); }
   }

}

