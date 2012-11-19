package bisection;

import org.apfloat.Apfloat;

import function.Function1;

public class Bisection {

	public Apfloat find(Apfloat a, Apfloat b, Apfloat accuracy) {
		accuracy = accuracy.divide(new Apfloat(100));
		Apfloat l2 = new Apfloat(2, Apfloat.INFINITE);
		Apfloat c = new Apfloat(Apfloat.INFINITE);
		while(b.subtract(a).compareTo(accuracy) >= 0) {
			c = a.add(b).divide(l2);
			//nie uwzględniamy zera!
			//System.out.print(Function1.f(a));
			 //System.out.println(Function1.f(c));
			if(Function1.f(a).signum() != Function1.f(c).signum()) {
				b = c;
			}
			else {
				a = c;
			}
		}
		return c;
	}


}
