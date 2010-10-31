package com.bitmotif.schemarede.ddl.standard;

import com.bitmotif.schemarede.ddl.Schema;
import com.bitmotif.schemarede.ddl.SchemaFactory;
import com.bitmotif.schemarede.ddl.Table;
import com.bitmotif.schemarede.ddl.TableFactory;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Oct 30, 2010
 * Time: 8:27:53 AM
 */
public class SchemaFactoryStandardImpl implements SchemaFactory {

   private TableFactory tableFactory;

   public SchemaFactoryStandardImpl(TableFactory tableFactory) {
      this.tableFactory = tableFactory;
   }

   public Schema buildSchema(DatabaseMetaData databaseMetaData, String schemaName) throws SQLException {
      ResultSet tableResultSet = databaseMetaData.getTables(null, schemaName, "%", null);
      Table[] tables = buildTables(databaseMetaData, tableResultSet);
      return new SchemaImpl(schemaName, tables);
   }

   private Table[] buildTables(DatabaseMetaData databaseMetaData, ResultSet tableResultSet) throws SQLException {
      List<Table> tables = new ArrayList<Table>();

      while(tableResultSet.next()) {
         String tableName = tableResultSet.getString("TABLE_NAME");
         Table table = tableFactory.buildTable(databaseMetaData, tableName);
         tables.add( table );
      }

      return tables.toArray(new Table[tables.size()]);
   }
}
