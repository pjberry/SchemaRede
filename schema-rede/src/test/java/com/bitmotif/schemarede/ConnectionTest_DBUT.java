package com.bitmotif.schemarede;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
      Class.forName ("oracle.jdbc.driver.OracleDriver");
      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "a");
      Statement stmt = conn.createStatement();
      ResultSet resultSet = stmt.executeQuery("select 1 from dual");

      while(resultSet.next()) {
         assertEquals(1, resultSet.getInt(1));
      }
   }
}
