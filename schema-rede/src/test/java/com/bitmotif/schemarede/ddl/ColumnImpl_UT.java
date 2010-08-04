package com.bitmotif.schemarede.ddl;

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

   @Test
   public void testGetName() throws Exception {
      Column column = new ColumnImpl(COLUMN_NAME, null, 0);
      
      assertEquals(COLUMN_NAME, column.getName());
   }

   @Test
   public void testGetTypeName() throws Exception {
      Column column = new ColumnImpl(null, TYPE_NAME, 0);

      assertEquals(TYPE_NAME, column.getTypeName());
   }

   @Test
   public void testColumnSize() throws Exception {
      Column column = new ColumnImpl(null, null, COLUMN_SIZE);

      assertEquals(COLUMN_SIZE, column.getSize());
   }

}
