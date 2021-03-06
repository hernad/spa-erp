/****license*****************************************************************
**   file: Artikli.java
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
import com.borland.dx.dataset.SortDescriptor;
import com.borland.dx.sql.dataset.QueryDataSet;

public class Artikli extends KreirDrop implements DataModule {

  private static Artikli inst = new Artikli();
  QueryDataSet artikliaktiv = new raDataSet();
  QueryDataSet artikliroba = new raDataSet();

  {
    createFilteredDataSet(artikliaktiv, "aktiv = 'D'");
    createFilteredDataSet(artikliroba, "vrart = 'A'");
  }
  
  public static Artikli getDataModule() {
    return inst;
  }


  public com.borland.dx.sql.dataset.QueryDataSet getArtikliRoba() {
    return artikliroba;
  }

  public com.borland.dx.sql.dataset.QueryDataSet getAktiv() {
    return artikliaktiv;
  }
  
  public void fixSort() {
    if (artikliaktiv.getSort() == null ||
        artikliaktiv.getSort().getKeys().length != 1 ||
        !artikliaktiv.getSort().getKeys()[0].equalsIgnoreCase("CART"))
      artikliaktiv.setSort(new SortDescriptor(new String[] {"CART"}));
  }

  public boolean isAutoRefresh() {
    return true;
  }
}
