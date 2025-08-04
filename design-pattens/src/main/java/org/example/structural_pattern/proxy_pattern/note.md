1. 📌 ĐỊNH NGHĨA (DEFINITION)
    - Thuộc nhóm: Structural Design Pattern
    - Cung cấp một đối tượng thay thế (proxy) cho một đối tượng khác (real object), nhằm kiểm soát truy cập, bổ sung
      hành vi hoặc tối ưu hiệu năng, mà không làm thay đổi logic của đối tượng gốc.

2. ❓ VẤN ĐỀ (PROBLEM)
    - Khi bạn cần kiểm soát việc truy cập vào một đối tượng, ví dụ:
        - Kiểm tra quyền truy cập
        - Trì hoãn khởi tạo (lazy)
        - Ghi log hoặc đếm số lần gọi
        - Cache kết quả từ đối tượng gốc
    - Nhưng bạn không muốn hoặc không thể sửa trực tiếp RealObject.

3. 🚩 MỤC ĐÍCH (INTENT)
    - Cung cấp một đối tượng thay thế (proxy) đóng vai trò trung gian để kiểm soát, bổ sung hành vi hoặc tối ưu hóa
      trước khi chuyển thao tác đến đối tượng thực (RealSubject).

4. ⚙️ THÀNH PHẦN (COMPONENTS)
    - Subject Interface định nghĩa hành vi chung
    - RealSubject Đối tượng thật, thực hiện logic chính
    - Proxy Lớp thay thế, gọi đến RealSubject và thêm logic phụ

5. 🔑 KHI NÀO DÙNG (APPLICABILITY)
    - Cần kiểm soát quyền truy cập
    - Cần lazy load (tạo khi cần)
    - Muốn cache kết quả
    - Muốn log hoặc tracking
    - Muốn bảo vệ hoặc validate trước gọi thật

6. ✅ ƯU ĐIỂM (ADVANTAGES)
    - ✅ Kiểm soát truy cập tốt Giới hạn quyền hoặc thời điểm truy cập
    - ✅ Hỗ trợ lazy-loading Tiết kiệm tài nguyên
    - ✅ Có thể ghi log, đếm lượt gọi Hữu ích cho thống kê
    - ✅ Tách biệt rõ chức năng chính và phụ

7. ❌ NHƯỢC ĐIỂM (DISADVANTAGES)
    - ❌ Thêm nhiều lớp Phức tạp hơn nếu không tổ chức tốt
    - ❌ Nếu quá nhiều proxy lồng nhau → khó debug
    - ❌ Tăng độ trễ không cần thiết nếu không tối ưu

8. 🌟 VÍ DỤ THỰC TẾ (REAL-LIFE EXAMPLES)
    - Truy cập file Kiểm tra quyền người dùng
    - REST API Client Ghi log + retry nếu lỗi
    - Cache Service Trả lại dữ liệu đã lưu, không gọi real service
    - Spring AOP Ghi log, validate, transaction, security qua proxy
    - ORM Hibernate Tạo proxy của entity để lazy-load

9. CÁC KIỂU PROXY PHỔ BIẾN
    - Virtual Proxy Chỉ tạo object thật khi cần
    - Protection Proxy Kiểm tra quyền trước khi gọi
    - Remote Proxy Giao tiếp với object ở xa (RMI, gRPC)
    - Smart Proxy Ghi log, thống kê, đếm, hạn chế
    - Cache Proxy Trả lại kết quả cũ để tiết kiệm tài nguyên