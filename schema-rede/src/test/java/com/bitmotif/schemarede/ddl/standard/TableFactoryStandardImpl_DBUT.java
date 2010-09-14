package com.bitmotif.schemarede.ddl.standard;

import com.bitmotif.schemarede.ddl.Table;
import com.bitmotif.schemarede.ddl.TableFactory;
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
public class TableFactoryStandardImpl_DBUT extends AbstractDatabaseTestCase {

   @Test
   public void testBuildTable() throws Exception {
      DatabaseMetaData databaseMetaData = conn.getMetaData();
      ResultSet tableResultSet = databaseMetaData.getTables(null, null, "%", null);
      tableResultSet.next();

      TableFactory tableFactory = new TableFactoryStandardImpl();
      Table table = tableFactory.buildTable(tableResultSet);
      tableResultSet.close();

      assertNotNull(table.getName());
   }
}