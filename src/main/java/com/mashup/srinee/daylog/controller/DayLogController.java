package com.mashup.srinee.daylog.controller;


import com.mashup.srinee.common.Response;
import com.mashup.srinee.common.ResponseCode;
import com.mashup.srinee.common.ResponseMessage;
import com.mashup.srinee.daylog.dto.DayLogDTO;
import com.mashup.srinee.daylog.service.DayLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "/daylog")
@RestController
public class DayLogController {

    private final DayLogService dayLogService;

    @PostMapping("/write")
    public Response write(@RequestBody DayLogDTO dayLogDTO) {
        try{
            return Response.builder().responseCode(ResponseCode.SUCCESS).responseData(dayLogService.writeDayLog(dayLogDTO)).build();
        } catch(Exception e) {
            return Response.builder().responseCode(ResponseCode.FAIL).responseData(ResponseMessage.DAY_LOG_CREATE_FAIL).build();
        }
    }

    @GetMapping("/read/{dayLogSeq}")
    public Response read(@PathVariable("dayLogSeq") Integer dayLogSeq) {
        try{
            return Response.builder().responseCode(ResponseCode.SUCCESS).responseData(dayLogService.readDayLog(dayLogSeq)).build();
        } catch(Exception e) {
            return Response.builder().responseCode(ResponseCode.FAIL).responseData(ResponseMessage.DAY_LOG_CREATE_FAIL).build();
        }
    }

    @GetMapping("/list")
    public Response list() {
        try{
            return Response.builder().responseCode(ResponseCode.SUCCESS).responseData(dayLogService.getDayLogList()).build();
        } catch(Exception e) {
            return Response.builder().responseCode(ResponseCode.FAIL).responseData(ResponseMessage.DAY_LOG_CREATE_FAIL).build();
        }
    }
    @PutMapping("/update")
    public Response update(@RequestBody DayLogDTO dayLogDTO) {
        try{
            return Response.builder().responseCode(ResponseCode.SUCCESS).responseData(dayLogService.updateDayLog(dayLogDTO)).build();
        } catch(Exception e) {
            return Response.builder().responseCode(ResponseCode.FAIL).responseData(ResponseMessage.DAY_LOG_UPDATE_FAIL).build();
        }
    }

    @DeleteMapping("/delete/{dayLogSeq}")
    public Response delete(@PathVariable("dayLogSeq") Integer dayLogSeq) {
        try{
            dayLogService.deleteDayLog(dayLogSeq);
            return Response.builder().responseCode(ResponseCode.SUCCESS).responseData(ResponseMessage.DAY_LOG_DELETE_SUCCESS).build();
        } catch(Exception e) {
            return Response.builder().responseCode(ResponseCode.FAIL).responseData(ResponseMessage.DAY_LOG_DELETE_FAIL).build();
        }
    }
}
