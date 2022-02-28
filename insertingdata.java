import java.sql.*;

public class insertingdata {

   public static void main( String args[] ) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:movie.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO MOVIES (ID,MOVIE,ACTORNAME,ACTRESSNAME,YEAROFRELEASE,DIRECTORNAME) " +"VALUES (1,'Vaaranam Aayiram','Suriya','Simran and Sameera reddy',2008,'Gautham Vasudev Menon' );"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO MOVIES (ID,MOVIE,ACTORNAME,ACTRESSNAME,YEAROFRELEASE,DIRECTORNAME) " + "VALUES (2,'Minnale','Madhavan','Reema Sen',2001,'Gautham Vasudev Menon' );"; 
         stmt.executeUpdate(sql);

        sql = "INSERT INTO MOVIES (ID,MOVIE,ACTORNAME,ACTRESSNAME,YEAROFRELEASE,DIRECTORNAME) " +"VALUES (3,'Vettaiyaadu Vilaiyaadu','Kamal Haasan','Jyotika',2006,'Gautham Vasudev Menon' );"; 
        stmt.executeUpdate(sql);

        sql = "INSERT INTO MOVIES (ID,MOVIE,ACTORNAME,ACTRESSNAME,YEAROFRELEASE,DIRECTORNAME) " +"VALUES (4,'Maanaadu','Simbu','Kalyani Priyadarshan',2008,'Venkat Prabhu' );"; 
        stmt.executeUpdate(sql);
        
        sql = "INSERT INTO MOVIES (ID,MOVIE,ACTORNAME,ACTRESSNAME,YEAROFRELEASE,DIRECTORNAME) " +"VALUES (5,'Mankatha',' Ajith Kumar','Trisha Krishnan',2011,'Venkat Prabhu' );"; 
        stmt.executeUpdate(sql);

        sql = "INSERT INTO MOVIES (ID,MOVIE,ACTORNAME,ACTRESSNAME,YEAROFRELEASE,DIRECTORNAME) " +"VALUES (6,'Chennai 600028','Jai','Vijayalakshmi Feroz',2007,'Venkat Prabhu' );"; 
        stmt.executeUpdate(sql);

        sql = "INSERT INTO MOVIES (ID,MOVIE,ACTORNAME,ACTRESSNAME,YEAROFRELEASE,DIRECTORNAME) " +"VALUES (7,'Muthu','Rajinikanth','Meena',1995,'K. S. Ravikumar' );"; 
        stmt.executeUpdate(sql);

        sql = "INSERT INTO MOVIES (ID,MOVIE,ACTORNAME,ACTRESSNAME,YEAROFRELEASE,DIRECTORNAME) " +"VALUES (8,'Lingaa','Rajinikanth','Anushka Shetty and Sonakshi Sinha',2014,'K. S. Ravikumar' );"; 
        stmt.executeUpdate(sql);

        sql = "INSERT INTO MOVIES (ID,MOVIE,ACTORNAME,ACTRESSNAME,YEAROFRELEASE,DIRECTORNAME) " +"VALUES (9,'Aadhavan','Suriya','Nayantara',2009,'K. S. Ravikumar' );"; 
        stmt.executeUpdate(sql);

        sql = "INSERT INTO MOVIES (ID,MOVIE,ACTORNAME,ACTRESSNAME,YEAROFRELEASE,DIRECTORNAME) " +"VALUES (10,'Enthiran','Rajinikanth','Aishwarya Rai Bachchan',2010,'S. Shankar' );"; 
        stmt.executeUpdate(sql);

        sql = "INSERT INTO MOVIES (ID,MOVIE,ACTORNAME,ACTRESSNAME,YEAROFRELEASE,DIRECTORNAME) " +"VALUES (11,'Nanban','Vijay','Ileana DCruz',2012,'S. Shankar' );"; 
        stmt.executeUpdate(sql);

        sql = "INSERT INTO MOVIES (ID,MOVIE,ACTORNAME,ACTRESSNAME,YEAROFRELEASE,DIRECTORNAME) " +"VALUES (12,'Jeans','Prashanth and Nassar','Aishwarya Rai Bachchan',1998,'S. Shankar' );"; 
        stmt.executeUpdate(sql);
        

         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }
}