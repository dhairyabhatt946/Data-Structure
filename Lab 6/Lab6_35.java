import java.util.Scanner;

class Student_Detail {
    int enrollment_no;
    String name;
    int semester;
    float cpi;

    public Student_Detail(int enrollment_no, String name, int semester, float cpi) {
        this.enrollment_no = enrollment_no;
        this.name = name;
        this.semester = semester;
        this.cpi = cpi;
    }
    public void display() {
        System.out.println("Enrollment No. : " + enrollment_no);
        System.out.println("Name : " + name);
        System.out.println("Semester : " + semester);
        System.out.println("CPI : " + cpi);
    }
}
public class Lab6_35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        Student_Detail[] students = new Student_Detail[5];
        for (int i = 0; i < students.length; i++) {
            System.out.println("Enter details of student "+(i+1)+": ");
            System.out.print("Enter enrollment no: ");
            int enrollment_no = sc.nextInt();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter semester: ");
            int semester = sc.nextInt();
            System.out.print("Enter cpi: ");
            float cpi = sc.nextFloat();
            students[i] = new Student_Detail(enrollment_no, name, semester, cpi);
        }
        for(int i=0; i<students.length; i++) {
            System.out.println("Details of student "+(i+1)+": ");
            students[i].display();
        }
        sc.close();
        scanner.close();
    }
}
