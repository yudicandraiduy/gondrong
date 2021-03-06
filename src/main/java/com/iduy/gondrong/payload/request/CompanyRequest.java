package com.iduy.gondrong.payload.request;

import com.iduy.gondrong.util.ServiceOption;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Time;

@Setter
@Getter
public class CompanyRequest implements Serializable {
    private String companyName;
    private ServiceOption serviceOption;
    private String areaServed;
    private Time hoursStart;
    private Time hoursEnd;
    private String phoneNumber;
    private String imageUrl;
    private Long userId;
    private Long locationId;
}
