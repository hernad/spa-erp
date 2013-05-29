/****license*****************************************************************
**   file: TextFileReader.java
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
package hr.restart.sisfun;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2001</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class TextFileReader extends BufferedReader {

  public TextFileReader(String fname) throws FileNotFoundException {
    super(new InputStreamReader(new FileInputStream(fname)));
  }

  public TextFileReader(String fname, String enc)
      throws FileNotFoundException, UnsupportedEncodingException {
    super(new InputStreamReader(new FileInputStream(fname), enc));
  }

  public String in() {
    try {
      return readLine();
    } catch (IOException e) {
      return null;
    }
  }

  public void close() {
    try {
      super.close();
    } catch (IOException e) {}
  }
}

