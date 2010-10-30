package com.bitmotif.schemarede.ddl.standard;

import com.bitmotif.schemarede.ddl.Schema;
import com.bitmotif.schemarede.ddl.Table;
import static org.junit.Assert.assertSame;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Oct 30, 2010
 * Time: 8:15:22 AM
 */
public class Schema_UT {

   @Test
   public void testGetTables() throws Exception {
      Table[] tables = new Table[0];

      Schema schema = new SchemaImpl(tables);

      assertSame(tables, schema.getTables());
   }
}
