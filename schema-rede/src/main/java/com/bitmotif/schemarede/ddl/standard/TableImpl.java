package com.bitmotif.schemarede.ddl.standard;

import com.bitmotif.schemarede.ddl.Column;
import com.bitmotif.schemarede.ddl.Table;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Jun 22, 2010
 * Time: 5:42:47 AM
 */
public class TableImpl implements Table {

   private static final String LINE_SEPARATOR = System.getProperty( "line.separator" );

   private String tableName;
   private Column[] columns;

   public TableImpl(String tableName) {
      this.tableName = tableName;
      columns = new Column[0];
   }

   public TableImpl(String tableName, Column[] columns) {
      this.tableName = tableName;
      this.columns = columns;
   }

   public String getName() {
      return tableName;
   }

   public Column[] getColumns() {
      return columns;
   }

   public String toString() {
      StringBuilder tableString = new StringBuilder();
      tableString.append("table").append(" ").append( tableName ).append(LINE_SEPARATOR)
         .append("(").append(LINE_SEPARATOR);

         appendColumns(tableString);

         tableString.append(LINE_SEPARATOR)
         .append(")");

      return tableString.toString();
   }

   private void appendColumns(StringBuilder tableString) {
      for(int i = 0; i < columns.length; i ++) {
         tableString.append(columns[i].toString());
         if(i < columns.length - 1) {
            tableString.append(",").append(LINE_SEPARATOR);
         }
      }
   }
}
