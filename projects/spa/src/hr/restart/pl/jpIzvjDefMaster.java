/****license*****************************************************************
**   file: jpIzvjDefMaster.java
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

import hr.restart.baza.dM;
import hr.restart.swing.JraTextField;
import hr.restart.util.raCommonClass;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.borland.jbcl.layout.XYConstraints;
import com.borland.jbcl.layout.XYLayout;


public class jpIzvjDefMaster extends JPanel {
  raCommonClass rcc = raCommonClass.getraCommonClass();
  dM dm = dM.getDataModule();

  frmIzvjDef fIzvjDef;
  JPanel jpDetail = new JPanel();

  XYLayout lay = new XYLayout();
  JLabel jlCizv = new JLabel();
  JLabel jlaCizv = new JLabel();
  JLabel jlaOpis = new JLabel();
  JraTextField jraCizv = new JraTextField();
  JraTextField jraOpis = new JraTextField();

  public jpIzvjDefMaster(frmIzvjDef md) {
    try {
      fIzvjDef = md;
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    jpDetail.setLayout(lay);
    lay.setWidth(570);
    lay.setHeight(80);

    jlCizv.setText("Izvje�taj");
    jlaCizv.setHorizontalAlignment(SwingConstants.LEFT);
    jlaCizv.setText("Oznaka");
    jlaOpis.setHorizontalAlignment(SwingConstants.LEFT);
    jlaOpis.setText("Opis");
    jraCizv.setColumnName("CIZV");
    jraCizv.setDataSet(fIzvjDef.getMasterSet());
    jraOpis.setColumnName("OPIS");
    jraOpis.setDataSet(fIzvjDef.getMasterSet());

    jpDetail.add(jlCizv, new XYConstraints(15, 40, -1, -1));
    jpDetail.add(jlaCizv, new XYConstraints(151, 23, 98, -1));
    jpDetail.add(jlaOpis, new XYConstraints(256, 23, 298, -1));
    jpDetail.add(jraCizv, new XYConstraints(150, 40, 100, -1));
    jpDetail.add(jraOpis, new XYConstraints(255, 40, 300, -1));

    this.add(jpDetail, BorderLayout.CENTER);
  }
}
