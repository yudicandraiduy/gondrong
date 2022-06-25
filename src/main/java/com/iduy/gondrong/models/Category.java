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

    @Column(length = 100)
    @NotBlank
    private String name;

    private String entityName;

}
