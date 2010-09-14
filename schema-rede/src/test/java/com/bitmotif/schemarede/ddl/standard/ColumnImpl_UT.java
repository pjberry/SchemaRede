package com.bitmotif.schemarede.ddl.standard;

import com.bitmotif.schemarede.ddl.Column;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Aug 2, 2010
 * Time: 7:12:05 PM
 */

public class ColumnImpl_UT {
   
   private static final String COLUMN_NAME = "columnName";
   private static final String TYPE_NAME = "typeName";
   private static final Integer COLUMN_SIZE = 2;
   private static final Integer DECIMAL_DIGITS = 3;

   @Test
   public void testGetName() throws Exception {
      Column column = new ColumnStandardImpl(COLUMN_NAME, null, null, null);
      
      assertEquals(COLUMN_NAME, column.getName());
   }

   @Test
   public void testGetTypeName() throws Exception {
      Column column = new ColumnStandardImpl(null, TYPE_NAME, null, null);

      assertEquals(TYPE_NAME, column.getTypeName());
   }

   @Test
   public void testColumnSize() throws Exception {
      Column column = new ColumnStandardImpl(null, null, COLUMN_SIZE, null);

      assertEquals(COLUMN_SIZE, column.getSize());
   }

   @Test
   public void testDecimalDigits() throws Exception {
      Column column = new ColumnStandardImpl(null, null, null, DECIMAL_DIGITS);

      assertEquals(DECIMAL_DIGITS, column.getDecimalDigits());
   }

}
