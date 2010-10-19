package com.bitmotif.schemarede.ddl.oracle;

import com.bitmotif.schemarede.ddl.Column;
import com.bitmotif.schemarede.ddl.ColumnFactory;
import com.bitmotif.schemarede.ddl.standard.ColumnFactoryStandardImpl;
import com.bitmotif.schemarede.ddl.standard.ColumnStandardImpl;
import com.bitmotif.schemarede.mock.StubbedResultSet;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Sep 15, 2010
 * Time: 6:20:03 PM
 */
public class ColumnFactoryOracleImpl_UT {

   @Test
   public void testBuildColumn() throws Exception {
      StubbedResultSet resultSet = new StubbedResultSet();

      ColumnFactory columnFactory = new ColumnFactoryOracleImpl( new ColumnFactoryStandardImpl() );
      Column column = columnFactory.buildColumn(resultSet);

      assertTrue(column instanceof ColumnOracleImpl);
   }

   @Test
   public void testDelegation() throws Exception {
      MockColumnFactoryStandardImpl mockColumnFactory = new MockColumnFactoryStandardImpl();
      StubbedResultSet resultSet = new StubbedResultSet();

      ColumnFactory columnFactory = new ColumnFactoryOracleImpl( mockColumnFactory );
      columnFactory.buildColumn(resultSet);

      assertTrue("Expected the build method to be delegated.", mockColumnFactory.wasBuildMethodCalled());
   }


   private class MockColumnFactoryStandardImpl extends ColumnFactoryStandardImpl {

      private boolean buildMethodCalled = false;

      public Column buildColumn(ResultSet columnResultSet) throws SQLException {
         buildMethodCalled = true;
         return new ColumnStandardImpl(null, null, null, null);
      }

      public boolean wasBuildMethodCalled() {
         return buildMethodCalled;
      }
   }
}
