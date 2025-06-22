#


🧰 BƯỚC 1: Cài đặt OpenCV cho Java  
## ✅ Tải thư viện OpenCV
Vào trang chính: https://opencv.org/releases
Giải nén, vào thư mục opencv/build/java/ → bạn sẽ thấy file opencv-xxx.jar và thư mục x64/ (chứa file .dll hoặc .so).
## ✅ Thêm vào project:
Thêm opencv-xxx.jar vào thư viện project Java (nếu dùng IDE như IntelliJ/Eclipse).
Cấu hình VM options để Java biết đường dẫn file .dll:
-Djava.library.path="path/to/opencv/build/java/x64"
📌 Ví dụ IntelliJ:
Vào Run > Edit Configurations > VM options → dán dòng trên.
Nếu là project Maven thì thêm dòng này vào file pom.xml
"<!-- https://mvnrepository.com/artifact/org.bytedeco/opencv-platform -->
<dependency>
    <groupId>org.bytedeco</groupId>
    <artifactId>opencv-platform</artifactId>
    <version>4.10.0-1.5.11</version>
</dependency>"


# 🧪 BƯỚC 2: Viết code so sánh ảnh UI
✅ Ảnh cần:
baseline.png (ảnh UI đúng).

current.png (ảnh UI hiện tại bạn chụp bằng Selenium).

✅ Code so sánh ảnh (Java + OpenCV):

# 📸 BƯỚC 3: Dùng Selenium chụp giao diện (current.png)


