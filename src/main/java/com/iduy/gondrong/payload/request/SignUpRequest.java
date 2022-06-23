package com.iduy.gondrong.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SignUpRequest implements Serializable {
    private String username;
    private String password;
    private String email;
    Set<String> role = new HashSet<>();
}
