package org.example.asynchronous_exception.handle;

import java.util.function.BiFunction;

public class WeatherHandleFunction implements BiFunction<String, Throwable, String> {
    @Override
    public String apply(String result, Throwable ex) {
        if (ex != null) {
            System.out.println("HandleFunction: Xảy ra lỗi: " + ex.getMessage());
            return "HandleFunction: Không thể lấy dữ liệu thời tiết, vui lòng thử lại sau.";
        }
        return result;
    }
}