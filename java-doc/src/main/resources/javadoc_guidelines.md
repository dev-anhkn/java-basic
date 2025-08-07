# 📘 JavaDoc Guidelines – Full Notes

## ✅ I. JavaDoc là gì?

**JavaDoc** là công cụ tích hợp sẵn trong JDK giúp:

- Sinh tài liệu HTML từ các chú thích (comments) trong mã nguồn Java.
- Giao diện tài liệu giúp lập trình viên hiểu rõ hơn về class, method, biến, v.v.

---

## ✅ II. Vị trí sử dụng JavaDoc

JavaDoc nên được đặt **ngay trên phần khai báo** của:

- `class`, `interface`, `enum`
- `method` và `constructor`
- `field` (biến thành viên)
- `package-info.java` (ghi chú cấp package)

---

## ✅ III. Cú pháp cơ bản

```java
/**
 * [Mô tả ngắn gọn chức năng của phần tử]
 *
 * [Mô tả chi tiết hơn nếu cần]
 *
 * @param <tên biến>    Mô tả tham số truyền vào (chỉ với method)
 * @return Mô tả giá trị trả về (nếu có)
 * @throws Exception    Mô tả nếu có thể ném exception
 * @see                 Liên kết tới class/method liên quan
 * @since Phiên bản từ khi có
 * @author Tác giả
 * @version Phiên bản
 */
```

---

## ✅ IV. Ví dụ JavaDoc đầy đủ

### 1. Class

```java
/**
 * Lớp xử lý các phép toán số học cơ bản.
 *
 * @author Trâu
 * @version 1.0
 * @since 2025-08-07
 */
public class Calculator {
}
```

### 2. Method

```java
/**
 * Cộng hai số nguyên.
 *
 * @param a Số thứ nhất
 * @param b Số thứ hai
 * @return Tổng của a và b
 */
public int add(int a, int b) {
    return a + b;
}
```

### 3. Constructor

```java
/**
 * Khởi tạo đối tượng người dùng với tên và tuổi.
 *
 * @param name Tên người dùng
 * @param age  Tuổi người dùng
 */
public User(String name, int age) {
    ...
}
```

### 4. Exception

```java
/**
 * Lấy phần tử theo chỉ số.
 *
 * @param index Vị trí cần lấy
 * @return Phần tử tại vị trí đó
 * @throws IndexOutOfBoundsException Nếu index không hợp lệ
 */
public String getElement(int index) throws IndexOutOfBoundsException {
    ...
}
```

---

## ✅ V. Thẻ JavaDoc phổ biến

| Thẻ           | Dùng cho           | Ghi chú              |
|---------------|--------------------|----------------------|
| `@param`      | Method/Constructor | Tham số đầu vào      |
| `@return`     | Method             | Giá trị trả về       |
| `@throws`     | Method             | Ngoại lệ có thể ném  |
| `@author`     | Class/Interface    | Tên tác giả          |
| `@version`    | Class/Interface    | Số phiên bản         |
| `@since`      | Bất kỳ             | Từ phiên bản nào có  |
| `@see`        | Bất kỳ             | Tham chiếu liên quan |
| `@deprecated` | Bất kỳ             | Đánh dấu đã lỗi thời |

---

## ✅ VI. Lưu ý quan trọng

- **Ngắn gọn + đầy đủ + dễ hiểu**
- Mỗi dòng nên dài dưới **80 ký tự**.
- Dùng **ngôi thứ ba** (vd: *Tính tổng 2 số*, không phải *Hàm này tính tổng...*)
- Không viết kiểu "chép code ra tiếng Việt". Tập trung vào ý định, mục đích.
- Nếu sử dụng tiếng Việt, nên có cả tiếng Anh nếu dự án quốc tế.

---

## ✅ VII. Gợi ý cấu trúc JavaDoc chuẩn

```java
/**
 * [Tóm tắt: Làm gì? Dùng khi nào?]
 *
 * [Chi tiết: Ý nghĩa, cách hoạt động]
 *
 * @param ...
 * @return ...
 * @throws ...
 * @since ...
 * @author ...
 * @version ...
 * @see ...
 */
```
