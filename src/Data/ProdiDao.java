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

import Model.Prodi_model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andi
 */
public class ProdiDao {
    Connection con;
    private final String SQL_TABLE_PRODI = "prodi";
    private final String SQL_INSERT_PRODI = "INSERT INTO "+SQL_TABLE_PRODI+" VALUES(?,?,?,?)";
    private final String SQL_UPDATE_PRODI = "UPDATE "+SQL_TABLE_PRODI+" SET kdProdi= ?, namaprodi= ? WHERE kdjurusan = ? AND kdProdi = ?";
    private final String SQL_DELETE_PRODI = "DELETE FROM "+SQL_TABLE_PRODI+"WHERE kdProdi= ?";
    private final String SQL_GET_PRODI = "SELECT * FROM "+SQL_TABLE_PRODI+" WHERE kdProdi= ?";
    private final String SQL_GET_NM_PRODI = "SELECT namaprodi FROM "+SQL_TABLE_PRODI+" WHERE kdProdi= ?";
    private final String SQL_GET_NM_JURUSAN = "SELECT namaJurusan FROM "+SQL_TABLE_PRODI+" WHERE kdJurusan= ? LIMIT 1";
    private final String SQL_GET_KD_PRODI = "SELECT kdProdi FROM "+SQL_TABLE_PRODI+" WHERE namaprodi= ?";
    private final String SQL_GET_KD_JURUSAN = "SELECT distinct kdJurusan FROM "+SQL_TABLE_PRODI+" WHERE namaJurusan= ?";
    private final String SQL_GET_KDNM_PRODI = "SELECT kdprodi, namaprodi FROM "+SQL_TABLE_PRODI+" WHERE kdJurusan= ?";
    private final String SQL_GET_KDNM_JURUSAN = "SELECT DISTINCT kdJurusan, namajurusan FROM "+SQL_TABLE_PRODI;
    public final String SQL_GET_ALLPRODI = "SELECT * FROM "+SQL_TABLE_PRODI;
    PreparedStatement ps;
    
    public ProdiDao(){
        Koneksi k = new Koneksi();
        con = k.getConnection();
    }
    
    // CRUD METHODS
    public void create(Prodi_model model) throws SQLException   // CREATE RECORD 
    {
        String sql = SQL_INSERT_PRODI;
        ps = con.prepareStatement(sql);
        ps.setString(1, model.getKdJurusan());
        ps.setString(2, model.getNamaJurusan());
        ps.setString(3, model.getKdProdi());
        ps.setString(4, model.getNamaProdi());
        ps.executeUpdate();
    }
    
    public void update(Prodi_model model) throws SQLException   // UPDATE RECORD
    {
        String sql = SQL_UPDATE_PRODI;
        ps = con.prepareStatement(sql);
        ps.setString(3, model.getKdJurusan());
        ps.setString(1, model.getKdProdi());
        ps.setString(2, model.getNamaProdi());
        ps.setString(4, model.getKdProdi());
        ps.executeUpdate();
    }
    
    public void delete(String kode) throws SQLException // DELETE RECORD
    {
        String sql = SQL_DELETE_PRODI;
        ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ps.executeUpdate();
    }
     
    // GET METHODS
    public String getNmJurusan(String kdJurusan) throws SQLException 
    {
        String sql = SQL_GET_NM_JURUSAN;
        ps = con.prepareStatement(sql);
        ps.setString(1, kdJurusan);
        String jurusan = null;
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            jurusan = rs.getString(1);
        }
        return jurusan;
    }
    
    public String getKdJurusan(String nmJurusan) throws SQLException 
    {
        String sql = SQL_GET_KD_JURUSAN;
        ps = con.prepareStatement(sql);
        ps.setString(1, nmJurusan);
        String jurusan = null;
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            jurusan = rs.getString(1);
        }
        return jurusan;
    }
    
    public String getNmProdi(String kdProdi) throws SQLException 
    {
        String sql = SQL_GET_NM_PRODI;
        ps = con.prepareStatement(sql);
        ps.setString(1, kdProdi);
        String prodi = null;
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            prodi = rs.getString(1);
        }
        return prodi;
    }
    
    public String getKdProdi(String nmProdi) throws SQLException 
    {
        String sql = SQL_GET_KD_PRODI;
        ps = con.prepareStatement(sql);
        ps.setString(1, nmProdi);
        String prodi = null;
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            prodi = rs.getString(1);
        }
        return prodi;
    }
    
    public List<String> getAllJurusan() throws SQLException
    {
        String sql = SQL_GET_KDNM_JURUSAN;
        ps = con.prepareStatement(sql);
        List<String> list = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            list.add(rs.getString(1));
        }
        return list;
    }
    
    public List<String> getAllProdi(String kdProdi) throws SQLException
    {
        String sql = SQL_GET_KDNM_PRODI;
        ps = con.prepareStatement(sql);
        ps.setString(1, kdProdi);
        List<String> list = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            list.add(rs.getString(1)) ;
        }
        return list;
    }
    
    // GET TABLE METHODS
    public Prodi_model getTbProdi(String kdProdi) throws SQLException 
    {
        String sql = SQL_GET_PRODI;
        ps = con.prepareStatement(sql);
        ps.setString(1, kdProdi);
        Prodi_model model = null;
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            model = new Prodi_model();
            model.setKdJurusan(rs.getString(1));
            model.setKdProdi(rs.getString(3));
            model.setNamaJurusan(rs.getString(2));
            model.setNamaProdi(rs.getString(4));
        }
        return model;
    }
    
    public List<Prodi_model> getAllTbProdi(Connection con) throws SQLException 
    {
        String sql = SQL_GET_ALLPRODI;
        ps = con.prepareStatement(sql);
        Prodi_model model;
        List<Prodi_model> list = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            model = new Prodi_model();
            model.setKdJurusan(rs.getString(1));
            model.setKdProdi(rs.getString(2));
            model.setNamaJurusan(rs.getString(3));
            model.setNamaProdi(rs.getString(4));
            list.add(model);
        }
        return list;
    }
}
