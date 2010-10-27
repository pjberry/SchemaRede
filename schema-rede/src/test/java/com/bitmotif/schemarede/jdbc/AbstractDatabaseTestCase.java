package com.bitmotif.schemarede.jdbc;

import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Jun 22, 2010
 * Time: 5:29:51 AM
 */
public class AbstractDatabaseTestCase {

   protected Connection conn;

   @Before
   public void createConnection() throws Exception {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "a");
   }

   @After
   public void closeConnection() throws Exception {
      conn.close();
   }
}
