package com.iduy.gondrong.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class LocationRequest implements Serializable {
    private String address;
    private String neighbourhood;
    private String hamlet;
    private String village;
    private String subDistrict;
    private String regency;
    private String province;
    private String postalCode;
}
