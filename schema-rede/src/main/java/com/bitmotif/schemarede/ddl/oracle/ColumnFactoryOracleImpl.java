package com.bitmotif.schemarede.ddl.oracle;

import com.bitmotif.schemarede.ddl.Column;
import com.bitmotif.schemarede.ddl.ColumnFactory;
import com.bitmotif.schemarede.ddl.standard.ColumnFactoryStandardImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Oct 19, 2010
 * Time: 7:10:48 AM
 */
public class ColumnFactoryOracleImpl implements ColumnFactory {
   
   private ColumnFactoryStandardImpl columnFactoryStandardImpl;

   public ColumnFactoryOracleImpl(ColumnFactoryStandardImpl columnFactory) {
      this.columnFactoryStandardImpl = columnFactory;
   }

   public Column buildColumn(ResultSet columnResultSet) throws SQLException {
      Column column = columnFactoryStandardImpl.buildColumn(columnResultSet);
      return new ColumnOracleImpl(column);
   }
}
