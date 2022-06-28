package com.iduy.gondrong.payload.response;

import com.iduy.gondrong.util.ServiceOption;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Time;
@Setter
@Getter
public class CompanyResponse implements Serializable {
    private String id;
    private String companyName;
    private ServiceOption serviceOption;
    private String areaServed;
    private Time hoursStart;
    private Time hoursEnd;
    private String phoneNumber;
    private String imageUrl;


}
