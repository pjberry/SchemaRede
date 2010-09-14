package com.bitmotif.schemarede.ddl.oracle;

import com.bitmotif.schemarede.ddl.Column;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Aug 13, 2010
 * Time: 6:27:31 AM
 */
public class ColumnOracleImpl implements Column {

   private static final List<String> SIZELESS_TYPES = Arrays.asList("CLOB", "NCLOB", "BLOB", "BFILE", "XMLType");
   private static final List<String> PRECISION_TYPES = Arrays.asList("NUMBER");

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
      if(!SIZELESS_TYPES.contains( getTypeName() )) {
         stringBuilder.append( "(" );
         stringBuilder.append( getSize() );
         appendPrecision(stringBuilder);
         stringBuilder.append( ")" );
      }
   }

   private void appendPrecision(StringBuilder stringBuilder) {
      if(PRECISION_TYPES.contains( getTypeName() )) {
         stringBuilder.append( ", ");
         stringBuilder.append( getDecimalDigits() );
      }
   }
}