# Quản Lý Phòng GYMS
# GYMSmanagementSystem
## Bộ code Version 1 link github:https://github.com/VickyJang095/GYMSmanagementSystem.git
Nhóm 12:
Thành Viên:
Nguyễn Thanh Nam: 23010056
Hoàng Thị Minh Ngọc: 23010669
1. Tài Khoản login
username: admin
password: password
2. Môi trường 
      1. Apache Netbeans 23, JDK 23
3. Cơ sở dữ liệu
      1. Lữu trữ XML.
      2. Gồm cơ sở dữ liệu của khách hàng và phòng gym
4. Công nghệ sử dụng
      1. Java: Ngôn ngữ lập trình chính cho ứng dụng
      2. JavaFX: Dùng để xây dựng giao diện người dùng
      3. Maven: Công cụ quả lý dự án và thư viện
      4. API : Công cụ tự động cập nhật ngày giờ với múi giờ GMT +7
5. Cài đặt
      1. Cài đặt JDK 23 và Apache Netbeans 23
      2. Chạy ứng dụng : LoginController.java
6. Hướng dẫn sử dụng
      1. Khi ứng dụng khởi động, một cửa sổ đăng nhập sẽ xuất hiện. Nhập thông tin tài khoản đã cung cấp ở trên
      2. Chọn " Coaches " trên giao diện chính.
               Nhập thông tin cần thiết : 
               1. ID huấn luyện viên, tên huấn luyện viên, địa chỉ huấn luyện viên, giới tính, số điện thoại, trạng thái hoạt động.
               2.Chọn các tính năng như "Add" để thêm thông tin, "Update" để sửa thông tin, "Reset" để làm mới người tạo, "Delete" để xoá huấn luyện viên.
               3. Thông tin sau khi được thêm sẽ nằm ở bên phải của giao diện theo thứ tự ID.
      3. Chọn " Customer " trên giao diện chính.
               Nhập thông tin cần thiết :
               1. ID khách hàng, tên khác hàng, địa chỉ khách hàng, số điện thoại, giới tính, thời gian tập, trạng thái hoạt động, ngày bắt đầu, ngày kết thúc
               2.Chọn các tính năng như "Add" để thêm thông tin, "Update" để sửa thông tin, "Reset" để làm mới người tạo, "Delete" để xoá khách hàng.
               3. Thông tin sau khi được thêm sẽ nằm ở bên dưới của giao diện theo thứ tự ID.
      4. Chọn " Payment " trên giao diện chính.
               Nhập các thông tin cần thiết :
               1. ID khách hàng, tên khách hàng, ngày bắt đầu, ngày kết thúc, số tiền thanh toán.
               2. Chọn "PAY" để thanh toán và thông tin sẽ được hiển thị bên trái của giao diện.
         
      5. Chọn " Search " để tìm kiếm thông tin khách hàng theo ID của khách hàng.
               Nhập các thông tin cần thiết :
               1. ID khách hàng.
               2. Chọn "Search" để tìm kiếm thông tin khách hàng và sẽ được hiển thị ở bên dưới giao diện.
      7. Chọn " Logout " để đăng xuất tài khoản  và quay lại giao diện đăng nhập  
