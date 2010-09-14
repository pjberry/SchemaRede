package com.bitmotif.schemarede.ddl.oracle;

import com.bitmotif.schemarede.ddl.Column;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Aug 13, 2010
 * Time: 6:27:31 AM
 */
public class ColumnOracleImpl implements Column {

   private Column column;

   public ColumnOracleImpl(Column column) {
      this.column = column;
   }

   public String getName() {
      return column.getName();
   }

   public String getTypeName() {
      return column.getTypeName();
   }

   public Integer getSize() {
      return column.getSize();
   }

   public Integer getDecimalDigits() {
      return column.getDecimalDigits();
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
      if(!OracleColumnTypes.SIZELESS_TYPES.contains( getTypeName() )) {
         stringBuilder.append( "(" );
         stringBuilder.append( getSize() );
         appendPrecision(stringBuilder);
         stringBuilder.append( ")" );
      }
   }

   private void appendPrecision(StringBuilder stringBuilder) {
      if(OracleColumnTypes.PRECISION_TYPES.contains( getTypeName() )) {
         stringBuilder.append( ", ");
         stringBuilder.append( getDecimalDigits() );
      }
   }
}
