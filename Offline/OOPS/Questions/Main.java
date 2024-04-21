 import java.util.Scanner;

class ComplexNumbers {
    int real;
    int imaginary;

    public ComplexNumbers(int real, int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public void plus(ComplexNumbers c2){
        this.real += c2.real;
        this.imaginary += c2.imaginary;
    }

    public void multiply(ComplexNumbers c2){
        int a = this.real;
        int b = this.imaginary;

        int c = c2.real;
        int d = c2.imaginary;

        int realResult = (a*c - b*d);
        int imaginaryResult = (a*d + b*c);

        this.real = realResult;
        this.imaginary = imaginaryResult;
    }

    public void print(){
        System.out.println(this.real+ " + i" + this.imaginary);
    }
}

class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int real1, imaginary1, real2, imaginary2;
		real1 = sc.nextInt(); // 1 
		imaginary1 = sc.nextInt(); // 2
		real2 = sc.nextInt(); // 3
		imaginary2 = sc.nextInt(); // 6

		ComplexNumbers c1 = new ComplexNumbers(real1, imaginary1);
		ComplexNumbers c2 = new ComplexNumbers(real2, imaginary2);

		int choice = sc.nextInt();
		if (choice == 1) {
			c1.plus(c2);
			c1.print();
		} else if (choice == 2) {
			c1.multiply(c2);
			c1.print();
		}

	}
}
 