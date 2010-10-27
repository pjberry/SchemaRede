package com.bitmotif.schemarede.ddl;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Jun 22, 2010
 * Time: 5:52:00 AM
 */
public interface TableFactory {

   Table buildTable(DatabaseMetaData databaseMetaData, String tableName) throws SQLException;
}
