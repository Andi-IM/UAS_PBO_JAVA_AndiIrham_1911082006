/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Koneksi;
import Data.ProdiDao;
import Model.Prodi_model;
import View.ProdiView;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andi
 */
public class Prodi_controller {
    ProdiView view;
    Prodi_model model;
    ProdiDao dao;
    private Koneksi k;
    private Connection con;

    public Prodi_controller(ProdiView view) {
        this.view = view;
        dao = new ProdiDao();
        k = new Koneksi();
        try {
            con = k.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
    
    public void clear(){
        view.getTxtKdJurusan().setText("");
        view.getTxtNamaJurusan().setText("");
        view.getTxtKodeProdi().setText("");
        view.getTxtNamaProdi().setText("");
    }
    
    public void insert(){
        String kdJurusan = view.getTxtKdJurusan().getText();
        String NamaJurusan = view.getTxtNamaJurusan().getText();
        String KdProdi = view.getTxtKodeProdi().getText();
        String NamaProdi = view.getTxtNamaProdi().getText();
        
        model = new Prodi_model();
        model.setKdJurusan(kdJurusan);
        model.setNamaJurusan(NamaJurusan);
        model.setKdProdi(KdProdi);
        model.setNamaProdi(NamaProdi);
        
        try {
            dao.create(model);
            JOptionPane.showMessageDialog(view, "Inserted");
            clear();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "ERROR: "+e.getMessage());
        }   
    }
    
    public void update(){
        String kdJurusan = view.getTxtKdJurusan().getText();
        String NamaJurusan = view.getTxtNamaJurusan().getText();
        String KdProdi = view.getTxtKodeProdi().getText();
        String NamaProdi = view.getTxtNamaProdi().getText();
        
        model = new Prodi_model();
        model.setKdJurusan(kdJurusan);
        model.setNamaJurusan(NamaJurusan);
        model.setKdProdi(KdProdi);
        model.setNamaProdi(NamaProdi);
        
        try {
            int a = JOptionPane.showConfirmDialog(null, "Yakin mau diubah?", "Konfirmasi", 0, 2);
            if (a == 0) {
                dao.update(model);
                JOptionPane.showMessageDialog(view, "Updated");
            }
            clear();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "ERROR: "+e.getMessage());
        }  
    }
    
    public void delete(){
        String kodeProdi = view.getTxtKodeProdi().getText();
        try {
            int a = JOptionPane.showConfirmDialog(null, "Yakin mau dihapus?", "Konfirmasi", 0, JOptionPane.OK_OPTION);
            if (a == 0) {
              dao.delete(kodeProdi);
              JOptionPane.showMessageDialog(null, "DELETED");
            }
            this.clear();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void isiTable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) view.getTbProdi().getModel();
            dtm.setRowCount(0);
            ResultSet rs = k.getQuery(con, dao.SQL_GET_ALLPRODI);
            while (rs.next()) {
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                };
                dtm.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    
    public void getNmJurusan(){
        String kodeCari = view.getTxtKdJurusan().getText();
        try {
            String find = dao.getNmJurusan(kodeCari);
            if (find != null) {
            view.getTxtNamaJurusan().setText(find);
            view.getTxtKodeProdi().requestFocus();
            } else {
            JOptionPane.showMessageDialog(null, "NOT FOUND");
            view.getTxtNamaJurusan().setText(null);
            view.getTxtNamaJurusan().requestFocus();
            }
       } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void onMouseClickTabelProdi(){
        dao = new ProdiDao();
        String kdProdi = view.getTbProdi().getValueAt(
                view.getTbProdi().getSelectedRow(),2).toString();
        try {
            model = dao.getTbProdi(kdProdi);
            view.getTxtKdJurusan().setText(model.getKdJurusan());
            view.getTxtNamaJurusan().setText(model.getNamaJurusan());
            view.getTxtKodeProdi().setText(model.getKdProdi());
            view.getTxtNamaProdi().setText(model.getNamaProdi());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error : "+e);
        }
    }
}