<h1>MuleSoft Internship Screening Test</h1>

<h3> How to run this file ?</h3>

```
> javac file_name.java
> java -classpath ".;sqlite-jdbc-(VERSION).jar" Sample   # in Windows
or
> java -classpath ".:sqlite-jdbc-(VERSION).jar" Sample   # in Mac or Linux

```  
<h3> TASKS AND SOLUTIONS</h3>
<hr />
1.  Connect to the SQLite database (or any Database you know): Learn how to download SQLiteJDBC driver and connect to an existing SQLite database using JDBC. Creating a new SQLite database – Learn how to create a new SQLite database from a Java (any language) program using SQLiteJDBC driver or related driver.

<h6> (NAME OF THE DB FILE IS MOVIE.DB (IF FILE DOESNOT EXISTS, IT WILL BE CREATED)) </h6>

**connecttodb.java**

```java
import java.sql.*;

public class connecttodb {
  public static void main( String args[] ) {
      Connection c = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:movie.db");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Opened database successfully");
   }
}
```    
2.  Creating a new table (Movies) using JDBC / Other Languages – before working with data, you need to create a table called Movies. Learn how to create a new table in an SQLite database from a Java (any language) program.

<p align="center">
  <img src="https://github.com/Avinashroffl/MULESOFT_SUBMISSION/blob/main/MOVIETABLE.png" />
</p>


**createtable.java**

```java
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
```  

3.   Inserting data into Movies table from a Java (any language) program

**insertingdata.java**

```java
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
``` 

4.   Querying data from Movies table with or without parameters – after having the movies data in the table, you need to query the movie details (name, actor, actress, director, year of release) using a SELECT statement. You will need to write a program to issue a simple SELECT statement to query all rows from the Movies table, as well as use a query with parameter like actor name to select movies based on the actor's name.

**selectall.java**

```java
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
      ResultSet rs = stmt.executeQuery( "SELECT * FROM MOVIES;" );
      
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
``` 
QUERY USED:
```SQL
SELECT * FROM MOVIES
``` 

5.   SELECTING ROWS BASED ON ACTOR NAME:

**basedonactor.java**

```java
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
      ResultSet rs = stmt.executeQuery( "SELECT * FROM MOVIES WHERE ACTORNAME='Rajinikanth';" );
      
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
``` 
QUERY USED:
```SQL
SELECT * FROM MOVIES WHERE ACTORNAME='Rajinikanth'
```

<hr />
<p align="center">
<a href="https://github.com/Avinashroffl/MULESOFT_SUBMISSION/blob/main/SCREENSHOTS.pdf" target="_blank" >FINAL OUTPUT SCREENSHOTS</a>
</p>
<hr />
