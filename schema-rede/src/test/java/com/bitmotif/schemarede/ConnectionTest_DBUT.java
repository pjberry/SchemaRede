package com.bitmotif.schemarede;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Jun 16, 2010
 * Time: 8:29:35 PM
 */
public class ConnectionTest_DBUT {

   @Test
   public void testConnection() throws Exception {

      try {
         Class.forName ("oracle.jdbc.driver.OracleDriver");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }

      Connection conn = DriverManager.getConnection
         ("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "a");
      // @machineName:port:SID,   userid,  password


      // a little test
      // yet again

      Statement stmt = conn.createStatement();
      ResultSet rset = stmt.executeQuery("select BANNER from SYS.V_$VERSION");
      while (rset.next())
         System.out.println ("********** " + rset.getString(1));   // Print col 1
      stmt.close();

   }
}
