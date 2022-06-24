package com.iduy.gondrong.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@Table(name = "location")
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotBlank
    private String location;

    @Column

    private String Address;

    private String neighbourhood;

    private String hamlet;

    private String village;

    private String subDistrict;

    private String regency;

    private String province;

    private String postalCode;


}
