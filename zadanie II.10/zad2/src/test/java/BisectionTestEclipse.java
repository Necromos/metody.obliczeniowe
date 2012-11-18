import static org.junit.Assert.*;

import org.apfloat.Apfloat;
import org.junit.Test;

import bisection.Bisection;


public class BisectionTestEclipse {
	
	private String accuracyString = "1e-20";
	private String s1 = "0.052469097457714872409873611286018358554199235460031095103381713308";
	private String s2 = "4.5052414957928833669986244321373539400768435601902198116437944092";
	private Apfloat x1 = new Apfloat(s1, 40);
	private Apfloat x2 = new Apfloat(s2, 40);
	private Apfloat accuracy = new Apfloat(accuracyString, 40);
	private Apfloat a = new Apfloat("4", 40);
	private Apfloat b = new Apfloat("5", 40);
	private Apfloat solution = new Apfloat("0", 40);
	
	@Test
	public void testFind() {
		Bisection bisec = new Bisection();
		solution = bisec.find(a, b, accuracy);
		System.out.println(a + " " + b + " " + accuracy);
		System.out.println(x2);
		System.out.println(solution);
		System.out.println(solution.equalDigits(x2));
		System.out.println(solution.equalDigits(x2) > 20);
		//TODO nie wiem czemu niedziala!
		assertTrue("za mała dokładność", solution.equalDigits(x2) > 20);
		
	}

}
