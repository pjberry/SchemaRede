package com.bitmotif.schemarede.ddl.standard;

import com.bitmotif.schemarede.ddl.Schema;
import com.bitmotif.schemarede.ddl.SchemaFactory;
import com.bitmotif.schemarede.ddl.Table;
import com.bitmotif.schemarede.ddl.TableFactory;
import com.bitmotif.schemarede.mock.StubbedDatabaseMetaData;
import com.bitmotif.schemarede.mock.StubbedResultSet;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Oct 30, 2010
 * Time: 8:22:07 AM
 */
public class SchemaFactory_UT {
   private static final int NUMBER_OF_TABLES = 2;

   @Test
   public void testDelegatesToTableFactory() throws Exception {
      StubbedDatabaseMetaData databaseMetaData = buildDatabaseMetaData();
      MockTableFactory tableFactory = new MockTableFactory();

      SchemaFactory schemaFactory = new SchemaFactoryStandardImpl(tableFactory);
      schemaFactory.buildSchema(databaseMetaData, "schemaName");

      assertEquals(NUMBER_OF_TABLES, tableFactory.numberOfCalls().intValue());
   }

   @Test
   public void testSchema() throws Exception {
      StubbedDatabaseMetaData databaseMetaData = buildDatabaseMetaData();
      MockTableFactory tableFactory = new MockTableFactory();

      SchemaFactory schemaFactory = new SchemaFactoryStandardImpl(tableFactory);
      Schema schema = schemaFactory.buildSchema(databaseMetaData, "schemaName");

      assertEquals("schemaName", schema.getName());
      assertEquals(2, schema.getTables().length);
   }

   private StubbedDatabaseMetaData buildDatabaseMetaData() {
      StubbedDatabaseMetaData databaseMetaData = new StubbedDatabaseMetaData();
      databaseMetaData.setResultSetForGetTables( buildResultSet() );
      return databaseMetaData;
   }

   private StubbedResultSet buildResultSet() {
      StubbedResultSet resultSetForGetTables = new StubbedResultSet();
      resultSetForGetTables.setNumberOfResults(NUMBER_OF_TABLES);
      return resultSetForGetTables;
   }


   private class MockTableFactory implements TableFactory {

      private Integer numberOfCalls = 0;

      public Table buildTable(DatabaseMetaData databaseMetaData, String tableName) throws SQLException {
         numberOfCalls++;
         return null;
      }

      public Integer numberOfCalls() {
         return numberOfCalls;
      }
   }
}
