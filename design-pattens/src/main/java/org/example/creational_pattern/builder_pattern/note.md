1. 📌 ĐỊNH NGHĨA (DEFINITION)
    - Thuộc nhóm: Creational Design Pattern
    - Tạo ra các đối tượng phức tạp bằng cách chia quá trình xây dựng thành nhiều bước nhỏ và có thể cấu hình linh hoạt.

2. ❓ VẤN ĐỀ (PROBLEM)
    - Khi tạo một đối tượng phức tạp với:
        - Rất nhiều thuộc tính (fields) khác nhau.
        - Nhiều thuộc tính là không bắt buộc, có thể có hoặc không.
        - Các constructor quá dài và khó hiểu.
    - Bạn không muốn tạo các constructor có quá nhiều tham số (telescoping constructor) hoặc gọi rất nhiều setters dễ
      gây lỗi.

3. 🚩 MỤC ĐÍCH (INTENT)
    - Tách biệt quá trình xây dựng một đối tượng phức tạp khỏi việc hiển thị đối tượng đó, để một quá trình xây dựng duy
      nhất có thể tạo ra nhiều biểu diễn khác nhau của đối tượng.
    - Hay nói đơn giản hơn: Xây đối tượng từng bước một cách rõ ràng, dễ hiểu và linh hoạt.

4. ⚙️ THÀNH PHẦN (Components)
    - Builder Interface/abstract class khai báo phương thức xây dựng
    - ConcreteBuilder Xây dựng từng bước đối tượng và trả lại kết quả
    - Product Đối tượng được xây dựng có nhiều thuộc tính
    - Director (optional)    Điều khiển trình tự xây dựng

5. 🔑 KHI NÀO DÙNG (APPLICABILITY)
    - Đối tượng có nhiều thuộc tính tùy chọn
    - Muốn tránh telescoping constructor (constructor dài)
    - Muốn tạo đối tượng immutable dễ dàng
    - Muốn quy trình xây dựng đối tượng rõ ràng

6. ✅ ƯU ĐIỂM (ADVANTAGES)
    - ✅ Dễ đọc, dễ hiểu Mỗi phương thức mô tả rõ từng bước
    - ✅ Dễ sử dụng, bảo trì Không cần nhớ thứ tự constructor dài
    - ✅ Đối tượng có thể immutable (bất biến)    An toàn trong đa luồng
    - ✅ Tính linh hoạt cao Dễ thay đổi trình tự xây dựng

7. ❌ NHƯỢC ĐIỂM (DISADVANTAGES)
    - ❌ Thêm nhiều class phụ Builder, ConcreteBuilder, Director
    - ❌ Đôi khi dư thừa với object đơn giản Chỉ dùng khi thực sự cần thiết
    - ❌ Có thể phức tạp hơn mức cần thiết Nếu object quá đơn giản

8. VÍ DỤ THỰC TẾ
    - Tạo đối tượng HttpClient Xây các thuộc tính: timeout, headers, proxy
    - StringBuilder trong Java Nối chuỗi từng bước
    - Tạo object request phức tạp (JSON, XML)    Thêm từng field, nested object
    - Xây dựng cấu hình phức tạp Set từng tùy chọn cấu hình

9. 🧪 Best Practices
    - Đặt class Builder là inner class nếu chỉ dùng riêng cho 1 object (Java).
    - Sử dụng method chaining (return this) để gọi liên tiếp.
    - Kết hợp với Director để chuẩn hoá quy trình tạo object.
    - Không nên dùng Builder nếu object đơn giản, ít tham số.

* KẾT LUẬN
    - Builder Pattern là mẫu thiết kế mạnh mẽ giúp xây dựng object phức tạp một cách linh hoạt và rõ ràng, tránh việc sử
      dụng constructor rối rắm hoặc setter lặp lại. Đây là một pattern phổ biến và cực kỳ hữu dụng trong thực tế, đặc
      biệt khi làm việc với UI, file, config, object có nhiều field hoặc có nhiều biến thể.