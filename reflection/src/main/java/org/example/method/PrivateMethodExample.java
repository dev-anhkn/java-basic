package org.example.method;

import java.lang.reflect.Method;

public class PrivateMethodExample {

    public static void main(String[] args) throws Exception {

        PrivateMethod privateMethod = new PrivateMethod();
        //privateMethod.displayMessage("Message"); // Không gọi được trực tiếp

        // Gọi phương thức private
        Method method = PrivateMethod.class.getDeclaredMethod("displayMessage", String.class);
        method.setAccessible(true); // Cho phép truy cập phương thức private
        method.invoke(privateMethod, "Chào mừng bạn đến với Reflection!"); // Gọi phương thức
    }
}