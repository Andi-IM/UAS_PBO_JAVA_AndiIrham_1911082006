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
import Model.Mahasiswa_model;
import Model.Uangkuliah_model;
import View.UangkuliahView;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.swing.AbstractButton;
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
    Mahasiswa_model mmodel;
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
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage());
        }

    }

    String getSelectedButton() {
        String isi = null;
        for (Enumeration<AbstractButton> buttons = view.getKelompokUkt().getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                isi = button.getText();
                return isi;
            }
        }
        return null;
    }

    public void rbmouseClicked() {
        if (view.getLevel0().isSelected()) {
            getGolongan(view.getLevel0().getText());
        } else if (view.getLevel1().isSelected()) {
            getGolongan(view.getLevel1().getText());
        } else if (view.getLevel2().isSelected()) {
            getGolongan(view.getLevel2().getText());
        } else if (view.getLevel3().isSelected()) {
            getGolongan(view.getLevel3().getText());
        } else if (view.getLevel4().isSelected()) {
            getGolongan(view.getLevel4().getText());
        } else {
            getGolongan(view.getLevel5().getText());
        }
    }

    public void getGolongan(String isi) {
        switch (isi) {
            case "0":
                view.getLevel0().setSelected(true);
                view.getSpinJumlah().setValue(0);
                break;
            case "1":
                view.getLevel1().setSelected(true);
                view.getSpinJumlah().setValue(500000);
                break;
            case "2":
                view.getLevel2().setSelected(true);
                view.getSpinJumlah().setValue(1500000);
                break;
            case "3":
                view.getLevel3().setSelected(true);
                view.getSpinJumlah().setValue(2500000);
                break;
            case "4":
                view.getLevel4().setSelected(true);
                view.getSpinJumlah().setValue(3000000);
                break;
            case "5":
                view.getLevel5().setSelected(true);
                view.getSpinJumlah().setValue(5000000);
                break;
        }
    }

    public void clear() {
        view.getTxtNoPembayaran().setText(null);
        view.getTxtNoBp().setText(null);
        view.getTxtNama().setText(null);
        view.getCbJenisPembayaran().setSelectedIndex(0);
        view.getKelompokUkt().clearSelection();
        view.getSpinJumlah().setValue(0);
        view.getSpinSemester().setValue(1);
        view.getTxtTA().setText(null);
    }

    public void insert() {
        model = new Uangkuliah_model();
        model.setNoPembayaran(view.getTxtNoPembayaran().getText());
        model.setNoBp(view.getTxtNoBp().getText());
        model.setJenisPembayaran(view.getCbJenisPembayaran().getSelectedItem().toString());
        model.setGolongan(getSelectedButton());
        model.setJumlah(view.getSpinJumlah().getValue().toString());
        model.setSemester(view.getSpinSemester().getValue().toString());
        model.setTahunAjaran(view.getTxtTahunAjaran().getText());

        try {
            dao.create(model);
            JOptionPane.showMessageDialog(view, "Inserted");
            clear();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "ERROR: " + e.getMessage());
        }
    }

    public void update() {
        model = new Uangkuliah_model();
        model.setNoPembayaran(view.getTxtNoPembayaran().getText());
        model.setNoBp(view.getTxtNoBp().getText());
        model.setJenisPembayaran(view.getCbJenisPembayaran().getSelectedItem().toString());
        model.setGolongan(getSelectedButton());
        model.setJumlah(view.getSpinJumlah().getValue().toString());
        model.setSemester(view.getSpinSemester().getValue().toString());
        model.setTahunAjaran(view.getTxtTahunAjaran().getText());

        try {
            int a = JOptionPane.showConfirmDialog(null, "Yakin mau diubah?", "Konfirmasi", 0, 2);
            if (a == 0) {
                dao.update(model);
                JOptionPane.showMessageDialog(view, "Updated");
            }
            clear();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "ERROR: " + e.getMessage());
        }
    }

    public void delete() {
        String noPembayaran = view.getTxtNoPembayaran().getText();
        try {
            int a = JOptionPane.showConfirmDialog(null, "Yakin mau dihapus?", "Konfirmasi", 0, JOptionPane.OK_OPTION);
            if (a == 0) {
                dao.delete(noPembayaran);
                JOptionPane.showMessageDialog(null, "DELETED");
            }
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
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),};
                dtm.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void isiTableMahasiswa() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) view.getTblMhs().getModel();
            dtm.setRowCount(0);
            ResultSet rs = k.getQuery(con, mdao.SQL_GET_UKT_MAHASISWA);
            while (rs.next()) {
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),};
                dtm.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void tblMhsMouseClicked() {
        mdao = new MahasiswaDao();
        String noBp = view.getTblMhs().getValueAt(
                view.getTblMhs().getSelectedRow(), 0).toString();
        try {
            mmodel = mdao.getTbMahasiswa(noBp);
            view.getTxtNoBp().setText(mmodel.getNo_bp());
            view.getTxtNama().setText(mmodel.getNama());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error : " + e);
        }
    }

    public void tableUktMouseClicked() {
        dao = new UangkuliahDao();
        String nopembayaran = view.getTableUkt().getValueAt(
                view.getTableUkt().getSelectedRow(), 0).toString();

        try {
            model = dao.getTbUangkuliah(nopembayaran);
            mmodel = mdao.getTbMahasiswa(model.getNoBp());
            view.getTxtNoBp().setText(model.getNoBp());
            view.getTxtNama().setText(mmodel.getNama());
            view.getCbJenisPembayaran().setSelectedItem(model.getJenisPembayaran());
            view.getTxtNoPembayaran().setText(model.getNoPembayaran());
            view.getSpinJumlah().setValue(Integer.parseInt(model.getJumlah()));
            getGolongan(model.getGolongan());
            view.getSpinSemester().setValue(Integer.parseInt(model.getSemester()));
            view.getTxtTA().setText(model.getTahunAjaran());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error : " + e);
        }
    }
}
