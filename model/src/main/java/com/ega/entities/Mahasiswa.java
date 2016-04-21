/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.ega.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.gdn.common.base.entity.GdnBaseEntity;


/**
 *
 * @author Ega Prianto
 */
@Entity
@Table(name = "Mahasiswa")
public class Mahasiswa extends GdnBaseEntity {

  private static final String STORE_ID = "1";


//  @GeneratedValue(generator = "system-uuid")
//  @GenericGenerator(name = "system-uuid", strategy = "uuid2")
//  private String id;

  @Column(name = "Nama_Mahasiswa")
  private String nama;

  @Column(name = "Npm_Mahasiswa")
  private String npm;

  @Column(name = "MataKuliah_Mahasiswa")
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mahasiswa")
  private Set<MataKuliah> mataKuliahs = new HashSet<MataKuliah>();

  public Mahasiswa() {
    // nothing to do here
    this.setStoreId(STORE_ID);
  }

//  @Override
//  public String getId() {
//    return id;
//  }

  public Set<MataKuliah> getMataKuliahs() {
    return mataKuliahs;
  }

  public String getNama() {
    return nama;
  }

  public String getNpm() {
    return npm;
  }

//  @Override
//  public void setId(String id) {
//    this.id = id;
//  }

  public void setMatakuliahs(Set<MataKuliah> matakuliahs) {
    this.mataKuliahs = matakuliahs;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public void setNpm(String npm) {
    this.npm = npm;
  }
}
