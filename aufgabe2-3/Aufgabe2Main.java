package aufgabe2;

public class Aufgabe2Main {

	public static void main(String[] args) {
		System.out.println(MyInteger.parseInt("594"));
		System.out.println(MyInteger.parseInt("-594"));
		System.out.println(MyInteger.parseInt("+594"));
		System.out.println(MyInteger.parseInt("0000594"));
		System.out.println(MyInteger.parseInt("5940"));
		System.out.println(MyInteger.parseInt("    594    "));
		System.out.println(MyInteger.parseInt("0000"));
		System.out.println(MyInteger.parseInt("0"));
		System.out.println(MyInteger.parseInt("abcdefg"));
		
	}

}
