/****license*****************************************************************
**   file: repMxRacun.java
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

import hr.restart.baza.dM;
import hr.restart.pos.presBlag;
import hr.restart.sisfun.frmParam;
import hr.restart.util.Aus;
import hr.restart.util.Valid;
import hr.restart.util.VarStr;
import hr.restart.util.lookupData;
import hr.restart.util.reports.mxPrinter;
import hr.restart.util.reports.mxRM;
import hr.restart.util.reports.mxReport;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.borland.dx.dataset.Column;
import com.borland.dx.dataset.DataSet;
import com.borland.dx.dataset.Variant;
import com.borland.dx.sql.dataset.QueryDataSet;

/**
 * <p>Title: Robno poslovanje</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2000</p>
 * <p>Company: REST-ART</p>
 * @author unascribed
 * @version 1.0
 */

public class repMxRacun extends mxReport {
  public QueryDataSet ds;
  raDateUtil rdu = raDateUtil.getraDateUtil();
  reportsQuerysCollector repQC = reportsQuerysCollector.getRQCModule();
  private QueryDataSet detailDS = new QueryDataSet();
  lookupData ld = lookupData.getlookupData();
  hr.restart.util.Util ut =  hr.restart.util.Util.getUtil();
  BigDecimal sumaBP = Aus.zero2;
  BigDecimal sumaSP = Aus.zero2;
  BigDecimal sumaPOR = Aus.zero2;
  BigDecimal sumaIneto = Aus.zero2;
  BigDecimal sumaMC = Aus.zero2;
  BigDecimal popustMC = Aus.zero2;
  int brRedDetail =0;
  int brRedKupac =0;
  int brRedHeader = 6;
  int brRedPGHeader = 5;
  int brRedFooter = 6;
  int brRedRekap = 0;
  int brRedRekPl = 3;
  String oib;
  String fiskForm, specForm;
  String parametar = hr.restart.sisfun.frmParam.getParam("robno","GOTcijena","VC");
  ArrayList nacinPlacanja,rata,datumNaplate ;
  dM dm = dM.getDataModule();

  public repMxRacun() {
    try
    {
      init();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

  }
  public void init() throws Exception
  {
    ds = reportsQuerysCollector.getRQCModule().getQueryDataSet();
    setDataSet(detailDS);
    if(!ds.isOpen()) ds.open();
    nacPl();
    QueryDataSet printerRM = hr.restart.baza.dM.getDataModule().getMxPrinterRM();
    printerRM.open();
    printerRM.first();
    
    oib = frmParam.getParam("robno", "oibMode", "MB", 
    "Staviti mati�ni broj (MB) ili OIB?");
    
    fiskForm = frmParam.getParam("robno", "fiskForm", "[FBR]-[FPP]-[FNU]",
      "Format fiskalnog broja izlaznog dokumenta na ispisu");
    
    specForm = frmParam.getParam("robno", "specForm", "",
        "Custom format broja izlaznog dokumenta na ispisu");

    mxRM matIsp = new mxRM();
    try {
      matIsp.init(printerRM);
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    setRM(matIsp);

    detailDS.addColumn(new Column("RBR","RedBr",Variant.SHORT));
    detailDS.addColumn(new Column("SIFRA","Sifra",Variant.STRING));
    detailDS.addColumn(new Column("NAZIV","Naziv",Variant.STRING));
    detailDS.addColumn(new Column("JM","JedMj",Variant.STRING));
    detailDS.addColumn(new Column("KOL","Kol",Variant.STRING));
    detailDS.addColumn(new Column("CIJENA","CijenaBP",Variant.STRING));
    detailDS.addColumn(new Column("IZNOS","Iznos",Variant.STRING));
//*** dodano
    detailDS.addColumn(new Column("POPUST","Popust",Variant.STRING));
    detailDS.addColumn(new Column("POREZ","Porez",Variant.STRING));
//    String kupac =getKupac();
//    String skladiste = getSkladiste();

    String [] detail =new String[]{"<#RBR|3|right#>"+". "+"<#SIFRA|20|left#>"+" "+"<#NAZIV|36|left#>"+" "+
      "<#KOL|12|right#>"+" "+"<#JM|6|right#>"+" "+"<#POPUST|11|right#>"+" "+"<#POREZ|10|right#>"+" "+"<#CIJENA|13|right#>"+
      " "+"<#IZNOS|16|right#>"};
    this.setDetail(detail);
  }

  protected void fill()
  {
    sumaBP = Aus.zero2;
    sumaSP = Aus.zero2;
    sumaPOR = Aus.zero2;
    sumaIneto = Aus.zero2;
    sumaMC = Aus.zero2;
    popustMC = Aus.zero2;
    String knjig = hr.restart.zapod.OrgStr.getKNJCORG(false);
    String r1 = frmParam.getParam("robno", "izlazObr"+knjig,
        "R-1", "Vrsta obrasca ispisa ra�una za knjigovodstvo "+knjig);
    getDatum();
    String param = Aut.getAut().getIzlazCART();

    ds.open();

//    hr.restart.util.sysoutTEST syst = new hr.restart.util.sysoutTEST(false);
//    syst.showInFrame(ds,"Dataset");

    ds.first();
    brRedDetail = ds.getRowCount();
    detailDS.open();
    detailDS.empty();
    while(ds.inBounds())
    {
      detailDS.insertRow(false);
      detailDS.setShort("RBR", ds.getShort("RBR"));
      if(param.equals("CART"))
        detailDS.setString("SIFRA", ds.getInt("CART")+"");
      else if(param.equals("CART1"))
        detailDS.setString("SIFRA", ds.getString("CART1"));
      else
        detailDS.setString("SIFRA", ds.getString("BC"));
      detailDS.setString("NAZIV", ds.getString("NAZART"));
      detailDS.setString("JM", ds.getString("JM"));
      detailDS.setString("KOL", replaceFullStop(ds.getBigDecimal("KOL").toString()));
      if(parametar.equals("VC"))
      {
        detailDS.setString("CIJENA", formatIznos(ds.getBigDecimal("FC"), 13));
        detailDS.setString("IZNOS", formatIznos(ds.getBigDecimal("INETO"),16));
      }
      else
      {
        BigDecimal cj =ds.getBigDecimal("FMCPRP");
        detailDS.setString("CIJENA", formatIznos(cj, 13));
        BigDecimal izn = ds.getBigDecimal("FMCPRP").multiply(ds.getBigDecimal("KOL")).setScale(2,BigDecimal.ROUND_HALF_UP);
        detailDS.setString("IZNOS", formatIznos(izn,16));
        sumaMC = sumaMC.add((ds.getBigDecimal("FMCPRP").multiply(ds.getBigDecimal("KOL"))).setScale(2,BigDecimal.ROUND_HALF_UP));
      }
      detailDS.setString("POPUST", replaceFullStop(ds.getBigDecimal("UPRAB1").toString()));
      detailDS.setString("POREZ", replaceFullStop(ds.getBigDecimal("UPPOR").toString()));
      sumaBP=sumaBP.add(ds.getBigDecimal("IPRODBP"));
      sumaSP=sumaSP.add(ds.getBigDecimal("IPRODSP"));

      sumaIneto=sumaIneto.add(ds.getBigDecimal("INETO"));
      popustMC = popustMC.add(((ds.getBigDecimal("FMCPRP").subtract(ds.getBigDecimal("FMC"))).multiply(ds.getBigDecimal("KOL"))).setScale(2,BigDecimal.ROUND_HALF_UP));
      detailDS.post();
      ds.next();
    }

    if(parametar.equals("VC"))
    {
      this.setFooter(new String[]{"----------------------------------------------------------------------------------------------------------------------------------------"+"<$newline$>"+
                     ukBPStr()+
                     ukPopustStr()+
                     "              REKAPITULACIJA POREZA                                                                   UKUPNO BEZ POREZA   "+formatIznos(sumaBP,14)+"<$newline$>"+
                     "      Grupa      %         Osnovica          Iznos                                                         UKUPNO POREZ   "+formatIznos(sumaSP.add(sumaBP.negate()),14)+"<$newline$>"+
          getPorezRekapitulacija()+getNP()+"<$newline$><$newline$>" + getNapomenaOpis() +addLines()});
    }
    else
    {
      this.setFooter(new String[]{"----------------------------------------------------------------------------------------------------------------------------------------"+"<$newline$>"+
                     "              REKAPITULACIJA POREZA                                                                              UKUPNO   "+formatIznos(sumaMC,14)+"<$newline$>"+
                     "      Grupa      %         Osnovica          Iznos                                                               POPUST   "+ukPopustStr()+"<$newline$>"+
          getPorezRekapitulacija()+getNP()+"<$newline$><$newline$>" + getNapomenaOpis() +addLines()});
    }

    this.setHeader(new String[]{"                                                                                                                                                         "+"<$DoubleWidthON$>"+r1+/*"R-1"+*/"<$DoubleWidthOFF$>"+"<$newline$>"+
                   "<$Reset$><$CondensedON$>"+getKupac()+getRacun()+getSkladiste()+
                   "----------------------------------------------------------------------------------------------------------------------------------------"+"<$newline$>"+
                   "R.B."+" �ifra               "+" Naziv artikla/usluge                "+"     Koli�ina"+"     JM"+"  Popust (%)"+"  Porez (%)"+"        Cijena"+"            Iznos"+"<$newline$>"+
        "----------------------------------------------------------------------------------------------------------------------------------------"});
    this.setPgHeader("<$Reset$>"+Util.getUtil().getDefaultMxHeader()+
                     "");
    brRedDetail = detailDS.getRowCount();
  }

  private String formatIznos(BigDecimal izn, int len)
  {
    if(izn.compareTo(new BigDecimal(0))==0)
       return Valid.getValid().maskString("0,00",' ', len);
    String finalStr ="";
    int idx=0;
    String temp="";
    String iznos = izn.toString();
    String iznosInt=iznos.substring(0,iznos.indexOf("."));
    String iznosDec=iznos.substring(iznos.indexOf(".")+1, iznos.length());
    for(int i= 0; i<iznosInt.length();i++)
    {
      temp = iznosInt.substring((iznosInt.length()-(i+1)),(iznosInt.length()-(i)))+temp;
      idx++;
      if(idx==3 && iznosInt.length()>3)
      {
        temp="."+temp;
        idx=0;
      }
    }
    finalStr = temp+","+iznosDec;
    return Valid.getValid().maskString(finalStr,' ', len);
  }

  private String formatStr(String i, int length)
  {
    return Valid.getValid().maskString(i+"",' ', length);
  }

  String racunString = "";

  protected String getKupac()
  {
    ds.open();
    ds.first();
    String kupacTemp=ds.getInt("CKUPAC")+"";
    String knjig = hr.restart.zapod.OrgStr.getKNJCORG(false);
    String r1 = frmParam.getParam("robno", "izlazObr"+knjig,
        "R-1", "Vrsta obrasca ispisa ra�una za knjigovodstvo "+knjig);
    
    if(!kupacTemp.equals("0") )
    {
      racunString = r1+" RA�UN";
      brRedKupac = 1;
      ld.raLocate(dm.getKupci(), new String []{"CKUPAC"}, new String []{kupacTemp});
      String firstRow;
      String secondRow ="";
      String thirdRow="";
      String fourthRow="";
      firstRow = "KUPAC: "+formatStr(kupacTemp,6)+" <$CondensedOFF$>"+dm.getKupci().getString("IME")+" "+
                 dm.getKupci().getString("PREZIME")+"<$CondensedON$><$newline$>";
      if(!dm.getKupci().getString("ADR").equals(""))
      {
        secondRow = formatStr("",14)+dm.getKupci().getString("ADR");
        brRedKupac+=1;
      }
      if(!dm.getKupci().getString("MJ").equals(""))
      {
        secondRow += ", " +dm.getKupci().getInt("PBR")+" "+dm.getKupci().getString("MJ");
      }

      if (!oib.equalsIgnoreCase("MB") && 
          dm.getKupci().getString("OIB").length() > 0) {
        if(secondRow.equals(""))
          secondRow = "<$newline$>"+formatStr("",14)+"OIB: "+dm.getKupci().getString("OIB")+"<$newline$>"+"<$newline$>";
        else
          secondRow += ", OIB: "+dm.getKupci().getString("OIB")+"<$newline$>"+"<$newline$>";
        brRedKupac +=1;
      } else       
      if(!oib.equalsIgnoreCase("OIB") &&
          !dm.getKupci().getString("JMBG").equals(""))
      {
        if(secondRow.equals(""))
          secondRow = "<$newline$>"+formatStr("",14)+"MB: "+dm.getKupci().getString("JMBG")+"<$newline$>"+"<$newline$>";
        else
          secondRow += ", MB: "+dm.getKupci().getString("JMBG")+"<$newline$>"+"<$newline$>";
        brRedKupac +=1;
      }
      else
      {
        fourthRow = "<$newline$>";
        brRedKupac+=1;
      }
      return firstRow+secondRow+thirdRow+fourthRow;
    } else {
      racunString = "RA�UN";
    }
    return "";
  }

//  private String getRekapPl()
//  {
//    return "REKAPITULACIJA PLA�ANJA";
//  }

  protected String getSkladiste()
  {
    ds.open();
    ds.first();
    String skladTemp=ds.getString("CSKL");
    ld.raLocate(dm.getSklad(), new String []{"CSKL"}, new String []{skladTemp});
    String prMj = "PRODAJNO MJESTO:"+formatStr(skladTemp,12)+" "+dm.getSklad().getString("NAZSKL");
    String date = formatStr(getDatum(), 136-prMj.length());
    return prMj+date+"<$newline$>";
  }

  protected String getRacun()
  {
    ds.open();
    ds.first();
    String vrati = /*"RA�UN"*/racunString+" br.  "+ds.getString("VRDOK")+"-"+ds.getString("CSKL")+"/"+ds.getString("GOD")+"-"+ds.getInt("BRDOK");
    
    if (ds.getString("FOK").equalsIgnoreCase("D")) {
      vrati = racunString+" br.  " + Aus.formatBroj(ds, fiskForm);
    }
    
    return "<$Reset$><$DoubleWidthON$>"+formatStr(vrati, vrati.length()+(40-vrati.length())/2)+"<$DoubleWidthOFF$>"+"<$CondensedON$>"+"<$newline$>"+"<$newline$>";
  }

  private String addLines()
  {
    String lines ="";
    int red = 0;
    int brRedova=0;

    int initBrRedova = mxPrinter.getDefaultMxPrinter().getDefaultMxPrinterA5();
    for (int koef = 1; koef<10;koef++)
    {
      if(initBrRedova*koef>brRedKupac + brRedDetail+brRedHeader+brRedFooter+brRedPGHeader+brRedRekap+brRedRekPl)
      {
      brRedova = initBrRedova*koef;
      break;
    }
    }

    if(brRedKupac + brRedDetail+brRedHeader+brRedFooter+brRedPGHeader+brRedRekap+brRedRekPl<brRedova)
    {
      for(int i = brRedKupac + brRedDetail+brRedHeader+brRedFooter+brRedPGHeader+brRedRekap+brRedRekPl; i<(brRedova);i++)
      {
        lines += "<$newline$>";
        red++;
      }
    }
    return lines;
  }

  private String getDatum()
  {
    ds.open();
    ds.first();
    ld.raLocate(dm.getSklad(), new String []{"CSKL"}, new String []{ds.getString("CSKL")});
    String corg = dm.getSklad().getString("CORG");
    ld.raLocate(dm.getOrgstruktura(), new String []{"CORG"}, new String []{corg});
    String mjesto = dm.getOrgstruktura().getString("MJESTO");

    return mjesto+", "+raDateUtil.getraDateUtil().dataFormatter(Valid.getValid().getToday())+".";
  }

  private String getPorezRekapitulacija()
  {
    DataSet qds_porez = repQC.getPoreziSet(ds.getString("CSKL"),
                                           ds.getString("VRDOK"),
                                           ds.getString("GOD"),
                                           ds.getInt("BRDOK"));
    if(!qds_porez.isOpen()) qds_porez.open();
    qds_porez.first();
    String rekapitulacija = "";
    while (qds_porez.inBounds())
    {
      rekapitulacija += formatStr(replaceFullStop(qds_porez.getString("CPOR").trim()),11)+" "+
                        formatStr(replaceFullStop(qds_porez.getBigDecimal("UKUPOR").toString())+"%",8)+" "+
                        formatStr(replaceFullStop(qds_porez.getBigDecimal("IPRODBP").toString()),14)+" "+
                        formatStr(replaceFullStop(qds_porez.getBigDecimal("POR1").toString()),14);
                        if(qds_porez.getRow()==0)
                          rekapitulacija += getTotal();
                        rekapitulacija += "<$newline$>";
                        qds_porez.next();
    }
    brRedRekap = qds_porez.getRowCount()-1;
    rekapitulacija +="<$newline$>";
    return rekapitulacija;
  }
  public String getSLOVIMA() {
    return ut.numToLet(sumaSP.doubleValue());
  }

  private String getTotal()
  {
    if(parametar.equals("VC"))
      return formatStr("UKUPNO S POREZOM   "+formatIznos(sumaSP,14), 86);
    return formatStr("                      SVEUKUPNO   "+formatIznos(sumaSP,14), 86);
  }

  private String ukBPStr()
  {
    BigDecimal popust = sumaIneto.add(sumaBP.negate());
    if( popust.compareTo(new BigDecimal(0))==0)
      return "";
    return formatStr("UKUPNO BEZ POPUSTA   "+formatIznos(sumaIneto,14), 136)+"<$newline$>";
  }


  private String ukPopustStr()
  {
    BigDecimal popust = sumaIneto.add(sumaBP.negate());
    if( popust.compareTo(new BigDecimal(0))==0)
    {
      if(parametar.equals("VC"))
        return "";
      return "          0,00";
    }
    if(parametar.equals("VC"))
      brRedFooter=8;
    else
      brRedFooter=6;
    if(parametar.equals("VC"))
      return formatStr("UKUPNO POPUST   "+formatIznos(sumaIneto.add(sumaBP.negate()),14), 136)+"<$newline$>";
    return formatIznos(popustMC,14);
  }



  private void nacPl(){
    nacinPlacanja = new ArrayList();
    rata = new ArrayList();
    datumNaplate  = new ArrayList();
    try
    {
      String upit = "SELECT rbr, cnacpl, cbanka, datum, irata FROM rate "+
                    "WHERE cskl='"+ds.getString("CSKL")+
                    "' AND vrdok='"+ds.getString("VRDOK")+"' AND brdok='" + ds.getInt("BRDOK") +
                    "' and god='"+ds.getString("GOD")+"'";
      QueryDataSet rate = ut.getNewQueryDataSet(upit);
      if (rate.rowCount() == 0){
        nacinPlacanja.add("Gotovina");
        String jednaRata = sgQuerys.getSgQuerys().format(ds, "UIRAC");
        if (jednaRata.indexOf(',') <0)
          rata.add(jednaRata+",00");
      } else {
        rate.first();
        do {
          try {
            lookupData.getlookupData().raLocate(dm.getNacpl(), "CNACPL", rate.getString("CNACPL"));
            if (dm.getNacpl().getString("FL_KARTICA").equals("D")){
              lookupData.getlookupData().raLocate(dm.getKartice(), "CBANKA", rate.getString("CBANKA"));
              nacinPlacanja.add(dm.getNacpl().getString("NAZNACPL")+" - "+dm.getKartice().getString("NAZIV"));
            } else if (dm.getNacpl().getString("FL_CEK").equals("D")){
              lookupData.getlookupData().raLocate(dm.getBanke(), "CBANKA", rate.getString("CBANKA"));
              nacinPlacanja.add(dm.getNacpl().getString("NAZNACPL")+" - "+dm.getBanke().getString("NAZIV"));
            } else {
              nacinPlacanja.add(dm.getNacpl().getString("NAZNACPL"));
            }
          }
          catch (Exception ex) {
            ex.printStackTrace();
          }
          String jednaRata = sgQuerys.getSgQuerys().format(rate, "IRATA");
          if (jednaRata.indexOf(',') <0)
            rata.add(jednaRata+",00");
          else
            rata.add(jednaRata);
          if (!dm.getNacpl().getString("FL_GOT").equals("D"))
            datumNaplate.add(rdu.dataFormatter(rate.getTimestamp("DATUM")));
          else
            datumNaplate.add("");

        } while (rate.next());
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }

  protected String getNP()
  {
    String np="";
    if(rata.size()<=0)
    {
      if(nacinPlacanja.size()==0)
        nacinPlacanja.add("Gotovina");
      rata.add(formatIznos(sumaSP,48-nacinPlacanja.get(0).toString().length()));
      datumNaplate.add("");
    }
    np="              REKAPITULACIJA PLA�ANJA\n";
    for(int i=0;i<nacinPlacanja.size();i++)
    {
      np += nacinPlacanja.get(i)+myFormatStr(rata.get(i).toString(),50-nacinPlacanja.get(i).toString().length() )+
              "  "+  datumNaplate.get(i).toString()+"\n";
    }
    np += "\n"+"SLOVIMA: " +getSLOVIMA();
    
    if (ds.getString("FOK").equalsIgnoreCase("D")) {
      brRedRekPl = brRedRekPl+ 2;
      np += "\n\n" + "Datum i vrijeme izrade: " + rdu.dataFormatter(ds.getTimestamp("SYSDAT")) +
           " u  " + ds.getTimestamp("SYSDAT").toString().substring(11,19) + "    Operater: " + 
             getUSER() + "    Interni broj: " + getOldFormatBroj();
      if ("GOT|GRN".indexOf(ds.getString("VRDOK")) >= 0) {
        brRedRekPl = brRedRekPl+ 2;
        np += "\nZKI: " + getZKI() + "  JIR: " + getJIR();
      }
    }
    
    brRedRekPl = brRedRekPl+ rata.size();
    return np;
  }
  
  protected String getZKI() {
    try {
      return presBlag.getFis(ds).generateZKI(raIzlazTemplate.getRacType(ds));
    } catch (Exception e) {
      return "";
    }
  }
  
  protected String getJIR() {
    try {
      if (repFISBIH.isFISBIH() && (ds.hasColumn("FBR") != null) && (ds.getInt("FBR") > 0)) {
        //return Valid.getValid().maskZeroInteger(new Integer(ds.getInt("FBR")), 6);
        return ds.getInt("FBR")+"";
      } else if (ds.hasColumn("JIR") != null) {
        return ds.getString("JIR").trim();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }
  
  protected String getUSER(){
    if(lookupData.getlookupData().raLocate(dm.getUseri(), "CUSER", ds.getString("CUSER"))){
      return dm.getUseri().getString("NAZIV");
    } else{
      return "";
    }
  }
  
  protected String getOldFormatBroj() {
    if (specForm == null || specForm.length() == 0)
      return repUtil.getFormatBroj(ds);
    if (specForm.equalsIgnoreCase("pnbz2")) {
      if (ds.getString("PNBZ2").trim().length()>0)
        return ds.getString("PNBZ2");
      return repUtil.getFormatBroj(ds);
    }
    return Aus.formatBroj(ds, specForm);
  }

  private String getNapomenaOpis(){
    if (lookupData.getlookupData().raLocate(dm.getNapomene(),"CNAP",ds.getString("CNAP"))){
      if (!ds.getString("OPIS").equals("")){
        return dm.getNapomene().getString("NAZNAP")+"<$newline$>"+ds.getString("OPIS");
      } else {
        return dm.getNapomene().getString("NAZNAP");
      }
    }
    if (!ds.getString("OPIS").equals("")) return ds.getString("OPIS");
    return "";
  }

  private String myFormatStr(String str, int length)
  {
    String temp ="";
    for(int i = 0; i<(length-str.length());i++)
    {
      temp=" "+temp;
    }
    return temp+str;
  }

  private String replaceFullStop(String str)
  {
    VarStr v = new VarStr(str);
    v.replace(".",",");
    return v.toString();
  }

  public void makeReport()
  {
    fill();
    super.makeReport();
  }
}
