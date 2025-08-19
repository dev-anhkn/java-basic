package org.example.asynchronous_exception.exceptionally;

import java.util.function.Function;

public class WeatherExceptionFunction implements Function<Throwable, String> {

    @Override
    public String apply(Throwable ex) {
        System.out.println("ExceptionFunction: Xảy ra lỗi: " + ex.getMessage());
        return "ExceptionFunction: Không thể lấy dữ liệu thời tiết, vui lòng thử lại sau.";
    }
}
