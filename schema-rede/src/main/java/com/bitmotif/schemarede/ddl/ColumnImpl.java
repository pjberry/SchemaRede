package com.bitmotif.schemarede.ddl;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Aug 2, 2010
 * Time: 7:13:31 PM
 */
public class ColumnImpl implements Column {

   private String columnName;
   private String typeName;

   public ColumnImpl(String columnName, String typeName) {
      this.columnName = columnName;
      this.typeName = typeName;
   }

   public String getName() {
      return columnName;
   }

   public String getTypeName() {
      return typeName;
   }
}
