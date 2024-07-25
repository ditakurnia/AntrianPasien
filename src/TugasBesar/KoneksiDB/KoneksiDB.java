package TugasBesar.KoneksiDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.*;
import javax.swing.JOptionPane;

public class KoneksiDB {
    public static Connection conn;
    public static final String USER = "root";
    public static final String PASS = "";
    public static final String DB_NAME ="antrian_pasien";
    
    public static Connection getConnection(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DB_NAME, USER, PASS);
        } catch (SQLException ex){
            Logger.getLogger (KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (conn != null){
            System.out.println("Koneksi Berhasil");
        } else {
            JOptionPane.showMessageDialog (null, "Koneksi Gagal !! \nCek Ulang Konfigurasi");
            System.exit(0);
        }
        return conn;
}

    public static void openConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
