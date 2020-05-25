package com.mashup.srinee.daylog.dto;


import com.mashup.srinee.daylog.domain.DayLog;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class DayLogDTO {

    private Integer seq;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public DayLog toDomain() {
        return DayLog.builder().title(title).content(content).build();
    }

    public static DayLogDTO fromDomain(DayLog dayLog) {
        return new DayLogDTO(dayLog.getSeq(), dayLog.getTitle(), dayLog.getContent(), dayLog.getCreateDate(), dayLog.getUpdateDate());
    }
}
