package zcController;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.Arrays;

/**
 *
 * @author RK Raju Khunt
 */
public final class zcValidation {
    /**
     * 
     * <code><b>Welcome to RKinfotech </b></code> 
     * @since 01-08-2016
     */
    
    public zcValidation() {
    }
    
    char c;
    /**
     * 
     * @param evt Only Allow Digit Character
     *  
     */
    public void rkIsDigit(KeyEvent evt) {
        c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)) || c == KeyEvent.VK_DELETE) {
            evt.consume();
        }
    }
    
    /**
     * 
     * @param evt Only Allow Letter Character
     */
    public void rkIsLetter(KeyEvent evt) {
        c = evt.getKeyChar();
        if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE)) || c == KeyEvent.VK_DELETE) {
            evt.consume();
        }
    }
    
    /**
     * 
     * @param evt Only Allow Letter Or Digit Character
     */
    public void rkIsLetterOrDigit(KeyEvent evt) {
        c = evt.getKeyChar();
        if (!(Character.isLetterOrDigit(c) || (c == KeyEvent.VK_BACK_SPACE)) || c == KeyEvent.VK_DELETE) {
            evt.consume();
        }
    }
    
    /**
     * 
     * @param evt Only Allow Letter,Digit Or `_` , ` `, `Delete` Character
     */
    public void rkIsLetterOrDigitWith(KeyEvent evt) {
        c = evt.getKeyChar();
        if (!(Character.isLetterOrDigit(c)) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ASTERISK) || (c==KeyEvent.VK_UNDERSCORE))  {
            evt.consume();
        }
    }
    
    /**
     * 
     * @param evt Only Allow LowerCase Digit Character
     */
    public void rkIsLowerCase(KeyEvent evt) {
        c = evt.getKeyChar();
        if (!(Character.isLowerCase(c) || (c == KeyEvent.VK_BACK_SLASH)) || c == KeyEvent.VK_DELETE) {
            evt.consume();
        }
    }

    /**
     * 
     * @param evt Only Allow UpperCase Digit Character
     */
    public void rkIsUpperCase(KeyEvent evt) {
        c = evt.getKeyChar();
        if (!(Character.isUpperCase(c) || (c == KeyEvent.VK_BACK_SLASH)) || c == KeyEvent.VK_DELETE) {
            evt.consume();
        }
    }
    
    /**
     * 
     * @param className
     * @param message
     * @return Error Message
     */
    public String printError(Object className,String message){
        return "<html>"
                + "<table>"
                + "<tr><td>Class Name</td><td>"+className+"</td><tr>"
                + "<tr><td>Message</td><td>"+message+"</td><tr>"
                + "</table>";
    }
    
    /**
     * 
     * @param className
     * @param message
     * @param errorClass
     * @return Error Message 
     */
    public String printError(Object className,String message,String errorClass){
        return "<html>"
                + "<table weight='250' height='250' border='1'>"
                + "<tr><td>Class Name</td><td>"+className+"</td><tr>"
                + "<tr><td>Error Class Name</td><td>"+errorClass+"</td><tr>"
                + "<tr><td>Message</td><td>"+message+"</td><tr>"
                + "</table>";
    }
    
    public String printError(Object error){
        return "<html>"
                + "<table weight='250' height='250'>"
                + "<tr><td>"+error+"</td><tr>"
                + "</table>";
    }
    
    public static String printErrorStatic(Object error){
        return "<html>"
                + "<table weight='250' height='250'>"
                + "<tr><td>"+error+"</td><tr>"
                + "</table>";
    }
    
    public static String printErrorStatic(String message,String errorClass){
        return "<html>"
                + "<table weight='250' height='250' border='1'>"
                + "<tr><td>Error Class Name</td><td>"+errorClass+"</td><tr>"
                + "<tr><td>Message</td><td>"+message+"</td><tr>"
                + "</table>";
    }
    
    
}
