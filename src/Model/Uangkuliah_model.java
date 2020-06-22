package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andi
 */
public class Uangkuliah_model {
    private String noPembayaran;
    private String noBp;
    private String semester;
    private String tahunAjaran;
    private String jenisPembayaran;
    private String golongan;
    private String jumlah;
    private String tanggalPembayaran;

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getTahunAjaran() {
        return tahunAjaran;
    }

    public void setTahunAjaran(String tahunAjaran) {
        this.tahunAjaran = tahunAjaran;
    }    
    
    public String getNoPembayaran() {
        return noPembayaran;
    }

    public String getNoBp() {
        return noBp;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public String getGolongan() {
        return golongan;
    }

    public String getJumlah() {
        return jumlah;
    }

    public String getTanggalPembayaran() {
        return tanggalPembayaran;
    }

    public void setNoPembayaran(String noPembayaran) {
        this.noPembayaran = noPembayaran;
    }

    public void setNoBp(String noBp) {
        this.noBp = noBp;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }

    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
    
    
}
