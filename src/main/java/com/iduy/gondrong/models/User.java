package com.iduy.gondrong.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table( name ="users",uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@Proxy(lazy = false)
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotBlank
    @Size(max=20)
    private String username;

    @NotBlank
    @Size(max=50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 255)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns=@JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {

    }
}
