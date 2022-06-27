package com.iduy.gondrong.models;

import com.iduy.gondrong.models.audit.DateAudit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name = "categories")
@Setter
@Getter
public class Category extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 100)
    @NotBlank
    private String name;

    @Column(name = "entity_name", length = 21)
    private String entityName;

    @Column(name = "is_active")
    private Boolean isActive;
}
