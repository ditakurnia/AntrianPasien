package TugasBesar.Implement;

import TugasBesar.Entity.Pasien;
import TugasBesar.KoneksiDB.KoneksiDB;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import TugasBesar.Interfaces.PasienInterfaces;

public class PasienImplement implements PasienInterfaces {

    @Override
    public Pasien insert(Pasien ap) throws SQLException {
        try {
            PreparedStatement st = KoneksiDB.getConnection().prepareStatement("insert into pasien values(?, ?, ?, ?, ?, ?)");
            st.setInt(1, ap.getNo_antrian());
            st.setString(2, ap.getId_pasien());
            st.setString(3, ap.getNama());
            st.setString(4, ap.getTgl_lahir());
            st.setString(5, ap.getGender());
            st.setString(6, ap.getAlamat());

            st.executeUpdate();
            KoneksiDB.conn.close();
            System.out.println("insert data akta");
        } catch (SQLException ex) {
            Logger.getLogger(PasienImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ap;
    }

    @Override
    public void update(Pasien ap) throws SQLException {
        PreparedStatement st = KoneksiDB.getConnection().prepareStatement("update pasien set no_antrian=?, nama=?, tgl_lahir=?, gender=?, alamat=? where id_pasien=?");
        st.setInt(1, ap.getNo_antrian());
        st.setString(6, ap.getId_pasien());
        st.setString(2, ap.getNama());
        st.setString(3, ap.getTgl_lahir());
        st.setString(4, ap.getGender());
        st.setString(5, ap.getAlamat());
        st.executeUpdate();
        KoneksiDB.conn.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            PreparedStatement st = KoneksiDB.getConnection().prepareStatement("delete from pasien where no_antrian=?");
            st.setInt(1, id);
            st.executeUpdate();
            KoneksiDB.conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Pasien> getAll(String nama) {
        List<Pasien> list = new ArrayList<>();
        try {
            Statement ss = KoneksiDB.getConnection().createStatement();
            ResultSet st = ss.executeQuery("select * from pasien where nama like '%" + nama + "%'");
            while (st.next()) {
                Pasien ap = new Pasien();
                ap.setNo_antrian(st.getInt("no_antrian"));
                ap.setId_pasien(st.getString("id_pasien"));
                ap.setNama(st.getString("nama"));
                ap.setTgl_lahir(st.getString("tgl_lahir"));
                ap.setGender(st.getString("gender"));
                ap.setAlamat(st.getString("alamat"));

                list.add(ap);
            }
            KoneksiDB.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PasienImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
