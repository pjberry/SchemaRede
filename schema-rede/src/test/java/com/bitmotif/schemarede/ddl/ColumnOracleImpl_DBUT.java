package com.bitmotif.schemarede.ddl;

import com.bitmotif.schemarede.jdbc.AbstractDatabaseTestCase;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Aug 3, 2010
 * Time: 8:23:34 AM
 */
public class ColumnOracleImpl_DBUT extends AbstractDatabaseTestCase {

   @Before
   public void createTables() throws Exception {
      createTableWithXmlColumn();
      createTableWithClobColumn();
   }

   @After
   public void removeTables() throws Exception {
      dropTableWithXmlColumn();
      dropTableWithClobColumn();
   }

   @Test
   public void testXmlColumn() throws Exception {
      DatabaseMetaData databaseMetaData = conn.getMetaData();
      ResultSet columnResultSet = databaseMetaData.getColumns(null, null, "XML_TABLE", "%");
      columnResultSet.next();

      ColumnFactory tableFactory = new ColumnFactoryImpl();
      Column column = tableFactory.buildColumn(columnResultSet);
      columnResultSet.close();

      Column columnOracleImpl = new ColumnOracleImpl(column);

      assertEquals("XML_COLUMN", columnOracleImpl.getName());
      assertEquals("XMLTYPE", columnOracleImpl.getTypeName());
      assertEquals(2000, columnOracleImpl.getSize().intValue());
      assertEquals("XML_COLUMN XMLTYPE(2000)", columnOracleImpl.toString());
   }

   @Test
   public void testBuildClobColumn() throws Exception {
      DatabaseMetaData databaseMetaData = conn.getMetaData();
      ResultSet columnResultSet = databaseMetaData.getColumns(null, null, "MY_CLOB_TABLE", "%");
      columnResultSet.next();

      ColumnFactory tableFactory = new ColumnFactoryImpl();
      Column column = tableFactory.buildColumn(columnResultSet);
      columnResultSet.close();

      Column columnOracleImpl = new ColumnOracleImpl(column);

      assertEquals("CLOB_COLUMN", columnOracleImpl.getName());
      assertEquals("CLOB", columnOracleImpl.getTypeName());
      assertEquals(4000, columnOracleImpl.getSize().intValue());
      assertEquals("CLOB_COLUMN CLOB", columnOracleImpl.toString());
   }

   @Test
   public void testBuildBlobColumn() throws Exception {
      createTableWithBlobColumn();

      DatabaseMetaData databaseMetaData = conn.getMetaData();
      ResultSet columnResultSet = databaseMetaData.getColumns(null, null, "MY_BLOB_TABLE", "%");
      columnResultSet.next();

      ColumnFactory tableFactory = new ColumnFactoryImpl();
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

      ColumnFactory tableFactory = new ColumnFactoryImpl();
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