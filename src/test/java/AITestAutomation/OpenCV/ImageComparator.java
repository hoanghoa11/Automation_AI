package AITestAutomation.OpenCV;


import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.List;

public class ImageComparator {
        static {
            System.load("D:\\opencv\\build\\java\\x64\\opencv_java4110.dll");
            // load thư viện native
        }

        public static void main(String[] args) {
            String baselinePath = "baseline.png";
            String currentPath = "current.png";

            Mat img1 = Imgcodecs.imread(baselinePath);
            Mat img2 = Imgcodecs.imread(currentPath);

            // Resize nếu cần
            if (!img1.size().equals(img2.size())) {
                Imgproc.resize(img2, img2, img1.size());
            }

            Mat diff = new Mat();
            Core.absdiff(img1, img2, diff);

            Mat gray = new Mat();
            Imgproc.cvtColor(diff, gray, Imgproc.COLOR_BGR2GRAY);

            Mat thresh = new Mat();
            Imgproc.threshold(gray, thresh, 30, 255, Imgproc.THRESH_BINARY);

            // Tính % khác biệt
            double diffPercent = Core.countNonZero(thresh) * 100.0 / (thresh.rows() * thresh.cols());
            System.out.println("Khác biệt giao diện: " + diffPercent + "%");

            // Tìm vùng khác biệt
            List<MatOfPoint> contours = new java.util.ArrayList<>();
            Mat hierarchy = new Mat();
            Imgproc.findContours(thresh, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

            // Vẽ khung đỏ lên ảnh gốc
            Mat result = img2.clone();
            for (MatOfPoint contour : contours) {
                Rect rect = Imgproc.boundingRect(contour);
                Imgproc.rectangle(result, rect, new Scalar(0, 0, 255), 2); // đỏ
            }

            // Lưu ảnh highlight vùng thay đổi
            Imgcodecs.imwrite("diff_highlighted.png", result);

            if (diffPercent > 1.0) {
                System.out.println("⚠️ UI thay đổi đáng kể! Xem ảnh diff_highlighted.png để xem vùng khác.");
            } else {
                System.out.println("✅ UI ổn định.");
            }
        }
    }


