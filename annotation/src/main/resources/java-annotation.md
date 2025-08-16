s# 📌 Java Annotation

## 1. Annotation là gì?
**Annotation** là một siêu dữ liệu (metadata) gắn kèm vào **class**, **method**, **field**, **parameter** hoặc các thành phần khác trong Java.
- Không ảnh hưởng trực tiếp đến logic chương trình.
- Được dùng để cung cấp thông tin cho **trình biên dịch** hoặc **các công cụ/framework** tại compile-time hoặc runtime.

Ví dụ:
```java
@Override
public String toString() {
    return "Hello";
}
```
Ở đây `@Override` cho trình biên dịch biết method này ghi đè từ class cha.

---

## 2. Lợi ích của Annotation
- **Giúp code rõ nghĩa hơn**: Gắn ý nghĩa đặc biệt cho một đoạn code.
- **Giảm code lặp lại**: Thay thế các cấu hình XML bằng annotation.
- **Tích hợp với framework**: Spring, Hibernate, JUnit... đều dùng annotation để cấu hình.
- **Xử lý động**: Có thể đọc annotation bằng Reflection và thay đổi hành vi chương trình.

---

## 3. Các loại Annotation trong Java

### 3.1. Built-in Annotation
Java cung cấp sẵn một số annotation cơ bản:
- `@Override` – Xác nhận method ghi đè.
- `@Deprecated` – Đánh dấu method/class không nên dùng nữa.
- `@SuppressWarnings` – Bỏ qua cảnh báo của compiler.

Ví dụ:
```java
@Deprecated
public void oldMethod() {
    // code cũ
}
```

---

### 3.2. Meta-Annotation
Annotation dành để định nghĩa annotation khác:
- `@Target` – Xác định annotation áp dụng cho đâu (class, method, field…).
- `@Retention` – Quy định annotation tồn tại đến mức nào:
  - `SOURCE` – Chỉ tồn tại khi compile, không vào bytecode.
  - `CLASS` – Có trong bytecode, nhưng không load vào runtime.
  - `RUNTIME` – Có thể truy cập bằng Reflection khi chạy.
- `@Documented` – Đưa annotation vào JavaDoc.
- `@Inherited` – Annotation có thể kế thừa bởi subclass.

---

### 3.3. Custom Annotation (Annotation tùy chỉnh)
Bạn có thể tự tạo annotation cho mục đích riêng.

Ví dụ:
```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Loggable {
    String value() default "INFO";
}
```

Sử dụng:
```java
public class MyService {
    @Loggable("DEBUG")
    public void doSomething() {
        System.out.println("Doing something...");
    }
}
```

---

## 4. Đọc Annotation bằng Reflection
Ví dụ đọc `@Loggable` khi runtime:
```java
import java.lang.reflect.Method;

public class AnnotationReader {
    public static void main(String[] args) throws Exception {
        for (Method method : MyService.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Loggable.class)) {
                Loggable loggable = method.getAnnotation(Loggable.class);
                System.out.println("Method: " + method.getName() +
                                   ", Level: " + loggable.value());
            }
        }
    }
}
```

---

## 5. Ứng dụng thực tế của Annotation
- **Spring**: `@Controller`, `@Service`, `@Autowired`
- **Hibernate**: `@Entity`, `@Table`, `@Column`
- **JUnit**: `@Test`, `@Before`, `@After`
- **REST API**: `@GetMapping`, `@PostMapping`

---

## 6. Kết luận
- Annotation giúp tách biệt **logic xử lý** và **cấu hình**.
- Phù hợp cho các framework cần meta-data để xử lý tự động.
- Kết hợp với **Reflection** hoặc **AOP** để thay đổi hành vi chương trình một cách linh hoạt.

> 💡 Mẹo: Khi thiết kế annotation, hãy xác định rõ **Retention** và **Target** để tránh lạm dụng hoặc dùng sai ngữ cảnh.
