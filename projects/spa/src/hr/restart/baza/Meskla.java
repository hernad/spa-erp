/****license*****************************************************************
**   file: Meskla.java
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
import com.borland.dx.dataset.DataModule;
import com.borland.dx.sql.dataset.QueryDataSet;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Meskla extends KreirDrop implements DataModule {

  private static Meskla inst = new Meskla();
  QueryDataSet MesklaMES = new raDataSet();
  QueryDataSet MesklaMEU = new raDataSet();
  QueryDataSet MesklaMEI = new raDataSet();

  {
    createFilteredDataSet(MesklaMES, "vrdok = 'MES'");
    createFilteredDataSet(MesklaMEU, "vrdok = 'MEU'");
    createFilteredDataSet(MesklaMEI, "vrdok = 'MEI'");
  }


  public static Meskla getDataModule() {
    return inst;
  }
  public com.borland.dx.sql.dataset.QueryDataSet getMES() {
    return MesklaMES;
  }
  public com.borland.dx.sql.dataset.QueryDataSet getMEU() {
    return MesklaMEU;
  }
  public com.borland.dx.sql.dataset.QueryDataSet getMEI() {
    return MesklaMEI;
  }

  public boolean isAutoRefresh() {
    return true;
  }
}
