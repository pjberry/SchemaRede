package com.bitmotif.schemarede.ddl.standard;

import com.bitmotif.schemarede.ddl.Table;
import com.bitmotif.schemarede.ddl.TableFactory;
import com.bitmotif.schemarede.jdbc.AbstractDatabaseTestCase;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Jun 22, 2010
 * Time: 5:52:17 AM
 */
public class TableFactoryStandardImpl_DBUT extends AbstractDatabaseTestCase {

   @Before
   public void setUpTestTable() throws Exception {
      removeTableIfItExists();
      createTableForTesting();
   }

   @After
   public void removeTestTable() throws SQLException {
      dropTableForTesting();
   }

   @Test
   public void testBuildTable_DefaultConstructor() throws Exception {
      DatabaseMetaData databaseMetaData = conn.getMetaData();

      TableFactory tableFactory = new TableFactoryStandardImpl();
      Table table = tableFactory.buildTable(databaseMetaData, "TEST_TABLE");

      assertEquals("TEST_TABLE", table.getName());

      assertEquals(2, table.getColumns().length);
      assertEquals("CHAR_COLUMN", table.getColumns()[0].getName());
      assertEquals("BLOB_COLUMN", table.getColumns()[1].getName());
   }

   @Test
   public void testBuildTable_InjectColumnFactory() throws Exception {
      DatabaseMetaData databaseMetaData = conn.getMetaData();

      TableFactory tableFactory = new TableFactoryStandardImpl( new ColumnFactoryStandardImpl() );
      Table table = tableFactory.buildTable(databaseMetaData, "TEST_TABLE");

      assertEquals("TEST_TABLE", table.getName());

      assertEquals(2, table.getColumns().length);
      assertEquals("CHAR_COLUMN", table.getColumns()[0].getName());
      assertEquals("BLOB_COLUMN", table.getColumns()[1].getName());
   }

   private void createTableForTesting() throws SQLException {
      String sql = "create table TEST_TABLE ( char_column CHAR(17), blob_column BLOB )";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.execute();
   }

   private void removeTableIfItExists() {
      try {
         dropTableForTesting();
      } catch (SQLException e) {
         // assume that it is already dropped
      }
   }

   private void dropTableForTesting() throws SQLException {
      String sql = "drop table TEST_TABLE";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.execute();
   }
}
