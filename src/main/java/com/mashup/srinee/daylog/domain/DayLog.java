package com.mashup.srinee.daylog.domain;

import com.mashup.srinee.daylog.dto.DayLogDTO;
import com.mashup.srinee.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class DayLog {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer seq;

    @Column
    private String title;

    @Column
    private String content;

    @CreatedDate
    @Column
    private LocalDateTime createDate = LocalDateTime.now();

    @LastModifiedDate
    @Column
    private LocalDateTime updateDate = LocalDateTime.now();

    @JoinColumn(name = "user_seq")
    @ManyToOne
    private User user;

    @Builder
    public DayLog(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public void update(DayLogDTO dayLogDTO) {
        this.title = dayLogDTO.getTitle();
        this.content = dayLogDTO.getContent();
        this.updateDate = LocalDateTime.now();
    }
}
