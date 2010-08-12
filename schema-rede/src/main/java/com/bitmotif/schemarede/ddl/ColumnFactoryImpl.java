package com.bitmotif.schemarede.ddl;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Aug 3, 2010
 * Time: 8:29:11 AM
 */
public class ColumnFactoryImpl implements ColumnFactory {

   public Column buildColumn(ResultSet columnResultSet) throws SQLException {
      String columnName = columnResultSet.getString("COLUMN_NAME");
      String typeName = columnResultSet.getString("TYPE_NAME");
      Integer columnSize = columnResultSet.getInt("COLUMN_SIZE");
      Integer decimalDigits = columnResultSet.getInt("DECIMAL_DIGITS");

      return new ColumnImpl(columnName, typeName, columnSize, decimalDigits);
   }
}
