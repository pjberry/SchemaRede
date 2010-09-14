package com.bitmotif.schemarede.ddl.oracle;

import com.bitmotif.schemarede.ddl.Column;
import com.bitmotif.schemarede.ddl.standard.ColumnStandardImpl;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Sep 11, 2010
 * Time: 2:42:46 PM
 */
public class ColumnOracleImpl_UT {

   @Test
   public void testNUMBER_toString() throws Exception {
      Column column = buildColumn("NUMBER");

      Column oracleColumn = new ColumnOracleImpl(column);

      assertEquals("columnName NUMBER(1, 1)", oracleColumn.toString());
   }

   @Test
   public void testNCHAR_toString() throws Exception {
      Column column = buildColumn("NCHAR");

      Column oracleColumn = new ColumnOracleImpl(column);

      assertEquals("columnName NCHAR(1)", oracleColumn.toString());
   }

   @Test
   public void testCHAR_toString() throws Exception {
      Column column = buildColumn("CHAR");

      Column oracleColumn = new ColumnOracleImpl(column);

      assertEquals("columnName CHAR(1)", oracleColumn.toString());
   }

   @Test
   public void testVARCHAR2_toString() throws Exception {
      Column column = buildColumn("VARCHAR2");

      Column oracleColumn = new ColumnOracleImpl(column);

      assertEquals("columnName VARCHAR2(1)", oracleColumn.toString());
   }

   @Test
   public void testNVARCHAR2_toString() throws Exception {
      Column column = buildColumn("NVARCHAR2");

      Column oracleColumn = new ColumnOracleImpl(column);

      assertEquals("columnName NVARCHAR2(1)", oracleColumn.toString());
   }

   @Test
   public void testCLOB_toString() throws Exception {
      Column column = buildColumn(OracleColumnTypes.CLOB);

      Column oracleColumn = new ColumnOracleImpl(column);

      assertEquals("columnName CLOB", oracleColumn.toString());
   }

   @Test
   public void testNCLOB_toString() throws Exception {
      Column column = buildColumn(OracleColumnTypes.NCLOB);

      Column oracleColumn = new ColumnOracleImpl(column);

      assertEquals("columnName NCLOB", oracleColumn.toString());
   }

   @Test
   public void testBLOB_toString() throws Exception {
      Column column = buildColumn(OracleColumnTypes.BLOB);

      Column oracleColumn = new ColumnOracleImpl(column);

      assertEquals("columnName BLOB", oracleColumn.toString());
   }

   @Test
   public void testBFILE_toString() throws Exception {
      Column column = buildColumn(OracleColumnTypes.BFILE);

      Column oracleColumn = new ColumnOracleImpl(column);

      assertEquals("columnName BFILE", oracleColumn.toString());
   }

   @Test
   public void testXMLType_toString() throws Exception {
      Column column = buildColumn(OracleColumnTypes.XML_TYPE);

      Column oracleColumn = new ColumnOracleImpl(column);

      assertEquals("columnName XMLType", oracleColumn.toString());
   }

   private Column buildColumn(String columnType) {
      return new ColumnStandardImpl("columnName", columnType, 1, 1);
   }
}
