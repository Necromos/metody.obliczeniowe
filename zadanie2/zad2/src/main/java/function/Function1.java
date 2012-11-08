package function;

import java.util.Scanner;

import org.apfloat.Apfloat;

public class Function1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
			String napis = input.nextLine();
			Apfloat liczba = new Apfloat(napis, 1000);
			Apfloat wynik = f(liczba);
			System.out.println(wynik.toString(true));
			
		input.close();
	}

	public static Apfloat f(Apfloat x) {
		Apfloat result = new Apfloat(3, 1000);
		result = result.subtract(x);
		result = result.add(org.apfloat.ApfloatMath.log(x));
		return result;
	}
}