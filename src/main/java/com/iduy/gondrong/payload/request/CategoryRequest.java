package com.iduy.gondrong.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CategoryRequest implements Serializable {
    private String name;
    private String entityName;
}
