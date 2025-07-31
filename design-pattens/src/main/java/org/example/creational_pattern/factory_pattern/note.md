1. 📌 ĐỊNH NGHĨA (DEFINITION)
   Thuộc nhóm: Creational Design Pattern (Nhóm thiết kế khởi tạo)

Mục tiêu: Cung cấp giao diện chung để tạo đối tượng, cho phép lớp con quyết định class cụ thể nào sẽ được khởi tạo.

Thay vì dùng từ khóa new, đối tượng sẽ được tạo ra thông qua phương thức factory, giúp tách biệt quá trình khởi tạo và sử dụng.

2. ❓ VẤN ĐỀ (PROBLEM)
   Khi mã client trực tiếp khởi tạo đối tượng bằng new, sẽ:

Phụ thuộc chặt vào class cụ thể (tight coupling)

Khó mở rộng, khó test, và không linh hoạt khi cần thay đổi loại đối tượng tạo ra

Cần một cách để ẩn chi tiết tạo đối tượng, chỉ quan tâm đến interface/chức năng của đối tượng đó

3. 🚩 MỤC ĐÍCH (INTENT)
   Đóng gói logic khởi tạo đối tượng trong một method riêng biệt

Tách biệt quá trình tạo đối tượng khỏi mã sử dụng đối tượng

Cho phép chương trình linh hoạt chọn loại đối tượng cụ thể tại runtime

4. ⚙️ THÀNH PHẦN (COMPONENTS)
   📌 Factory Method
   Thành phần	Vai trò
   Product	Interface hoặc abstract class cho các đối tượng được tạo
   ConcreteProductA/B	Các lớp hiện thực cụ thể của Product
   Creator	Interface hoặc abstract class có phương thức createProduct()
   ConcreteCreatorA/B	Lớp con hiện thực createProduct() để trả về ConcreteProduct cụ thể

🧱 Abstract Factory
Thành phần	Vai trò
AbstractFactory	Giao diện tạo ra nhiều sản phẩm liên quan
ConcreteFactoryA/B	Cung cấp hiện thực cụ thể cho từng họ sản phẩm
AbstractProductA/B	Giao diện của từng loại sản phẩm
ConcreteProductA1/B1	Hiện thực cụ thể của sản phẩm, tương ứng với từng factory
Client	Sử dụng AbstractFactory để làm việc với các đối tượng

5. 🔑 KHI NÀO DÙNG (APPLICABILITY)
   ✅ Factory Method:
   Khi mã client không nên biết chính xác class nào sẽ được tạo

Khi cần hoãn việc tạo đối tượng đến runtime

Khi muốn giao trách nhiệm khởi tạo cho lớp con

✅ Abstract Factory:
Khi cần tạo họ đối tượng liên quan/chức năng tương tự

Khi muốn đảm bảo các sản phẩm tạo ra tương thích với nhau

Khi hệ thống cần chuyển đổi toàn bộ họ sản phẩm dễ dàng

6. ✅ ƯU ĐIỂM (ADVANTAGES)
   ✅ Tuân thủ nguyên lý Open/Closed (mở rộng dễ, không cần sửa mã cũ)

✅ Giảm phụ thuộc vào lớp cụ thể

✅ Cho phép hoán đổi object linh hoạt khi thay đổi yêu cầu

✅ Giúp đơn vị test dễ hơn khi thay thế bằng mock objects

7. ❌ NHƯỢC ĐIỂM (DISADVANTAGES)
   ❌ Tăng số lượng class do mỗi loại sản phẩm cần factory riêng

❌ Code có thể phức tạp hơn với người mới bắt đầu

❌ Có thể bị lạm dụng nếu chỉ cần new đơn giản

8. 🔧 CÁC CÁCH TRIỂN KHAI PHỔ BIẾN
   Kiểu triển khai	Mô tả
   Factory Method	Mỗi lớp con hiện thực factory để tạo object phù hợp
   Static Factory Method	Dùng method static tạo object → dễ dùng, không cần kế thừa
   Abstract Factory	Tạo nhiều loại sản phẩm liên quan thông qua một interface
   Factory với DI/IOC	Kết hợp Spring, Guice để inject object linh hoạt

9. 🌟 VÍ DỤ THỰC TẾ (REAL-LIFE EXAMPLES)
   ✅ Factory Method:
   DocumentFactory trong các trình soạn thảo như Word, Excel

NotificationFactory tạo Email, SMS, Push Notification

✅ Abstract Factory:
GUI toolkit hỗ trợ nhiều OS: WindowsFactory, MacFactory → tạo Button, Checkbox tương ứng

Game tạo enemy, weapon khác nhau theo từng màn chơi

10. 🧪 BEST PRACTICES
    Đặt tên factory rõ ràng để phản ánh mục đích: NotificationFactory, ShapeFactory...

Nếu chỉ cần một phương thức duy nhất để tạo object → dùng static factory

Tránh lạm dụng khi không cần thiết → nếu logic tạo object đơn giản, có thể không cần Factory

Kết hợp với Strategy Pattern nếu có nhiều chiến lược tạo object khác nhau

📌 KẾT LUẬN
Factory Pattern giúp quản lý việc khởi tạo đối tượng một cách linh hoạt, tách biệt việc sử dụng và tạo mới, phù hợp cho các hệ thống cần mở rộng dễ dàng theo hướng plug-in hoặc nhiều kiểu sản phẩm tương thích. Tuy nhiên, cần cân nhắc giữa lợi ích và độ phức tạp thêm vào.