/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Koneksi;
import Data.MahasiswaDao;
import Data.ProdiDao;
import Data.UangkuliahDao;
import Model.Uangkuliah_model;
import View.UangkuliahView;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andi
 */
public class Uangkuliah_controller {
    UangkuliahView view;
    Uangkuliah_model model;
    UangkuliahDao dao;
    MahasiswaDao mdao;
    ProdiDao pdao;
    private Koneksi k;
    private Connection con;

    public Uangkuliah_controller(UangkuliahView view) {
        this.view = view;
        dao = new UangkuliahDao();
        mdao = new MahasiswaDao();
        pdao = new ProdiDao();
         k = new Koneksi();
        try {
            con = k.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: "+e.getMessage());
        }
        
    }
    
    public void getGolongan(String isi) {
        switch(isi){
            case "0":
                view.getLevel0().setSelected(true);
                break;
            case "1":
                view.getLevel1().setSelected(true);
                break;
            case "2":
                view.getLevel2().setSelected(true);
                break;
            case "3":
                view.getLevel3().setSelected(true);
                break;
            case "4":
                view.getLevel4().setSelected(true);
                break;
            case "5":
                view.getLevel5().setSelected(true);
                break;       
        }
    }    
    
    public void clear(){
        view.getTxtNoPembayaran().setText(null);
        view.getTxtNoBp().setText(null);
        view.getTxtNama().setText(null);
        view.getCbJenisPembayaran().setSelectedIndex(0);
        view.getKelompokUkt().clearSelection();
        view.getSpinJumlah().setValue(0);
        view.getSpinSemester().setValue(1);
        view.getTxtTA().setText(null);
    }
    
    public void insert(){
        model = new Uangkuliah_model();
        model.setNoPembayaran(view.getTxtNoPembayaran().getText());
        model.setNoBp(view.getTxtNoBp().getText());
        model.setJenisPembayaran(view.getCbJenisPembayaran().getSelectedItem().toString());
        model.setJumlah(view.getSpinJumlah().getValue().toString());
        model.setSemester(view.getSpinSemester().getValue().toString());
        model.setTahunAjaran(view.getTxtTahunAjaran().getText());
        
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
        model = new Uangkuliah_model();
        model.setNoPembayaran(view.getTxtNoPembayaran().getText());
        model.setNoBp(view.getTxtNoBp().getText());
        model.setJenisPembayaran(view.getCbJenisPembayaran().getSelectedItem().toString());
        model.setJumlah(view.getSpinJumlah().getValue().toString());
        model.setSemester(view.getSpinSemester().getValue().toString());
        model.setTahunAjaran(view.getTxtTahunAjaran().getText());
        
        try {
            dao.update(model);
            JOptionPane.showMessageDialog(view, "Updated");
            clear();
        } catch (HeadlessException | SQLException e) {
              JOptionPane.showMessageDialog(null, 
                    "ERROR: "+e.getMessage());
        }
    }
    
    public void delete(){
        String noPembayaran = view.getTxtNoPembayaran().getText();
        try {
            dao.delete(noPembayaran);
            JOptionPane.showMessageDialog(null, "DELETED");
            this.clear();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void isiTable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) view.getTableUkt().getModel();
            dtm.setRowCount(0);
            ResultSet rs = k.getQuery(con, dao.SQL_GET_ALL_UANGKULIAH);
            while (rs.next()) {
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                };
                dtm.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    
    public void isiTableMahasiswa(){
        try {
            DefaultTableModel dtm = (DefaultTableModel) view.getTableUkt().getModel();
            dtm.setRowCount(0);
            ResultSet rs = k.getQuery(con, dao.SQL_GET_ALL_UANGKULIAH);
            while (rs.next()) {
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                };
                dtm.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
}
