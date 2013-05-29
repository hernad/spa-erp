/****license*****************************************************************
**   file: repAkontacijaPNIspl.java
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
package hr.restart.blpn;

import hr.restart.robno.raDateUtil;
import hr.restart.robno.repMemo;
import hr.restart.robno.repUtil;
import hr.restart.util.Valid;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.borland.dx.dataset.DataSet;

public class repAkontacijaPNIspl implements sg.com.elixir.reportwriter.datasource.IDataProvider {

  hr.restart.robno._Main main;
  frmAkontacijaPN fui = frmAkontacijaPN.getFAPN();
  DataSet ds = frmAkontacijaPN.getFAPN().getRepQDS();

  hr.restart.baza.dM dm= hr.restart.baza.dM.getDataModule();
  raDateUtil rdu = raDateUtil.getraDateUtil();
  Valid vl = Valid.getValid();

  repUtil ru = repUtil.getrepUtil();
  hr.restart.util.Util ut =  hr.restart.util.Util.getUtil();
  repMemo re = repMemo.getrepMemo();
  public static double iznosGrupe;
  public static int rb;

  public repAkontacijaPNIspl() {
    ru.setDataSet(ds);
  }

  public repAkontacijaPNIspl(int idx) {
    if(idx==0){
      rb = 0;
    }
    ds.goToRow(idx);
  }

  public java.util.Enumeration getData() {
    return new java.util.Enumeration() {
      {
        ds.open();
      }
      int indx=0;
      public Object nextElement() {

        return new repAkontacijaPNIspl(indx++);
      }
      public boolean hasMoreElements() {
        return (indx < ds.getRowCount());
      }
    };
  }

  public void close() {
  }

  public String getNASLOV() {
    if (getIZDATAK().compareTo(new BigDecimal(0)) > 0)
      return "ISPLATNICA br. " + getRBS();
    return "UPLATNICA br. " + getRBS();
  }
  public String getLinija() {
    if (getIZDATAK().compareTo(new BigDecimal(0)) > 0)
      return "Kome";
    return "Od koga";
  }
  public String getOznaka(){
    String oznaka = "Izvje�\u0107e: " + getCBLAG() + "-" + getOZNVAL() + "-" + getGODINA() + "-" + getBRIZV();
//    System.out.println(oznaka);
    return oznaka;
  }
  public String getBROJKONTA() {
    String stavka = ds.getString("STAVKA");
    String cskl = ds.getString("CSKL");
//    System.out.println("stavka : " + stavka);
    if (stavka.equals("")) return "";
//    System.out.println("brkonta : " + fui.ss.getBrojKonta(stavka));
    return fui.ss.getBrojKonta(stavka, cskl);
  }
  public BigDecimal getIznos(){
    if (getIZDATAK().compareTo(new BigDecimal(0)) > 0)
      return getIZDATAK();
    return getPRIMITAK();
  }
  public String getIznos2(){
    if (getIZDATAK().compareTo(new BigDecimal(0)) > 0)
      return getIZDATAK() + " " + getOZNVAL();
    return getPRIMITAK() + " " + getOZNVAL();
  }
  public String getSLOVIMA() {
    return ut.numToLet(getIznos().doubleValue(), ds.getString("OZNVAL"));
  }
  public String getTKO() {
    return ds.getString("TKO");
  }
  public int getCBLAG() {
    return ds.getInt("CBLAG");
  }
  public String getKNJIG() {
    return ds.getString("KNJIG");
  }
  public String getOZNVAL() {
    return ds.getString("OZNVAL");
  }
  public int getBRIZV(){
    return ds.getInt("BRIZV");
  }
  public BigDecimal getPRIMITAK() {
    return ds.getBigDecimal("PRIMITAK");
  }
  public BigDecimal getIZDATAK() {
    return ds.getBigDecimal("IZDATAK");
  }
  public String getOPIS() {
    return ds.getString("OPIS");
  }
  public Timestamp getDATUMSTAVKE() {
    return ds.getTimestamp("DATUM");
  }
  public short getGODINA(){
    return ds.getShort("GODINA");
  }
  public int getRBS(){
    return ds.getInt("RBS");
  }
  public String getFirstLine(){
    return re.getFirstLine();
  }
  public String getSecondLine(){
    return re.getSecondLine();
  }
  public String getThirdLine(){
    return re.getThirdLine();
  }
  public String getLogoMjesto(){
    return re.getLogoMjesto();
  }
  public String getDatumIsp(){
    return rdu.dataFormatter(vl.getToday());
  }
}