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

   String CLOB = "CLOB";
   String NCLOB = "NCLOB";
   String BLOB = "BLOB";
   String BFILE = "BFILE";
   String XML_TYPE = "XMLType";
   String NUMBER = "NUMBER";

   List<String> SIZELESS_TYPES = Arrays.asList(CLOB, NCLOB, BLOB, BFILE, XML_TYPE);

   List<String> PRECISION_TYPES = Arrays.asList(NUMBER);
}
