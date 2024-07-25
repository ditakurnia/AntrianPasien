package TugasBesar.Interfaces;

import TugasBesar.Entity.Pasien;
import java.sql.SQLException;
import java.util.List;

public interface PasienInterfaces {
    
    Pasien insert(Pasien ap) throws SQLException;

    void update(Pasien ap) throws SQLException;

    void delete(int id) throws SQLException;

    public List<Pasien> getAll(String nama);
}
