package com.bitmotif.schemarede.ddl.standard;

import com.bitmotif.schemarede.ddl.Column;
import com.bitmotif.schemarede.ddl.ColumnFactory;
import com.bitmotif.schemarede.jdbc.AbstractDatabaseTestCase;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Aug 3, 2010
 * Time: 8:23:34 AM
 */
public class ColumnFactoryStandardImpl_DBUT extends AbstractDatabaseTestCase {

   @Test
   public void testBuildColumn() throws Exception {
      DatabaseMetaData databaseMetaData = conn.getMetaData();
      ResultSet columnResultSet = databaseMetaData.getColumns(null, null, "%", "%");
      columnResultSet.next();

      ColumnFactory columnFactory = new ColumnFactoryStandardImpl();
      Column column = columnFactory.buildColumn(columnResultSet);
      columnResultSet.close();

      assertNotNull(column.getName());
      assertNotNull(column.getTypeName());
      assertNotNull(column.getSize());
      assertNotNull(column.getDecimalDigits());
   }
}
