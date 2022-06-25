package com.iduy.gondrong.models;

import com.iduy.gondrong.models.audit.UserDateAudit;
import com.iduy.gondrong.util.EventType;
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
@Table(name = "events")
public class Event extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url")
    @NotBlank
    private String url;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "about")
    private String about;

    @Column(name = "host")
    private String host;

    @Enumerated(EnumType.STRING)
    @Column(length = 7)
    private EventType eventType;

    @Column(name = "place")
    private String place;

    @ManyToOne (fetch = FetchType .LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;















}
