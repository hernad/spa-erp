/****license*****************************************************************
**   file: repBBprpsNameWideOrigTemplate.java
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
package hr.restart.gk;

import hr.restart.util.reports.raElixirProperties;
import hr.restart.util.reports.raElixirPropertiesInstance;
import hr.restart.util.reports.raReportElement;
import hr.restart.util.reports.raReportSection;
import hr.restart.util.reports.raReportTemplate;
import sg.com.elixir.reportwriter.xml.ModelFactory;

public abstract class repBBprpsNameWideOrigTemplate extends raReportTemplate {
  public raElixirProperties ep = raElixirPropertiesInstance.get();

  public raReportSection ReportTemplate;
  private String[] ReportTemplateProps = new String[] {"Report Template", "", "JDOrepBrutoBilanca", 
     "", "", "15580", "", "", "", "", "1.50"};
  public raReportSection PageSetup;
  private String[] PageSetupProps = new String[] {"340", "567.0", "560", "567.0", "Landscape", "", 
     "11880", "16820", "", "", "0.0", "0.0", ""};
  public raReportSection Sections;
  public raReportElement Section0;
  private String[] Section0Props = new String[] {"FirstLine", "", "Yes", "Yes", "", "", ""};
  public raReportElement Section1;
  private String[] Section1Props = new String[] {"Grouper", "", "Yes", "Yes", "", "", ""};
  public raReportElement Section2;
  private String[] Section2Props = new String[] {"KLASE", "", "Yes", "Yes", "", "", ""};
  public raReportElement Section3;
  private String[] Section3Props = new String[] {"KLASE2", "", "Yes", "Yes", "", "", ""};
  public raReportElement Section4;
  private String[] Section4Props = new String[] {"KLASE3", "", "Yes", "Yes", "", "", ""};
  public raReportElement Section5;
  private String[] Section5Props = new String[] {"BROJKONTA", "", "", "", "", "", ""};
  public raReportSection ReportHeader;
  public raReportSection PageHeader;
  public raReportSection SectionHeader0;
  private String[] SectionHeader0Props = new String[] {"FirstLine", "Before", "", "", "Yes", "", 
     "Yes", "", "2360"};
  public raReportElement TextFirstLine;
  private String[] TextFirstLineProps = new String[] {"FirstLine", "", "", "", "", "", "", "", "60", 
     "", "5660", "220", "", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "", ""};
  public raReportElement TextSecondLine;
  private String[] TextSecondLineProps = new String[] {"SecondLine", "", "", "", "", "", "", "", 
     "60", "220", "5660", "220", "", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "", 
     ""};
  public raReportElement TextDatumIsp;
  private String[] TextDatumIspProps = new String[] {"DatumIsp", "", "", "", "", "", "", "", 
     "14600", "320", "1080", "220", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", 
     "Right", ""};
  public raReportElement LabelDatum_ispisa_;
  private String[] LabelDatum_ispisa_Props = new String[] {"Datum ispisa :", "", "12780", "320", 
     "1820", "220", "", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Right"};
  public raReportElement TextThirdLine;
  private String[] TextThirdLineProps = new String[] {"ThirdLine", "", "", "", "", "", "", "", "60", 
     "440", "5660", "220", "", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "", ""};
  public raReportElement LabelBRUTO_BILANCA;
  private String[] LabelBRUTO_BILANCAProps = new String[] {"\nBRUTO BILANCA", "", "", "420", 
     "15680", "700", "", "", "", "", "", "", "Lucida Bright", "14", "Bold", "", "", "Center"};
  public raReportElement TextZaPeriod;
  private String[] TextZaPeriodProps = new String[] {"ZaPeriod", "", "", "", "", "", "", "", "", 
     "1100", "15680", "280", "", "", "", "", "", "", "Lucida Bright", "11", "Bold", "", "", 
     "Center", ""};
  public raReportElement TextNAZORGLAVA;
  private String[] TextNAZORGLAVAProps = new String[] {"NAZORGLAVA", "", "", "", "", "", "", "", 
     "3200", "1500", "7540", "240", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "", 
     ""};
  public raReportElement TextCORGLAVA;
  private String[] TextCORGLAVAProps = new String[] {"CORGLAVA", "", "", "", "", "", "", "", "2340", 
     "1500", "840", "240", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "Right", ""};
  public raReportElement LabelOrganizacijska_jedinica;
  private String[] LabelOrganizacijska_jedinicaProps = new String[] {"Organizacijska jedinica", "", 
     "", "1500", "2320", "240", "", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", 
     "Right"};
  public raReportElement TextVRBIL;
  private String[] TextVRBILProps = new String[] {"VRBIL", "", "", "", "", "", "Yes", "", "2340", 
     "1780", "8400", "240", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "", ""};
  public raReportElement LabelVrsta_bilance;
  private String[] LabelVrsta_bilanceProps = new String[] {"Vrsta bilance", "", "", "1780", "2320", 
     "220", "", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Right"};
  public raReportElement TextNAZVAL;
  private String[] TextNAZVALProps = new String[] {"NAZVAL", "", "", "", "", "", "", "", "3200", 
     "2040", "2320", "220", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "", ""};
  public raReportElement TextCVAL;
  private String[] TextCVALProps = new String[] {"CVAL", "", "", "", "", "", "", "", "2340", "2040", 
     "840", "220", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "Right", ""};
  public raReportElement TextTECAJ;
  private String[] TextTECAJProps = new String[] {"TECAJ", "", "", "", "", "", "", "", "6520", 
     "2040", "2320", "220", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "", ""};
  public raReportElement LabelTecaj;
  private String[] LabelTecajProps = new String[] {"Te\u010Daj", "", "5680", "2040", "780", "220", 
     "", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Right"};
  public raReportElement LabelValuta;
  private String[] LabelValutaProps = new String[] {"Valuta", "", "", "2040", "2320", "220", "", "", 
     "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Right"};
  public raReportSection SectionHeader1;
  private String[] SectionHeader1Props = new String[] {"Grouper", "", "", "", "Yes", "Yes", "Yes", 
     "Yes", "680"};
  
//  public raReportElement TextCORG;
//  private String[] TextCORGProps = new String[] {"CORG", "", "", "", "", "", "", "", "2340", "60", 
//      "840", "220", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "Right", ""};
//  public raReportElement LabelOrganizacijska_jedinica1;
//  private String[] LabelOrganizacijska_jedinica1Props = new String[] {"Organizacijska jedinica", "", 
//     "", "60", "2320", "220", "", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Right"};
//  public raReportElement TextNAZORG;
//  private String[] TextNAZORGProps = new String[] {"NAZORG", "", "", "", "", "", "", "", "3200", 
//      "60", "4520", "220", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "", ""};
  
  public raReportElement TextCORG;
  private String[] TextCORGProps = new String[] {"CORG", "", "", "", "", "", "", "", "2340", "", 
     "840", "220", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "Right", ""};
  public raReportElement TextNAZORG;
  private String[] TextNAZORGProps = new String[] {"NAZORG", "", "", "", "", "", "", "", "3200", "", 
     "4520", "220", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "", ""};
  public raReportElement TextOJGR;
  private String[] TextOJGRProps = new String[] {"OJGR", "", "", "", "", "", "", "", "", "20", 
     "2320", "220", "", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Right", ""};
  
  public raReportElement Line1;
  private String[] Line1Props = new String[] {"", "", "", "300", "15640", "0", "", "", ""};
  public raReportElement LabelBroj_konta;
  private String[] LabelBroj_kontaProps = new String[] {"Broj konta", "", "", "340", "1220", "240", 
     "Normal", "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement LabelUkupno_potrazuje_PS;
  private String[] LabelUkupno_potrazuje_PSProps = new String[] {"Ukupno potražuje (PS)", "", 
     "11040", "340", "2300", "240", "Normal", "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", 
     "", "", "Center"};
  public raReportElement LabelNaziv_konta;
  private String[] LabelNaziv_kontaProps = new String[] {"Naziv konta", "", "1240", "340", "7460", 
     "240", "Normal", "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement LabelSaldo_PS;
  private String[] LabelSaldo_PSProps = new String[] {"Saldo (PS)", "", "13360", "340", "2300", 
     "240", "Normal", "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement LabelUkupno_duguje_PS;
  private String[] LabelUkupno_duguje_PSProps = new String[] {"Ukupno duguje (PS)", "", "8720", 
     "340", "2300", "240", "Normal", "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", 
     "Center"};
  public raReportElement Line2;
  private String[] Line2Props = new String[] {"", "", "", "600", "15640", "0", "", "", ""};
  public raReportSection SectionHeader2;
  private String[] SectionHeader2Props = new String[] {"KLASE", "", "", "", "Yes", "", "Yes", "", 
     "880"};
  public raReportElement TextRKLASE;
  private String[] TextRKLASEProps = new String[] {"RKLASE", "", "", "Number|true|#.##0,00", "", "", 
     "", "", "", "40", "1220", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "", 
     ""};
  public raReportElement TextNAZIVKLASE;
  private String[] TextNAZIVKLASEProps = new String[] {"NAZIVKLASE", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "1240", "40", "7460", "420", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "", ""};
  public raReportElement Text1;
  private String[] Text1Props = new String[] {"=(dsum \"SALPS\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "13360", "40", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text2;
  private String[] Text2Props = new String[] {"=(dsum \"PSID\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "8720", "40", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text3;
  private String[] Text3Props = new String[] {"=(dsum \"PSIP\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "11040", "40", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text4;
  private String[] Text4Props = new String[] {"=(dsum \"ID\")", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "8720", "240", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", 
     "", "Right", "No"};
  public raReportElement LabelPromet;
  private String[] LabelPrometProps = new String[] {"Promet:", "", "", "240", "1220", "200", 
     "Normal", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Text5;
  private String[] Text5Props = new String[] {"=(dsum \"IP\")", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "11040", "240", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text6;
  private String[] Text6Props = new String[] {"=(dsum \"SALPROM\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "13360", "240", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", 
     "", "", "", "Right", "No"};
  public raReportElement Line3;
  private String[] Line3Props = new String[] {"", "", "", "460", "15640", "0", "", "", ""};
  public raReportElement Label1;
  private String[] Label1Props = new String[] {"", "", "13360", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label2;
  private String[] Label2Props = new String[] {"", "", "11040", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label3;
  private String[] Label3Props = new String[] {"", "", "8720", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label4;
  private String[] Label4Props = new String[] {"", "", "", "500", "8700", "240", "Normal", "Gray", 
     "", "", "", "", "", "", "", "", "", ""};
  public raReportElement LabelUkupno;
  private String[] LabelUkupnoProps = new String[] {"Ukupno:", "", "", "500", "1220", "240", "", "", 
     "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Text7;
  private String[] Text7Props = new String[] {"=(dsum \"SALDO\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "13360", "500", "2300", "240", "", "", "", "", "", "", "Lucida Bright", "8", 
     "", "", "", "Right", "No"};
  public raReportElement Text8;
  private String[] Text8Props = new String[] {"=(dsum \"IPALL\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "11040", "500", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Text9;
  private String[] Text9Props = new String[] {"=(dsum \"IDALL\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "8720", "500", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Line4;
  private String[] Line4Props = new String[] {"", "", "", "760", "15640", "0", "", "", ""};
  public raReportSection SectionHeader3;
  private String[] SectionHeader3Props = new String[] {"KLASE2", "", "", "", "Yes", "", "Yes", "", 
     "880"};
  public raReportElement TextKLASE2;
  private String[] TextKLASE2Props = new String[] {"KLASE2", "", "", "Number|true|#.##0,00", "", "", 
     "", "", "", "40", "1220", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "", 
     ""};
  public raReportElement TextNAZIVKLASE2;
  private String[] TextNAZIVKLASE2Props = new String[] {"NAZIVKLASE2", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "1240", "40", "7460", "420", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "", ""};
  public raReportElement Text10;
  private String[] Text10Props = new String[] {"=(dsum \"SALPS\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "13360", "40", "2300", "200", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Text11;
  private String[] Text11Props = new String[] {"=(dsum \"PSID\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "8720", "40", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text12;
  private String[] Text12Props = new String[] {"=(dsum \"PSIP\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "11040", "40", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text13;
  private String[] Text13Props = new String[] {"=(dsum \"IP\")", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "11040", "240", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text14;
  private String[] Text14Props = new String[] {"=(dsum \"SALPROM\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "13360", "240", "2300", "200", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement LabelPromet1;
  private String[] LabelPromet1Props = new String[] {"Promet:", "", "", "240", "1220", "200", 
     "Normal", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Text15;
  private String[] Text15Props = new String[] {"=(dsum \"ID\")", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "8720", "240", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", 
     "", "Right", "No"};
  public raReportElement Line5;
  private String[] Line5Props = new String[] {"", "", "", "460", "15640", "0", "", "", ""};
  public raReportElement Text16;
  private String[] Text16Props = new String[] {"=(dsum \"SALDO\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "13360", "500", "2300", "240", "", "", "", "", "", "", "Lucida Bright", "8", 
     "", "", "", "Right", "No"};
  public raReportElement Text17;
  private String[] Text17Props = new String[] {"=(dsum \"IPALL\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "11040", "500", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Text18;
  private String[] Text18Props = new String[] {"=(dsum \"IDALL\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "8720", "500", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Label5;
  private String[] Label5Props = new String[] {"", "", "8720", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label6;
  private String[] Label6Props = new String[] {"", "", "11040", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label7;
  private String[] Label7Props = new String[] {"", "", "13360", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label8;
  private String[] Label8Props = new String[] {"", "", "", "500", "8700", "240", "Normal", "Gray", 
     "", "", "", "", "", "", "", "", "", ""};
  public raReportElement LabelUkupno1;
  private String[] LabelUkupno1Props = new String[] {"Ukupno:", "", "", "500", "1220", "240", "", 
     "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Line6;
  private String[] Line6Props = new String[] {"", "", "", "760", "15640", "0", "", "", ""};
  public raReportSection SectionHeader4;
  private String[] SectionHeader4Props = new String[] {"KLASE3", "", "", "", "Yes", "", "Yes", "", 
     "840"};
  public raReportElement TextNAZIVKLASE3;
  private String[] TextNAZIVKLASE3Props = new String[] {"NAZIVKLASE3", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "1240", "40", "7460", "420", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "", ""};
  public raReportElement Text19;
  private String[] Text19Props = new String[] {"=(dsum \"SALPS\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "13360", "40", "2300", "200", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Text20;
  private String[] Text20Props = new String[] {"=(dsum \"PSID\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "8720", "40", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text21;
  private String[] Text21Props = new String[] {"=(dsum \"PSIP\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "11040", "40", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement TextKLASE3;
  private String[] TextKLASE3Props = new String[] {"KLASE3", "", "", "Number|true|#.##0,00", "", "", 
     "", "", "", "40", "1220", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "", 
     ""};
  public raReportElement LabelPromet2;
  private String[] LabelPromet2Props = new String[] {"Promet:", "", "", "240", "1220", "200", 
     "Normal", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Text22;
  private String[] Text22Props = new String[] {"=(dsum \"ID\")", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "8720", "240", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", 
     "", "Right", "No"};
  public raReportElement Text23;
  private String[] Text23Props = new String[] {"=(dsum \"IP\")", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "11040", "240", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text24;
  private String[] Text24Props = new String[] {"=(dsum \"SALPROM\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "13360", "240", "2300", "200", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Line7;
  private String[] Line7Props = new String[] {"", "", "", "460", "15640", "0", "", "", ""};
  public raReportElement Label9;
  private String[] Label9Props = new String[] {"", "", "13360", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement LabelUkupno2;
  private String[] LabelUkupno2Props = new String[] {"Ukupno:", "", "", "500", "1220", "240", "", 
     "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Text25;
  private String[] Text25Props = new String[] {"=(dsum \"SALDO\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "13360", "500", "2300", "240", "", "", "", "", "", "", "Lucida Bright", "8", 
     "", "", "", "Right", "No"};
  public raReportElement Text26;
  private String[] Text26Props = new String[] {"=(dsum \"IPALL\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "11040", "500", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Text27;
  private String[] Text27Props = new String[] {"=(dsum \"IDALL\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "8720", "500", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Label10;
  private String[] Label10Props = new String[] {"", "", "", "500", "8700", "240", "Normal", "Gray", 
     "", "", "", "", "", "", "", "", "", ""};
  public raReportElement Label11;
  private String[] Label11Props = new String[] {"", "", "8720", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label12;
  private String[] Label12Props = new String[] {"", "", "11040", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Line8;
  private String[] Line8Props = new String[] {"", "", "", "760", "15640", "0", "", "", ""};
  public raReportSection Detail;
  private String[] DetailProps = new String[] {"", "", "", "", "", "", "", "860"};
  public raReportElement TextNAZIVKONTA;
  private String[] TextNAZIVKONTAProps = new String[] {"NAZIVKONTA", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "1240", "40", "7460", "420", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "", ""};
  public raReportElement TextSALPS;
  private String[] TextSALPSProps = new String[] {"SALPS", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "13360", "40", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", 
     "", "Right", "No"};
  public raReportElement TextPSID;
  private String[] TextPSIDProps = new String[] {"PSID", "", "", "Number|true|#.##0,00", "", "", "", 
     "", "8720", "40", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", 
     "Right", "No"};
  public raReportElement TextPSIP;
  private String[] TextPSIPProps = new String[] {"PSIP", "", "", "Number|true|#.##0,00", "", "", "", 
     "", "11040", "40", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", 
     "Right", "No"};
  public raReportElement TextBROJKONTA;
  private String[] TextBROJKONTAProps = new String[] {"BROJKONTA", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "", "40", "1220", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", 
     "", "", ""};
  public raReportElement TextID;
  private String[] TextIDProps = new String[] {"ID", "", "", "Number|true|#.##0,00", "", "", "", "", 
     "8720", "240", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", 
     "Right", "No"};
  public raReportElement TextIP;
  private String[] TextIPProps = new String[] {"IP", "", "", "Number|true|#.##0,00", "", "", "", "", 
     "11040", "240", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", 
     "Right", "No"};
  public raReportElement TextSALPROM;
  private String[] TextSALPROMProps = new String[] {"SALPROM", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "13360", "240", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement LabelPromet3;
  private String[] LabelPromet3Props = new String[] {"Promet:", "", "", "240", "1220", "200", 
     "Normal", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Line9;
  private String[] Line9Props = new String[] {"", "", "", "460", "15640", "0", "", "", ""};
  public raReportElement Label13;
  private String[] Label13Props = new String[] {"", "", "8720", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label14;
  private String[] Label14Props = new String[] {"", "", "13360", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label15;
  private String[] Label15Props = new String[] {"", "", "11040", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label16;
  private String[] Label16Props = new String[] {"", "", "", "500", "8700", "240", "Normal", "Gray", 
     "", "", "", "", "", "", "", "", "", ""};
  public raReportElement LabelUkupno3;
  private String[] LabelUkupno3Props = new String[] {"Ukupno:", "", "", "500", "1220", "240", "", 
     "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement TextIDALL;
  private String[] TextIDALLProps = new String[] {"IDALL", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "8720", "500", "2300", "240", "", "", "", "", "", "", "Lucida Bright", "8", "", "", 
     "", "Right", "No"};
  public raReportElement TextIPALL;
  private String[] TextIPALLProps = new String[] {"IPALL", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "11040", "500", "2300", "240", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement TextSALDO;
  private String[] TextSALDOProps = new String[] {"SALDO", "", "", "Number|true|#.##0,00", "", "", 
     "", "", "13360", "500", "2300", "240", "", "", "", "", "", "", "Lucida Bright", "8", "", "", 
     "", "Right", "No"};
  public raReportElement Line10;
  private String[] Line10Props = new String[] {"", "", "", "760", "15640", "0", "", "", ""};
  public raReportSection SectionFooter4;
  private String[] SectionFooter4Props = new String[] {"KLASE3", "", "", "", "Yes", "Yes", "Yes", "900"};
  public raReportElement Text28;
  private String[] Text28Props = new String[] {"=(dsum \"PSIP\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "11040", "40", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text29;
  private String[] Text29Props = new String[] {"=(dsum \"PSID\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "8720", "40", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text30;
  private String[] Text30Props = new String[] {"=(dsum \"SALPS\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "13360", "40", "2300", "200", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement TextNAZIVKLASE31;
  private String[] TextNAZIVKLASE31Props = new String[] {"NAZIVKLASE3", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "1240", "40", "7460", "420", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "", ""};
  public raReportElement TextKLASE31;
  private String[] TextKLASE31Props = new String[] {"KLASE3", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "", "40", "1220", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", 
     "", ""};
  public raReportElement LabelPromet4;
  private String[] LabelPromet4Props = new String[] {"Promet:", "", "", "240", "1220", "200", 
     "Normal", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Text31;
  private String[] Text31Props = new String[] {"=(dsum \"SALPROM\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "13360", "240", "2300", "200", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Text32;
  private String[] Text32Props = new String[] {"=(dsum \"IP\")", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "11040", "240", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text33;
  private String[] Text33Props = new String[] {"=(dsum \"ID\")", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "8720", "240", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", 
     "", "Right", "No"};
  public raReportElement Line11;
  private String[] Line11Props = new String[] {"", "", "", "460", "15640", "0", "", "", ""};
  public raReportElement Label17;
  private String[] Label17Props = new String[] {"", "", "", "500", "8700", "240", "Normal", "Gray", 
     "", "", "", "", "", "", "", "", "", ""};
  public raReportElement Label18;
  private String[] Label18Props = new String[] {"", "", "8720", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label19;
  private String[] Label19Props = new String[] {"", "", "11040", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label20;
  private String[] Label20Props = new String[] {"", "", "13360", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement LabelUkupno4;
  private String[] LabelUkupno4Props = new String[] {"Ukupno:", "", "", "500", "1220", "240", "", 
     "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Text34;
  private String[] Text34Props = new String[] {"=(dsum \"IDALL\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "8720", "500", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Text35;
  private String[] Text35Props = new String[] {"=(dsum \"IPALL\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "11040", "500", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Text36;
  private String[] Text36Props = new String[] {"=(dsum \"SALDO\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "13360", "500", "2300", "240", "", "", "", "", "", "", "Lucida Bright", "8", 
     "", "", "", "Right", "No"};
  public raReportElement Line12;
  private String[] Line12Props = new String[] {"", "", "", "760", "15640", "0", "", "", ""};
  public raReportSection SectionFooter3;
  private String[] SectionFooter3Props = new String[] {"KLASE2", "", "", "", "Yes", "Yes", "Yes", "900"};
  public raReportElement TextKLASE21;
  private String[] TextKLASE21Props = new String[] {"KLASE2", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "", "40", "1220", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", 
     "", ""};
  public raReportElement Text37;
  private String[] Text37Props = new String[] {"=(dsum \"PSIP\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "11040", "40", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text38;
  private String[] Text38Props = new String[] {"=(dsum \"PSID\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "8720", "40", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text39;
  private String[] Text39Props = new String[] {"=(dsum \"SALPS\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "13360", "40", "2300", "200", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement TextNAZIVKLASE21;
  private String[] TextNAZIVKLASE21Props = new String[] {"NAZIVKLASE2", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "1240", "40", "7460", "420", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "", ""};
  public raReportElement LabelPromet5;
  private String[] LabelPromet5Props = new String[] {"Promet:", "", "", "240", "1220", "200", 
     "Normal", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Text40;
  private String[] Text40Props = new String[] {"=(dsum \"SALPROM\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "13360", "240", "2300", "200", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Text41;
  private String[] Text41Props = new String[] {"=(dsum \"IP\")", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "11040", "240", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text42;
  private String[] Text42Props = new String[] {"=(dsum \"ID\")", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "8720", "240", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", 
     "", "Right", "No"};
  public raReportElement Line13;
  private String[] Line13Props = new String[] {"", "", "", "460", "15640", "0", "", "", ""};
  public raReportElement LabelUkupno5;
  private String[] LabelUkupno5Props = new String[] {"Ukupno:", "", "", "500", "1220", "240", "", 
     "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Text43;
  private String[] Text43Props = new String[] {"=(dsum \"IDALL\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "8720", "500", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Text44;
  private String[] Text44Props = new String[] {"=(dsum \"IPALL\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "11040", "500", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Text45;
  private String[] Text45Props = new String[] {"=(dsum \"SALDO\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "13360", "500", "2300", "240", "", "", "", "", "", "", "Lucida Bright", "8", 
     "", "", "", "Right", "No"};
  public raReportElement Label21;
  private String[] Label21Props = new String[] {"", "", "", "500", "8700", "240", "Normal", "Gray", 
     "", "", "", "", "", "", "", "", "", ""};
  public raReportElement Label22;
  private String[] Label22Props = new String[] {"", "", "8720", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label23;
  private String[] Label23Props = new String[] {"", "", "11040", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label24;
  private String[] Label24Props = new String[] {"", "", "13360", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Line14;
  private String[] Line14Props = new String[] {"", "", "", "760", "15640", "0", "", "", ""};
  public raReportSection SectionFooter2;
  private String[] SectionFooter2Props = new String[] {"KLASE", "", "", "", "Yes", "Yes", "Yes", "900"};
  public raReportElement Text46;
  private String[] Text46Props = new String[] {"=(dsum \"SALPS\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "13360", "40", "2300", "200", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement TextNAZIVKLASE1;
  private String[] TextNAZIVKLASE1Props = new String[] {"NAZIVKLASE", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "1240", "40", "7460", "420", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "", ""};
  public raReportElement TextRKLASE1;
  private String[] TextRKLASE1Props = new String[] {"RKLASE", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "", "40", "1220", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", 
     "", ""};
  public raReportElement Text47;
  private String[] Text47Props = new String[] {"=(dsum \"PSIP\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "11040", "40", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text48;
  private String[] Text48Props = new String[] {"=(dsum \"PSID\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "8720", "40", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text49;
  private String[] Text49Props = new String[] {"=(dsum \"SALPROM\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "13360", "240", "2300", "200", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Text50;
  private String[] Text50Props = new String[] {"=(dsum \"IP\")", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "11040", "240", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", 
     "", "", "Right", "No"};
  public raReportElement Text51;
  private String[] Text51Props = new String[] {"=(dsum \"ID\")", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "8720", "240", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "", "", 
     "", "Right", "No"};
  public raReportElement LabelPromet6;
  private String[] LabelPromet6Props = new String[] {"Promet:", "", "", "240", "1220", "200", 
     "Normal", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Line15;
  private String[] Line15Props = new String[] {"", "", "", "460", "15640", "0", "", "", ""};
  public raReportElement Label25;
  private String[] Label25Props = new String[] {"", "", "", "500", "8700", "240", "Normal", "Gray", 
     "", "", "", "", "", "", "", "", "", ""};
  public raReportElement Label26;
  private String[] Label26Props = new String[] {"", "", "8720", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Text52;
  private String[] Text52Props = new String[] {"=(dsum \"IDALL\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "8720", "500", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Text53;
  private String[] Text53Props = new String[] {"=(dsum \"IPALL\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "11040", "500", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "", "", "", "Right", "No"};
  public raReportElement Text54;
  private String[] Text54Props = new String[] {"=(dsum \"SALDO\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "13360", "500", "2300", "240", "", "", "", "", "", "", "Lucida Bright", "8", 
     "", "", "", "Right", "No"};
  public raReportElement Label27;
  private String[] Label27Props = new String[] {"", "", "11040", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label28;
  private String[] Label28Props = new String[] {"", "", "13360", "500", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement LabelUkupno6;
  private String[] LabelUkupno6Props = new String[] {"Ukupno:", "", "", "500", "1220", "240", "", 
     "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Line16;
  private String[] Line16Props = new String[] {"", "", "", "760", "15640", "0", "", "", ""};
  public raReportSection SectionFooter1;
  private String[] SectionFooter1Props = new String[] {"Grouper", "", "", "", "Yes", "Yes", "Yes", 
     "900"};
  public raReportElement Text55;
  private String[] Text55Props = new String[] {"=(dsum \"SALPS\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "13360", "80", "2300", "200", "", "", "", "", "", "", 
     "Lucida Bright", "8", "Bold", "", "", "Right", "No"};
  public raReportElement Text56;
  private String[] Text56Props = new String[] {"=(dsum \"PSID\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "8720", "80", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", 
     "Bold", "", "", "Right", "No"};
  public raReportElement Text57;
  private String[] Text57Props = new String[] {"=(dsum \"PSIP\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "11040", "80", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", 
     "Bold", "", "", "Right", "No"};
  public raReportElement LabelRAZREDI_0__9;
  private String[] LabelRAZREDI_0__9Props = new String[] {"RAZREDI 0 - 9", "", "", "80", "1520", 
     "200", "Normal", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Text58;
  private String[] Text58Props = new String[] {"=(dsum \"ID\")", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "8720", "280", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", "Bold", 
     "", "", "Right", "No"};
  public raReportElement Text59;
  private String[] Text59Props = new String[] {"=(dsum \"IP\")", "", "", "Number|true|#.##0,00", "", 
     "", "", "", "11040", "280", "2300", "200", "", "", "", "", "", "", "Lucida Bright", "8", 
     "Bold", "", "", "Right", "No"};
  public raReportElement Text60;
  private String[] Text60Props = new String[] {"=(dsum \"SALPROM\")", "", "", 
     "Number|false|1|309|2|2|true|3|false", "", "", "", "", "13360", "280", "2300", "200", "", "", 
     "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Right", "No"};
  public raReportElement LabelPromet7;
  private String[] LabelPromet7Props = new String[] {"Promet:", "", "", "280", "1220", "200", 
     "Normal", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Line17;
  private String[] Line17Props = new String[] {"", "", "", "500", "15640", "0", "", "", ""};
  public raReportElement Label29;
  private String[] Label29Props = new String[] {"", "", "11040", "540", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label30;
  private String[] Label30Props = new String[] {"", "", "8720", "540", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label31;
  private String[] Label31Props = new String[] {"", "", "", "540", "8700", "240", "Normal", "Gray", 
     "", "", "", "", "", "", "", "", "", ""};
  public raReportElement LabelUkupno7;
  private String[] LabelUkupno7Props = new String[] {"Ukupno:", "", "", "540", "1220", "240", "", 
     "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Label32;
  private String[] Label32Props = new String[] {"", "", "13360", "540", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Text61;
  private String[] Text61Props = new String[] {"=(dsum \"SALDO\")", "", "", "Number|true|#.##0,00", 
     "", "", "", "", "13360", "540", "2300", "240", "", "", "", "", "", "", "Lucida Bright", "8", 
     "Bold", "", "", "Right", "No"};
  public raReportElement Text62;
  private String[] Text62Props = new String[] {"=(dsum \"IPALL\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "11040", "540", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "Bold", "", "", "Right", "No"};
  public raReportElement Text63;
  private String[] Text63Props = new String[] {"=(dsum \"IDALL\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "8720", "540", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "Bold", "", "", "Right", "No"};
  public raReportElement Line18;
  private String[] Line18Props = new String[] {"", "", "", "800", "15640", "0", "", "", ""};
  public raReportSection SectionFooter0;
  private String[] SectionFooter0Props = new String[] {"FirstLine", "", "", "", "Yes", "Yes", "Yes", 
     "520"};
  public raReportElement Line19;
  private String[] Line19Props = new String[] {"", "", "", "80", "15640", "0", "", "", ""};
  public raReportElement Text64;
  private String[] Text64Props = new String[] {"=(dsum \"IDALL\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "8720", "120", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "Bold", "", "", "Right", "No"};
  public raReportElement Text65;
  private String[] Text65Props = new String[] {"=(dsum \"IPALL\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "11040", "120", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "Bold", "", "", "Right", "No"};
  public raReportElement TextKumulativSALDO;
  private String[] TextKumulativSALDOProps = new String[] {"=(dsum \"SALDO\")", "", "", 
     "Number|true|#.##0,00", "", "", "", "", "13360", "120", "2300", "240", "", "", "", "", "", "", 
     "Lucida Bright", "8", "Bold", "", "", "Right", "No"};
  public raReportElement Label33;
  private String[] Label33Props = new String[] {"", "", "", "120", "8700", "240", "Normal", "Gray", 
     "", "", "", "", "", "", "", "", "", ""};
  public raReportElement Label34;
  private String[] Label34Props = new String[] {"", "", "8720", "120", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label35;
  private String[] Label35Props = new String[] {"", "", "11040", "120", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label36;
  private String[] Label36Props = new String[] {"", "", "13360", "120", "2300", "240", "Normal", 
     "Gray", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement LabelSveukupno;
  private String[] LabelSveukupnoProps = new String[] {"Sveukupno:", "", "", "120", "1220", "240", 
     "", "", "", "", "", "", "Lucida Bright", "8", "Bold", "", "", ""};
  public raReportElement Line20;
  private String[] Line20Props = new String[] {"", "", "", "380", "15640", "0", "", "", ""};
  public raReportSection PageFooter;
  private String[] PageFooterProps = new String[] {"", "", "260"};
  public raReportElement Text66;
  private String[] Text66Props = new String[] {
     "=(string-append \"Stranica \" (page) \" od \" (pages))", "", "", "", "", "", "", "", "12960", 
     "", "2700", "240", "", "", "", "", "", "", "Lucida Bright", "8", "", "", "", "Right", ""};
  public raReportSection ReportFooter;

  public repBBprpsNameWideOrigTemplate() {
    createReportStructure();
    setReportProperties();
  }

  public raReportSection createSections() {
    raReportSection sect = new raReportSection(template.getModel(ep.SECTIONS));

    Section0 = sect.getModel(ep.SECTION + 0, Section0Props);
    Section1 = sect.getModel(ep.SECTION + 1, Section1Props);
    Section2 = sect.getModel(ep.SECTION + 2, Section2Props);
    Section3 = sect.getModel(ep.SECTION + 3, Section3Props);
    Section4 = sect.getModel(ep.SECTION + 4, Section4Props);
    Section5 = sect.getModel(ep.SECTION + 5, Section5Props);
    return sect;
  }

  public abstract raReportSection createReportHeader();

  public abstract raReportSection createPageHeader();

  public raReportSection createSectionHeader0() {
    raReportSection sect = new raReportSection(template.getModel(ep.SECTION_HEADER + 0), SectionHeader0Props);

    LabelDatum_ispisa_ = sect.addModel(ep.LABEL, LabelDatum_ispisa_Props);
    LabelBRUTO_BILANCA = sect.addModel(ep.LABEL, LabelBRUTO_BILANCAProps);
    LabelOrganizacijska_jedinica = sect.addModel(ep.LABEL, LabelOrganizacijska_jedinicaProps);
    LabelVrsta_bilance = sect.addModel(ep.LABEL, LabelVrsta_bilanceProps);
    LabelTecaj = sect.addModel(ep.LABEL, LabelTecajProps);
    LabelValuta = sect.addModel(ep.LABEL, LabelValutaProps);
    TextFirstLine = sect.addModel(ep.TEXT, TextFirstLineProps);
    TextSecondLine = sect.addModel(ep.TEXT, TextSecondLineProps);
    TextDatumIsp = sect.addModel(ep.TEXT, TextDatumIspProps);
    TextThirdLine = sect.addModel(ep.TEXT, TextThirdLineProps);
    TextZaPeriod = sect.addModel(ep.TEXT, TextZaPeriodProps);
    TextNAZORGLAVA = sect.addModel(ep.TEXT, TextNAZORGLAVAProps);
    TextCORGLAVA = sect.addModel(ep.TEXT, TextCORGLAVAProps);
    TextVRBIL = sect.addModel(ep.TEXT, TextVRBILProps);
    TextNAZVAL = sect.addModel(ep.TEXT, TextNAZVALProps);
    TextCVAL = sect.addModel(ep.TEXT, TextCVALProps);
    TextTECAJ = sect.addModel(ep.TEXT, TextTECAJProps);
    return sect;
  }

  public raReportSection createSectionHeader1() {
    raReportSection sect = new raReportSection(template.getModel(ep.SECTION_HEADER + 1), SectionHeader1Props);

    TextCORG = sect.addModel(ep.TEXT, TextCORGProps);
    TextNAZORG = sect.addModel(ep.TEXT, TextNAZORGProps);
    TextOJGR = sect.addModel(ep.TEXT, TextOJGRProps);
    LabelBroj_konta = sect.addModel(ep.LABEL, LabelBroj_kontaProps);
    LabelUkupno_potrazuje_PS = sect.addModel(ep.LABEL, LabelUkupno_potrazuje_PSProps);
    LabelNaziv_konta = sect.addModel(ep.LABEL, LabelNaziv_kontaProps);
    LabelSaldo_PS = sect.addModel(ep.LABEL, LabelSaldo_PSProps);
    LabelUkupno_duguje_PS = sect.addModel(ep.LABEL, LabelUkupno_duguje_PSProps);
    Line1 = sect.addModel(ep.LINE, Line1Props);
    Line2 = sect.addModel(ep.LINE, Line2Props);
    return sect;
  }

  public raReportSection createSectionHeader2() {
    raReportSection sect = new raReportSection(template.getModel(ep.SECTION_HEADER + 2), SectionHeader2Props);

    Label1 = sect.addModel(ep.LABEL, Label1Props);
    Label2 = sect.addModel(ep.LABEL, Label2Props);
    Label3 = sect.addModel(ep.LABEL, Label3Props);
    Label4 = sect.addModel(ep.LABEL, Label4Props);
    LabelUkupno = sect.addModel(ep.LABEL, LabelUkupnoProps);
    LabelPromet = sect.addModel(ep.LABEL, LabelPrometProps);
    TextRKLASE = sect.addModel(ep.TEXT, TextRKLASEProps);
    TextNAZIVKLASE = sect.addModel(ep.TEXT, TextNAZIVKLASEProps);
    Text1 = sect.addModel(ep.TEXT, Text1Props);
    Text2 = sect.addModel(ep.TEXT, Text2Props);
    Text3 = sect.addModel(ep.TEXT, Text3Props);
    Text4 = sect.addModel(ep.TEXT, Text4Props);
    Text5 = sect.addModel(ep.TEXT, Text5Props);
    Text6 = sect.addModel(ep.TEXT, Text6Props);
    Line3 = sect.addModel(ep.LINE, Line3Props);
    Text7 = sect.addModel(ep.TEXT, Text7Props);
    Text8 = sect.addModel(ep.TEXT, Text8Props);
    Text9 = sect.addModel(ep.TEXT, Text9Props);
    Line4 = sect.addModel(ep.LINE, Line4Props);
    return sect;
  }

  public raReportSection createSectionHeader3() {
    raReportSection sect = new raReportSection(template.getModel(ep.SECTION_HEADER + 3), SectionHeader3Props);

    Label5 = sect.addModel(ep.LABEL, Label5Props);
    Label6 = sect.addModel(ep.LABEL, Label6Props);
    Label7 = sect.addModel(ep.LABEL, Label7Props);
    Label8 = sect.addModel(ep.LABEL, Label8Props);
    LabelPromet1 = sect.addModel(ep.LABEL, LabelPromet1Props);
    LabelUkupno1 = sect.addModel(ep.LABEL, LabelUkupno1Props);
    TextKLASE2 = sect.addModel(ep.TEXT, TextKLASE2Props);
    TextNAZIVKLASE2 = sect.addModel(ep.TEXT, TextNAZIVKLASE2Props);
    Text10 = sect.addModel(ep.TEXT, Text10Props);
    Text11 = sect.addModel(ep.TEXT, Text11Props);
    Text12 = sect.addModel(ep.TEXT, Text12Props);
    Text13 = sect.addModel(ep.TEXT, Text13Props);
    Text14 = sect.addModel(ep.TEXT, Text14Props);
    Text15 = sect.addModel(ep.TEXT, Text15Props);
    Line5 = sect.addModel(ep.LINE, Line5Props);
    Text16 = sect.addModel(ep.TEXT, Text16Props);
    Text17 = sect.addModel(ep.TEXT, Text17Props);
    Text18 = sect.addModel(ep.TEXT, Text18Props);
    Line6 = sect.addModel(ep.LINE, Line6Props);
    return sect;
  }

  public raReportSection createSectionHeader4() {
    raReportSection sect = new raReportSection(template.getModel(ep.SECTION_HEADER + 4), SectionHeader4Props);

    Label9 = sect.addModel(ep.LABEL, Label9Props);
    Label10 = sect.addModel(ep.LABEL, Label10Props);
    Label11 = sect.addModel(ep.LABEL, Label11Props);
    Label12 = sect.addModel(ep.LABEL, Label12Props);
    LabelUkupno2 = sect.addModel(ep.LABEL, LabelUkupno2Props);
    LabelPromet2 = sect.addModel(ep.LABEL, LabelPromet2Props);
    TextNAZIVKLASE3 = sect.addModel(ep.TEXT, TextNAZIVKLASE3Props);
    Text19 = sect.addModel(ep.TEXT, Text19Props);
    Text20 = sect.addModel(ep.TEXT, Text20Props);
    Text21 = sect.addModel(ep.TEXT, Text21Props);
    TextKLASE3 = sect.addModel(ep.TEXT, TextKLASE3Props);
    Text22 = sect.addModel(ep.TEXT, Text22Props);
    Text23 = sect.addModel(ep.TEXT, Text23Props);
    Text24 = sect.addModel(ep.TEXT, Text24Props);
    Line7 = sect.addModel(ep.LINE, Line7Props);
    Text25 = sect.addModel(ep.TEXT, Text25Props);
    Text26 = sect.addModel(ep.TEXT, Text26Props);
    Text27 = sect.addModel(ep.TEXT, Text27Props);
    Line8 = sect.addModel(ep.LINE, Line8Props);
    return sect;
  }

  public raReportSection createDetail() {
    raReportSection sect = new raReportSection(template.getModel(ep.DETAIL), DetailProps);

    Label13 = sect.addModel(ep.LABEL, Label13Props);
    Label14 = sect.addModel(ep.LABEL, Label14Props);
    Label15 = sect.addModel(ep.LABEL, Label15Props);
    Label16 = sect.addModel(ep.LABEL, Label16Props);
    LabelUkupno3 = sect.addModel(ep.LABEL, LabelUkupno3Props);
    LabelPromet3 = sect.addModel(ep.LABEL, LabelPromet3Props);
    TextNAZIVKONTA = sect.addModel(ep.TEXT, TextNAZIVKONTAProps);
    TextSALPS = sect.addModel(ep.TEXT, TextSALPSProps);
    TextPSID = sect.addModel(ep.TEXT, TextPSIDProps);
    TextPSIP = sect.addModel(ep.TEXT, TextPSIPProps);
    TextBROJKONTA = sect.addModel(ep.TEXT, TextBROJKONTAProps);
    TextID = sect.addModel(ep.TEXT, TextIDProps);
    TextIP = sect.addModel(ep.TEXT, TextIPProps);
    TextSALPROM = sect.addModel(ep.TEXT, TextSALPROMProps);
    Line9 = sect.addModel(ep.LINE, Line9Props);
    TextIDALL = sect.addModel(ep.TEXT, TextIDALLProps);
    TextIPALL = sect.addModel(ep.TEXT, TextIPALLProps);
    TextSALDO = sect.addModel(ep.TEXT, TextSALDOProps);
    Line10 = sect.addModel(ep.LINE, Line10Props);
    return sect;
  }

  public raReportSection createSectionFooter4() {
    raReportSection sect = new raReportSection(template.getModel(ep.SECTION_FOOTER + 4), SectionFooter4Props);

    Label17 = sect.addModel(ep.LABEL, Label17Props);
    Label18 = sect.addModel(ep.LABEL, Label18Props);
    Label19 = sect.addModel(ep.LABEL, Label19Props);
    Label20 = sect.addModel(ep.LABEL, Label20Props);
    LabelUkupno4 = sect.addModel(ep.LABEL, LabelUkupno4Props);
    LabelPromet4 = sect.addModel(ep.LABEL, LabelPromet4Props);
    Text28 = sect.addModel(ep.TEXT, Text28Props);
    Text29 = sect.addModel(ep.TEXT, Text29Props);
    Text30 = sect.addModel(ep.TEXT, Text30Props);
    TextNAZIVKLASE31 = sect.addModel(ep.TEXT, TextNAZIVKLASE31Props);
    TextKLASE31 = sect.addModel(ep.TEXT, TextKLASE31Props);
    Text31 = sect.addModel(ep.TEXT, Text31Props);
    Text32 = sect.addModel(ep.TEXT, Text32Props);
    Text33 = sect.addModel(ep.TEXT, Text33Props);
    Line11 = sect.addModel(ep.LINE, Line11Props);
    Text34 = sect.addModel(ep.TEXT, Text34Props);
    Text35 = sect.addModel(ep.TEXT, Text35Props);
    Text36 = sect.addModel(ep.TEXT, Text36Props);
    Line12 = sect.addModel(ep.LINE, Line12Props);
    return sect;
  }

  public raReportSection createSectionFooter3() {
    raReportSection sect = new raReportSection(template.getModel(ep.SECTION_FOOTER + 3), SectionFooter3Props);

    Label21 = sect.addModel(ep.LABEL, Label21Props);
    Label22 = sect.addModel(ep.LABEL, Label22Props);
    Label23 = sect.addModel(ep.LABEL, Label23Props);
    Label24 = sect.addModel(ep.LABEL, Label24Props);
    LabelUkupno5 = sect.addModel(ep.LABEL, LabelUkupno5Props);
    LabelPromet5 = sect.addModel(ep.LABEL, LabelPromet5Props);
    TextKLASE21 = sect.addModel(ep.TEXT, TextKLASE21Props);
    Text37 = sect.addModel(ep.TEXT, Text37Props);
    Text38 = sect.addModel(ep.TEXT, Text38Props);
    Text39 = sect.addModel(ep.TEXT, Text39Props);
    TextNAZIVKLASE21 = sect.addModel(ep.TEXT, TextNAZIVKLASE21Props);
    Text40 = sect.addModel(ep.TEXT, Text40Props);
    Text41 = sect.addModel(ep.TEXT, Text41Props);
    Text42 = sect.addModel(ep.TEXT, Text42Props);
    Line13 = sect.addModel(ep.LINE, Line13Props);
    Text43 = sect.addModel(ep.TEXT, Text43Props);
    Text44 = sect.addModel(ep.TEXT, Text44Props);
    Text45 = sect.addModel(ep.TEXT, Text45Props);
    Line14 = sect.addModel(ep.LINE, Line14Props);
    return sect;
  }

  public raReportSection createSectionFooter2() {
    raReportSection sect = new raReportSection(template.getModel(ep.SECTION_FOOTER + 2), SectionFooter2Props);

    Label25 = sect.addModel(ep.LABEL, Label25Props);
    Label26 = sect.addModel(ep.LABEL, Label26Props);
    Label27 = sect.addModel(ep.LABEL, Label27Props);
    Label28 = sect.addModel(ep.LABEL, Label28Props);
    LabelUkupno6 = sect.addModel(ep.LABEL, LabelUkupno6Props);
    LabelPromet6 = sect.addModel(ep.LABEL, LabelPromet6Props);
    Text46 = sect.addModel(ep.TEXT, Text46Props);
    TextNAZIVKLASE1 = sect.addModel(ep.TEXT, TextNAZIVKLASE1Props);
    TextRKLASE1 = sect.addModel(ep.TEXT, TextRKLASE1Props);
    Text47 = sect.addModel(ep.TEXT, Text47Props);
    Text48 = sect.addModel(ep.TEXT, Text48Props);
    Text49 = sect.addModel(ep.TEXT, Text49Props);
    Text50 = sect.addModel(ep.TEXT, Text50Props);
    Text51 = sect.addModel(ep.TEXT, Text51Props);
    Line15 = sect.addModel(ep.LINE, Line15Props);
    Text52 = sect.addModel(ep.TEXT, Text52Props);
    Text53 = sect.addModel(ep.TEXT, Text53Props);
    Text54 = sect.addModel(ep.TEXT, Text54Props);
    Line16 = sect.addModel(ep.LINE, Line16Props);
    return sect;
  }

  public raReportSection createSectionFooter1() {
    raReportSection sect = new raReportSection(template.getModel(ep.SECTION_FOOTER + 1), SectionFooter1Props);

    Label29 = sect.addModel(ep.LABEL, Label29Props);
    Label30 = sect.addModel(ep.LABEL, Label30Props);
    Label31 = sect.addModel(ep.LABEL, Label31Props);
    Label32 = sect.addModel(ep.LABEL, Label32Props);
    LabelUkupno7 = sect.addModel(ep.LABEL, LabelUkupno7Props);
    LabelPromet7 = sect.addModel(ep.LABEL, LabelPromet7Props);
    LabelRAZREDI_0__9 = sect.addModel(ep.LABEL, LabelRAZREDI_0__9Props);
    Text55 = sect.addModel(ep.TEXT, Text55Props);
    Text56 = sect.addModel(ep.TEXT, Text56Props);
    Text57 = sect.addModel(ep.TEXT, Text57Props);
    Text58 = sect.addModel(ep.TEXT, Text58Props);
    Text59 = sect.addModel(ep.TEXT, Text59Props);
    Text60 = sect.addModel(ep.TEXT, Text60Props);
    Line17 = sect.addModel(ep.LINE, Line17Props);
    Text61 = sect.addModel(ep.TEXT, Text61Props);
    Text62 = sect.addModel(ep.TEXT, Text62Props);
    Text63 = sect.addModel(ep.TEXT, Text63Props);
    Line18 = sect.addModel(ep.LINE, Line18Props);
    return sect;
  }

  public raReportSection createSectionFooter0() {
    raReportSection sect = new raReportSection(template.getModel(ep.SECTION_FOOTER + 0), SectionFooter0Props);

    Label33 = sect.addModel(ep.LABEL, Label33Props);
    Label34 = sect.addModel(ep.LABEL, Label34Props);
    Label35 = sect.addModel(ep.LABEL, Label35Props);
    Label36 = sect.addModel(ep.LABEL, Label36Props);
    LabelSveukupno = sect.addModel(ep.LABEL, LabelSveukupnoProps);
    Line19 = sect.addModel(ep.LINE, Line19Props);
    Text64 = sect.addModel(ep.TEXT, Text64Props);
    Text65 = sect.addModel(ep.TEXT, Text65Props);
    Line20 = sect.addModel(ep.LINE, Line20Props);
    TextKumulativSALDO = sect.addModel(ep.TEXT, TextKumulativSALDOProps);
    return sect;
  }

  public raReportSection createPageFooter() {
    raReportSection sect = new raReportSection(template.getModel(ep.PAGE_FOOTER), PageFooterProps);

    Text66 = sect.addModel(ep.TEXT, Text66Props);
    return sect;
  }

  public abstract raReportSection createReportFooter();

  public void createReportStructure() {
    template = ModelFactory.getModel(ep.REPORT_TEMPLATE);
    ModelFactory.setCurrentReport(template);

    ReportTemplate = addSection(new raReportSection(template, ReportTemplateProps));

    PageSetup = addSection(new raReportSection(template.getModel(ep.PAGE_SETUP), PageSetupProps));
    Sections = addSection(createSections());

    ReportHeader = addSection(createReportHeader());
    PageHeader = addSection(createPageHeader());
    SectionHeader0 = addSection(createSectionHeader0());
    SectionHeader1 = addSection(createSectionHeader1());
    SectionHeader2 = addSection(createSectionHeader2());
    SectionHeader3 = addSection(createSectionHeader3());
    SectionHeader4 = addSection(createSectionHeader4());
    Detail = addSection(createDetail());
    SectionFooter4 = addSection(createSectionFooter4());
    SectionFooter3 = addSection(createSectionFooter3());
    SectionFooter2 = addSection(createSectionFooter2());
    SectionFooter1 = addSection(createSectionFooter1());
    SectionFooter0 = addSection(createSectionFooter0());
    PageFooter = addSection(createPageFooter());
    ReportFooter = addSection(createReportFooter());
  }
}
