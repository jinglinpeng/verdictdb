/*
 *    Copyright 2018 University of Michigan
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.verdictdb.core.sqlobject;

public class DropTableQuery implements SqlConvertible {

  private static final long serialVersionUID = -3481351240470800158L;

  String schemaName;

  String tableName;

  boolean isIfExists;

  public DropTableQuery(String schemaName, String tableName) {
    this.schemaName = schemaName;
    this.tableName = tableName;
  }

  public static DropTableQuery create(String schemaName, String tableName) {
    return new DropTableQuery(schemaName, tableName);
  }

  public String getSchemaName() {
    return schemaName;
  }

  public String getTableName() {
    return tableName;
  }

  public boolean isIfExists() {
    return isIfExists;
  }

  public void setIfExists(boolean ifExists) {
    isIfExists = ifExists;
  }
}
