package com.iduy.gondrong.models;

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
@Table(name = "Proposal")

public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotBlank
    private String latarBelakang;

    @Column
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

    @ManyToOne (fetch = FetchType .LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;





}
