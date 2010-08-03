package com.bitmotif.schemarede.ddl;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Aug 2, 2010
 * Time: 7:12:05 PM
 */
public class ColumnImpl_UT {

   @Test
   public void testGetName() throws Exception {
      Column column = new ColumnImpl("columnName");
      
      assertEquals("columnName", column.getName());
   }
}
