1. 📌 ĐỊNH NGHĨA (DEFINITION)
    - Thuộc nhóm: Structural Design Pattern
    - Cho phép thêm (hoặc thay đổi) các chức năng cho một object cụ thể mà không làm thay đổi code của class gốc hoặc
      ảnh hưởng đến các object khác cùng class.
    - Đạt được điều này bằng cách bọc object ban đầu bằng các class “decorator” bổ sung chức năng mới một cách linh
      hoạt.

2. ❓ VẤN ĐỀ (PROBLEM)
    - Khi muốn mở rộng chức năng cho một đối tượng (ví dụ: thêm log, thêm kiểm tra quyền, nén dữ liệu, mã hóa…) mà không
      thể hoặc không nên sửa trực tiếp class gốc.
    - Sử dụng kế thừa (subclass) để mở rộng có thể dẫn tới:
    - Số lượng subclass tăng nhanh (class explosion).
    - Cứng nhắc, không thể linh hoạt bật/tắt hoặc kết hợp nhiều chức năng động.
    - Cần một giải pháp cho phép kết hợp, thêm bớt tính năng động cho từng instance.

3. 🚩 MỤC ĐÍCH (INTENT)
    - Cho phép thêm các tính năng mới cho object hiện tại bằng cách bọc object đó trong các decorator mà không cần chỉnh
      sửa code class gốc.
    - Hỗ trợ kết hợp nhiều decorator với nhau, giúp linh hoạt bật/tắt hoặc phối hợp chức năng theo yêu cầu runtime.
    - Đáp ứng nguyên tắc Mở/Đóng (Open/Closed Principle): mở rộng chức năng mà không sửa code gốc.

4. ⚙️ THÀNH PHẦN (COMPONENTS)
    - Component: Interface hoặc abstract class định nghĩa các phương thức chung.
    - ConcreteComponent: Cài đặt thực tế của Component, là đối tượng cần được “trang trí”.
    - Decorator: Class trừu tượng/abstract implement lại Component, chứa reference đến Component (composition).
    - ConcreteDecorator: Class kế thừa Decorator, thêm chức năng mới trước/hoặc sau khi gọi tới Component gốc.

5. 🔑 KHI NÀO DÙNG (APPLICABILITY)
    - Cần thêm mới, kết hợp nhiều chức năng cho object mà không cần sửa hoặc kế thừa class gốc.
    - Khi muốn bật/tắt linh hoạt các tính năng theo nhu cầu runtime.
    - Khi kế thừa dẫn đến quá nhiều subclass hoặc class hierarchy phức tạp.
    - Khi muốn mở rộng chức năng động cho từng instance mà không ảnh hưởng instance khác.
    - Ví dụ thực tế:
        - Bổ sung logging, validation, security cho service.
        - Xử lý dữ liệu: nén, mã hóa, ghi log, retry… cho file/network stream.
        - UI component: thêm border, scroll, background cho widget.

6. ✅ ƯU ĐIỂM (ADVANTAGES)
    - ✅ Linh hoạt: Có thể thêm, bớt, phối hợp nhiều chức năng động tại runtime.
    - ✅ Không ảnh hưởng code gốc: Không cần sửa class gốc, tránh rủi ro bug.
    - ✅ Nguyên tắc mở-đóng: Mở rộng tính năng dễ dàng mà không phá vỡ code cũ.
    - ✅ Tổ hợp tự do: Có thể kết hợp nhiều decorator với nhau theo nhu cầu.

7. ❌ NHƯỢC ĐIỂM (DISADVANTAGES)
    - ❌ Tạo nhiều object: Một chuỗi decorator có thể tạo ra nhiều instance lồng nhau, khó debug.
    - ❌ Khó trace luồng thực thi: Nếu decorator lồng nhiều lớp, việc đọc code và trace logic trở nên phức tạp.
    - ❌ Tạo nhiều class nhỏ: Dễ phát sinh nhiều class nhỏ lẻ, khó quản lý khi hệ thống lớn.

8. 🔧 CÁC CÁCH TRIỂN KHAI PHỔ BIẾN
    - Decorator kế thừa Dễ implement, rõ ràng Cứng nhắc nếu thêm nhiều chức năng
    - Decorator sử dụng composition Dễ kết hợp, linh hoạt Dễ tạo nhiều object lồng nhau
    - Dùng anonymous class (Java 8+)    Gọn nhẹ cho trường hợp đơn giản Không dùng được cho logic phức tạp

9. 🌟 VÍ DỤ THỰC TẾ (REAL-LIFE EXAMPLES)
    - Java I/O: InputStream → BufferedInputStream, DataInputStream, GZIPInputStream... đều là decorator bọc object
      InputStream
      để thêm chức năng.
    - Spring AOP: Các proxy AOP thực chất là decorator để thêm log, security, transaction cho method.
    - UI Framework: Thêm border, scroll, hiệu ứng cho component (Swing, JavaFX).
    - HttpClient: Bọc HttpClient bằng decorator để thêm retry, log, caching…

10. 🧪 Best Practices
    - Tối ưu decorator cho các tính năng độc lập, có thể phối hợp tự do.
    - Giữ interface của Component và Decorator đơn giản, rõ ràng.
    - Không lạm dụng decorator cho các logic phức tạp khó debug, nên combine với các pattern khác (Proxy, Chain of
      Responsibility…).
    - Nếu có thể, document rõ luồng lồng nhau để dễ bảo trì.
    - Sử dụng factory/builder để tự động phối hợp decorator khi cấu hình nhiều lớp.

* ✅ Tổng kết:
    - Decorator Pattern là giải pháp mạnh mẽ để mở rộng chức năng động cho object, đặc biệt hữu ích khi cần phối hợp
      linh hoạt nhiều tính năng mà không ảnh hưởng tới code gốc hoặc hệ thống kế thừa cứng nhắc. Tuy nhiên, cần kiểm
      soát số lượng decorator và document rõ để tránh code khó đọc, khó bảo trì về sau.