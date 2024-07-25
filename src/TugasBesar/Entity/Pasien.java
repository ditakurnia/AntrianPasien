package TugasBesar.Entity;


public class Pasien {
    private int no_antrian;
    private String id_pasien;
    private String nama;
    private String tgl_lahir;
    private String gender;
    private String alamat;
   

    public String getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(String id_pasien) {
        this.id_pasien = id_pasien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public int getNo_antrian() {
        return no_antrian;
    }

    public void setNo_antrian(int no_antrian) {
        this.no_antrian = no_antrian;
    }

    
 
    
}
