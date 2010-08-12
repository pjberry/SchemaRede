package com.bitmotif.schemarede.ddl;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Aug 2, 2010
 * Time: 7:10:26 PM
 */
public interface Column {

   String getName();
   String getTypeName();
   Integer getSize();
   Integer getDecimalDigits();
}
