import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
	static int	scale	= 1000;

	public static void main(String[] args) {
		new Main();
	}
	Main() {
		run();
	}

	// -3y(y + x^3) - 3x^4 + 1
	public static double f(double x, double y) {
		return -3 * y * (y + x * x * x) - 3 * x * x * x * x + 1;
	}

	public static double ff(double x) {
		return x - x * x * x;
	}

	public static BigDecimal f(BigDecimal x, BigDecimal y) {
		return ((y.multiply(y.add(x.multiply(x).multiply(x)))
				.multiply(BigDecimal.valueOf(-3))).subtract(x.multiply(x)
				.multiply(x).multiply(x).multiply(BigDecimal.valueOf(3)))
				.add(BigDecimal.ONE)).setScale(scale, RoundingMode.HALF_DOWN);
	}
	// x-x^3
	public static BigDecimal ff(BigDecimal x) {
		return (x.subtract(x.multiply(x).multiply(x))).setScale(scale,
				RoundingMode.HALF_DOWN);
	}

	public void run() {
		String c;
		// System.out.println(f(BigDecimal.valueOf(2), BigDecimal.valueOf(3)));
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Podaj n: ");

			double x = 1;
			double y = 0;
			double y2 = 0;
			double e1 = 0;
			double e2 = 0;
			double emax1 = 0;
			double emax2 = 0;
			double emed1 = 0;
			double emed2 = 0;
			double h = 0;
			int b = 0;
			int n = 0;
			n = input.nextInt();
			h = 2 / (double) n;
			while (x < 3) {
				// System.out.println("x= " + x);
				// System.out.println("euler = " + y);
				// System.out.println("dok³adnie = " + ff(x));
				// System.out.println("zmodyfikowana = " + y2);

				// System.out.println("b³¹d eulera = " + e1);
				// System.out.println("b³¹d zmodyfikowanej = " + e2);
				// System.out.println();
				y = y + h * f(x, y);
				y2 = y2 + h * f(x + h / 2, y2 + h / 2 * f(x, y2));

				x = x + h;
				b++;
				e1 = Math.abs((y - ff(x)) / ff(x));
				e2 = Math.abs((y2 - ff(x)) / ff(x));
				if (emax1 < e1)
					emax1 = e1;
				if (emax2 < e2)
					emax2 = e2;
				emed1 += e1;
				emed2 += e2;
			}
			System.out.println("METODA EULERA");
			System.out.println("B³¹d maksymalny: " + emax1);
			System.out.println("B³¹d œredni: " + emed1 / b);
			System.out.println();
			System.out.println("ZMODYFIKOWANA METODA EULERA");
			System.out.println("B³¹d maksymalny: " + emax2);
			System.out.println("B³¹d œredni: " + emed2 / b);

			System.out.println("Zakoñczyæ?");
			c = input.next();
		} while (!c.equals("t"));
		input.close();
	}
}

/*
 * BigDecimal eulerX = BigDecimal.ONE.setScale(scale, RoundingMode.HALF_DOWN);
 * BigDecimal eulerY = BigDecimal.ZERO.setScale(scale, RoundingMode.HALF_DOWN);
 * BigDecimal modifiedEulerY = BigDecimal.ZERO.setScale(scale,
 * RoundingMode.HALF_DOWN); BigDecimal step = BigDecimal.valueOf(2).divide(
 * BigDecimal.valueOf(n), scale, RoundingMode.HALF_DOWN); BigDecimal
 * maxErrorEuler = BigDecimal.ZERO.setScale(scale, RoundingMode.HALF_DOWN);
 * BigDecimal sumErrorEuler = BigDecimal.ZERO.setScale(scale,
 * RoundingMode.HALF_DOWN); BigDecimal errorEuler =
 * BigDecimal.ZERO.setScale(scale, RoundingMode.HALF_DOWN); BigDecimal
 * maxErrorModified = BigDecimal.ZERO.setScale(scale, RoundingMode.HALF_DOWN);
 * BigDecimal sumErrorModified = BigDecimal.ZERO.setScale(scale,
 * RoundingMode.HALF_DOWN); BigDecimal errorModified =
 * BigDecimal.ZERO.setScale(scale, RoundingMode.HALF_DOWN);
 * 
 * while (eulerX.compareTo(BigDecimal.valueOf(3)) < 0) { //
 * System.out.println("x = " + eulerX);
 * 
 * errorModified = (modifiedEulerY.subtract(ff(eulerX))).abs(); sumErrorModified
 * = sumErrorModified.add(errorModified); if
 * (maxErrorModified.compareTo(errorModified) < 0) { maxErrorModified =
 * errorModified; } errorEuler = (eulerY.subtract(ff(eulerX))).abs();
 * sumErrorEuler = sumErrorEuler.add(errorEuler); if
 * (maxErrorEuler.compareTo(errorEuler) < 0) { maxErrorEuler = errorEuler; } //
 * System.out.println(" metoda eulera = " + eulerY); //
 * System.out.println(" zmodyfikowana metoda = " + // modifiedEulerY); //
 * System.out.println(" rozwi¹zanie dok³adne = " + ff(eulerX)); //
 * System.out.println("x=" + eulerX); // System.out.println("y=" +
 * modifiedEulerY);
 * 
 * eulerY = eulerY.add(step.multiply(f(eulerX, eulerY)));
 * 
 * modifiedEulerY = modifiedEulerY.add(step.multiply(f(eulerX
 * .add(step.divide(BigDecimal.valueOf(2))),
 * modifiedEulerY.multiply((step.divide(BigDecimal .valueOf(2)))
 * .multiply(f(eulerX, modifiedEulerY)))))); eulerX = eulerX.add(step); }
 * 
 * System.out.println("Œredni b³¹d metody Eulera:" +
 * sumErrorEuler.divide(BigDecimal.valueOf(n), scale, RoundingMode.HALF_DOWN));
 * System.out.println("B³¹d maksymalny metody Eulera: " + maxErrorEuler);
 * System.out.println("Œredni b³¹d metody Zmodyfikowanej:" +
 * sumErrorModified.divide(BigDecimal.valueOf(n), 20, RoundingMode.HALF_DOWN));
 * System.out.println("B³¹d maksymalny metody Zmodyfikowanej: " +
 * maxErrorModified.setScale(20, RoundingMode.HALF_DOWN));
 */
