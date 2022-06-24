package com.iduy.gondrong.models;

import com.iduy.gondrong.models.audit.UserDateAudit;
import com.iduy.gondrong.util.ServiceOption;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Table(name = "companies")
@Entity
public class Company extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    @NotBlank
    private String companyName;

    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private ServiceOption serviceOption;

    @Column(length = 100)
    private String areaServed;

    @Column(name = "hours_start")
    private Time hoursStart;

    @Column(name = "hours_end")
    private Time hoursEnd;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(targetEntity = User.class)
    @JsonIgnore
    private User user;

    @OneToMany(targetEntity = Location.class)
    private Set<Location> locations = new HashSet<>();
}
