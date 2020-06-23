/*
 * Copyright 2020 Andi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Data;

import Model.Uangkuliah_model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Andi
 */
public class UangkuliahDao {
    Connection con;
    PreparedStatement ps;
    private final String SQL_TABLE_PRODI = "prodi";
    private final String SQL_TABLE_MAHASISWA = "mahasiswa";
    private final String SQL_TABLE_UANGKULIAH = "uangkuliah";
    private final String SQL_INSERT_UANGKULIAH = "INSERT INTO "+SQL_TABLE_UANGKULIAH+"(nopembayaran, no_bp, semester, \n"
                                                 +"tahunajaran, jenispembayaran, golongan, jumlah) VALUES(?,?,?,?,?,?,?)";
    private final String SQL_UPDATE_UANGKULIAH = "UPDATE "+SQL_TABLE_UANGKULIAH+" SET "+
            "nopembayaran=?, nobp=?, semester=?, tahunAjaran=?, jenispembayaran=?, golongan=?, jumlah=? "+
            "WHERE nopembayaran=?";
    private final String SQL_DELETE_UANGKULIAH = "DELETE FROM "+SQL_TABLE_UANGKULIAH+" WHERE nopembayaran=?";
    private final String SQL_GET_UANGKULIAH = "SELECT * FROM "+SQL_TABLE_UANGKULIAH+" WHERE nopembayaran=?";
    public final String SQL_GET_ALL_UANGKULIAH = "SELECT nopembayaran, nama, namajurusan, namaprodi, semester, \n" +
                                                 "tahunajaran, golongan, jenispembayaran, jumlah, tanggalpembayaran  \n" +
                                                 "FROM "+SQL_TABLE_UANGKULIAH+" JOIN "+SQL_TABLE_MAHASISWA+" using(no_bp) \n" +
                                                 "JOIN "+SQL_TABLE_PRODI+" USING(kdprodi);";

    public UangkuliahDao() {
        Koneksi k = new Koneksi();
        con = k.getConnection();
    }
    
    public void create(Uangkuliah_model model) throws SQLException {
        String sql = SQL_INSERT_UANGKULIAH;
        ps = con.prepareStatement(sql);
        ps.setString(1, model.getNoPembayaran());
        ps.setString(2, model.getNoBp());
        ps.setString(3, model.getSemester());
        ps.setString(4, model.getTahunAjaran());
        ps.setString(5, model.getJenisPembayaran());
        ps.setString(6, model.getGolongan());
        ps.setString(7, model.getJumlah());
        ps.executeUpdate();
    }
     
    public void update(Uangkuliah_model model) throws SQLException {
        String sql = SQL_UPDATE_UANGKULIAH;
        ps = con.prepareStatement(sql);
        ps.setString(1, model.getNoPembayaran());
        ps.setString(2, model.getNoBp());
        ps.setString(3, model.getSemester());
        ps.setString(4, model.getTahunAjaran());
        ps.setString(5, model.getJenisPembayaran());
        ps.setString(6, model.getGolongan());
        ps.setString(7, model.getJumlah());
        ps.setString(8, model.getNoPembayaran());
        ps.executeUpdate();
    } 
    
    public void delete(String noPembayaran) throws SQLException {
        String sql = SQL_DELETE_UANGKULIAH;
        ps = con.prepareStatement(sql);
        ps.setString(1, noPembayaran);
        ps.executeUpdate();
    }
    
    public Uangkuliah_model getTbUangkuliah(String kdProdi) throws SQLException {
        String sql = SQL_GET_UANGKULIAH;
        ps = con.prepareStatement(sql);
        ps.setString(1, kdProdi);
        Uangkuliah_model model = null;
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            model = new Uangkuliah_model();
            model.setNoPembayaran(rs.getString(1));
            model.setNoBp(rs.getString(2));
            model.setSemester(rs.getString(3));
            model.setTahunAjaran(rs.getString(4));
            model.setJenisPembayaran(rs.getString(5));
            model.setGolongan(rs.getString(6));
            model.setJumlah(rs.getString(7));
        }
        return model;
    }
}
