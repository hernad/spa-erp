/****license*****************************************************************
**   file: repTotKarSve.java
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
package hr.restart.robno;
import java.math.BigDecimal;

import com.borland.dx.dataset.DataSet;

public class repTotKarSve implements sg.com.elixir.reportwriter.datasource.IDataProvider {

  _Main main;
  repMemo rpm = repMemo.getrepMemo();
  upTotKar upk = upTotKar.getupTotKar();
  DataSet ds = upk.getQds();
  hr.restart.baza.dM dm= hr.restart.baza.dM.getDataModule();
  raDateUtil rdu = raDateUtil.getraDateUtil();
  String[] colname = new String[] {""};
  repUtil ru = repUtil.getrepUtil();
  hr.restart.util.Valid val = hr.restart.util.Valid.getValid();
  public repTotKarSve() {
  }

  public repTotKarSve(int idx) {
    ds.goToRow(idx);
  }

  public java.util.Enumeration getData() {
    return new java.util.Enumeration() {
      {
        ds.open();
        ru.setDataSet(ds);
      }
      int indx=0;
      public Object nextElement() {
        return new repTotKarSve(indx++);
      }
      public boolean hasMoreElements() {
        return (indx < ds.getRowCount());
      }
    };
  }
  public void close() {}

  public String getNAZART()
  {
    return ds.getString("NAZART");
  }

  public double getKOLULa()
  {
   return ds.getBigDecimal("KOLUL").doubleValue();
  }

  public BigDecimal getKOLIZ()
  {
    return ds.getBigDecimal("KOLIZ");
  }

  public double getKOLZAD()
  {
    return ds.getBigDecimal("KOLZAD").doubleValue();
  }

  public double getKOLRAZ()
  {
    return ds.getBigDecimal("KOLRAZ").doubleValue();
  }

  public double getSKOL()
  {
    BigDecimal sKol = ds.getBigDecimal("KOLIZ").add(ds.getBigDecimal("KOLUL"));

    return sKol.doubleValue();
  }

  public double getSIZN()
  {
    BigDecimal sIzn = ds.getBigDecimal("KOLRAZ").add(ds.getBigDecimal("KOLZAD"));
    return sIzn.doubleValue();
  }

  public String getCART()
  {
    return Aut.getAut().getCARTdependable(ds);
  }

  public double getZc(){
    return (ds.getBigDecimal("ZC").doubleValue());
  }

  public String getCSKL()
  {
    return ds.getString("KOLSK");
  }


  public String getNSKL()
  {

    return ds.getString("KOLNSK");
  }

   public String getDatDok(){
    return rdu.dataFormatter(ds.getTimestamp("DATDOK"));
  }
  public int getBrDok() {
    return ds.getInt("BRDOK");
  }
  public String getVrDok(){
    return ds.getString("VRDOK");
  }

  public int getDummy()
  {
    return 1;
  }

  public String getFirstLine(){
    return rpm.getFirstLine();
  }
  public String getSecondLine(){
    return rpm.getSecondLine();
  }
  public String getThirdLine(){
    return rpm.getThirdLine();
  }

  public String getDatumIsp()
  {
    return rdu.dataFormatter(val.getToday());
  }

   public String getCaption()
  {
    return (ds.getString("KOLPD")+ " do " + ds.getString("KOLZD"));
  }
}