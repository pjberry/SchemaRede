package com.bitmotif.schemarede.ddl;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Aug 3, 2010
 * Time: 8:28:56 AM
 */
public interface ColumnFactory {

   Column buildColumn(ResultSet columnResultSet) throws SQLException;
}
