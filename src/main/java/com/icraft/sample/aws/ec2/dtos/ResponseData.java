package com.icraft.sample.aws.ec2.dtos;

import com.icraft.sample.aws.ec2.enums.Code;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class ResponseData<T> {
    private Code code;
    private String url;
    private LocalDateTime time;
    private String message;
    private T data;

    private ResponseData() {
    }

    public ResponseData(Code code, String message, T data, String url, LocalDateTime now) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.url = url;
        this.time = now;

    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Code getCode() {
        return code;
    }

    public static <T> ResponseData ofSuccess(HttpServletRequest request, String message, T data) {
        return new ResponseData(Code.SUCCESS, message, data, request.getRequestURL().toString(), LocalDateTime.now());
    }
}
