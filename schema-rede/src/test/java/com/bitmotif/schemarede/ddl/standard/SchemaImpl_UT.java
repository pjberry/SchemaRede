package com.bitmotif.schemarede.ddl.standard;

import com.bitmotif.schemarede.ddl.Column;
import com.bitmotif.schemarede.ddl.Schema;
import com.bitmotif.schemarede.ddl.Table;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Oct 30, 2010
 * Time: 8:15:22 AM
 */
public class SchemaImpl_UT {

   @Test
   public void testGetTables() throws Exception {
      Table[] tables = new Table[0];

      Schema schema = new SchemaImpl(null, tables);

      assertSame(tables, schema.getTables());
   }

   @Test
   public void testGetName() throws Exception {
      Schema schema = new SchemaImpl("schemaName", new Table[0]);

      assertSame("schemaName", schema.getName());
   }

   @Test
   public void testToString() throws Exception {
      Column columnOne = new ColumnStandardImpl("columnOne", "typeOne", 2, 1);
      Column columnTwo = new ColumnStandardImpl("columnTwo", "typeTwo", 1, 0);

      Table tableOne = new TableStandardImpl("tableOne", new Column[] {columnOne, columnTwo});
      Table tableTwo = new TableStandardImpl("tableTwo", new Column[] {columnTwo, columnOne});

      Schema schema = new SchemaImpl("schemaName", new Table[]{tableOne, tableTwo});


      String expected =
         "table tableOne\n" +
            "(\n" +
            "columnOne typeOne(2, 1),\n" +
            "columnTwo typeTwo(1, 0)\n" +
            ")\n" +
            "\n" +
            "table tableTwo\n" +
            "(\n" +
            "columnTwo typeTwo(1, 0),\n" +
            "columnOne typeOne(2, 1)\n" +
            ")\n\n";



      assertEquals(expected, schema.toString());
   }


}
