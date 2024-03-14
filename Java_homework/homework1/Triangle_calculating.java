package Java_homework.homework1;

import java.util.Scanner;

class Triangle_checking {
    int a, b, c;

    Triangle_checking(int a1, int b1, int c1) {
        this.a = a1;
        this.b = b1;
        this.c = c1;
    }

    boolean isTriangle() {
        if (a + b > c && a + c > b && b + c > a)
            return true;
        else
            return false;
    }
}

public class Triangle_calculating {
    static int a;
    static int b;
    static int c;
    static boolean boo;
    int Tlen;
    double Taera;

    @SuppressWarnings("resource")
    public void inputing() {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入第一条边：");
        a = scan.nextInt();
        System.out.println("输入第二条边：");
        b = scan.nextInt();
        System.out.println("输入第三条边：");
        c = scan.nextInt();
    }

    public int getTriangleLength() {
        Tlen = a + b + c;
        if (boo)
            return Tlen;
        else {
            System.err.println("不构成三角形,不计算周长");
            return 0;
        }
    }

    public double getTriangleAera() {
        double p = 0.5 * Tlen;
        Taera = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        if (boo)
            return Taera;
        else {
            System.err.println("不构成三角形,不计算面积");
            return 0;
        }
    }

    public static void main(String[] args) {
        Triangle_calculating check = new Triangle_calculating();
        check.inputing();
        Triangle_checking sides = new Triangle_checking(a, b, c);
        boo = sides.isTriangle();
        System.out.println(boo);
        if(!boo) return;
        System.out.println("周长为：" + check.getTriangleLength());
        System.out.println("面积为：" + check.getTriangleAera());
    }
}
