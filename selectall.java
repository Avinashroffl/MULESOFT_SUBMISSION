import java.sql.*;

public class selectall {

  public static void main( String args[] ) {

   Connection c = null;
   Statement stmt = null;
   try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:movie.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM MOVIES WHERE YEAROFRELEASE=2010;" );
      
      while ( rs.next() ) {
         int id = rs.getInt("ID");
         String  mv = rs.getString("MOVIE");
         String  actor = rs.getString("ACTORNAME");
         String  actress = rs.getString("ACTRESSNAME");
         int yor = rs.getInt("YEAROFRELEASE");
         String  dirname = rs.getString("DIRECTORNAME");
         
         System.out.println( "ID = " + id );
         System.out.println( "MOVIE NAME = " + mv );
         System.out.println( "ACTOR NAME = " + actor );
         System.out.println( "ACTRESS NAME = " + actress );
         System.out.println( "YEAR OF RELEASE = " + yor );
         System.out.println( "DIRECTOR NAME = " + dirname );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
   } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
   }
   System.out.println("Selected all data successfully");
  }
}