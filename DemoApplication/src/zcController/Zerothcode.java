/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zcController;

import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import zcView.ZCMainScreen;

/**
 *
 * @author rk
 */
public class Zerothcode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
            new Thread(() -> {
                try {
                    Thread.sleep(4500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Zerothcode.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            ZCMainScreen rk = new ZCMainScreen("View");
            rk.setSize(850, 493);
            rk.setVisible(true);
            rk.setResizable(false);
            //rk.setIconImage(Toolkit.getDefaultToolkit().getImage("RKinfotech/Image/RKLogo.png"));
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
           javax.swing.JOptionPane.showMessageDialog(null,zcValidation.printErrorStatic("Can't Open Main Class "));
        }
    }
    
}
