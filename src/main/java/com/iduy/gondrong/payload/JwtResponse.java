package com.iduy.gondrong.payload;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class JwtResponse implements Serializable {
    private String jwt;
    private Long id;
    private String username;
    private String email;
    private List<String> roles = new ArrayList<>();

    public JwtResponse(String jwt, Long id, String username, String email, List<String> roles) {
        this.jwt = jwt;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
