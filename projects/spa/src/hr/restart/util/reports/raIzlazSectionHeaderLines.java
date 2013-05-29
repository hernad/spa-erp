/****license*****************************************************************
**   file: raIzlazSectionHeaderLines.java
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

public class raIzlazSectionHeaderLines extends raReportSection {

  private String[] thisProps = new String[] {"BRDOK", "", "", "", "Yes", "No", "", "Yes", "740"};
  public raReportElement Line1;
  private String[] Line1Props = new String[] {"", "", "", "60", "10820", "0", "", "", ""};
  public raReportElement LabelNaziv;
  private String[] LabelNazivProps = new String[] {"Naziv", "", "1300", "100", "4180", "460",
     "Normal", "Gray", "Solid", "Gray", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement LabelSifra;
  private String[] LabelSifraProps = new String[] {"�ifra", "", "480", "100", "800", "460",
     "Normal", "Gray", "Solid", "Gray", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement LabelKolicina;
  private String[] LabelKolicinaProps = new String[] {"Koli\u010Dina", "", "5500", "100", "960",
     "460", "Normal", "Gray", "Solid", "Gray", "", "", "Lucida Bright", "8", "Bold", "", "",
     "Center"};
  public raReportElement LabelRbr;
  private String[] LabelRbrProps = new String[] {"Rbr", "", "", "100", "460", "460", "Normal",
     "Gray", "Solid", "Gray", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement Label1;
  private String[] Label1Props = new String[] {"%", "", "8200", "100", "1200", "220", "Normal",
     "Gray", "Solid", "Gray", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement LabelIznos;
  private String[] LabelIznosProps = new String[] {"Iznos", "", "9420", "100", "1400", "460",
     "Normal", "Gray", "Solid", "Gray", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement LabelCijena;
  private String[] LabelCijenaProps = new String[] {"Cijena", "", "6960", "100", "1220", "460",
     "Normal", "Gray", "Solid", "Gray", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement LabelJmj;
  private String[] LabelJmjProps = new String[] {"Jmj", "", "6480", "100", "460", "460", "Normal",
     "Gray", "Solid", "Gray", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  
  public raReportElement LabelPop;
  private String[] LabelPopProps = new String[] {"Pop", "", "8200", "340", "620", "220", "Normal",
     "Gray", "Solid", "Gray", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  public raReportElement LabelPor;
  private String[] LabelPorProps = new String[] {"Por", "", "8840", "340", "560", "220", "Normal",
     "Gray", "Solid", "Gray", "", "", "Lucida Bright", "8", "Bold", "", "", "Center"};
  
  public raReportElement Line2;
  private String[] Line2Props = new String[] {"", "", "", "580", "10820", "0", "", "", ""};

  public raIzlazSectionHeaderLines(raReportTemplate owner) {
    super(owner.template.getModel(raElixirProperties.SECTION_HEADER + 1));
    this.setDefaults(thisProps);

    addElements();

    final raReportTemplate ownerFF = owner;

    addReportModifier(new ReportModifier() {
      public void modify() {
        modifyThis(ownerFF);
      }
    });

//    addElements();
//
//    addReportModifier(new ReportModifier() {
//      public void modify() {
//        modifyThis();
//      }
//    });
  }

  private void addElements() {
    Line1 = addModel(ep.LINE, Line1Props);
    LabelNaziv = addModel(ep.LABEL, LabelNazivProps);
    LabelSifra = addModel(ep.LABEL, LabelSifraProps);
    LabelKolicina = addModel(ep.LABEL, LabelKolicinaProps);
    LabelRbr = addModel(ep.LABEL, LabelRbrProps);
    Label1 = addModel(ep.LABEL, Label1Props);
    LabelIznos = addModel(ep.LABEL, LabelIznosProps);
    LabelCijena = addModel(ep.LABEL, LabelCijenaProps);
    LabelJmj = addModel(ep.LABEL, LabelJmjProps);
    LabelPop = addModel(ep.LABEL, LabelPopProps);
    LabelPor = addModel(ep.LABEL, LabelPorProps);
    Line2 = addModel(ep.LINE, Line2Props);
  }

  private void modifyThis(raReportTemplate owner) {
    if (owner instanceof hr.restart.robno.repRacRnalTemplate ||
        owner instanceof hr.restart.robno.repRacRnalKupacTemplate){
//          System.out.println("\n\nsad bi se tribalo stisnit\n\n");
      this.setProperty(raElixirProperties.GROW,raElixirPropertyValues.YES);
      this.setProperty(raElixirProperties.SHRINK,raElixirPropertyValues.YES);
    }
    LabelSifra.setCaption(hr.restart.robno.Aut.getAut().getIzlazCARTdep("�ifra", "Oznaka", "Barcode"));
    if (owner instanceof hr.restart.robno.repRacuniEANTemplate)
      LabelSifra.setCaption("EAN Code");
    resizeElement(this.LabelSifra, hr.restart.robno.Aut.getAut().getIzlazCARTwidth(), this.LabelNaziv);
  }
}
