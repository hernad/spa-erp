/****license*****************************************************************
**   file: repOTPvri.java
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

import hr.restart.util.lookupData;
import hr.restart.util.reports.raReportData;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.borland.dx.dataset.DataRow;
import com.borland.dx.dataset.SortDescriptor;

public class repOTPvri extends repIzlazni implements raReportData { //sg.com.elixir.reportwriter.datasource.IDataProvider {

  //_Main main;
  //DataSet ds = reportsQuerysCollector.getRQCModule().getQueryDataSet();
  //hr.restart.baza.dM dm= hr.restart.baza.dM.getDataModule();
  //raDateUtil rdu = raDateUtil.getraDateUtil();

  //String[] colname = new String[] {""};
  //repUtil ru = repUtil.getrepUtil();
  //hr.restart.util.Util ut =  hr.restart.util.Util.getUtil();
  //repMemo rm = repMemo.getrepMemo();


  public repOTPvri() {
    System.out.println("REPOTPVRI!!!!!!");
    ds.setSort(new SortDescriptor(new String[] {"BRDOK", "RBR"}));
    ru.setDataSet(ds);
    hr.restart.util.sysoutTEST syst = new hr.restart.util.sysoutTEST(false);
    syst.prn(ds);

  }

  public raReportData getRow(int i) {
    ds.goToRow(i);
    return this;
  }

  public int getRowCount() {
    return ds.rowCount();
  }

  public void close() {
    ru.setDataSet(null);
    ds = null;
  }
  /*
  public repOTPvri(int idx) {
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
        return new repOTPvri(indx++);
      }
      public boolean hasMoreElements() {
        return (indx < ds.getRowCount());
      }
    };
  }

  public void close() {
  }
   */
  public int getCPAR() {
    if (!ds.isNull("CPAR") && ds.getInt("CPAR") != 0){
      return ds.getInt("CPAR");
    }else if (!ds.isNull("CKUPAC") && ds.getInt("CKUPAC") != 0){
      DataRow dr = hr.restart.util.lookupData.getlookupData().raLookup(hr.restart.baza.dM.getDataModule().getKupci(),"CKUPAC", ds.getInt("CKUPAC")+"");
      return dr.getInt("CKUPAC");
    }
    return 0;
  }

  public String getNAZPAR() {
    if (!ds.isNull("CPAR") && ds.getInt("CPAR") != 0){
      ru.setDataSet(ds);
      colname[0] = "CPAR";
      String np = ru.getSomething(colname, dm.getPartneri(), "NAZPAR").getString();
      if(ds.getInt("PJ")>0){
        lookupData.getlookupData().raLocate(dm.getPjpar(),
            new String[]{"CPAR", "PJ"}
        ,
        new String[]{ds.getInt("CPAR")+"", ds.getInt("PJ")+""});
        np += "\n"+dm.getPjpar().getString("NAZPJ");
      }
      return np;
    } else if (!ds.isNull("CKUPAC") && ds.getInt("CKUPAC") != 0){
      DataRow dr = hr.restart.util.lookupData.getlookupData().raLookup(hr.restart.baza.dM.getDataModule().getKupci(),"CKUPAC", ds.getInt("CKUPAC")+"");
      return dr.getString("IME")+" "+dr.getString("PREZIME");
    }
    return "";
  }

  public String getMJ() {
    if (!ds.isNull("CPAR") && ds.getInt("CPAR") != 0){
      ru.setDataSet(ds);
      colname[0] = "CPAR";
      String mj = "";
      if(ds.getInt("PJ")>0){
        lookupData.getlookupData().raLocate(dm.getPjpar(),
            new String[]{"CPAR", "PJ"}
        ,
        new String[]{ds.getInt("CPAR")+"", ds.getInt("PJ")+""});
        if(dm.getPjpar().getInt("PBRPJ")>0)mj = dm.getPjpar().getInt("PBRPJ")+" "+dm.getPjpar().getString("MJPJ");
        else mj = dm.getPjpar().getString("MJPJ");
      } else{
        lookupData.getlookupData().raLocate(dm.getPartneri(), "CPAR", ds.getInt("CPAR")+"");
        if(dm.getPartneri().getInt("PBR")>0)mj = dm.getPartneri().getInt("PBR")+" "+dm.getPartneri().getString("MJ");
        else mj = dm.getPartneri().getString("MJ");
      }
      return mj;
    } else if (!ds.isNull("CKUPAC") && ds.getInt("CKUPAC") != 0){
      DataRow dr = hr.restart.util.lookupData.getlookupData().raLookup(hr.restart.baza.dM.getDataModule().getKupci(),"CKUPAC", ds.getInt("CKUPAC")+"");
      if (dr.getInt("PBR") >0) return dr.getInt("PBR") + " " + dr.getString("MJ");
      else return dr.getString("MJ");
    }
    return "";
  }

  public String getADR() {
    if (!ds.isNull("CPAR") && ds.getInt("CPAR") != 0){
      String adr = "";
      if(ds.getInt("PJ")>0){
        lookupData.getlookupData().raLocate(dm.getPjpar(),
            new String[]{"CPAR", "PJ"}
        ,
        new String[]{ds.getInt("CPAR")+"", ds.getInt("PJ")+""});
        adr = dm.getPjpar().getString("ADRPJ");
      } else{
        lookupData.getlookupData().raLocate(dm.getPartneri(), "CPAR", ds.getInt("CPAR")+"");
        adr = dm.getPartneri().getString("ADR");
      }
      return adr;
    } else if (!ds.isNull("CKUPAC") && ds.getInt("CKUPAC") != 0){
      DataRow dr = hr.restart.util.lookupData.getlookupData().raLookup(hr.restart.baza.dM.getDataModule().getKupci(),"CKUPAC", ds.getInt("CKUPAC")+"");
      return dr.getString("ADR");
    }
    return "";
  }

  public String getKONTOSOB() {
    String koso = "";
    if (ds.getInt("CKO") > 0){
      lookupData.getlookupData().raLocate(dm.getKosobe(),"CKO",ds.getInt("CKO")+"");
      koso = "n/r " + dm.getKosobe().getString("IME");
    }
    return koso;
  }

//public String getNAZPAR() {
//ru.setDataSet(ds);
//colname[0] = "CPAR";
//return ru.getSomething(colname,dm.getPartneri(),"NAZPAR").getString();
//}

//public String getMJ() {
//ru.setDataSet(ds);
//colname[0] = "CPAR";
//return ru.getSomething(colname,dm.getPartneri(),"MJ").getString();
//}

//public String getADR() {
//ru.setDataSet(ds);
//colname[0] = "CPAR";
//return ru.getSomething(colname,dm.getPartneri(),"ADR").getString();
//}

  public int getPBR() {
    ru.setDataSet(ds);
    colname[0] = "CPAR";
    return ru.getSomething(colname,dm.getPartneri(),"PBR").getAsInt();
  }

  public String getMB(){
    if(!ds.isNull("CPAR")&&ds.getInt("CPAR")!=0){
      return super.getMB();
    } else if(!ds.isNull("CKUPAC")&&ds.getInt("CKUPAC")!=0){
      return super.getJMBG();
    }
    return "";

  }

  public String getZR() {
    ru.setDataSet(ds);
    colname[0] = "CPAR";
    return ru.getSomething(colname,dm.getPartneri(),"ZR").getString();
  }

  public String getCSKL() {
    return ds.getString("CSKL");
  }

  public String getVRDOK() {
    return ds.getString("VRDOK");
  }

  public String getGOD() {
    return ds.getString("GOD");
  }

  public int getBRDOK() {
    return ds.getInt("BRDOK");
  }

  public String getUI() {
    return ds.getString("UI");
  }

  public Timestamp getSYSDAT() {
    return ds.getTimestamp("SYSDAT");
  }

  public String SgetSYSDAT() {
    return rdu.dataFormatter(getSYSDAT());
  }

  public Timestamp getDATDOK() {
    return ds.getTimestamp("DATDOK");
  }
  public String SgetDATDOK() {
    return rdu.dataFormatter(getDATDOK());
  }

  public int getPJ() {
    return ds.getInt("PJ");
  }

  public String getCORG() {
    return ds.getString("CORG");
  }

  public String getCVRTR() {
    return ds.getString("CVRTR");
  }

  public String getCUG() {
    return ds.getString("CUG");
  }

  public Timestamp getDATUG() {
    return ds.getTimestamp("DATUG");
  }
  public String SgetDATUG() {
    return rdu.dataFormatter(getDATUG());
  }

  public Timestamp getDVO() {
    return ds.getTimestamp("DVO");
  }

  public String SgetDVO() {
    return rdu.dataFormatter(getDVO());
  }

  public short getDDOSP() {
    return ds.getShort("DDOSP");
  }

  public Timestamp getDATDOSP() {
    return ds.getTimestamp("DATDOSP");
  }

  public String SgetDATDOSP() {
    return rdu.dataFormatter(getDATDOSP());
  }

  public String getBRDOKIZ() {
    return ds.getString("BRDOKIZ");
  }

  public Timestamp getDATDOKIZ() {
    return ds.getTimestamp("DATDOKIZ");
  }

  public String SgetDATDOKIZ() {
    return rdu.dataFormatter(getDATDOKIZ());
  }

  public String getBRPRD() {
    return ds.getString("BRPRD");
  }

  public Timestamp getDATPRD() {
    return ds.getTimestamp("DATPRD");
  }

  public String SgetDATPRD() {
    return rdu.dataFormatter(getDATPRD());
  }

  public String getBRNARIZ() {
    return ds.getString("BRNARIZ");
  }

  public Timestamp getDATNARIZ() {
    return ds.getTimestamp("DATNARIZ");
  }

  public String SgetDATNARIZ() {
    return rdu.dataFormatter(getDATNARIZ());
  }

  public String getOZNVAL() {
    return ds.getString("OZNVAL");
  }

  public BigDecimal getTECAJ() {
    return ds.getBigDecimal("TECAJ");
  }

  public String getBRNAL() {
    return ds.getString("BRNAL");
  }

  public Timestamp getDATKNJ() {
    return ds.getTimestamp("DATKNJ");
  }

  public String SgetDATKNJ() {
    return rdu.dataFormatter(getDATKNJ());
  }

  public String getCRADNAL() {
    return ds.getString("CRADNAL");
  }

  public Timestamp getDATRADNAL() {
    return ds.getTimestamp("DATRADNAL");
  }

  public String SgetDATRADNAL() {
    return rdu.dataFormatter(getDATRADNAL());
  }

  public String getSTATUS1() {
    return ds.getString("STATUS1");
  }

  public String getSTATKNJ() {
    return ds.getString("STATKNJ");
  }

  public String getSTATPLA() {
    return ds.getString("STATPLA");
  }

  public String getSTATIRA() {
    return ds.getString("STATIRA");
  }

  public String getCFRA() {
    return ds.getString("CFRA");
  }

  public String getCNACPL() {
    return ds.getString("CNACPL");
  }

  public String getCNAMJ() {
    return ds.getString("CNAMJ");
  }

  public String getCNAC() {
    return ds.getString("CNAC");
  }

  public String getCNAP() {
    return ds.getString("CNAP");
  }

  public BigDecimal getUPZT() {
    return ds.getBigDecimal("UPZT");
  }

  public String getCSHZT() {
    return ds.getString("CSHZT");
  }

  public BigDecimal getUPRAB() {
    return ds.getBigDecimal("UPRAB");
  }

  public String getCSHRAB() {
    return ds.getString("CSHRAB");
  }

  public String getOPIS() {
    return ds.getString("OPIS");
  }

  public short getRBR() {
    return ds.getShort("RBR");
  }

  public String getSHIFRA() {
    return "" + ds.getInt("CART");
  }

  public String getCART1() {
    return ds.getString("CART1");
  }

  public String getBC() {
    return ds.getString("BC");
  }

  public String getCART() {
    return Aut.getAut().getIzlazCARTdep(ds);
  }

  public String getNAZART() {
    return ds.getString("NAZART");
  }

  public String getJM() {
    return ds.getString("JM");
  }

  public BigDecimal getKOL() {
    return ds.getBigDecimal("KOL");
  }

  public BigDecimal getUPRAB1() {
    return ds.getBigDecimal("UPRAB1");
  }

  public double getUIRAB() {
    return ds.getBigDecimal("UIRAB").doubleValue();
  }

  public BigDecimal getUPZT1() {
    return ds.getBigDecimal("UPZT1");
  }

  public BigDecimal getUIZT() {
    return ds.getBigDecimal("UIZT");
  }

  public BigDecimal getFC() {
    return ds.getBigDecimal("FC");
  }

  public double getINETO() {
    return ds.getBigDecimal("INETO").doubleValue();
  }

  public BigDecimal getFVC() {
    return ds.getBigDecimal("FVC");
  }
  /*
  public BigDecimal getIPRODBP() {
   return ds.getBigDecimal("IPRODBP");
  }

  public BigDecimal getPOR1() {
   return ds.getBigDecimal("POR1");
  }

  public BigDecimal getPOR2() {
   return ds.getBigDecimal("POR2");
  }

  public BigDecimal getPOR3() {
   return ds.getBigDecimal("POR3");
  }
   */
  public double getIPRODBP() {
    return ds.getBigDecimal("IPRODBP").doubleValue();
  }

  public double getPOR1() {
    return ds.getBigDecimal("POR1").doubleValue();
  }

  public double getPOR2() {
    return ds.getBigDecimal("POR2").doubleValue();
  }

  public double getPOR3() {
    return ds.getBigDecimal("POR3").doubleValue();
  }


  public double getUKPOR3() {
    return getPOR1()+getPOR2()+getPOR3();
  }

  public BigDecimal getFMC() {
    return ds.getBigDecimal("FMC");
  }

  /*
  public BigDecimal getIPRODSP() {
   return ds.getBigDecimal("IPRODSP");
  }
   */
  public double getIPRODSP() {
    return ds.getBigDecimal("IPRODSP").doubleValue();
  }

  public BigDecimal getNC() {
    return ds.getBigDecimal("NC");
  }

  public BigDecimal getINAB() {
    return ds.getBigDecimal("INAB");
  }

  public BigDecimal getIMAR() {
    return ds.getBigDecimal("IMAR");
  }

  public BigDecimal getVC() {
    return ds.getBigDecimal("VC");
  }

  public BigDecimal getIBP() {
    return ds.getBigDecimal("IBP");
  }

  public BigDecimal getIPOR() {
    return ds.getBigDecimal("IPOR");
  }

  public BigDecimal getMC() {
    return ds.getBigDecimal("MC");
  }

  public double getISP() {
    return ds.getBigDecimal("ISP").doubleValue();
  }

  public BigDecimal getZC() {
    return ds.getBigDecimal("ZC");
  }

  public double getIRAZ() {
    return ds.getBigDecimal("IRAZ").doubleValue();
  }

  public String getBRPRI() {
    return ds.getString("BRPRI");
  }

  public short getRBRPRI() {
    return ds.getShort("RBRPRI");
  }

  public String getNAZNAP() {
    ru.setDataSet(ds);
    colname[0] = "CNAP";
    return ru.getSomething(colname,dm.getNapomene(),"NAZNAP").getString();
  }

  public String getNAZNACPL() {
    ru.setDataSet(ds);
    colname[0] = "CNACPL";
    return ru.getSomething(colname,dm.getNacpl(),"NAZNACPL").getString();
  }

  public String getNAZNAC() {
    ru.setDataSet(ds);
    colname[0] = "CNAC";
    return ru.getSomething(colname,dm.getNacotp(),"NAZNAC").getString();
  }

  public String getNAZFRA() {
    ru.setDataSet(ds);
    colname[0] = "CFRA";
    return ru.getSomething(colname,dm.getFranka(),"NAZFRA").getString();
  }
  /*
  public String getFormatBroj(){
   return ru.getFormatBroj();
  }
   */
  public String getPorezPos() {
    ru.setDataSet(ds);
    colname[0]="CART";
    return ru.getSomething(colname,dm.getArtikli(),"CPOR").getString();
  }

  public String getUSER(){
    if(lookupData.getlookupData().raLocate(dm.getUseri(), "CUSER", ds.getString("CUSER"))){
      return dm.getUseri().getString("NAZIV");
    } else{
      return "";
    }
  }

  public String getPor1Naz(){
    getPorezPos();
    colname[0] ="CPOR";
    return ru.getSomething2(colname,colname,dm.getArtikli(),dm.getPorezi(),"nazpor1").getString();
  }
  public int getImaPor1(){
    return (getPor1Naz().equals(""))?0:1;
  }
  public String getPor2Naz(){
    ru.setDataSet(ds);
    getPorezPos();
    colname[0] ="CPOR";
    return ru.getSomething2(colname,colname,dm.getArtikli(),dm.getPorezi(),"nazpor2").getString();
  }
  public int getImaPor2(){
    return (getPor2Naz().equals(""))?0:1;
  }
  public String getPor3Naz(){
    ru.setDataSet(ds);
    getPorezPos();
    colname[0] ="CPOR";
    return ru.getSomething2(colname,colname,dm.getArtikli(),dm.getPorezi(),"nazpor3").getString();
  }
  public int getImaPor3(){
    return (getPor3Naz().equals(""))?0:1;
  }
  public BigDecimal getPOSPor1(){
    /*ru.setDataSet(ds);
   getPorezPos();
   colname[0] ="CPOR";
   return ru.getSomething2(colname,colname,dm.getArtikli(),dm.getPorezi(),"por1").getBigDecimal();
     */
    return ds.getBigDecimal("PPOR1");
  }
  public BigDecimal getPOSPor3(){
    /*ru.setDataSet(ds);
   getPorezPos();
   colname[0] ="CPOR";
   return ru.getSomething2(colname,colname,dm.getArtikli(),dm.getPorezi(),"por3").getBigDecimal();
     */
    return ds.getBigDecimal("PPOR3");
  }
  public BigDecimal getPOSPor2(){
    /*ru.setDataSet(ds);
   getPorezPos();
   colname[0] ="CPOR";
   return ru.getSomething2(colname,colname,dm.getArtikli(),dm.getPorezi(),"por2").getBigDecimal();
     */
    return ds.getBigDecimal("PPOR2");
  }

  public BigDecimal getPor1p2p3Naz(){
    /*
   ru.setDataSet(ds);
   getPorezPos();
   colname[0] ="CPOR";
   return ru.getSomething2(colname,colname,dm.getArtikli(),dm.getPorezi(),"ukupor").getBigDecimal();
     */
    return ds.getBigDecimal("PPOR1").add(ds.getBigDecimal("PPOR2")).add(ds.getBigDecimal("PPOR3"));
  }
  public String getSLOVIMA() {
    return ut.numToLet(ds.getBigDecimal("UIRAC").doubleValue());
  }
  public int getLogoPotvrda() {
    if (rm.test()) return 1;
    return 0;
  }
  public String getLogoFullAdr() {
    if (!rm.test()) return "";
    else return rm.getLogoAdresa() + " ,  " + rm.getLogoPbr() + " " + rm.getLogoMjesto();
  }
  public String getLineName() {
    return ClassLoader.getSystemResource("hr/restart/robno/reports/line2.jpg").toString();
  }
  public String getLogoCorg(){return rm.getLogoCorg();}
  public String getLogoNazivlog(){return rm.getLogoNazivlog();}
  public String getLogoMjesto(){  return rm.getLogoMjesto();}
  public String getLogoMjestoZarez(){
    lookupData.getlookupData().raLocate(dm.getSklad(),new String[] {"CSKL"}, new String[] {ds.getString("CSKL")});
    String corg = dm.getSklad().getString("CORG"); //System.out.println("* CORG ---> " + corg);
    lookupData.getlookupData().raLocate(dm.getOrgstruktura(),new String[] {"CORG"}, new String[] {corg});
    return dm.getOrgstruktura().getString("MJESTO");
  }
  public String getLogoPbr(){return rm.getLogoPbr();}
  public String getLogoAdresa(){return rm.getLogoAdresa();}
  public String getLogoZiro(){return   rm.getLogoZiro();}
  public String getLogoMatbroj(){return rm.getLogoMatbroj();}
  public String getLogoSifdjel(){return rm.getLogoSifdjel();}
  public String getLogoPorisp(){return rm.getLogoPorisp();}
  public String getLogoFax(){return rm.getLogoFax();}
  public String getLogoTel1(){return rm.getLogoTel1();}
  public String getLogoTel2(){return rm.getLogoTel2();}
}
