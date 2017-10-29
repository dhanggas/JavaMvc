
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.mycompany.belajarswing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dhanggas
 */
public class MahasiswaKontroler {

    String sql = "insert into tbmahasiswa(id,nama,jurusan) values (?,?,?)";

    public List<Mahasiswa> ambilseumaData() throws SQLException {
        List<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        Connection koneksi = Koneksi.getConnection();
        Statement st = koneksi.createStatement();
        ResultSet hasil = st.executeQuery("select * from tbmahasiswa");

        while (hasil.next()) {
            Mahasiswa m = new Mahasiswa();

            m.setNim(hasil.getString(1));
            m.setNama(hasil.getString(2));
            m.setJurusan(hasil.getString(3));
            daftarMahasiswa.add(m);
        }

        return daftarMahasiswa;
    }

    public void simpanData(Mahasiswa m) throws SQLException {
        Connection koneksi = Koneksi.getConnection();
        PreparedStatement ps = koneksi.prepareStatement(sql);

        ps.setString(1, m.getNim());
        ps.setString(2, m.getNama());
        ps.setString(3, m.getJurusan());
        ps.executeUpdate();
        ps.close();
        koneksi.close();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
