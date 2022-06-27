package com.teamfresh.project.api.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Desc 상태코드, 응답메세지, 데이터로 형식을 갖춰서 클라이언트에게 응답
 * @author ChangSu, Ham
 * @version 1.0
 */
@Data
@AllArgsConstructor
public class DefaultResponse<T> {

    private int statusCode;
    private String responseMessage;
    private T data;

    public DefaultResponse(int statusCode, String responseMessage) {
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
        this.data = null;
    }

    public static <T> DefaultResponse<T> res(int statusCode, String responseMessage) {
        return res(statusCode, responseMessage, null);
    }

    public static <T> DefaultResponse<T> res(int statusCode,String responseMessage, T t) {
        return new DefaultResponse<T>(statusCode, responseMessage, t);
    }

}
