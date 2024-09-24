package com.example.demo.base;

import lombok.Data;

import java.util.List;

@Data
public class BaseResponse {
    List<ErrorDetail> errors;
}
