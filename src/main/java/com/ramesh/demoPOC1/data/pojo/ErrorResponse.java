package com.ramesh.demoPOC1.data.pojo;

import java.time.LocalDateTime;
import java.time.ZoneId;


import com.ramesh.demoPOC1.data.GlobalVariables;

import lombok.Data;
@Data
public class ErrorResponse {
    private LocalDateTime utcTime;
    private String status;
    private String code;
    private String message;
    public ErrorResponse(String status, String code, String message){
        this.utcTime=LocalDateTime.now(ZoneId.of(GlobalVariables.TIME_ZONE));
        this.status=status;
        this.code=code;
        this.message=message;
    }
}
