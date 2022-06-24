package com.iduy.gondrong.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
public class ProposalRequest implements Serializable {
    private String latarBelakang;
    private String namaKegiatan;
    private String maksudKegiatan;
    private String tujuanKegiatan;
    private LocalDateTime waktuAwal;
    private LocalDateTime waktuAkhir;
    private String tempatKegiatan;
    private String bentukKegitan;
    private String susunanKegiatan;
    private Long estimasiBiaya;
    private String kriteriaSponsorship;
    private String penutup;
    private Long userId;
}