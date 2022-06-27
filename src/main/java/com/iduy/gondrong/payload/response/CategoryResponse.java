package com.iduy.gondrong.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CategoryResponse implements Serializable {
    private Integer id;
    private String name;
    private String entityName;
}
