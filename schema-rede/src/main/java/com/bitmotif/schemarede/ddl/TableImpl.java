package com.bitmotif.schemarede.ddl;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Jun 22, 2010
 * Time: 5:42:47 AM
 */
public class TableImpl implements Table {

   private String tableName;

   public TableImpl(String tableName) {
      this.tableName = tableName;
   }

   public String getName() {
      return tableName;
   }
}
