/****license*****************************************************************
**   file: repNarDobTemplate.java
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

import hr.restart.sisfun.frmParam;
import hr.restart.util.reports.raIzlazSectionFooterForCustom;
import hr.restart.util.reports.raIzlazSectionFooterForCustomSlovima;
import hr.restart.util.reports.raPonDetail;
import hr.restart.util.reports.raPonSectionHeader1;
import hr.restart.util.reports.raRPSectionHeader;
import hr.restart.util.reports.raReportElement;
import hr.restart.util.reports.raReportSection;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class repNarDobTemplate extends repIzlazOrigTemplate {
  public raReportSection createSectionHeader0() {
    raRPSectionHeader sh = new raRPSectionHeader(this);
    sh.LabelRACUNOTPREMNICA.setDefault(ep.CAPTION, "\nNARUD�BENICA");

    sh.defaultAltererSect().getView(sh.LabelMjesto, sh.TextNAZFRA).
        deleteElementsPushDown(sh, new raReportElement[]
        {sh.LabelNarudzba, sh.TextBRNARIZ, sh.TextSgetDATNARIZ,
        /*sh.LabelParitet, sh.TextNAZFRA*/});

    sh.LabelR1.defaultAlterer().setVisible(false);
    sh.LabelObrazac.defaultAlterer().setVisible(false);
    sh.LabelDospijece.defaultAlterer().setCaption("Rok izvr�enja");
    
    sh.LabelParitet.defaultAlterer().setCaption("Mjesto tro�ka");
    sh.TextNAZFRA.defaultAlterer().setControlSource("CSNS");

    if (frmParam.getParam("robno", "narNatemelju", "D", 
        "Ispis linije 'na temelju' na narud�bi za dobavlja�a (D,N)?").equalsIgnoreCase("D"))
      sh.addModel(ep.TEXT, new String[] {
          "NATEM", "", "", "", "", "", "", "", "20",
          "2600", "10500", "220", "", "", "", "", "", "", "Lucida Bright", "8",
          "", "", "", "", ""
      });
    return sh;
  }
  public raReportSection createSectionFooter1() {
    raIzlazSectionFooterForCustomSlovima sh = new raIzlazSectionFooterForCustomSlovima(this);
    sh.Text1.defaultAlterer().setControlSource("=(dsum \"INABreal\")");
    return sh;
  }
  public raReportSection createDetail() {
    raPonDetail sh = new raPonDetail(this);
//    sh.TextZC.defaultAlterer().setControlSource("NC");
//    sh.TextIRAZ.defaultAlterer().setControlSource("INAB");
//    sh.resizeElement(sh.TextCART, 1400, sh.TextNAZART);
    return sh;
  }
  public raReportSection createSectionHeader1() {
    raPonSectionHeader1 sh = new raPonSectionHeader1(this);
//    sh.LabelSifra.defaultAlterer().setCaption("�ifraa");
//    sh.resizeElement(sh.LabelSifra, 1400, sh.LabelNaziv_artikla);
    return sh;
  }
  
  public raReportSection createSectionFooter0() {
    /*raIzlazSectionFooterForCustom isf0 = new raIzlazSectionFooterForCustom(this);
    isf0.TextNAPOMENAOPIS.defaultAlterer().setControlSource("NAZNAP");
    return isf0;*/    
    return new raIzlazSectionFooterForCustom(this);
  }
}

