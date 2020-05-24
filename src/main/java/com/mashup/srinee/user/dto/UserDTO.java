package com.mashup.srinee.user.dto;

import com.mashup.srinee.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDTO {

    private Integer seq;
    private String id;
    private String password;
    private String name;

    public User toDomain() {
        return User.builder().id(id).password(password).name(name).build();
    }

    public UserDTO fromDomain(User user) {
        this.seq = user.getSeq();
        this.id = user.getId();
        this.password = user.getPassword();
        this.name = user.getName();
        return this;
    }

}
