/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.ega.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ega.entities.MataKuliah;

/**
 *
 * @author Ega Prianto
 */
public interface MataKuliahDao extends JpaRepository<MataKuliah, String> {
  MataKuliah findByKode(String kode);
}
