import java.util.Scanner;
import org.apfloat.Apfloat;

import function.Function1;
import secant.Secant;
import bisection.Bisection;

public class Main {
	
	private int scale;

	public int getScale() {
		return scale;
	}

	public static void main(String[] args) {
		new Main();
	}

	Main() {
		start();
	}

	void start() {
		Scanner input = new Scanner(System.in);
		System.out.println("Podaj dokładność");
		String s = input.nextLine();
		Apfloat accuracy = new Apfloat(s, Apfloat.INFINITE);
		if(accuracy.compareTo(Apfloat.ONE) > 0 || accuracy.compareTo(Apfloat.ZERO) <= 0) {
			System.out.println("dokładność musi być z przedziału (0, 1>");
			System.exit(1);
		}
		//współczynnik 2
		scale = (2 * - (int)accuracy.scale()) + 2;
		//System.out.println(scale);
		System.out.println("Podaj a > 0");
		s = input.nextLine();
		Apfloat a = new Apfloat(s, scale);
		if(a.compareTo(Apfloat.ZERO) < 0) {
			System.out.println("a musi być wieksze od 0");
			System.exit(1);
		}
		System.out.println("Podaj b wieksze od a");
		s = input.nextLine();
		Apfloat b = new Apfloat(s, scale);
		if(b.compareTo(a) < 0) {
			System.out.println("b musi być wieksze od a");
			System.exit(1);
		}
		if(Function1.f(b).signum() == Function1.f(a).signum()) {
			System.out
					.println("dla podanych a i b funkcja musi być różnych znaków");
			System.exit(2);
		}
		Bisection bisection = new Bisection();
		Apfloat wynikBisection = bisection.find(a, b, accuracy);
		Secant secant = new Secant();
		Apfloat wynikSecant = secant.find(a, b, accuracy);
		String wynikBisectionString = wynikBisection.toString(true).substring(0, 3 - (int)accuracy.scale());
		String wynikSecantString = wynikSecant.toString(true).substring(0, 3 - (int)accuracy.scale());
		System.out.println(wynikBisectionString);
		System.out.println(wynikSecantString);
		input.close();
	}
}
