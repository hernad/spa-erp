/****license*****************************************************************
**   file: repAmRev.java
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
package hr.restart.os;

import hr.restart.robno._Main;
import hr.restart.robno.raDateUtil;
import hr.restart.robno.repMemo;
import hr.restart.robno.repUtil;

import com.borland.dx.dataset.DataSet;

/**
 * <p>Title: </p> repOrgOS
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class repAmRev implements sg.com.elixir.reportwriter.datasource.IDataProvider
{
  _Main main;
  //DataSet ds = hr.restart.os.upObrLikvidacija.getQdsIspis();
  DataSet ds = hr.restart.os.ispAmor.getQdsIspis();
  hr.restart.util.Valid val = hr.restart.util.Valid.getValid();
  hr.restart.baza.dM dm= hr.restart.baza.dM.getDataModule();
  raDateUtil rdu = raDateUtil.getraDateUtil();
  String[] colname = new String[] {""};
  repUtil ru = repUtil.getrepUtil();
  repMemo rpm = repMemo.getrepMemo();


  double osn;
  double isp;
  int rowCount=0;

  public repAmRev() {
    ru.setDataSet(ds);
  }

  public repAmRev(int idx) {
    ds.goToRow(idx);
  }

  public java.util.Enumeration getData() {
    return new java.util.Enumeration() {
      {
        ds.open();
        rowCount= ds.getRowCount();
      }
      int indx=0;
      public Object nextElement() {
        return new repAmRev(indx++);
      }
      public boolean hasMoreElements() {
        return (indx < ds.getRowCount());
      }
    };
  }

  public void close()
  {

  }

  public String getInvBr()
  {
    return ds.getString("invbroj");
  }

  public int getRowNum()
  {
    return rowCount;
  }

  public String getCOrg()
  {
    return ds.getString("corg");
  }

  public String getNazOrg()
  {
    ru.setDataSet(ds);
    colname[0] = "corg";
    String rez = ru.getSomething(colname,dm.getOrgstruktura() ,"naziv").toString().trim();
    return rez;
  }

  public String getNazSred()
  {
    return ds.getString("nazsredstva");
  }

  public double getNabVr()
  {
    return ds.getBigDecimal("NABVRIJED").doubleValue();
  }

  public double getIspravak()
  {
    return ds.getBigDecimal("ISPRAVAK").doubleValue();
  }

  public String getDatPr()
  {
    return rdu.dataFormatter(ds.getTimestamp("DATPR"));
  }

  public String getDatLik()
  {
    return rdu.dataFormatter(ds.getTimestamp("DATLIK"));
  }
  public double getAmortizacija()
  {
    return ds.getBigDecimal("AMORTIZACIJA").doubleValue();
  }

  public double getStIspravak()
  {
    return rdOSUtil.getBDouble(ds, "STVARNIISP");
  }

  public double getSadVrUl()
  {
    return (getNabVr()-getStIspravak());
  }

  public String getSumLabela()
  {
    return "S V E U K U P N O";
  }


  public String getPocDat()
  {
    String sb = hr.restart.os.ispAmor.datumOd;
    String year = sb.substring(0,4);
    String month = sb.substring(5,7);
    String day = sb.substring(8,10);
    return day+"."+month+"."+year+".";
  }

  public String getZavDat()
  {
    String sb = hr.restart.os.ispAmor.datumDo;
    String year = sb.substring(0,4);
    String month = sb.substring(5,7);
    String day = sb.substring(8,10);
    return day+"."+month+"."+year+".";
  }

  public String getDatRange()
  {
    return getPocDat() + " do " + getZavDat();
  }


  public String getFake()
  {
    return"a";
  }

  public String getBrMjeseci()
  {
//    Integer prInt = new Integer(ds.getTimestamp("DATPR").toString().substring(5,7));
//    Integer likInt = new Integer(ds.getTimestamp("DATLIK").toString().substring(5,7));
//    int razlika = likInt.intValue() - prInt.intValue();
//
//    return razlika +"";
    return ds.getString("MJESEC");
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
  public String getDatumIsp(){
    return rdu.dataFormatter(val.getToday());
  }

}
