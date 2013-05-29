/****license*****************************************************************
**   file: mxViewer.java
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

import hr.restart.swing.JraScrollPane;
import hr.restart.util.FileHandler;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class mxViewer extends JPanel {
  private static mxViewer mxV;
  JTextArea jEView = new JTextArea();
  JraScrollPane jScroll = new JraScrollPane();

  protected mxViewer() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    this.setLayout(new BorderLayout());
    jScroll.getViewport().add(jEView);
    this.add(jScroll, BorderLayout.CENTER);
  }

  public static mxViewer getViever() {
    if (mxV == null) mxV = new mxViewer();
    try {
      mxV.jEView.setText(FileHandler.readFile(mxReport.TMPPRINTFILE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mxV;
  }
}