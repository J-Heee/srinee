package com.mashup.srinee.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer seq;

    @Column(unique = true)
    private String id;

    @Column
    private String password;

    @Column
    private String name;

    @Builder
    public User(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }
}
