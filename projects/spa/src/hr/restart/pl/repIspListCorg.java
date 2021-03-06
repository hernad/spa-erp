/****license*****************************************************************
**   file: repIspListCorg.java
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
package hr.restart.pl;
import hr.restart.robno.raDateUtil;
import hr.restart.robno.repMemo;
import hr.restart.util.Valid;
import hr.restart.util.reports.raReportData;

import java.math.BigDecimal;

import com.borland.dx.dataset.DataSet;
import com.borland.dx.dataset.SortDescriptor;

public class repIspListCorg implements raReportData {//implements sg.com.elixir.reportwriter.datasource.IDataProvider {
  hr.restart.baza.dM dm= hr.restart.baza.dM.getDataModule();
  frmIspList fil = frmIspList.getInstance();
  DataSet radnici = fil.getRadniciCorg();

  raDateUtil rdu = raDateUtil.getraDateUtil();
  repMemo rpm = repMemo.getrepMemo();
  Valid vl = Valid.getValid();



  public repIspListCorg() {
    radnici.setSort(new SortDescriptor(new String[] {"CORG", "PREZIME"}));
//    fil = frmIspList.getInstance();
//    radnici = fil.getRadnici();
  }
  
/*
  public repIspListCorg(int idx) {
    if (idx == 0){
//      sysoutTEST syst = new sysoutTEST(false);
//      syst.prn(radnici);
    }
    radnici.goToRow(idx);
    fil.findStrings(radnici.getString("CRADNIK"), radnici.getShort("RBROBR"), radnici.getShort("MJOBR"), radnici.getShort("GODOBR"));
  }

  public java.util.Enumeration getData() {
    return new java.util.Enumeration() {
      {
        radnici.enableDataSetEvents(false);
        radnici.open();
      }
      int indx=0;
      public Object nextElement() {
        return new repIspListCorg(indx++);
      }
      public boolean hasMoreElements() {
        if (indx < radnici.getRowCount()) return true;
        radnici.enableDataSetEvents(true);
        return false;
      }
    };
  }

  public void close() {
  }
*/
  


  public void close() {
    radnici = null;
  }
  public raReportData getRow(int i) {
    radnici.goToRow(i);
    fil.findStrings(radnici.getString("CRADNIK"), radnici.getShort("RBROBR"), radnici.getShort("MJOBR"), radnici.getShort("GODOBR"));
    return this;
  }
  public int getRowCount() {
    return radnici.rowCount();
  }
  
  
  public String getCORG() {
    return radnici.getString("CORG");
  }

  public String getNaziV() {
    fil.ld.raLocate(dm.getOrgstruktura(), new String[] {"CORG"}, new String[] {radnici.getString("CORG")});
    return dm.getOrgstruktura().getString("NAZIV");
  }

  public String getIsplataNa(){
    return fil.getIsplataString();
  }

  public String getRadnoMjesto() {
    return fil.getRadnoMjesto();
  }

  public String getNazivRadnogMjesta() {
    return fil.getNazivRadnogMjesta();
  }
  public String getInformationLine() {
    return fil.getInformLine();
  }

  public String getRadnik() {
    return radnici.getString("CRADNIK");
  }

  public String getPrezime() {
    return radnici.getString("PREZIME").concat(" " + radnici.getString("IME"));//.concat(" - " + radnici.getString("IMEOCA"));
  }

  public String getIme() {
    return radnici.getString("IME");
  }

  public String getImeOca() {
    return radnici.getString("IMEOCA");
  }

  // RASTEZLJIVI STRINGOVI ZA STAVKE

  public String getPrimanja() {
    return fil.getPrimanja();
  }

  public String getSati() {
    return fil.getSati();
  }

  public String getUcinak() {
    return fil.getUcinak();
  }

  public String getBruto() {
    return fil.getBruto();
  }

  public String getNeto() {
    return fil.getNeto();
  }

  public String getDoprinosi() {
    return fil.getDoprinosi();
  }

  public String getOsnovicaDop() {
    return fil.getOsnovicaDoprinosa();
  }

  public String getStopa() {
    return fil.getStopa();
  }

  public String getIznosDoprinosa() {
    return fil.getIznosDoprinosa();
  }
  
  public String getDoprinosiNa() {
    return fil.getDoprinosiNa();
  }

  public String getOsnovicaDopNa() {
    return fil.getOsnovicaDoprinosaNa();
  }

  public String getStopaNa() {
    return fil.getStopaNa();
  }

  public String getIznosDoprinosaNa() {
    return fil.getIznosDoprinosaNa();
  }

  public String getNaknade() {
    return fil.getNaknade();
  }

  public String getSatiNaknade() {
    return fil.getSatiNaknada();
  }

  public String getIznosNaknada() {
    return fil.getIznosNaknada();
  }

  public String getKrediti() {
    return fil.getKrediti();
  }

  public String getIznosKredita() {
    return fil.getIznosKredita();
  }

  // KRAJ - RASTEZLJIVI STRINGOVI


  public BigDecimal getTotalSati() {
    return radnici.getBigDecimal("SATI");
  }

  public BigDecimal getTotalBruto() {
    return radnici.getBigDecimal("BRUTO");
  }

//  public BigDecimal getTotalNeto() {
//    return radnici.getBigDecimal("NETO2");
//  }
  public BigDecimal getTotalNeto() {
    if (fil.getNetoColParam().equals("NETO")) {
      return radnici.getBigDecimal("NETO2");
    } else {
      return getDohodak();
    }
  }

  public BigDecimal getTotalDoprinosi() {
    return radnici.getBigDecimal("DOPRINOSI");
  }

  public BigDecimal getTotalStopa() {
    return fil.getTotalStopa();
  }
  public BigDecimal getTotalStopaNa() {
    return fil.getTotalStopaNa();
  }
  public BigDecimal getTotalDoprinosiNa() {
    return fil.getTotalIznosNa();
  }
  public BigDecimal getBruto2() {
    return getTotalDoprinosiNa().add(getTotalBruto());
  }
  public BigDecimal getDohodak() {
    return radnici.getBigDecimal("NETO");
  }

  public BigDecimal getMinimalac() {
    return fil.getMinimalac(radnici); 
  }

  public BigDecimal getKoefOlaksice() {
    return fil.getKoefOlaksice(radnici);
  }

  public BigDecimal getNeoporezivo() {
    return radnici.getBigDecimal("NEOP");
  }

  public BigDecimal get3_1_odIDa(){
    return radnici.getBigDecimal("ZIVOTNOOSIG");
  }

  public BigDecimal get3_2_odIDa(){
    return radnici.getBigDecimal("ZDRAVSTVENOOSIG");
  }

  public BigDecimal get3_3_odIDa(){
    return radnici.getBigDecimal("MIROVINSKOOSIG");
  }

  public BigDecimal getNeoporezivoIskoristeno() {
    return radnici.getBigDecimal("ISKNEOP");
  }

  public BigDecimal getPorezOsnovica() {
    return radnici.getBigDecimal("POROSN");
  }

  public BigDecimal getPorez15() {
    return radnici.getBigDecimal("POR1");
  }

  public BigDecimal getPorez25() {
    return radnici.getBigDecimal("POR2");
  }

  public BigDecimal getPorez35() {
    return radnici.getBigDecimal("POR3");
  }

  public BigDecimal getPorez45() {
    return radnici.getBigDecimal("POR4");
  }

  public BigDecimal getTotalPorez() {
    return radnici.getBigDecimal("PORUK");
  }

  public BigDecimal getPrirez() {
    return radnici.getBigDecimal("PRIR");
  }

  public BigDecimal getTotalPorezPrirez() {
    return radnici.getBigDecimal("PORIPRIR");
  }

  public BigDecimal getTotalNaknade() {
    return radnici.getBigDecimal("NAKNADE");
  }

  public BigDecimal getNetoPlusNaknade() {
    return radnici.getBigDecimal("NETOPK");
  }

  public BigDecimal getTotalKrediti() {
    return radnici.getBigDecimal("KREDITI");
  }

  public String getLovaNaRukeKeshovina() {
    if (fil.getPrikazIsplate())
      return fil.format(radnici, "NARUKE");
    else
      return "";
  }
  public String getPor1txt() {
    return fil.getPor1txt(radnici);
  }
  public String getPor2txt() {
    return fil.getPor2txt(radnici);
  }
  public String getPor3txt() {
    return fil.getPor3txt(radnici);
  }
  public String getPor4txt() {
    return fil.getPor4txt(radnici);
  }
  public String getPrirtxt() {
    return fil.getPrirtxt(radnici);
  }
  public String getFirstLine(){
//    return rpm.getFirstLine();
    return fil.shouldPrintLogo()?"":rpm.getOneLine()+"\n�iro: "+rpm.getLogoZiro()+"  OIB: "+rpm.getLogoOIB();
  }
  public String getSecondLine(){
    return rpm.getSecondLine();
  }
  public String getThirdLine(){
    return rpm.getThirdLine();
  }
  public String getLogoMjesto(){
    return rpm.getLogoMjesto();
  }
  public String getDatumIsplate(){
    return rdu.dataFormatter(radnici.getTimestamp("DATISP"));
  }
  public String getNADNASLOV(){
    if (fil.getRepMode() == 'A')
      return fil.getObracun(radnici.getShort("GODOBR"), radnici.getShort("MJOBR"), radnici.getShort("RBROBR"));
    return fil.getObracun();
  }
  public int getFINALSORTER(){
    int sort=0;
    if (fil.getRepMode() == 'A'){
      sort = radnici.getShort("GODOBR") * 10000 + radnici.getShort("MJOBR") * 100 + radnici.getShort("RBROBR");
    }
    return sort;
  }
}




/*

  public void allValues() {
    Method[] mets = this.getClass().getMethods();
    for (int i = 0; i < mets.length; i++) {
      try {
        if (mets[i].getName().toLowerCase().startsWith("get")) {
          Object val = mets[i].invoke(this,null);
          System.out.println(mets[i].getName()+" = "+val);
        }
      }
      catch (Exception ex) {
        System.out.println("TO SAM JA SJEBO");
        ex.printStackTrace();
      }
    }
  }
  public static void main(String[] args) {
    startFrame.getStartFrame();
    new frmIspList().pack();
    frmIspList.getInstance().show();

  }

  */

