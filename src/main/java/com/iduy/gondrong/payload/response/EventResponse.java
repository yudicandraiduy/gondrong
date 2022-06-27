package com.iduy.gondrong.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
@Getter
@Setter
public class EventResponse implements Serializable {
    private Long id;
    private String url;
    private String title;
    private LocalDateTime date;
    private String about;
    private String host;
    private String eventType;
    private String place;

}
