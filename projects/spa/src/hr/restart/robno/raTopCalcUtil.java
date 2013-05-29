/****license*****************************************************************
**   file: raTopCalcUtil.java
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
import java.lang.reflect.Field;
import java.math.BigDecimal;

public class raTopCalcUtil {

  boolean isDB = false;

  public boolean isEqualNula(String ime_object,String ime_polja) {

    boolean returnvalue = true;
    double value = 0;
    Object obj;

    try {
      Field clasa = this.getClass().getField(ime_object);
      obj = clasa.get(this);
      Field fild =  obj.getClass().getField(ime_polja);

      if (isDB){
        value = ((BigDecimal) fild.get(obj)).doubleValue();
      }
      else {
        value = ((java.lang.Double)fild.get(obj)).doubleValue();
      }

      if (value!=0) returnvalue = false;

    } catch (Exception e) {
      System.out.println("Gre�ka isEqualNula " + ime_polja+" "+e);
      returnvalue = false;
    }
    return returnvalue;
  }
}