package com.bitmotif.schemarede.ddl.oracle;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Sep 14, 2010
 * Time: 5:56:18 PM
 */
interface OracleColumnTypes {
   static final List<String> SIZELESS_TYPES = Arrays.asList("CLOB", "NCLOB", "BLOB", "BFILE", "XMLType");
   static final List<String> PRECISION_TYPES = Arrays.asList("NUMBER"); 
}
