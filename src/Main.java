import java.util.Scanner;

public class Main {
    public static String RectangleArea(String[] strArr) {
        if (strArr.length != 4) {
            throw new IllegalArgumentException("Invalid length of String for creating a rectangle!");
        }
        Integer x1 = Integer.parseInt(String.valueOf(strArr[0].charAt(1)));
        Integer y1 = Integer.parseInt(String.valueOf(strArr[0].charAt(3)));
        Integer height = 0;
        Integer weight = 0;

        for (int i = 0; i < 4; i++) {
            if (Integer.parseInt(String.valueOf(strArr[i].charAt(1))) == x1) {
                weight = Math.abs(x1 - Integer.parseInt(String.valueOf(strArr[i].charAt(3))));
            }
            if (Integer.parseInt(String.valueOf(strArr[i].charAt(3))) == y1) {
                height = Math.abs(y1 - Integer.parseInt(String.valueOf(strArr[i].charAt(1))));
            }
        }
        return String.valueOf(weight * height);
    }

    public static void main(String[] args) {
        String[] str = {"(0 0)", "(1 0)", "(1 1)", "(0 1)"};
        Scanner s = new Scanner(System.in);
        System.out.print(RectangleArea(str));
    }
}
