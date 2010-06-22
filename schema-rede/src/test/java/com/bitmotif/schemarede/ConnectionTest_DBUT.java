package com.bitmotif.schemarede;

import com.bitmotif.schemarede.jdbc.AbstractDatabaseTestCase;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Jun 16, 2010
 * Time: 8:29:35 PM
 */
public class ConnectionTest_DBUT extends AbstractDatabaseTestCase {

   @Test
   public void testConnection() throws Exception {
      Statement stmt = conn.createStatement();
      ResultSet resultSet = stmt.executeQuery("select 1 from dual");

      while(resultSet.next()) {
         assertEquals(1, resultSet.getInt(1));
      }
   }
}
