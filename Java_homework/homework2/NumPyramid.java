import java.util.Scanner;

public class NumPyramid {
    public static void main(String[] args) {
        int layer=0;
        System.out.println("Input the num of layer:");
        try (Scanner scan = new Scanner(System.in)) {
            layer=scan.nextInt();
        }
        System.out.println("The pyramid:");
        for(int i=0;i<layer;i++){
            System.out.print(" ".repeat(2*layer-2*i)); //先打出空格
            for(int j=0;j<=i;j++){
                System.out.print(2*j+1+" ");
            }
            for(int j=i-1;j>=0;j--){
                System.out.print(2*j+1+" ");
            }
            System.out.print("\n");
        }
    }
}
