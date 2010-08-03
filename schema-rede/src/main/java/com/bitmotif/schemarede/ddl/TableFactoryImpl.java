package com.bitmotif.schemarede.ddl;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Jun 22, 2010
 * Time: 5:54:41 AM
 */
public class TableFactoryImpl implements TableFactory {

   public Table buildTable(ResultSet resultSet) throws SQLException {
      String tableName = resultSet.getString("TABLE_NAME");
      return new TableImpl(tableName);
   }
}
