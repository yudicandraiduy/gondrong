package com.iduy.gondrong.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
public class LocationResponse implements Serializable {
    private long id;
    private String address;
    private String neighbourhood;
    private  String hamlet;
    private String village;
    private  String subDistrct;
    private String regency;
    private String province;
    private String postalCode;

}
