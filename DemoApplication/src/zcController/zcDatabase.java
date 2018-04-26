package zcController;

import java.sql.*;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author RK Raju Khunt
 */
public class zcDatabase {

    Connection con;
    zcValidation val = new zcValidation();
    PreparedStatement ps;
    ResultSet rs;
    ResultSet rs1;
    Statement st;
    JTextField[] rk;
    int id;
    private int rkIsresult;
    private int rkGetrow;

    public zcDatabase() {
        con = zcConnection.rkConnection();
    }

    /**
     *
     * @param rkGetrow
     */
    public void setRKrow(int rkGetrow) {
        this.rkGetrow = rkGetrow;
    }

    /**
     * can 1 return get a row can 0 return can't get row
     *
     * @return
     */
    public int getRKrow() {
        return rkGetrow;
    }

    /**
     *
     * @param rkIsResult
     */
    public void setRKisresult(int rkIsResult) {
        this.rkIsresult = rkIsResult;
    }

    public int getRKisresult() {
        return rkIsresult;
    }

    /**
     * DML (Data Manipulation Language)
     *
     * @param query
     * @throws SQLException
     * @since 23/01/2016 RK Raju Khunt DML statements affect records in a table.
     * These are basic operations we perform on data such as selecting a few
     * records from a table, inserting new records, deleting unnecessary
     * records, and updating/modifying existing records.
     *
     * DML statements include the following:
     *
     * SELECT – select records from a table INSERT – insert new records UPDATE –
     * update/Modify existing records DELETE – delete existing records
     */
    public void rkDML(String query) {
        try {
            ps = con.prepareStatement(query);
            rkIsresult = ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * TCL (Transaction Control Language) TCL statements allow you to control
     * and manage transactions to maintain the integrity of data within
     * SQLstatements.
     *
     * BEGIN Transaction – opens a transaction COMMIT Transaction – commits a
     * transaction ROLLBACK Transaction - ROLLBACK a transaction in case of any
     * error
     *
     * @param query
     */
    public void rkTCL(String query) {
    }

    /**
     * DCL (Data Control Language) DCL statements control the level of access
     * that users have on database objects.
     *
     * GRANT – allows users to read/write on certain database objects REVOKE –
     * keeps users from read/write permission on database objects
     *
     * @param query
     */
    public void rkDCL(String query) {
    }

    /**
     * DDL (Data Definition Language) DDL statements are used to alter/modify a
     * database or table structure and schema. These statements handle the
     * design and storage of database objects.
     *
     * CREATE – create a new Table,database, schema ALTER – alter existing
     * table, column description DROP –delete existing objects from database
     *
     * @param query
     */
    public void rkDDL(String query) {
    }

    /**
     *
     * @param query
     * @return
     */
    public ResultSet rkSelect_rs(String query) {
        try {
            ps = con.prepareStatement(query);
            return rs1 = ps.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error DB Result Set :- " + e);
            return null;
        }
    }

    /**
     *
     * @param query
     * @return Int can 1 return get a row can 0 return can't get row
     * @throws java.sql.SQLException
     */
    public int rkSelect_int(String query) throws SQLException {
        try {
            ps = con.prepareStatement(query);
            rs1 = ps.executeQuery();
            rs1.next();
            if (rs1.getRow() > 0) {
                return rkGetrow = 1;
            } else {
                rs1.close();
                return rkGetrow = 0;
            }
        } catch (SQLException e) {
            return 0;
        } finally {
            rs1.close();
        }
    }

    /**
     *
     * @param query
     * @param tablename
     * @throws SQLException
     *
     * public void setRKtabledt(String query, JTable tablename) throws
     * SQLException { try { ps = con.prepareStatement(query); rs =
     * ps.executeQuery(); tablename.setModel(DbUtils.resultSetToTableModel(rs));
     * rs.close(); ps.close(); } catch (Exception ex) { ex.printStackTrace(); }
     * }
     */
    /**
     *
     * @param query
     * @param comboboxname
     * <br> <b color="red">id</b> can pass query required first Argument is id
     * <br> <b color="red">After</b> Argument is required to be whish data are
     * display a ComboBox
     */
    public void setRKcomboboxdb(String query, JComboBox comboboxname) {
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
                comboboxname.addItem(rs.getString(2));
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            System.err.println("Set Data Combobox Error :- " + ex);
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param rktextbox Pass The Array Of TextField
     * @param qry
     */
    public void setRKtextfileddt(JTextField[] rktextbox, String qry) {
        try {
            rs = rkSelect_rs(qry);
            rs.next();
            for (int i = 0; i < rktextbox.length; i++) {
                rktextbox[i].setText(rs.getString(i + 2));
            }

        } catch (Exception ex) {
            System.err.println("RKDbClss Error And Set TextField Data Error ");
            ex.printStackTrace();
        }
    }

    public void rkTextField_clr(JTextField[] rktext) {
        int count = rktext.length;
        for (int i = 0; i < count; i++) {
            rktext[i].setText("");
        }
    }

    /**
     *
     * @param comboboxname
     *
     * public void rkAutoCompleted(JComboBox[] comboboxname) { int count =
     * comboboxname.length; for (int i = 0; i < count; i++) {
     * AutoCompleteDecorator.decorate(comboboxname[i]); } }
     */
    public int rkGetPrice(String qry) {
        try {
            rs = rkSelect_rs(qry);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Price Get Error :- " + e);
        }
        return 0;
    }

    public int getRKprofit_loss(String query) {
        try {
            return rkGetPrice(query);
        } catch (Exception e) {
            System.out.println("Error Profit And Loass Count :- " + e);
        }
        return 0;
    }

    /**
     *
     * @param query
     * @param tablename
     * @throws SQLException
     */
    public void rkSettableinfo(String query, JTable tablename) throws SQLException {
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            tablename.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     *
     * @param comboboxname
     */
    public void rkAutoCompleted(JComboBox[] comboboxname) {
        int count = comboboxname.length;
        for (int i = 0; i < count; i++) {
            AutoCompleteDecorator.decorate(comboboxname[i]);
        }
    }

    public int DML(String qry, JTextField[] param) {
        try {
            ps = con.prepareStatement(qry);
            JTextField[] txt = param;

            for (int i = 0; i < param.length; i++) {
                ps.setString((i + 1), txt[i].getText());
            }

            int count = ps.executeUpdate();
            ps.close();
            return count;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, zcValidation.printErrorStatic(ex.getMessage(),ex.getMessage()), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public HashMap<Object, Object> DML(String qry) {
        try {
            HashMap<Object, Object> item = new HashMap<>();
            ps = con.prepareStatement(qry);
            rs = ps.executeQuery();

            while (rs.next()) {
                item.put(rs.getString(2), rs.getString(1));
            }
            return item;
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null,val.printError(e.getClass(),e.getMessage(),getClass().getName()),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public HashMap<Object, Object> DML1(String qry) {
        try {
            HashMap<Object, Object> item = new HashMap<>();
            ps = con.prepareStatement(qry);
            rs = ps.executeQuery();

            while (rs.next()) {
                item.put(rs.getString(2), rs.getString(1));
            }
            return item;
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null,val.printError(e.getClass(),e.getMessage(),getClass().getName()),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
    
