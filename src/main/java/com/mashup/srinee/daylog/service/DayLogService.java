package com.mashup.srinee.daylog.service;

import com.mashup.srinee.daylog.domain.DayLog;
import com.mashup.srinee.daylog.domain.DayLogRepository;
import com.mashup.srinee.daylog.dto.DayLogDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DayLogService {

    private final DayLogRepository dayLogRepository;

    public DayLogDTO writeDayLog(DayLogDTO dayLogDTO) {
        DayLog dayLog = dayLogDTO.toDomain();
        dayLog = dayLogRepository.save(dayLog);
        return DayLogDTO.fromDomain(dayLog);
    }

    @Transactional
    public DayLogDTO updateDayLog(DayLogDTO dayLogDTO) {
        DayLog dayLog = dayLogRepository.getOne(dayLogDTO.getSeq());
        dayLog.update(dayLogDTO);
        return DayLogDTO.fromDomain(dayLog);
    }

    public DayLogDTO readDayLog(Integer dayLogSeq) {
        DayLog dayLog = dayLogRepository.getOne(dayLogSeq);

        return DayLogDTO.fromDomain(dayLog);
    }

    public List<DayLogDTO> getDayLogList() {
        List<DayLog> dayLogs = dayLogRepository.findAll();
        return dayLogs.stream().map(DayLogDTO::fromDomain).collect(Collectors.toList());

    }

    public void deleteDayLog(Integer dayLogSeq) {
        dayLogRepository.deleteById(dayLogSeq);
    }
}
