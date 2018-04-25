/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zcController;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
/**
 *
 * @author RK Raju Khunt
 */
public class zcOpen {
    
    /**
     * 
     * @param rkInternalFrame
     * @param rkDesktopPane 
     */
    public static void frame(JInternalFrame rkInternalFrame,JDesktopPane rkDesktopPane){
        try {
            rkDesktopPane.add(rkInternalFrame);
            rkInternalFrame.setVisible(true);
            rkInternalFrame.setClosable(true);
        } catch (Exception e) {
            System.err.println("Open Frame Error :- "+e);
        }
        
    }
}
