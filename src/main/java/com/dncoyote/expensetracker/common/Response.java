package com.dncoyote.expensetracker.common;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response<Data> {

    private Long timestamp = new Date().getTime();
    private String message;
    private Data data;

    public Response(String message, Data data) {
        this.message = message;
        this.data = data;
    }
}