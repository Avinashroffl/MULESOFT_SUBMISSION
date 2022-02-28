import java.sql.*;

public class createtable {

   public static void main( String args[] ) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:movie.db");
         System.out.println("Opened database successfully");
         
         stmt = c.createStatement();
         String sql = "CREATE TABLE MOVIES " +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " MOVIE          TEXT    NOT NULL, " + 
                        " ACTORNAME     TEXT    NOT NULL, " + 
                        " ACTRESSNAME   TEXT    NOT NULL, " + 
                        " YEAROFRELEASE INT     NOT NULL, " + 
                        " DIRECTORNAME   TEXT    NOT NULL)"; 
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Movies Table created successfully");
   }
}