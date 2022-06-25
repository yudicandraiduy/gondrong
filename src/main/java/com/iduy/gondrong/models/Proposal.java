package com.iduy.gondrong.models;

import com.iduy.gondrong.models.audit.UserDateAudit;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "proposals")
public class Proposal extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "latar_belakang")
    @NotBlank
    private String latarBelakang;

    @Column(name = "nama_kegiatan")
    private String namaKegiatan;

    @Column(name = "maksud_kegiatan")
    private String maksudKegiatan;

    @Column(name = "tujuan_kegiatan")
    private String tujuanKegiatan;

    @Column(name = "waktu_awal")
    private LocalDateTime waktuAwal;

    @Column(name = "waktu_akhir")
    private LocalDateTime waktuAkhir;

    @Column(name = "tempat_kegiatan")
    private String tempatKegiatan;

    @Column(name = "bentuk_kegiatan")
    private String bentukKegitan;

    @Column(name = "susunan_kegiatan")
    private String susunanKegiatan;

    @Column(name = "estimasi_biaya")
    private Long estimasiBiaya;

    @Column(name = "kriteria_sponsorsip")
    private String kriteriaSponsorship;

    @Column(name = "penutup")
    private String penutup;

    @ManyToOne (fetch = FetchType .LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;
}
