/****license*****************************************************************
**   file: Res_sqlserver.java
**   Copyright 2006 Rest Art
**
**   Licensed under the Apache License, Version 2.0 (the "License");
**   you may not use this file except in compliance with the License.
**   You may obtain a copy of the License at
**
**       http://www.apache.org/licenses/LICENSE-2.0
**
**   Unless required by applicable law or agreed to in writing, software
**   distributed under the License is distributed on an "AS IS" BASIS,
**   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
**   See the License for the specific language governing permissions and
**   limitations under the License.
**
****************************************************************************/
package hr.restart.baza;

import java.util.ListResourceBundle;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Res_sqlserver extends ListResourceBundle {

  static final Object[][] contents = new String[][] {
    { "CREATE", "create table %NAME (%BODY)" },
    { "CHAR", "char(%SIZE)" },
    { "EXTCHAR", "" },
    { "INTEGER", "numeric(%SIZE,0)" },
    { "SHORT", "numeric(%SIZE,0)" },
    { "FLOAT", "numeric(%SIZE,%PRECISION)" },
    { "DEFAULT", "default '%VALUE'" },
    { "DATE", "datetime" },
    { "PKEY", "Primary Key (%FIELD)" },

    { "INDEX", "create index %NAME on %TABLE (%FIELD)" },
    { "UINDEX", "create unique index %NAME on %TABLE (%FIELD)" }
  };
  protected Object[][] getContents() {
    return contents;
  }
}
