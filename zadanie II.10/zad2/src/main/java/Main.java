import java.util.Scanner;
import org.apfloat.Apfloat;
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
		//współczynnik 2
		scale = -2 * (int)accuracy.scale();
		//System.out.println(scale);
		System.out.println("Podaj a > 0");
		s = input.nextLine();
		Apfloat a = new Apfloat(s, scale);
		System.out.println("Podaj b wieksze od a");
		s = input.nextLine();
		Apfloat b = new Apfloat(s, scale);
		Bisection bisection = new Bisection();
		Apfloat wynikBisection = bisection.find(a, b, accuracy);
		Secant secant = new Secant();
		Apfloat wynikSecant = secant.find(a, b, accuracy);
		System.out.println(wynikBisection);
		System.out.println(wynikSecant);
		input.close();
	}
}
