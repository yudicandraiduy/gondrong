package com.iduy.gondrong.payload.request;

import com.iduy.gondrong.models.EventType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class EventRequest {

    private String url;

    private String title;

    private LocalDateTime date;

    private String about;

    private String host;

    private EventType eventType;

    private String place;

    private Long userId ;

}
