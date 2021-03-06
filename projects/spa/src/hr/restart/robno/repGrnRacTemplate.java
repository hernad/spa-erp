/****license*****************************************************************
**   file: repGrnRacTemplate.java
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

import hr.restart.util.reports.raGRNSectionHeader0;
import hr.restart.util.reports.raGRSectionFooterLines;
import hr.restart.util.reports.raGRSectionFooterMCLines;
import hr.restart.util.reports.raGRSectionHeaderWin;
import hr.restart.util.reports.raIzlazDetail;
import hr.restart.util.reports.raIzlazDetailMC;
import hr.restart.util.reports.raIzlazSectionHeaderLines;
import hr.restart.util.reports.raReportSection;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class repGrnRacTemplate extends repIzlazOrigTemplate {

//   raGRNSectionHeader0 sh;
  //raIzlazDetail rid;
  
  raGRSectionHeaderWin sh;
  raIzlazDetailMC ridmc;
  
  public raReportSection createSectionHeader0() {
    sh = new raGRSectionHeaderWin(this);
    return sh;
  }

//  public raReportSection createSectionHeader0() {
//    sh = new raGRSectionHeaderWin(this);
//    sh.LabelRACUNOTPREMNICA.defaultAlterer().setCaption("\nR A � U N");
//    raGRNSectionHeader0 sh = new raGRNSectionHeader0(this);
//    sh.TextTEL.setDefault(ep.CONTROL_SOURCE, "TELKUPCA");
//    sh.TextMJKUPCA.setDefault(ep.CONTROL_SOURCE, "PbrMjestoKupca");
//    sh.TextCPAR.setDefault(ep.CONTROL_SOURCE,"CKUPAC");
//    sh.TextCPAR.setDefault(ep.CONTROL_SOURCE, "=(if (> [CKUPAC] 0) [CKUPAC] \"\")");
//    sh.TextTEL.defaultAlterer().setVisible(false);
    /*if (hr.restart.sisfun.frmParam.getParam("robno","ispisTELFAX_Par","N","Ispis Telefona i faxa partnera na ROT-u u polju za adresu").
        equalsIgnoreCase("N")) {
      sh.TextTEL.defaultAlterer().setVisible(false);
//      sh.TextFAX.defaultAlterer().setVisible(false);
    }*/
    
//    return sh;
//    return new raGRNSectionHeader0(this);//sh;
//  }

  public raReportSection createSectionHeader1() {
    return new raIzlazSectionHeaderLines(this); // return new raIzlazSectionHeader(this);
  }

  public raReportSection createDetail() {
    if (hr.restart.sisfun.frmParam.getParam("robno", "GOTcijena", "VC").equalsIgnoreCase("MC")){
//    System.out.println("\n\n\nMALOPRODAJA\n\n\n");
      ridmc = new raIzlazDetailMC(this);
//    ridmc.TextIZNOSSTAVKESP.defaultAlterer().setControlSource("IPRODSP");
      ridmc.TextIZNOSSTAVKESP.defaultAlterer().setControlSource("IZNFMCPRP");
      return ridmc;
    }
    return new raIzlazDetail(this);
  }

//  public raReportSection createSectionFooter0() {
//    return new raIzlazSectionFooterLines(this); // return new raIzlazSectionFooter(this);
//  }

  public repGrnRacTemplate() {
    this.ReportTemplate.setDefault(ep.RECORD_SOURCE, "JDOrepGrnRac");
//    this.addReportModifier(new ReportModifier(){
//      public void modify(){
//        System.out.println("reportsQuerysCollector.getRQCModule().getQueryDataSet().getInt(\"CKUPAC\") = "+reportsQuerysCollector.getRQCModule().getQueryDataSet().getInt("CKUPAC"));
//        if (reportsQuerysCollector.getRQCModule().getQueryDataSet().getInt("CKUPAC") == 0){
//          System.out.println("ukidam R-1");
//          sh.LabelObrazac.setCaption("");
//          sh.LabelR1.setCaption("");
//        } else {
//          sh.LabelR1.setCaption("R-1");
//        }
//      }
//    });
//    this.ReportTemplate.setDefault(ep.RECORD_SOURCE, "JDOrepGrnRac");
  }


  raGRSectionFooterMCLines rgsfml;

  public raReportSection createSectionFooter1() {
    if (hr.restart.sisfun.frmParam.getParam("robno", "GOTcijena", "VC").equalsIgnoreCase("MC")){
      rgsfml = new raGRSectionFooterMCLines(this); // return new raGRSectionFooterMC(this);
      rgsfml.Text1.defaultAlterer().setControlSource("=(dsum \"IZNFMCPRP\")");

//      rgsfml.Text1.defaultAlterer().setControlSource("=(dsum \"ISP\")"); // bug tomo zakomentao
//=(dsum \"IPRODSP\")(+ (dsum \"IPRODBP\") (+ (+ (dsum \"POR1\") (dsum \"POR2\")) (dsum \"POR3\")))
      rgsfml.Text2.defaultAlterer().setControlSource
//      ("=(-(+ (dsum \"IPRODBP\") (+ (+ (dsum \"POR1\") (dsum \"POR2\")) (dsum \"POR3\")) (- (dsum \"ISP\"))))");
      ("=(- (dsum \"IZNFMCPRP\") (+ (dsum \"IPRODBP\") (+ (+ (dsum \"POR1\") (dsum \"POR2\")) (dsum \"POR3\"))))");
      return rgsfml;
    }
    return new raGRSectionFooterLines(this);
  }

}
