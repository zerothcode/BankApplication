package zcController;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class rkLicense {

    Connection con = zcConnection.rkConnection();
    PreparedStatement ps;
    ResultSet rs;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    java.util.Date date = new java.util.Date();

    private String getMacAdd() {
        try {
            final NetworkInterface netInf = NetworkInterface.getNetworkInterfaces().nextElement();
            final byte[] mac = netInf.getHardwareAddress();
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return sb.toString();
        } catch (SocketException e) {
            return null;
        }
    }

    public boolean check() {
        try {
            ps = con.prepareStatement("SELECT * FROM `2245023265ae4cf87d02c8b6ba991139`");
            rs = ps.executeQuery();
            if (rs.next()) {
                String mac = rs.getString(1);
                String days = rs.getString(2);
                String dt = rs.getString(3);
                String[] dates = dt.split("/");
                String add = null;
                if (mac == null ? getMacAdd() == null : mac.equals(zcMD5.getMD5(getMacAdd()))) {
                    if (!(dt == null ? dateFormat.format(date) == null : dt.equals(dateFormat.format(date)))) {
                        if (!(days == null ? zcMD5.getMD5("10") == null : days.equals(zcMD5.getMD5("10")))) {
                            if (days == null ? zcMD5.getMD5("1") == null : days.equals(zcMD5.getMD5("1"))) {
                                add = zcMD5.getMD5("2");
                            }
                            if (days == null ? zcMD5.getMD5("2") == null : days.equals(zcMD5.getMD5("2"))) {
                                add = zcMD5.getMD5("3");
                            }
                            if (days == null ? zcMD5.getMD5("3") == null : days.equals(zcMD5.getMD5("3"))) {
                                add = zcMD5.getMD5("4");
                            }
                            if (days == null ? zcMD5.getMD5("4") == null : days.equals(zcMD5.getMD5("4"))) {
                                add = zcMD5.getMD5("5");
                            }
                            if (days == null ? zcMD5.getMD5("5") == null : days.equals(zcMD5.getMD5("5"))) {
                                add = zcMD5.getMD5("6");
                            }
                            if (days == null ? zcMD5.getMD5("6") == null : days.equals(zcMD5.getMD5("6"))) {
                                add = zcMD5.getMD5("7");
                            }
                            if (days == null ? zcMD5.getMD5("7") == null : days.equals(zcMD5.getMD5("7"))) {
                                add = zcMD5.getMD5("8");
                            }
                            if (days == null ? zcMD5.getMD5("8") == null : days.equals(zcMD5.getMD5("8"))) {
                                add = zcMD5.getMD5("9");
                            }
                            if (days == null ? zcMD5.getMD5("9") == null : days.equals(zcMD5.getMD5("9"))) {
                                add = zcMD5.getMD5("10");
                            }
                            if (days == null ? zcMD5.getMD5("10") == null : days.equals(zcMD5.getMD5("10"))) {
                                add = zcMD5.getMD5("11");
                            }
                            if (days == null ? zcMD5.getMD5("11") == null : days.equals(zcMD5.getMD5("11"))) {
                                add = zcMD5.getMD5("12");
                            }
                            if (days == null ? zcMD5.getMD5("12") == null : days.equals(zcMD5.getMD5("12"))) {
                                add = zcMD5.getMD5("13");
                            }
                            if (days == null ? zcMD5.getMD5("13") == null : days.equals(zcMD5.getMD5("14"))) {
                                add = zcMD5.getMD5("14");
                            }
                            if (days == null ? zcMD5.getMD5("14") == null : days.equals(zcMD5.getMD5("14"))) {
                                add = zcMD5.getMD5("15");
                            }
                            ps = con.prepareStatement("UPDATE `2245023265ae4cf87d02c8b6ba991139` SET `44fdec47036f482b68b748f9d786801b`=?,`5fc732311905cb27e82d67f4f6511f7f`=? WHERE 140c1f12feeb2c52dfbeb2da6066a73a=?");
                            ps.setString(1, add);
                            ps.setString(2, dateFormat.format(date));
                            ps.setString(3, mac);
                            int count = ps.executeUpdate();
                            if(count>0)
                                System.out.println("Record Inserted....");
                            else
                                System.out.println("Record Inserted False....");
                        } else {
                            javax.swing.JOptionPane.showMessageDialog(null, "please upgrade this software");
                            return true;
                        }
                    }else{
                        System.out.println("Date is Same...");
                    }
                }else{
                    System.out.println("MAC Address can't be same..");
                    return true;
                }
            } else {
                ps = con.prepareStatement("INSERT INTO `2245023265ae4cf87d02c8b6ba991139`(`140c1f12feeb2c52dfbeb2da6066a73a`, `44fdec47036f482b68b748f9d786801b`, `5fc732311905cb27e82d67f4f6511f7f`) VALUES (?,?,?)");
                ps.setString(1, zcMD5.getMD5(getMacAdd()));
                ps.setString(2, zcMD5.getMD5("1"));
                ps.setString(3, dateFormat.format(date));
                if (ps.execute()) {
                    System.out.println("Record Inserted...");
                } else {
                    System.out.println("Execute false part");
                }
                return false;
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return true;
        }
        return true;
    }
}
