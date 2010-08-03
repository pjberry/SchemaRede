package com.bitmotif.schemarede.ddl;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Aug 2, 2010
 * Time: 7:13:31 PM
 */
public class ColumnImpl implements Column {
   private String columnName;

   public ColumnImpl(String columnName) {
      this.columnName = columnName;
   }


   public String getName() {
      return columnName;
   }
}
