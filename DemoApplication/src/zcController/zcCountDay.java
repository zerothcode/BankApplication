/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zcController;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author rk
 */
public class zcCountDay {
    public static double getDiiff(String dateBeforeString,String dateAfterString){
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
	try {
	       Date dateBefore = myFormat.parse(dateBeforeString);
	       Date dateAfter = myFormat.parse(dateAfterString);
	       long difference = dateAfter.getTime() - dateBefore.getTime();
	       float daysBetween = (difference / (1000*60*60*24));
               return daysBetween;
	 } catch (Exception e) {
	       e.printStackTrace();
               return 0.0;
	 }
    }
}
