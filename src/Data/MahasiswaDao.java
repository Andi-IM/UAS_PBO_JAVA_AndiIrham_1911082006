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
import Model.Mahasiswa_model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Andi
 */
public class MahasiswaDao {
    Connection con;
    private final String SQL_TABLE_PRODI = "prodi";
    private final String SQL_TABLE_MAHASISWA = "mahasiswa";
    private final String SQL_INSERT_MAHASISWA = "INSERT INTO "+SQL_TABLE_MAHASISWA+" VALUES(?,?,?,?,?,?,?,?,?)";
    private final String SQL_UPDATE_MAHASISWA = "UPDATE "+SQL_TABLE_MAHASISWA+
            " SET no_bp = ?, nama= ?,  jekel= ?, tempatLahir= ?, tanggalLahir= ?, alamat= ?, noTelepon= ?, kdJurusan=?, kdProdi=?"+
            " WHERE no_bp = ?";
    private final String SQL_DELETE_MAHASISWA = "DELETE FROM "+SQL_TABLE_MAHASISWA+" WHERE no_bp= ?";
    private final String SQl_GET_MAHASISWA = "SELECT * FROM "+SQL_TABLE_MAHASISWA+" WHERE no_bp= ?";
    public final String SQL_GET_ALL_MAHASISWA = "SELECT no_bp, nama, tempatLahir, tanggalLahir, jekel, "+
                                                "alamat, noTelepon, namaJurusan, namaProdi FROM mahasiswa JOIN "+
                                                SQL_TABLE_PRODI+" USING(kdProdi);";
    public final String SQL_GET_UKT_MAHASISWA = "SELECT no_bp, nama, namajurusan, namaprodi "
                                                +"FROM "+SQL_TABLE_MAHASISWA+" JOIN "+SQL_TABLE_PRODI+" USING(kdProdi);";
    
    
    PreparedStatement ps;
    public MahasiswaDao() {
        Koneksi k = new Koneksi();
        con = k.getConnection();
    }
    
    public void create(Mahasiswa_model model) throws SQLException {
        String sql = SQL_INSERT_MAHASISWA;
        ps = con.prepareStatement(sql);
        ps.setString(1, model.getNo_bp());
        ps.setString(2, model.getNama());
        ps.setString(3, model.getJekel());
        ps.setString(4, model.getTempatLahir());
        ps.setString(5, model.getTglLahir());
        ps.setString(6, model.getAlamat());
        ps.setString(7, model.getNoTelepon());
        ps.setString(8, model.getKdJurusan());
        ps.setString(9, model.getKodeProdi());
        ps.executeUpdate();
    }
    
        public void update(Mahasiswa_model model) throws SQLException {
        String sql = SQL_UPDATE_MAHASISWA;
        ps = con.prepareStatement(sql);
        ps.setString(1, model.getNo_bp());
        ps.setString(2, model.getNama());
        ps.setString(3, model.getJekel());
        ps.setString(4, model.getTempatLahir());
        ps.setString(5, model.getTglLahir());
        ps.setString(6, model.getAlamat());
        ps.setString(7, model.getNoTelepon());
        ps.setString(8, model.getKdJurusan());
        ps.setString(9, model.getKodeProdi());
        ps.setString(10, model.getNo_bp());
        ps.executeUpdate();
    }
        
    public void delete(String no_bp) throws SQLException {
        String sql = SQL_DELETE_MAHASISWA;
        ps = con.prepareStatement(sql);
        ps.setString(1, no_bp);
        ps.executeUpdate();
    }    
    
    public Mahasiswa_model getTbMahasiswa(String kdProdi) throws SQLException {
        String sql = SQl_GET_MAHASISWA;
        ps = con.prepareStatement(sql);
        ps.setString(1, kdProdi);
        Mahasiswa_model model = null;
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            model = new Mahasiswa_model();
            model.setNo_bp(rs.getString(1));
            model.setNama(rs.getString(2));
            model.setJekel(rs.getString(3));
            model.setTempatLahir(rs.getString(4));
            model.setTglLahir(rs.getString(5));
            model.setAlamat(rs.getString(6));
            model.setNoTelepon(rs.getString(7));
            model.setKdJurusan(rs.getString(8));
            model.setKodeProdi(rs.getString(9));
        }
        return model;
    }
}
