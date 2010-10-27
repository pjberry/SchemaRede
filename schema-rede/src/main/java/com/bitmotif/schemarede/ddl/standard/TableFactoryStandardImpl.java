package com.bitmotif.schemarede.ddl.standard;

import com.bitmotif.schemarede.ddl.Column;
import com.bitmotif.schemarede.ddl.ColumnFactory;
import com.bitmotif.schemarede.ddl.Table;
import com.bitmotif.schemarede.ddl.TableFactory;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Jun 22, 2010
 * Time: 5:54:41 AM
 */
public class TableFactoryStandardImpl implements TableFactory {
   
   private ColumnFactory columnFactory;

   public TableFactoryStandardImpl(ColumnFactory columnFactory) {
      this.columnFactory = columnFactory;
   }

   public TableFactoryStandardImpl() {
      this.columnFactory = new ColumnFactoryStandardImpl();
   }

   public Table buildTable(DatabaseMetaData databaseMetaData, String tableName) throws SQLException {
      Column[] columns = buildColumns(databaseMetaData, tableName);
      return new TableStandardImpl(tableName, columns);
   }

   private Column[] buildColumns(DatabaseMetaData databaseMetaData, String tableName) throws SQLException {
      ResultSet columnResultSet = databaseMetaData.getColumns(null, null, tableName, "%");
      return getColumnsFromResultSet(columnResultSet);
   }

   private Column[] getColumnsFromResultSet(ResultSet columnResultSet) throws SQLException {
      List<Column> columns = new ArrayList<Column>();

      try {
         while(columnResultSet.next()) {
            columns.add( columnFactory.buildColumn(columnResultSet) );
         }
      } finally {
         columnResultSet.close();
      }

      return columns.toArray(new Column[columns.size()]);
   }
}
