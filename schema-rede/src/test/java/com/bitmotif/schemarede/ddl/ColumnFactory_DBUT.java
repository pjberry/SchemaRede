package com.bitmotif.schemarede.ddl;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import com.bitmotif.schemarede.jdbc.AbstractDatabaseTestCase;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Aug 3, 2010
 * Time: 8:23:34 AM
 */
public class ColumnFactory_DBUT extends AbstractDatabaseTestCase {

   @Test
   public void testBuildColumn() throws Exception {
      DatabaseMetaData databaseMetaData = conn.getMetaData();
      ResultSet columnResultSet = databaseMetaData.getColumns(null, null, "%", "%");
      columnResultSet.next();

      ColumnFactory tableFactory = new ColumnFactoryImpl();
      Column column = tableFactory.buildColumn(columnResultSet);
      columnResultSet.close();

      assertNotNull(column.getName());
      assertNotNull(column.getTypeName());
   }
}
