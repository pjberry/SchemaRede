package com.bitmotif.schemarede.ddl.standard;

import com.bitmotif.schemarede.ddl.Column;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Aug 2, 2010
 * Time: 7:13:31 PM
 */
public class ColumnStandardImpl implements Column {

   private String columnName;
   private String typeName;
   private Integer columnSize;
   private Integer decimalDigits;

   public ColumnStandardImpl(String columnName, String typeName, Integer columnSize, Integer decimalDigits) {
      this.columnName = columnName;
      this.typeName = typeName;
      this.columnSize = columnSize;
      this.decimalDigits = decimalDigits;
   }

   public String getName() {
      return columnName;
   }

   public String getTypeName() {
      return typeName;
   }

   public Integer getSize() {
      return columnSize;
   }

   public Integer getDecimalDigits() {
      return decimalDigits;
   }

   public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append( getName() );
      stringBuilder.append( " " );
      stringBuilder.append( getTypeName() );
      appendSize(stringBuilder);
      return stringBuilder.toString();
   }

   private void appendSize(StringBuilder stringBuilder) {
      stringBuilder.append( "(" );
      stringBuilder.append( getSize() );
      appendPrecision(stringBuilder);
      stringBuilder.append( ")" );
   }

   private void appendPrecision(StringBuilder stringBuilder) {
      stringBuilder.append( ", ");
      stringBuilder.append( getDecimalDigits() );
   }
}
