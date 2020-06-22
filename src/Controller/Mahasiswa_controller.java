/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Koneksi;
import Data.MahasiswaDao;
import Data.ProdiDao;
import Model.Mahasiswa_model;
import View.MahasiswaView;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andi
 */
public class Mahasiswa_controller {
    MahasiswaView view;
    Mahasiswa_model model;
    MahasiswaDao dao;
    ProdiDao pdao;
    private Koneksi k;
    private Connection con;
    static final String OLD_FORMAT = "dd-MMMMM-yyyy";
    static final String NEW_FORMAT = "yyyy-MM-dd";
    SimpleDateFormat formatter; 
    
    public Mahasiswa_controller(MahasiswaView view) {
        this.view = view;
        dao = new MahasiswaDao();
        pdao = new ProdiDao();
        k = new Koneksi();
        try {
            con = k.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: "+e.getMessage());
        }
    }
    
    static boolean isValidDate(String input) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(NEW_FORMAT);
                formatter.parse(input);
                return true;
            } catch (ParseException e) {
                return false;
            }
        }
    
    public String dateFormater(String getTanggal) {
        if (isValidDate(getTanggal)) {
            try {
                formatter = new SimpleDateFormat(NEW_FORMAT);
                Date date = formatter.parse(getTanggal);
                formatter.applyPattern(OLD_FORMAT);
                return formatter.format(date);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null,
                        "ERROR: " + e.getMessage());
            }
        } else {
            try {
                formatter = new SimpleDateFormat(OLD_FORMAT);
                Date date = formatter.parse(getTanggal);
                formatter.applyPattern(NEW_FORMAT);
                return formatter.format(date);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null,
                        "ERROR: " + e.getMessage());
            }
        }
        return null;
    }
    
    public void clear(){
        view.getTxtNoBP().setText(null);
        view.getTxtNama().setText(null);
        view.getTxtTempatLahir().setText(null);
        view.getSpinTanggal1().setValue("01");
        view.getSpinBulan().setValue("Januari");
        view.getSpinTahun().setValue(2020);
        view.getRbPria().setSelected(false);
        view.getRbWanita().setSelected(false);
        view.getTxtAreaAlamat().setText(null);
        view.getTxtTelepon().setText(null);
        view.getCbJurusan().setSelectedIndex(0);
        view.getCbProdi().setSelectedIndex(0);
    }
    
    public String getkdJurusan(String nmJurusan){
        try {
            return pdao.getKdJurusan(nmJurusan);
        } catch (SQLException e) {  JOptionPane.showMessageDialog(null, 
                    "ERROR: "+e.getMessage());}
        return "";
    }
    
    public String getkdProdi(String nmProdi){
        try {
            System.out.println(pdao.getKdJurusan(nmProdi));
            return pdao.getKdProdi(nmProdi);
        } catch (SQLException e) {  JOptionPane.showMessageDialog(null, 
                    "ERROR: "+e.getMessage());}
        return "";
    }
    
    public Object getNmJurusan(String kdJurusan){
        try {
            return pdao.getNmJurusan(kdJurusan);
        } catch (SQLException e) {  JOptionPane.showMessageDialog(null, 
                    "ERROR: "+e.getMessage());}
        return null;
    }
    
    public Object getNmProdi(String kdProdi){
        try {
            System.out.println(pdao.getKdJurusan(kdProdi));
            return pdao.getNmProdi(kdProdi);
        } catch (SQLException e) {  JOptionPane.showMessageDialog(null, 
                    "ERROR: "+e.getMessage());}
        return null;
    }
    
    public void insert(){
        model = new Mahasiswa_model();
        
        model.setNo_bp(view.getTxtNoBP().getText());
        model.setNama(view.getTxtNama().getText());
        model.setTempatLahir(view.getTxtTempatLahir().getText());
        model.setTglLahir(dateFormater(view.getSpinTanggal1().getValue()+"-"+view.getSpinBulan().getValue()+"-"+
                view.getSpinTahun().getValue()));
        model.setJekel(setSemester());
        model.setAlamat(view.getTxtAreaAlamat().getText());
        model.setNoTelepon(view.getTxtTelepon().getText());
        model.setKdJurusan(getkdJurusan(view.getCbJurusan().getSelectedItem().toString()));
        model.setKodeProdi(getkdProdi(view.getCbProdi().getSelectedItem().toString()));
        
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
        model = new Mahasiswa_model();
         
        model.setNo_bp(view.getTxtNoBP().getText());
        model.setNama(view.getTxtNama().getText());
        model.setTempatLahir(view.getTxtTempatLahir().getText());
        model.setTglLahir(dateFormater(view.getSpinTanggal1().getValue()+"-"+view.getSpinBulan().getValue()+"-"+
                view.getSpinTahun().getValue()));
        model.setJekel(setSemester());
        model.setAlamat(view.getTxtAreaAlamat().getText());
        model.setNoTelepon(view.getTxtTelepon().getText());
        model.setKdJurusan(getkdJurusan(view.getCbJurusan().getSelectedItem().toString()));
        model.setKodeProdi(getkdProdi(view.getCbProdi().getSelectedItem().toString()));
        
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
        String noBP = view.getTxtNoBP().getText();
        try {
            dao.delete(noBP);
            JOptionPane.showMessageDialog(null, "DELETED");
            this.clear();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
     public void isiTable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) view.getTbMahasiswa().getModel();
            dtm.setRowCount(0);
            ResultSet rs = k.getQuery(con, dao.SQL_GET_ALL_MAHASISWA);
            while (rs.next()) {
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                };
                dtm.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    
    public void getSemester(String smt){
        if ("Laki-Laki".equals(smt)) {
            view.getRbPria().setSelected(true);
        }else {
            view.getRbWanita().setSelected(true);
        }
    } 
    
    public String setSemester(){
        if (view.getRbPria().isSelected()) {
          return  view.getRbPria().getText();
        } else {
          return  view.getRbWanita().getText();
        } 
    }
     
    public void onMouseClickTabelMahasiswa(){
        dao = new MahasiswaDao();
        String noBP = view.getTbMahasiswa().getValueAt(
                view.getTbMahasiswa().getSelectedRow(),0).toString();
        Object indexJurusan = "Teknologi Informasi";
        int indexProdi = 0;
        
        try {
            model = dao.getTbMahasiswa(noBP);
            String[] getDate = dateFormater(model.getTglLahir()).split("-");
            System.out.println(Arrays.toString(getDate));
            System.out.println(getDate[0]);
            System.out.println(getDate[1]);
            System.out.println(getDate[2]);
            
            view.getTxtNoBP().setText(model.getNo_bp());
            view.getTxtNama().setText(model.getNama());
            view.getTxtTempatLahir().setText(model.getTempatLahir());
            view.getSpinTanggal1().setValue(getDate[0]); 
            view.getSpinBulan().setValue(getDate[1]);
            view.getSpinTahun().setValue(Integer.parseInt(getDate[2]));
            getSemester(model.getJekel());
            view.getTxtAreaAlamat().setText(model.getAlamat());
            view.getTxtTelepon().setText(model.getNoTelepon());
            view.getCbJurusan().setSelectedItem(indexJurusan);
            view.getCbProdi().setSelectedItem(noBP);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error : "+e);
        }
    } 
}
