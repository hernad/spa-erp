/****license*****************************************************************
**   file: JraCheckBox.java
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
package hr.restart.swing;

import hr.restart.util.Aus;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBox;

import com.borland.dx.dataset.ColumnAware;
import com.borland.dx.dataset.DataSet;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class JraCheckBox extends JCheckBox implements raAbstractButton, ColumnAware {
  private boolean travers;
  private raButtonGroup bgr = null;
  private raButtonDataBinder binder;
  /**
	* Default konstruktor.
	*/
  public JraCheckBox() {
    initButton();
  }
  public JraCheckBox(Action action) {
    super(action);
    initButton();
  }
  public JraCheckBox(Icon icon) {
    super(icon);
    initButton();
  }
  public JraCheckBox(String text) {
    super(text);
    initButton();
  }
  public JraCheckBox(String text, Icon icon) {
    super(text,icon);
    initButton();
  }
  private void initButton() {
	 travers = true;
   binder = new raButtonDataBinder(this);
   /*addKeyListener(new JraKeyListener());*/
  }
  /**
	* Getter propertija focus-traversable. Interna stvar.<p>
	* @return true ako je button focus-traversable, ina�e false.
	*/
  public boolean isFocusTraversable() {
	 return travers;
  }

  /**
	* Setira ovaj radio button.<p>
	* @param sel true ili false, ali nema smisla zvati ovu metodu s parametrom
	* false, jer se radio button automatski isklju�uje kad se upali neki drugi.
	*/
/*
  public void setSelected(boolean sel) {
    super.setSelected(sel);
  }
*/
  /**
	* Setira ovaj button (automatski isklju�uje ostale iz grupe).
	*/
  public void setSelected() {
	 setSelected(true);
  }

  public void setFocusTraversable(boolean traversable) {
	 travers = traversable;   
  }

  public void setButtonGroup(raButtonGroup bg) {
	 bgr = bg;
  }
  public raDataBinder getBinder() {
    return binder;
  }

  /**
	* Vra�a button grupu kojoj pripada ovaj radio button.<p>
	* @return referencu na raButtonGroup kojoj pripada ovaj button, ili null.
	*/
  public raButtonGroup getButtonGroup() {
	 return bgr;
  }

  /**
	* Ne radi ni�ta ako je taj button pridodan nekoj buttongrupi. (glumi ColumnAware).<p>
	* @param ds neki dataset.
	*/
  public void setDataSet(DataSet ds) {
    binder.setDataSet(ds);
  }

  /**
	* Ne radi ni�ta ako je taj button pridodan nekoj buttongrupi. (glumi ColumnAware).<p>
	* @param col neki string.
	*/
  public void setColumnName(String col) {
    binder.setColumnName(col);
  }

  /**
	* Getter za DataSet (ColumnAware interface).<p>
	* @return dataset button grupe kojoj ovaj button pripada.
	*/
  public DataSet getDataSet() {
	 return (bgr == null) ? null : bgr.getDataSet();
  }

  /**
	* Getter za ColumnName (ColumnAware interface).<p>
	* @return ime kolone na koju se cijeli button group binda.
	*/
  public String getColumnName() {
	 return (bgr == null) ? null : bgr.getColumnName();
  }

  /**
	* Odre�uje vrijednost kolone koja odgovara ovom buttonu.<p>
	* @param selval vrijednost ovog buttona.
	*/
  public void setSelectedValue(Object selval) {
	  binder.setSelectedValue(selval);
  }

  /**
	* Getter za selectedValue.<p>
	* @return vrijednost kolone koja odgovara ovom buttonu.
	*/
  public String getSelectedValue() {
	 return binder.getSelectedValue().toString();
  }
////// com.borland.dbswing
  public void setSelectedDataValue(String v) {
    setSelectedValue(v);
  }
  public String getSelectedDataValue() {
    return getSelectedValue();
  }
  public void setUnselectedDataValue(String v) {
    binder.setUnselectedValue(v);
  }
  public String getUnselectedDataValue() {
    return binder.getUnselectedValue().toString();
  }
  
  public void addNotify() {
    super.addNotify();
    if (isFocusTraversable())
      Aus.installEnterRelease(this);
  }
  
  public void removeNotify() {
    super.removeNotify();
    AWTKeyboard.unregisterComponent(this);
  }
//////
}



//public class JraCheckBox extends com.borland.dbswing.JdbCheckBox {
//  {
//    addKeyListener(new JraKeyListener());
//  }
//}