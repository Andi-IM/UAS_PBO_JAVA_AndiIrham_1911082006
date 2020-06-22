/*
 * Copyright 2020 Andi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * @author Andi
 *
 */
public class TestDateExample {

    /**
     * @param args the command line arguments
     */
    static final String OLD_FORMAT = "dd-MMMMM-yyyy";
    static final String NEW_FORMAT = "yyyy-MM-dd";

    static boolean isValidDate(String input) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(NEW_FORMAT);
                formatter.parse(input);
                return true;
            } catch (ParseException e) {
                return false;
            }
        }
    
    public static String dateFormater(String getTanggal) {
        String tanggal = getTanggal;

        if (isValidDate(tanggal)) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(NEW_FORMAT);
                Date date = formatter.parse(tanggal);
                formatter.applyPattern(OLD_FORMAT);
                return formatter.format(date);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null,
                        "ERROR: " + e.getMessage());
            }
        } else {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(OLD_FORMAT);
                Date date = formatter.parse(tanggal);
                formatter.applyPattern(NEW_FORMAT);
                return formatter.format(date);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null,
                        "ERROR: " + e.getMessage());
            }
        }
        return null;
    }

    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        String tanggalini = "22-Juni-2020";
        String tanggallain = "2020-06-22";
        String[] bentuklain;

        bentuklain = dateFormater(tanggallain).split("-");
        
        System.out.println(bentuklain[2]);
    }

}
