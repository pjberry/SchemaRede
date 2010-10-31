package com.bitmotif.schemarede.ddl.standard;

import com.bitmotif.schemarede.ddl.Schema;
import com.bitmotif.schemarede.ddl.Table;

/**
 * Created by IntelliJ IDEA.
 * User: pjberry
 * Date: Oct 30, 2010
 * Time: 8:17:29 AM
 */
public class SchemaImpl implements Schema {

   private String name;
   private Table[] tables;

   public SchemaImpl(String name, Table[] tables) {
      this.name = name;
      this.tables = tables;
   }

   public String getName() {
      return name;
   }

   public Table[] getTables() {
      return tables;
   }
}
