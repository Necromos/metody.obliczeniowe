package secant;

import org.apfloat.Apfloat;

import function.Function1;

public class Secant {

	public Apfloat find(Apfloat x0, Apfloat x1, Apfloat accuracy) {
		accuracy = accuracy.divide(new Apfloat(100));
		Apfloat x2 = new Apfloat("0");
		int x = 0;
		while (x1.subtract(x0).compareTo(accuracy) >= 0 || x0.subtract(x1).compareTo(accuracy) >= 0) {
			x++;
			x2 = x1.subtract(Function1.f(x1).multiply(
					x1.subtract(x0).divide(
							Function1.f(x1).subtract(Function1.f(x0)))));
			x0 = x1;
			x1 = x2;
		}
		System.out.println("Ilość kroków w metodzie siecznych wyniosła " + x);
		return x2;
	}

}
