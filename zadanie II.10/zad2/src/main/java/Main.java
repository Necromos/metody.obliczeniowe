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
		String end = "";
		String s0, s1, s2;
		Scanner input = new Scanner(System.in);
		// System.out.println(scale);
		Apfloat a, b, accuracy; 
		do {
			System.out.println("Podaj a > 0");
			s1 = input.nextLine();
			a = new Apfloat(s1, Apfloat.INFINITE);
			while (a.compareTo(Apfloat.ZERO) <= 0) {
				System.out.println("a musi być wieksze od 0");
				System.out.println("Podaj a > 0");
				s1 = input.nextLine();
				a = new Apfloat(s1, Apfloat.INFINITE);
			}
			System.out.println("Podaj b wieksze od a");
			s2 = input.nextLine();
			b = new Apfloat(s2, Apfloat.INFINITE);
			while (b.compareTo(a) <= 0) {
				System.out.println("b musi być wieksze od a");
				s2 = input.nextLine();
				b = new Apfloat(s2, Apfloat.INFINITE);
			}
			System.out.println("Podaj dokładność");
			s0 = input.nextLine();
			accuracy = new Apfloat(s0, Apfloat.INFINITE);
			while (accuracy.compareTo(Apfloat.ONE) >= 0
					|| accuracy.compareTo(Apfloat.ZERO) <= 0) {
				System.out.println("dokładność musi być z przedziału (0, 1)");
				System.out.println("Podaj dokładność");
				s0 = input.nextLine();
			}
			// współczynnik 2
			scale = (2 * -(int) accuracy.scale()) + 5;
			a = new Apfloat(s1, scale);
			b = new Apfloat(s2, scale);
			if (Function1.f(b).signum() == Function1.f(a).signum()){
				System.out.println("f(a) i f(b) są tego samego znaku");
			}
		} while (Function1.f(b).signum() == Function1.f(a).signum());
		Bisection bisection = new Bisection();
		Apfloat wynikBisection = bisection.find(a, b, accuracy);
		Secant secant = new Secant();
		Apfloat wynikSecant = secant.find(a, b, accuracy);
		String wynikBisectionString = wynikBisection.toString(true).substring(
				0, 3 - (int) accuracy.scale());
		String wynikSecantString = wynikSecant.toString(true).substring(0,
				3 - (int) accuracy.scale());
		System.out.println("Metodą połowienia: " + wynikBisectionString);
		System.out.println("Metodą siecznych: " + wynikSecantString);
		System.out.println("zakończyć?");
		end = input.nextLine();
		while (!end.equals("t")) {
			System.out.println("Podaj dokładność");
			s0 = input.nextLine();
			accuracy = new Apfloat(s0, Apfloat.INFINITE);
			if (accuracy.compareTo(Apfloat.ONE) >= 0
					|| accuracy.compareTo(Apfloat.ZERO) <= 0) {
				System.out.println("dokładność musi być z przedziału (0, 1)");
				continue;
			}
			// współczynnik 2
			scale = (2 * -(int) accuracy.scale()) + 5;
			a = new Apfloat(s1, scale);
			b = new Apfloat(s2, scale);
			wynikBisection = bisection.find(a, b, accuracy);
			wynikSecant = secant.find(a, b, accuracy);

			wynikBisectionString = wynikBisection.toString(true);
			if (3 - (int) accuracy.scale() < wynikBisectionString.length()) {
				wynikBisectionString = wynikBisectionString.substring(0,
						3 - (int) accuracy.scale());
			}
			wynikSecantString = wynikSecant.toString(true);
			if (3 - (int) accuracy.scale() < wynikSecantString.length()) {
				wynikSecantString = wynikSecantString.substring(0,
						3 - (int) accuracy.scale());
			}

			System.out.println("Metodą połowienia: " + wynikBisectionString);
			System.out.println("Metodą siecznych: " + wynikSecantString);
			System.out.println("zakończyć?");
			end = input.nextLine();
		}
		input.close();
	}
}
