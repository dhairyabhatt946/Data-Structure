import java.util.Scanner;

public class Lab5_31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[3][2];
        int[][] b = new int[2][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<2; j++) {
                System.out.println("Enter an element at a["+i+"]["+j+"]: ");
                a[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<2; i++) {
            for(int j=0; j<3; j++) {
                System.out.println("Enter an element at b["+i+"]["+j+"]: ");
                b[i][j] = sc.nextInt();
            }
        }
        int[][] res = new int[3][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                for(int k=0; k<2; k++) {
                    res[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        System.out.println("Multiplication of two matrices: ");
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
