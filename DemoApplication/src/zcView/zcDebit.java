/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zcView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import zcController.zcDatabase;

/**
 *
 * @author rk
 */
public class zcDebit extends javax.swing.JInternalFrame {

    /**
     * Creates new form zcCredit
     */
    public zcDebit() {
        initComponents();
        con = zcController.zcConnection.rkConnection();
        db.rkAutoCompleted(new JComboBox[]{zc_Day, zc_Month, zc_Year, zcAC_Number});
        for (int i = 2018; i <= 2020; i++) {
            zc_Year.addItem(i + "");
        }
        AC_Name = db.DML("SELECT `acACHolderName`,`zcACNumber` FROM `zcaccount`");
        AC_Number = db.DML("SELECT `id`,`zcACNumber` FROM `zcaccount`");
        AC_Number.entrySet().forEach((e) -> {
            zcAC_Number.addItem((String) e.getKey());
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        zcAC_Number = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        zc_Month = new javax.swing.JComboBox<>();
        zc_Year = new javax.swing.JComboBox<>();
        zc_Day = new javax.swing.JComboBox<>();
        zcAC_holderName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        zcAC_holderAmount = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(61, 51, 51));
        setClosable(true);
        setTitle("Debit");

        zcAC_Number.setEditable(true);
        zcAC_Number.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Account Number" }));
        zcAC_Number.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                zcAC_NumberItemStateChanged(evt);
            }
        });
        zcAC_Number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zcAC_NumberActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel1.setText("A/C Number");

        zc_Month.setEditable(true);
        zc_Month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        zc_Year.setEditable(true);
        zc_Year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year" }));
        zc_Year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zc_YearActionPerformed(evt);
            }
        });

        zc_Day.setEditable(true);
        zc_Day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        zc_Day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zc_DayActionPerformed(evt);
            }
        });

        zcAC_holderName.setEditable(false);
        zcAC_holderName.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel3.setText("Amount");

        zcAC_holderAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                zcAC_holderAmountKeyTyped(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(zc_Day, 0, 1, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(zcAC_Number, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(zcAC_holderAmount, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(zcAC_holderName))
                                        .addContainerGap())))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(zc_Month, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zc_Year, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(zcAC_Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zc_Month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zc_Day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zc_Year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zcAC_holderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zcAC_holderAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Debit");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zc_YearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zc_YearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zc_YearActionPerformed

    private void zcAC_holderAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zcAC_holderAmountKeyTyped
        /*if(!Character.isDigit(evt.getKeyChar()) || evt.getKeyCode() == 46){
            
        }*/
    }//GEN-LAST:event_zcAC_holderAmountKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if ((0 == zcAC_Number.getSelectedIndex()) || (0 == zc_Day.getSelectedIndex()) || (0 == zc_Month.getSelectedIndex()) || (0 == zc_Year.getSelectedIndex())) {
                JOptionPane.showMessageDialog(this, "Full fill all details", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ps = con.prepareStatement("SELECT * FROM `zctransaction` where zcACNumber='" + zcAC_Number.getSelectedItem() + "'ORDER BY `zctransaction`.`id` ASC LIMIT 1");
                rs = ps.executeQuery();
                if (rs.next()) {
                    int zcMonth = rs.getInt("zcMonth");
                    int zcDay = rs.getInt("zcDay");
                    rs.close();
                    ps.close();
                    switch (zcMonth) {
                        case 1:
                            if (Integer.parseInt(zc_Month.getSelectedItem().toString()) >= 7) {
                                if (Integer.parseInt(zc_Day.getSelectedItem().toString()) >= zcDay) {
                                    setDebit(true);
                                }else
                                    setDebit(false);
                            }else
                                    setDebit(false);
                            break;
                        case 2:
                            if (Integer.parseInt(zc_Month.getSelectedItem().toString()) >= 8) {
                                if (Integer.parseInt(zc_Day.getSelectedItem().toString()) >= zcDay) {
                                    setDebit(true);
                                }else
                                    setDebit(false);
                            }else
                                    setDebit(false);
                            break;
                        case 3:
                            if (Integer.parseInt(zc_Month.getSelectedItem().toString()) >= 9) {
                                if (Integer.parseInt(zc_Day.getSelectedItem().toString()) >= zcDay) {
                                    setDebit(true);
                                }else
                                    setDebit(false);
                            }else
                                    setDebit(false);
                            break;
                        case 4:
                            if (Integer.parseInt(zc_Month.getSelectedItem().toString()) >= 10) {
                                if (Integer.parseInt(zc_Day.getSelectedItem().toString()) >= zcDay) {
                                    setDebit(true);
                                    System.out.println(zc_Day.getSelectedItem());
                                    System.out.println(zcDay);
                                }else
                                    setDebit(false);
                            }else
                                    setDebit(false);
                            break;
                        case 5:
                            if (Integer.parseInt(zc_Month.getSelectedItem().toString()) >= 11) {
                                if (Integer.parseInt(zc_Day.getSelectedItem().toString()) >= zcDay) {
                                    setDebit(true);
                                }else
                                    setDebit(false);
                            }else
                                    setDebit(false);
                            break;
                        case 6:
                            if (Integer.parseInt(zc_Month.getSelectedItem().toString()) >= 12) {
                                if (Integer.parseInt(zc_Day.getSelectedItem().toString()) >= zcDay) {
                                    setDebit(true);
                                }else
                                    setDebit(false);
                            }else
                                    setDebit(false);
                            break;
                        case 7:
                            if (Integer.parseInt(zc_Month.getSelectedItem().toString()) >= 1) {
                                if (Integer.parseInt(zc_Day.getSelectedItem().toString()) >= zcDay) {
                                    setDebit(true);
                                }else
                                    setDebit(false);
                            }else
                                    setDebit(false);
                            break;
                        case 8:
                            if (Integer.parseInt(zc_Month.getSelectedItem().toString()) >= 2) {
                                if (Integer.parseInt(zc_Day.getSelectedItem().toString()) >= zcDay) {
                                    setDebit(true);
                                }else
                                    setDebit(false);
                            }else
                                    setDebit(false);
                            break;
                        case 9:
                            if (Integer.parseInt(zc_Month.getSelectedItem().toString()) >= 3) {
                                if (Integer.parseInt(zc_Day.getSelectedItem().toString()) >= zcDay) {
                                    setDebit(true);
                                }else
                                    setDebit(false);
                            }else
                                    setDebit(false);
                            break;
                        case 10:
                            if (Integer.parseInt(zc_Month.getSelectedItem().toString()) >= 4) {
                                if (Integer.parseInt(zc_Day.getSelectedItem().toString()) >= zcDay) {
                                    setDebit(true);
                                }else
                                    setDebit(false);
                            }else
                                    setDebit(false);
                            break;
                        case 11:
                            if (Integer.parseInt(zc_Month.getSelectedItem().toString()) >= 5) {
                                if (Integer.parseInt(zc_Day.getSelectedItem().toString()) >= zcDay) {
                                    setDebit(true);
                                }else
                                    setDebit(false);
                            }else
                                    setDebit(false);
                            break;
                        case 12:
                            if (Integer.parseInt(zc_Month.getSelectedItem().toString()) >= 6) {
                                if (Integer.parseInt(zc_Day.getSelectedItem().toString()) >= zcDay) {
                                    setDebit(true);
                                }else
                                    setDebit(false);
                            }else
                                    setDebit(false);
                            break;
                    }

                    if (isDebit()) {
                        ps = con.prepareStatement("SELECT SUM(zcAmount) FROM zctransaction where zcACNumber = '"+zcAC_Number.getSelectedItem()+"'");
                        rs = ps.executeQuery();
                        if(rs.next()){
                            double totalAmount = rs.getInt(1);
                            double returnAmount = (totalAmount*80)/100;
                            if(returnAmount>=Double.parseDouble(zcAC_holderAmount.getText())){
                                JOptionPane.showMessageDialog(this,"you are not able to withdraw money,did't withdraw more then 80% amount");
                            }else{
                                // Write Code To Add To Data Base;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "can't possible debit money");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(zcDebit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void zcAC_NumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zcAC_NumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zcAC_NumberActionPerformed

    private void zcAC_NumberItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_zcAC_NumberItemStateChanged
        System.out.println(AC_Number.get(zcAC_Number.getSelectedItem()));
        System.out.println(AC_Name.get(zcAC_Number.getSelectedItem()));
        zcAC_holderName.setText((String) AC_Name.get(zcAC_Number.getSelectedItem()));
    }//GEN-LAST:event_zcAC_NumberItemStateChanged

    private void zc_DayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zc_DayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zc_DayActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> zcAC_Number;
    private javax.swing.JTextField zcAC_holderAmount;
    private javax.swing.JTextField zcAC_holderName;
    private javax.swing.JComboBox<String> zc_Day;
    private javax.swing.JComboBox<String> zc_Month;
    private javax.swing.JComboBox<String> zc_Year;
    // End of variables declaration//GEN-END:variables
    zcDatabase db = new zcDatabase();
    HashMap<Object, Object> AC_Name = new HashMap<>();
    HashMap<Object, Object> AC_Number = new HashMap<>();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    private boolean debit;

    public boolean isDebit() {
        return debit;
    }

    public void setDebit(boolean debit) {
        this.debit = debit;
    }
}
