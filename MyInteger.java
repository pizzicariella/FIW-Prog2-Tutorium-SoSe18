package aufgabe2;

public class MyInteger {
	static int MAX_VALUE = 2147483647;
	static int MIN_VALUE = -2147483648;
	
	private int value;
	
	public MyInteger(int value) {
		this.value=value;
	}
	
	public MyInteger(String value) throws IllegalArgumentException{
		this.value = parseInt(value);
	}
	
	public static boolean isDigit(char c) {
		return (c == '0' || c=='1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8'
				|| c == '9');
	}
	
	public static int parseInt(String s) throws IllegalArgumentException {
		if(s.length()==0) {
			throw new IllegalArgumentException();
		}
		boolean negative = false;
		if(s.startsWith("-")) {
			negative = true;
			s= s.substring(1);
		}
		else if(s.startsWith("+")) {
			s=s.substring(1);
		}
		if(s.length()==0) {
			throw new IllegalArgumentException();
		}
		boolean leadingZeros = false;
		if(s.startsWith("0")) {
			leadingZeros = true;
			while(leadingZeros) {
				s = s.substring(1);
				if(!s.startsWith("0")) {
					leadingZeros = false;
				}
			}
		}
		s = s.trim();
		if(s.length()==0) {
			return 0;
		}
		int value = 0;
		int factorMaker = 1;
		for(int i = s.length()-1; i>=0;i--) {
			if(isDigit(s.charAt(i))) {
				int charAsInt = s.charAt(i)-48;
				value+=charAsInt*factorMaker;
				factorMaker *= 10;
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		if(negative) {
			value = -value;
		}
		return value;
	}
	
	public int intValue() {
		return value;
	}
	
	public double doubleValue() {
		return (double) value;
	}
	
	public static MyInteger valueOf(String s) throws IllegalArgumentException{
		return new MyInteger(s);
	}
	
	public static MyInteger valueOf(int value) {
		return new MyInteger(value);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(this == o) return true; 
		if(this.getClass() != o.getClass())	return false; 	

		MyInteger oMI = (MyInteger)o; 	
		return (this.value == oMI.value); 
	}
	
	@Override 
	public int hashCode() {
		return value * 17;
	}
	
	@Override
	public String toString() {
		return ""+value;
	}
	
	
}
