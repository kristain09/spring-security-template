package com.example.security.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
@Getter
@Setter
public class User { // don't use user details in here
    @Id
    private Long id;
    private String username;
    private String password;
    private String authority;
}
