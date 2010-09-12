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

   private static final String LINE_SEPARATOR = System.getProperty( "line.separator" );

   @Test
   public void testName() throws Exception {
      Table table = new TableImpl("tableName");

      assertEquals("tableName", table.getName());
   }

   @Test
   public void testGetColumns() throws Exception {
      Column[] expectedColumns = buildControlColumns();

      Table table = new TableImpl("tableName", expectedColumns);

      Column[] actualColumns = table.getColumns();
      assertEquals(expectedColumns.length, actualColumns.length);

      assertEquals("columnNameOne", actualColumns[0].getName());
      assertEquals("typeNameOne", actualColumns[0].getTypeName());
      assertEquals(-1, actualColumns[0].getSize().intValue());
      assertEquals(-2, actualColumns[0].getDecimalDigits().intValue());

      assertEquals("columnNameTwo", actualColumns[1].getName());
      assertEquals("NUMBER", actualColumns[1].getTypeName());
      assertEquals(-3, actualColumns[1].getSize().intValue());
      assertEquals(-4, actualColumns[1].getDecimalDigits().intValue());
   }

   @Test
   public void testToString() throws Exception {
      Table table = new TableImpl("tableName", buildControlColumns());

      StringBuilder tableString = new StringBuilder();
      tableString.append("table").append(" ").append("tableName").append(LINE_SEPARATOR)
         .append("(").append(LINE_SEPARATOR)
         .append("columnNameOne").append(" ").append("typeNameOne(-1),").append(LINE_SEPARATOR)
         .append("columnNameTwo").append(" ").append("NUMBER(-3, -4)").append(LINE_SEPARATOR)
         .append(")");

     assertEquals(tableString.toString(), table.toString());
   }

   private Column[] buildControlColumns() {
      return new Column[] {buildColumn("columnNameOne", "typeNameOne", -1, -2), buildColumn("columnNameTwo", "NUMBER", -3, -4)};
   }

   private Column buildColumn(String columnName, String typeName, int columnSize, int decimalDigits) {
      return new ColumnOracleImpl( new ColumnImpl(columnName, typeName, columnSize, decimalDigits) );
   }
}
