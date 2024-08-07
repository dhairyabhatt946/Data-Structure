import java.util.Scanner;

public class Lab4_27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isLowerCase(ch)) {
                sb.append(Character.toUpperCase(ch));
            }
            else if(Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
            else {
                sb.append(ch);
            }
        }
        System.out.println("Updated string: \n"+sb);
        sc.close();
    }
}
