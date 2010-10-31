package com.bitmotif.schemarede.sandbox;

import com.bitmotif.schemarede.ddl.Column;
import com.bitmotif.schemarede.ddl.ColumnFactory;
import com.bitmotif.schemarede.ddl.standard.ColumnFactoryStandardImpl;
import com.bitmotif.schemarede.jdbc.AbstractDatabaseTestCase;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Aug 3, 2010
 * Time: 8:23:34 AM
 */
public class Sandbox_DBUT extends AbstractDatabaseTestCase {

   @Test
   public void testListSchemas() throws Exception {
      DatabaseMetaData databaseMetaData = conn.getMetaData();
      ResultSet schemaResultSet = databaseMetaData.getSchemas();
      while(schemaResultSet.next()) {
         String schemaName = schemaResultSet.getString("TABLE_SCHEM");
         System.out.println(schemaName);
      }

   }

   @Test
   public void testBuildATableWithAllTheStuff() throws Exception {
      createTableWithVariousColumns();


      DatabaseMetaData databaseMetaData = conn.getMetaData();
      ResultSet columnResultSet = databaseMetaData.getColumns(null, null, "TEST_TABLE", "%");

      ColumnFactory columnFactory = new ColumnFactoryStandardImpl();

      while(columnResultSet.next()) {
         Column column = columnFactory.buildColumn(columnResultSet);
         System.out.println(column.getName());
         System.out.println(column.getTypeName());
         System.out.println(column.getSize());
         System.out.println(column.getDecimalDigits());
         System.out.println("");
      }

      dropTableWithVariousColumns();
   }

   private void createTableWithVariousColumns() throws SQLException {
      String sql =
         "create table TEST_TABLE ( " +
            "varchar_two_column VARCHAR2(7), " +
            "nvarchar_two_column NVARCHAR2(8), " +
            "char_column CHAR(17), " +
            "nchar_column NCHAR(15), " +
            "number_column NUMBER(12,3), " +
            "clob_column CLOB, " +
            "nclob_column NCLOB, " +
            "blob_column BLOB, " +
            "bfile_column BFILE, " +
            "xml_column XMLType " +
            ")";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.execute();
   }

   private void dropTableWithVariousColumns() throws SQLException {
      String sql = "drop table TEST_TABLE";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.execute();
   }

   @Test
   public void testDatabaseNameAndVersion() throws Exception {
      DatabaseMetaData databaseMetaData = conn.getMetaData();

      System.out.println(databaseMetaData.getDatabaseProductName());
      System.out.println(databaseMetaData.getDatabaseProductVersion());
   }

   @Test
   public void testBuildXmlColumn() throws Exception {
      createTableWithXmlColumn();

      DatabaseMetaData databaseMetaData = conn.getMetaData();
      ResultSet columnResultSet = databaseMetaData.getColumns(null, null, "XML_TABLE", "%");
      columnResultSet.next();

      ColumnFactory tableFactory = new ColumnFactoryStandardImpl();
      Column column = tableFactory.buildColumn(columnResultSet);
      columnResultSet.close();

      assertNotNull(column.getName());
      assertNotNull(column.getTypeName());
      assertNotNull(column.getSize());


      System.out.println(column.getName());
      System.out.println(column.getTypeName());
      System.out.println(column.getSize());

      dropTableWithXmlColumn();
   }

   @Test
   public void testBuildClobColumn() throws Exception {
      createTableWithClobColumn();

      DatabaseMetaData databaseMetaData = conn.getMetaData();
      ResultSet columnResultSet = databaseMetaData.getColumns(null, null, "MY_CLOB_TABLE", "%");
      columnResultSet.next();

      ColumnFactory tableFactory = new ColumnFactoryStandardImpl();
      Column column = tableFactory.buildColumn(columnResultSet);
      columnResultSet.close();

      assertNotNull(column.getName());
      assertNotNull(column.getTypeName());
      assertNotNull(column.getSize());


      System.out.println(column.getName());
      System.out.println(column.getTypeName());
      System.out.println(column.getSize());

      dropTableWithClobColumn();
   }

   @Test
   public void testBuildBlobColumn() throws Exception {
      createTableWithBlobColumn();

      DatabaseMetaData databaseMetaData = conn.getMetaData();
      ResultSet columnResultSet = databaseMetaData.getColumns(null, null, "MY_BLOB_TABLE", "%");
      columnResultSet.next();

      ColumnFactory tableFactory = new ColumnFactoryStandardImpl();
      Column column = tableFactory.buildColumn(columnResultSet);
      columnResultSet.close();

      assertNotNull(column.getName());
      assertNotNull(column.getTypeName());
      assertNotNull(column.getSize());


      System.out.println(column.getName());
      System.out.println(column.getTypeName());
      System.out.println(column.getSize());

      dropTableWithBlobColumn();
   }

   @Test
   public void testBuildBfileColumn() throws Exception {
      createTableWithBfileColumn();

      DatabaseMetaData databaseMetaData = conn.getMetaData();
      ResultSet columnResultSet = databaseMetaData.getColumns(null, null, "MY_BFILE_TABLE", "%");
      columnResultSet.next();

      ColumnFactory tableFactory = new ColumnFactoryStandardImpl();
      Column column = tableFactory.buildColumn(columnResultSet);
      columnResultSet.close();

      assertNotNull(column.getName());
      assertNotNull(column.getTypeName());
      assertNotNull(column.getSize());


      System.out.println(column.getName());
      System.out.println(column.getTypeName());
      System.out.println(column.getSize());

      dropTableWithBfileColumn();
   }

   private void createTableWithBfileColumn() throws Exception {
      String sql = "create table MY_BFILE_TABLE (bfile_column BFILE)";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.execute();
   }

   private void dropTableWithBfileColumn() throws Exception {
      String sql = "drop table MY_BFILE_TABLE";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.execute();
   }

   private void createTableWithBlobColumn() throws Exception {
      String sql = "create table MY_BLOB_TABLE (blob_column BLOB)";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.execute();
   }

   private void dropTableWithBlobColumn() throws Exception {
      String sql = "drop table MY_BLOB_TABLE";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.execute();
   }

   private void createTableWithClobColumn() throws Exception {
      String sql = "create table MY_CLOB_TABLE (clob_column CLOB)";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.execute();
   }

   private void dropTableWithClobColumn() throws Exception {
      String sql = "drop table MY_CLOB_TABLE";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.execute();
   }

   private void createTableWithXmlColumn() throws Exception {
      String sql = "create table XML_TABLE (xml_column XMLType)";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.execute();
   }

   private void dropTableWithXmlColumn() throws Exception {
      String sql = "drop table XML_TABLE";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.execute();
   }
}