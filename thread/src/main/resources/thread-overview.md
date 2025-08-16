# 📌 Tại sao trong lập trình đồng thời, người ta nói nhiều về Thread hoặc bắt đầu từ Thread?

## 1. Thread là nền tảng cơ bản của lập trình đồng thời
- Thread (luồng) là **đơn vị cơ bản nhất** để thực hiện nhiều tác vụ cùng lúc trong một tiến trình (process).
- Mỗi thread có thể thực thi một đoạn mã độc lập, **chia sẻ tài nguyên** với các thread khác trong cùng tiến trình.
- Tất cả các mô hình lập trình đồng thời hiện đại (thread pool, actor, coroutine, async/await…) đều xây dựng hoặc lấy cảm hứng từ cơ chế thread truyền thống.

## 2. Vì sao lại bắt đầu từ thread?

### a. Là khái niệm gốc, dễ hình dung
- Khi nói về lập trình đồng thời, thread là đơn vị “thực thi song song” mà lập trình viên dễ hiểu và dễ kiểm soát nhất.
- Trước khi các mô hình cao cấp hơn ra đời, thread là cách duy nhất để chạy song song nhiều công việc.

### b. Hiểu thread sẽ giúp hiểu sâu các mô hình cao cấp hơn
- Các framework như ExecutorService, ForkJoinPool, RxJava, thậm chí cả async/await… đều sử dụng thread phía dưới.
- Nếu không hiểu thread, sẽ khó kiểm soát hoặc debug khi gặp vấn đề đồng thời (deadlock, race condition…).

### c. Hầu hết các hệ điều hành và ngôn ngữ đều hỗ trợ thread
- Từ Java, C/C++, Python… đến Windows, Linux đều dùng khái niệm thread như “nguyên liệu” cơ bản để xử lý đa nhiệm.

## 3. Lập trình đồng thời = làm việc với nhiều luồng
- **Lập trình tuần tự**: Code thực thi từ trên xuống dưới, một luồng duy nhất.
- **Lập trình đồng thời**: Có thể có nhiều thread chạy các phần code khác nhau cùng lúc (hoặc đan xen), tăng tốc độ, tận dụng CPU nhiều nhân.

## 4. Thread giúp giải quyết các vấn đề thực tế nào?
- **Xử lý song song**: tải nhiều file cùng lúc, xử lý nhiều request...
- **Giao diện mượt mà**: UI chạy ở thread chính, công việc nặng chạy ở thread phụ để tránh treo UI.
- **Tận dụng CPU đa nhân**: Thread giúp khai thác tối đa sức mạnh CPU nhiều core.

## 5. Những mô hình hiện đại vẫn dựa trên thread
- **Thread pool**: Quản lý tập hợp các thread để thực hiện nhiều task liên tục.
- **ExecutorService**: Quản lý thread pool trong Java.
- **Future/CompletableFuture**: Xử lý bất đồng bộ, nhưng thực chất vẫn chạy trên các thread.
- **Reactive (RxJava, Reactor…)**: Ẩn thread đi, nhưng bên dưới vẫn dùng thread.

## 6. Tóm tắt
> Thread là **viên gạch đầu tiên** của lập trình đồng thời. Hiểu thread giúp bạn nắm được các mô hình cao cấp hơn và tránh lỗi như deadlock, race condition.

--- 

## 🧵 Trạng thái của Thread

| Trạng thái       | Ý nghĩa | Khi nào xảy ra |
|------------------|--------|----------------|
| **NEW**          | Thread được tạo nhưng chưa start | Khi `new Thread(...)` nhưng chưa gọi `start()` |
| **RUNNABLE**     | Thread đã được start và sẵn sàng chạy hoặc đang chạy | Sau khi gọi `start()` nhưng CPU chưa hoặc đang cấp quyền chạy |
| **BLOCKED**      | Thread đang chờ giải phóng lock để vào `synchronized` | Khi nhiều thread tranh chấp cùng một lock |
| **WAITING**      | Chờ vô thời hạn cho tới khi `notify()` hoặc `notifyAll()` | Khi gọi `wait()` không timeout |
| **TIMED_WAITING**| Chờ có giới hạn thời gian | Khi gọi `sleep(ms)`, `join(ms)`, hoặc `wait(ms)` |
| **TERMINATED**   | Thread đã kết thúc | Khi `run()` hoàn tất hoặc bị dừng |

---

## 🔒 Đồng bộ hóa trong Java

### 1. `synchronized` là gì?
- Từ khóa gốc trong Java dùng để đảm bảo **chỉ một thread** được thực thi đoạn code hoặc truy cập tài nguyên tại một thời điểm.
- Có thể dùng với **phương thức** hoặc **khối code**.

### 2. `lock()` là gì? (`java.util.concurrent.locks.Lock`)
- `Lock` là interface mới hơn (Java 5), **linh hoạt hơn** so với `synchronized`.
- Lớp phổ biến: **ReentrantLock**.
- Hỗ trợ tính năng nâng cao: **tryLock(timeout)**, unlock từ thread khác...

---

## 🗂 ThreadLocal
- `ThreadLocal` là class đặc biệt trong Java giúp **mỗi thread có biến riêng**, không chia sẻ với thread khác.
- Mỗi thread truy cập biến `ThreadLocal` sẽ thấy **một giá trị độc lập** (giống như mỗi thread có một bản copy của biến đó).
