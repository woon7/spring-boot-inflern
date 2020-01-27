package com.example.demo3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SampleController
 */
@Controller
public class SampleController {

    @GetMapping("/hello")
    public String hello() {
        throw new SampleException();
    }

    /**
     * ExceptionHandler를 주석처리하면
     * 동적 Error page 출력이
     * 정적 Error page 출력으로 변경됨
     * 결과적으로 classpath:/static/error/5xx.html 출력
     */
    // @ExceptionHandler(SampleException.class)
    // public @ResponseBody AppError sampleError(SampleException e) {
    //     AppError appError = new AppError();
    //     appError.setMessage("error.app.key");
    //     appError.setReason("IDK IDK IDK");
    //     return appError;
    // }
}