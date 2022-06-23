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
@Getter
@Setter
@Table(name ="Event" )
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotBlank
    private String url;

    @Column
    private String title;

    private LocalDateTime date;

    private String about;

    private String host;

    @Enumerated(EnumType.STRING)
    @Column(length = 7)
    private EventType eventType;

    private String place;

    @ManyToOne (fetch = FetchType .LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;















}
