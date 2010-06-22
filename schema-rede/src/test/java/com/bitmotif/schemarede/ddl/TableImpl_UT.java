package com.bitmotif.schemarede.ddl;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Jun 22, 2010
 * Time: 5:41:45 AM
 */
public class TableImpl_UT {

   @Test
   public void testName() throws Exception {
      Table table = new TableImpl("tableName");

      assertEquals("tableName", table.getName());
   }
}
