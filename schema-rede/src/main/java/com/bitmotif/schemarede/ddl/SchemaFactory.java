package com.bitmotif.schemarede.ddl;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Oct 30, 2010
 * Time: 8:23:21 AM
 */
public interface SchemaFactory {

   Schema buildSchema(DatabaseMetaData databaseMetaData, String schemaName) throws SQLException;

}
