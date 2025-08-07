package org.example.utils;

/**
 * Đây là class demo javadoc với các thẻ đặc biệt
 */
public class SpecialUtil {

    /**
     * Tính tổng hai số nguyên.
     *
     * @param a Số nguyên thứ nhất
     * @param b Số nguyên thứ hai
     * @return Tổng của hai số a và b
     * @throws IllegalArgumentException Nếu giá trị quá lớn gây tràn số
     */
    public int sum(int a, int b) {
        if (a > Integer.MAX_VALUE - b) {
            throw new IllegalArgumentException("Giá trị quá lớn");
        }
        return a + b;
    }

    /**
     * Tính hiệu hai số nguyên.
     *
     * @param a Số bị trừ
     * @param b Số trừ
     * @return Hiệu của a và b
     * @see #sum(int, int) Phương thức tính tổng hai số
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Kiểm tra xem một số có phải là số chẵn hay không.
     *
     * @param number Số cần kiểm tra
     * @return {@code true} nếu là số chẵn, ngược lại trả về {@code false}
     * @see Math#abs(int)
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }


    /**
     * Sử dụng toán tử {@literal <} và {@literal >} để so sánh hai số.
     *
     * <p>Ví dụ sử dụng:</p>
     * <pre>
     * {@code
     * boolean result = compare(5, 10);
     * }
     * </pre>
     *
     * @param a Số thứ nhất
     * @param b Số thứ hai
     * @return {@code true} nếu a {@literal <} b, ngược lại trả về {@code false}
     */
    public boolean compare(int a, int b) {
        return a < b;
    }


}
