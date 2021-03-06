/****license*****************************************************************
**   file: raIzlazPnPDetail.java
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
package hr.restart.util.reports;

import hr.restart.sisfun.frmParam;

public class raIzlazPnPDetail extends raReportSection {

  private String[] thisProps = new String[] {"", "", "", "", "", "Yes", "Yes", "760"};
  public raReportElement TextRBR;
  private String[] TextRBRProps = new String[] {"RBR", "", "", "", "", "", "", "", "", "", "440", 
     "220", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement TextCART;
  private String[] TextCARTProps = new String[] {"CART", "", "", "", "", "", "", "", "480", "", "", 
     "220", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Text1;
  private String[] Text1Props = new String[] {"=(if (= [ImaPor2] 1) (put-var \"tpor2\" 1) \"\")", 
     "", "", "", "No", "", "", "", "2640", "", "0", "0", "", "", "", "", "", "", "Arial", "9", "", 
     "", "", "", ""};
  public raReportElement TextKOL;
  private String[] TextKOLProps = new String[] {"KOL", "", "", 
     "Number|false|1|309|3|3|true|3|false", "", "", "", "", "5500", "", "960", "220", "", "", "", 
     "", "", "", "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Text2;
  private String[] Text2Props = new String[] {"=(if (= [ImaPor3] 1) (put-var \"tpor3\" 1) \"\")", 
     "", "", "", "No", "", "", "", "3120", "", "0", "0", "", "", "", "", "", "", "Arial", "9", "", 
     "", "", "", ""};
  public raReportElement TextJM;
  private String[] TextJMProps = new String[] {"JM", "", "", "", "", "", "", "", "6480", "", "460", 
     "220", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "", "No"};
  public raReportElement Text3;
  private String[] Text3Props = new String[] {"=(if (= [ImaPor1] 1) (put-var \"tpor1\" 1) \"\")", 
     "", "", "", "No", "", "", "", "2300", "", "0", "0", "", "", "", "", "", "", "", "", "", "", "", 
     "", ""};
  public raReportElement TextNAZART;
  private String[] TextNAZARTProps = new String[] {"NAZART", "", "", "", "", "", "Yes", "", "1940", 
     "", "3540", "420", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "", ""};
  public raReportElement TextNAZARText;
  private String[] TextNAZARTextProps = new String[] {"NAZARText", "", "", "", "", "", "Yes", "", "1940", 
     "440", "7440", "0", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "", ""};
  public raReportElement TextFC;
  private String[] TextFCProps = new String[] {"FC", "", "", "Number|false|1|309|2|2|true|3|false", 
     "", "", "", "", "6960", "", "1220", "220", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement TextPor1p2p3Naz;
  private String[] TextPor1p2p3NazProps = new String[] {"Por1p2p3Naz", "", "", 
     "Number|false|1|3|2|2|true|3|false", "", "", "", "", "8200", "", "1200", "220", "", "", "", "", 
     "", "", "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement TextINETO;
  private String[] TextINETOProps = new String[] {"INETOP", "", "", 
     "Number|false|1|309|2|2|true|3|false", "", "", "", "", "9420", "", "1400", "220", "", "", "", 
     "", "", "", "Lucida Bright", "8", "", "", "", "Right", ""};
  public raReportElement TextKOLPAK;
  private String[] TextKOLPAKProps = new String[] {"KOLPAK", "", "", 
     "Number|false|1|309|3|3|true|3|false", "", "", "", "Yes", "5500", "220", "960", "220", "", "", 
     "", "", "", "", "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement TextJMPAK;
  private String[] TextJMPAKProps = new String[] {"JMPAK", "", "", "", "", "", "", "Yes", "6480", 
     "220", "460", "220", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "", "No"};
  public raReportElement TextSTRANASIFRA;
  private String[] TextSTRANASIFRAProps = new String[] {"STRANASIFRA", "", "", "", "", "", "Yes", 
     "Yes", "480", "220", "", "220", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", 
     "Right", "No"};
  public raReportElement TextVTRABPOSTO;
  private String[] TextVTRABPOSTOProps = new String[] {"VTRABPOSTO", "", "", 
     "Number|false|1|309|2|2|true|3|false", "", "", "Yes", "Yes", "6960", "420", "1220", "220", "", "", 
     "", "", "", "", "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement TextVTRABIRAB;
  private String[] TextVTRABIRABProps = new String[] {"VTRABIRAB", "", "", 
     "Number|false|1|3|2|2|true|3|false", "", "", "Yes", "Yes", "8200", "420", "1200", "220", "", "", 
     "", "", "", "", "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement TextVTRABNAZRAB;
  private String[] TextVTRABNAZRABProps = new String[] {"VTRABNAZRAB", "", "", "", "", "", "Yes", 
     "Yes", "1940", "420", "3540", "220", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", 
     "", "No"};

  public raIzlazPnPDetail(raReportTemplate owner) {
    super(owner.template.getModel(raElixirProperties.DETAIL));
    this.setDefaults(thisProps);

    addElements();

    addReportModifier(new ReportModifier() {
      public void modify() {
        modifyThis();
      }
    });
  }

  private void addElements() {
    TextRBR = addModel(ep.TEXT, TextRBRProps);
    TextCART = addModel(ep.TEXT, TextCARTProps);
    Text1 = addModel(ep.TEXT, Text1Props);
    TextKOL = addModel(ep.TEXT, TextKOLProps);
    Text2 = addModel(ep.TEXT, Text2Props);
    TextJM = addModel(ep.TEXT, TextJMProps);
    Text3 = addModel(ep.TEXT, Text3Props);
    TextNAZART = addModel(ep.TEXT, TextNAZARTProps);
    TextFC = addModel(ep.TEXT, TextFCProps);
    TextPor1p2p3Naz = addModel(ep.TEXT, TextPor1p2p3NazProps);
    TextINETO = addModel(ep.TEXT, TextINETOProps);
    TextKOLPAK = addModel(ep.TEXT, TextKOLPAKProps);
    TextJMPAK = addModel(ep.TEXT, TextJMPAKProps);
    TextSTRANASIFRA = addModel(ep.TEXT, TextSTRANASIFRAProps);
    TextVTRABPOSTO = addModel(ep.TEXT, TextVTRABPOSTOProps);
    TextVTRABIRAB = addModel(ep.TEXT, TextVTRABIRABProps);
    TextVTRABNAZRAB = addModel(ep.TEXT, TextVTRABNAZRABProps);
    TextNAZARText = addModel(ep.TEXT, TextNAZARTextProps);
  }

  private void modifyThis() {
    boolean wide = frmParam.getParam("robno", "extNazartWide", "N", 
      "�iroki dodatni opis artikla (D,N)?").equalsIgnoreCase("D");
    if (!wide) TextNAZARText.setWidth(TextNAZART.getWidth());
  }
}
