import static org.junit.Assert.*;

import org.apfloat.Apfloat;
import org.junit.Test;

import secant.Secant;


public class SecantTest {

	private String s1 = "0.052469097457714872409873611286018358554199235460031095103381713308436062167788997604522234456108464304597982355731748533668609668987194977184628457399857803023098431324633595634406918235810200523431501014806641511087181775895506984506663599485571924993435969685177695118978855053525549090886673846478840730916767817053655884464388224505451783775750247567997678109523438890790682726412015385786476651356334702088567661539920802750615613153675231352004916906641911023010721135212880796589335614251956531659208233560823952543681741673673002493890039598609039265791462585697170903";
	private String s2 = "4.5052414957928833669986244321373539400768435601902198116437944092467999039925450807174710904422227491858417763112083070031494901803299082363843764204982532504525165854207487904437779557981239890435948429317847238178431410572315908608541534240202101553142511371689481192832167084573133251912881949640428748003221945687568096188667375381245674539070768069040141031342940155207262330725172015263533069070797032153012846434929064077927618684107322654820326715455622742092976258474149562485023671275217253490497685188134296898385895175533341384987628762971145133435500021858429374";
	private Apfloat solution = new Apfloat("0", Apfloat.INFINITE);

	@Test
	public void testFindA10() {
		Secant secant = new Secant();
		String accuracyString = "1e-10";
		Apfloat accuracy = new Apfloat(accuracyString, Apfloat.INFINITE);
		int length = 12;	
		Apfloat a = new Apfloat("4", length);
		Apfloat b = new Apfloat("5", length);
		solution = secant.find(a, b, accuracy);
		String solutionString = solution.toString(true).substring(0, length);
		String solutionCheck = s2.substring(0, length);
		System.out.println(solutionString);
		System.out.println(solutionCheck);
		assertTrue("za mała dokładność", solutionString.equals(solutionCheck));
	}
	
	@Test
	public void testFindA20() {
		Secant secant = new Secant();
		String accuracyString = "1e-20";
		Apfloat accuracy = new Apfloat(accuracyString, Apfloat.INFINITE);
		int length = 22;	
		Apfloat a = new Apfloat("4", length+2);
		Apfloat b = new Apfloat("5", length+2);
		solution = secant.find(a, b, accuracy);
		String solutionString = solution.toString(true).substring(0, length);
		String solutionCheck = s2.substring(0, length);
		System.out.println(solutionString);
		System.out.println(solutionCheck);
		assertTrue("za mała dokładność", solutionString.equals(solutionCheck));
	}
	
	@Test
	public void testFindA30() {
		Secant secant = new Secant();
		String accuracyString = "1e-30";
		Apfloat accuracy = new Apfloat(accuracyString, Apfloat.INFINITE);
		int length = 32;	
		Apfloat a = new Apfloat("4", length+2);
		Apfloat b = new Apfloat("5", length+2);
		solution = secant.find(a, b, accuracy);
		String solutionString = solution.toString(true).substring(0, length);
		String solutionCheck = s2.substring(0, length);
		System.out.println(solutionString);
		System.out.println(solutionCheck);
		assertTrue("za mała dokładność", solutionString.equals(solutionCheck));
	}
	
	@Test
	public void testFindB10() {
		Secant secant = new Secant();
		String accuracyString = "1e-10";
		Apfloat accuracy = new Apfloat(accuracyString, Apfloat.INFINITE);
		int length = 12;	
		Apfloat a = new Apfloat("0.01", length);
		Apfloat b = new Apfloat("0.09", length);
		solution = secant.find(a, b, accuracy);
		String solutionString = solution.toString(true).substring(0, length);
		String solutionCheck = s1.substring(0, length);
		System.out.println(solutionString);
		System.out.println(solutionCheck);
		assertTrue("za mała dokładność", solutionString.equals(solutionCheck));
	}
	
	@Test
	public void testFindB20() {
		Secant secant = new Secant();
		String accuracyString = "1e-20";
		Apfloat accuracy = new Apfloat(accuracyString, Apfloat.INFINITE);
		int length = 20;	
		Apfloat a = new Apfloat("0.01", length+2);
		Apfloat b = new Apfloat("0.09", length+2);
		solution = secant.find(a, b, accuracy);
		String solutionString = solution.toString(true).substring(0, length);
		String solutionCheck = s1.substring(0, length);
		System.out.println(solutionString);
		System.out.println(solutionCheck);
		assertTrue("za mała dokładność", solutionString.equals(solutionCheck));
	}
	
	@Test
	public void testFindB30() {
		Secant secant = new Secant();
		String accuracyString = "1e-30";
		Apfloat accuracy = new Apfloat(accuracyString, Apfloat.INFINITE);
		int length = 32;	
		Apfloat a = new Apfloat("0.01", length+3);
		Apfloat b = new Apfloat("0.09", length+3);
		solution = secant.find(a, b, accuracy);
		String solutionString = solution.toString(true).substring(0, length);
		String solutionCheck = s1.substring(0, length);
		System.out.println(solutionString);
		System.out.println(solutionCheck);
		assertTrue("za mała dokładność", solutionString.equals(solutionCheck));
	}

	@Test
	public void testFindA100() {
		Secant secant = new Secant();
		String accuracyString = "1e-100";
		Apfloat accuracy = new Apfloat(accuracyString, Apfloat.INFINITE);
		int length = 102;	
		Apfloat a = new Apfloat("4", length+3);
		Apfloat b = new Apfloat("5", length+3);
		solution = secant.find(a, b, accuracy);
		String solutionString = solution.toString(true).substring(0, length);
		String solutionCheck = s2.substring(0, length);
		System.out.println(solutionString);
		System.out.println(solutionCheck);
		assertTrue("za mała dokładność", solutionString.equals(solutionCheck));
	}

	@Test
	public void testFindB100() {
		Secant secant = new Secant();
		String accuracyString = "1e-100";
		Apfloat accuracy = new Apfloat(accuracyString, Apfloat.INFINITE);
		int length = 102;	
		Apfloat a = new Apfloat("0.01", length+10);
		Apfloat b = new Apfloat("0.09", length+10);
		solution = secant.find(a, b, accuracy);
		String solutionString = solution.toString(true).substring(0, length);
		String solutionCheck = s1.substring(0, length);
		System.out.println(solutionString);
		System.out.println(solutionCheck);
		assertTrue("za mała dokładność", solutionString.equals(solutionCheck));
	}
	

	@Test
	public void testFindA500() {
		Secant secant = new Secant();
		String accuracyString = "1e-500";
		Apfloat accuracy = new Apfloat(accuracyString, Apfloat.INFINITE);
		int length = 502;	
		Apfloat a = new Apfloat("4", length+5);
		Apfloat b = new Apfloat("5", length+5);
		solution = secant.find(a, b, accuracy);
		String solutionString = solution.toString(true).substring(0, length);
		String solutionCheck = s2.substring(0, length);
		System.out.println(solutionString);
		System.out.println(solutionCheck);
		assertTrue("za mała dokładność", solutionString.equals(solutionCheck));
	}

	@Test
	public void testFindB500() {
		Secant secant = new Secant();
		String accuracyString = "1e-500";
		Apfloat accuracy = new Apfloat(accuracyString, Apfloat.INFINITE);
		int length = 502;	
		Apfloat a = new Apfloat("0.01", length+10);
		Apfloat b = new Apfloat("0.09", length+10);
		solution = secant.find(a, b, accuracy);
		String solutionString = solution.toString(true).substring(0, length);
		String solutionCheck = s1.substring(0, length);
		System.out.println(solutionString);
		System.out.println(solutionCheck);
		assertTrue("za mała dokładność", solutionString.equals(solutionCheck));
	}
	
}
