/****license*****************************************************************
**   file: JDOPrintCreator.java
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

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */
import java.io.File;
import java.io.RandomAccessFile;

import com.borland.dx.dataset.Column;
import com.borland.dx.dataset.DataSet;
import com.borland.dx.dataset.Variant;


public class JDOPrintCreator {
//sysoutTEST ST = new sysoutTEST(false);
  private String dataModuleName;
  private String dataSetName;
  private String fileName;
  private String className;
  DataSet dset;
  RandomAccessFile rafClass;
  public JDOPrintCreator(String dataModuleNameC, String dataSetNameC, String fileNameC, String classNameC) {
    dataModuleName = dataModuleNameC;
    dataSetName = dataSetNameC;
    fileName = fileNameC;
    className = classNameC;
    try {
      makeDataSet();
      openClass();
      makeCommonCode();
      makeDsCode();
      closeClass();
      javax.swing.JOptionPane.showMessageDialog(null,"Kreiranje uspjelo! File: "+fileNameC,"JDOC", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
      javax.swing.JOptionPane.showMessageDialog(null,"Kreiranje neuspje�no! Exception: "+e.toString(),"Gre�ka", javax.swing.JOptionPane.ERROR_MESSAGE);
      e.printStackTrace();
    }
  }
  private void makeDataSet() throws Exception {
    Object dm = Class.forName(dataModuleName).newInstance();
    java.lang.reflect.Method dsGetter = dm.getClass().getMethod("get"+dataSetName,null);
    dset = (DataSet)dsGetter.invoke(dm,null);
    dset.open();
  }

  private void openClass() throws Exception {
      File file = new File(fileName);
      if (file.exists()) {
        if (
            javax.swing.JOptionPane.showConfirmDialog(
              null,
              "File "+fileName+" postoji. Obrisati?",
              "JDOC",
              javax.swing.JOptionPane.YES_NO_OPTION
            ) == 1
           ) throw new java.lang.Exception("Nisi htio obrisati file");
      }
      file.delete();
      rafClass = new RandomAccessFile(fileName,"rw");
  }
/**
 *
 */
  private void makeCommonCode() throws Exception {
    String cn = className.substring(className.lastIndexOf('.')+1,className.length());

    writeln("package "+className.substring(0,className.lastIndexOf('.'))+";");
    writeln("");
    writeln("/**");
    writeln(" * Generated by hr.restart.util.JDOPrintCreator");
    writeln(" */");
    writeln("import java.io.*;");
    writeln("import java.math.*;");
    writeln("import java.sql.*;");
    writeln("import com.borland.dx.dataset.*;");
    writeln("import sg.com.elixir.reportwriter.rt.*;");
    writeln("import sg.com.elixir.*;");
    writeln("");
    writeln("public class "+className.substring(className.lastIndexOf('.')+1,className.length())+" implements sg.com.elixir.reportwriter.datasource.IDataProvider {");
    writeln("  DataSet ds = "+dataModuleName+".getDataModule().get"+dataSetName+"();");
    writeln("  public "+cn+"() {");
    writeln("  }");
    writeln("");
    writeln("  public "+cn+"(int idx) {");
    writeln("    ds.goToRow(idx);");
    writeln("  }");
    writeln("");
    writeln("  public java.util.Enumeration getData() {");
    writeln("    return new java.util.Enumeration() {");
    writeln("      {ds.open();}");
    writeln("      int indx=0;");
    writeln("      public Object nextElement() {");
    writeln("        return new "+cn+"(indx++);");
    writeln("      }");
    writeln("      public boolean hasMoreElements() {");
    writeln("        return (indx < ds.getRowCount());");
    writeln("      }");
    writeln("    };");
    writeln("  }");
    writeln("");
    writeln("  public void close() {");
    writeln("  }");
    writeln("");
  }

  private void makeDsCode() throws Exception {
    Column[] cols = dset.getColumns();
    for (int i=0;i<cols.length;i++) {
      String gName = cols[i].getColumnName();
      String gType = getTypeMethodName(cols[i].getDataType());
      writeln("  public "+gType+" get"+gName+"() {");
      writeln("    return ds.get"+gType.substring(0,1).toUpperCase()+gType.substring(1)+"(\""+gName+"\");");
      writeln("  }");
      writeln("");
    }
  }
  private String getTypeMethodName(int type) throws Exception {
    if (type == Variant.BYTE) return "byte";
    if (type == Variant.SHORT) return "short";
    if (type == Variant.INT) return "int";
    if (type == Variant.LONG) return "long";
    if (type == Variant.FLOAT) return "float";
    if (type == Variant.DOUBLE) return "double";
    if (type == Variant.BIGDECIMAL) return "BigDecimal"; //java.math.*
    if (type == Variant.BOOLEAN) return "boolean";
    if (type == Variant.INPUTSTREAM) return "InputStream"; //java.io.*
    if (type == Variant.DATE) return "Date"; //java.sql.*
    if (type == Variant.TIME) return "Time"; //java.sql.*
    if (type == Variant.TIMESTAMP) return "Timestamp"; //java.sql.*
    if (type == Variant.STRING) return "String";
    if (type == Variant.OBJECT) return "Object";
    if (type == Variant.BYTE_ARRAY) return "ByteArray"; //byte[]

    throw new java.lang.Exception("Unknown data type");

  }
  private void closeClass() throws Exception {
    writeln("}");
    rafClass.close();
  }
  private void writeln(String linetext) throws Exception {
    rafClass.writeBytes(linetext+"\n");
  }
}