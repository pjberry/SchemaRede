package com.bitmotif.schemarede.ddl;

import com.bitmotif.schemarede.jdbc.AbstractDatabaseTestCase;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Jun 22, 2010
 * Time: 5:52:17 AM
 */
public class TableFactory_DBUT extends AbstractDatabaseTestCase {

   @Test
   public void testBuildTable() throws Exception {
      DatabaseMetaData databaseMetaData = conn.getMetaData();
      ResultSet resultSet = databaseMetaData.getTables(null, null, "%", null);

      TableFactory tableFactory = new TableFactoryImpl();
      Table table = tableFactory.buildTable(resultSet);

      assertNotNull(table.getName());
   }
}
