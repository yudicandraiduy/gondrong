package com.iduy.gondrong.models;

import com.iduy.gondrong.models.audit.UserDateAudit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@Table(name = "locations")
@Entity
public class Location extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "address")
    @NotBlank
    private String Address;

    @Column(name = "neighbourhood", length = 3)
    private String neighbourhood;

    @Column(name = "hamlet", length = 3)
    private String hamlet;

    @Column(name = "village")
    private String village;

    @Column(name = "sub_district")
    private String subDistrict;

    @Column(name = "regency")
    private String regency;

    @Column(name = "province")
    private String province;

    @Column(name = "postal_code", length = 6)
    private String postalCode;
}
