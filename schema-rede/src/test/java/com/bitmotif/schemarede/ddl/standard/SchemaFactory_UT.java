package com.bitmotif.schemarede.ddl.standard;

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

   @Test
   public void testDelegatesToTableFactory() throws Exception {
      StubbedResultSet resultSetForGetTables = new StubbedResultSet();
      resultSetForGetTables.setNumberOfResults(2);

      StubbedDatabaseMetaData databaseMetaData = new StubbedDatabaseMetaData();
      databaseMetaData.setResultSetForGetTables(resultSetForGetTables);


      MockTableFactory tableFactory = new MockTableFactory();


      SchemaFactory schemaFactory = new SchemaFactoryStandardImpl(tableFactory);
      schemaFactory.buildSchema(databaseMetaData, "schemaName");

      assertEquals(2, tableFactory.numberOfCalls().intValue());
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
