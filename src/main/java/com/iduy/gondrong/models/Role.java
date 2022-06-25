package com.iduy.gondrong.models;

import com.iduy.gondrong.models.audit.DateAudit;
import com.iduy.gondrong.util.RoleType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length=20)
    private RoleType name;
}
