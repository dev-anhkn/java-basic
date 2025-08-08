1. 🔰 Xác định mục tiêu áp dụng SOLID
    - Trước khi áp dụng SOLID, hãy trả lời các câu hỏi:
    - 🧩 Dự án có mở rộng trong tương lai không?
    - 🛠 Có bao nhiêu người cùng làm việc trong codebase?
    - 🔄 Code có cần dễ test, dễ thay đổi, dễ bảo trì?

    * → Nếu câu trả lời là có, thì nên tuân thủ SOLID càng sớm càng tốt để tiết kiệm chi phí dài hạn.

2. 🧠 Hiểu rõ từng nguyên tắc SOLID & thời điểm áp dụng
    - S – Single Responsibility Principle
        - Áp dụng khi một class đang làm quá nhiều việc hoặc phải sửa đổi vì nhiều lý do khác nhau.
        - → Tách class thành nhiều class nhỏ, mỗi class chỉ phụ trách một nhiệm vụ duy nhất.

    - O – Open/Closed Principle
        - Áp dụng khi cần thêm tính năng mới nhưng không muốn làm ảnh hưởng hoặc sửa đổi code cũ.
        - → Thiết kế sao cho code mở rộng được bằng kế thừa hoặc interface, nhưng không cần sửa lại logic sẵn có.

    - L – Liskov Substitution Principle
        - Áp dụng khi sử dụng kế thừa (inheritance) hoặc đa hình (polymorphism).
        - → Đảm bảo rằng class con có thể thay thế class cha mà không làm thay đổi hành vi của chương trình.

    - I – Interface Segregation Principle
        - Áp dụng khi có interface quá lớn, trong đó có nhiều phương thức không phù hợp với một số class.
        - → Chia nhỏ interface để mỗi class chỉ cần implement những gì thực sự cần dùng.

    - D – Dependency Inversion Principle
        - Áp dụng khi muốn tách rời các tầng như Controller, Service, Repository để dễ dàng test và thay thế.
        - → Code nên phụ thuộc vào abstraction (interface) thay vì phụ thuộc trực tiếp vào class cụ thể.

3. 🛠️ Áp dụng vào quá trình phát triển phần mềm

    * ✳️ BƯỚC 1: Khi viết code mới hoặc refactor code cũ
        - Bắt đầu với câu hỏi: "Class này có nhiều hơn một lý do để thay đổi không?"
            - → Nếu có → tách ra theo SRP
        - Suy nghĩ: "Nếu khách hàng thêm yêu cầu mới, tôi có phải sửa class cũ không?"
            - → Nếu có → thiết kế lại để mở rộng không sửa đổi (OCP)

    * ✳️ BƯỚC 2: Khi thiết kế kiến trúc hệ thống (tầng, module)
        - Dùng interface + Dependency Injection để:
            - Giảm phụ thuộc giữa các module (DIP)
            - Dễ viết test/unit test với mock class
            - Tách interface lớn thành interface nhỏ cho từng use case:
            - Giúp module không bị "ép dùng" những gì không cần (ISP)

    * ✳️ BƯỚC 3: Khi review code hoặc review thiết kế
        - Class này có quá nhiều trách nhiệm không? **SRP**
        - Nếu thêm tính năng mới, có phải sửa code cũ không? **OCP**
        - Class con có thể dùng thay thế class cha không lỗi? **LSP**
        - Interface có lớn và gây dư thừa cho một số class không? **ISP**
        - Có phụ thuộc cứng vào class cụ thể không? **DIP**

4. 🔍 Kết hợp SOLID với các Design Pattern
    - Strategy, Observer **OCP, LSP**
    - Factory, Abstract Factory **DIP, OCP**
    - Adapter, Decorator **OCP, LSP**
    - Repository **SRP, DIP**
    - Builder **SRP**


* 📌 KẾT LUẬN
    - “SOLID không phải là bộ luật cứng nhắc, mà là kim chỉ nam giúp bạn viết phần mềm sạch, dễ mở rộng, và có thể phát
      triển lâu dài.”