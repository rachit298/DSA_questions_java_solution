import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {

		// TC - O()
		String s1 = "ros";
		String s2 = "horse";

		int operations = totalOperations(s1, s1.length() - 1, s2, s2.length() - 1);

		System.out.println("Total operations to changes first string to second string are: " + operations);
	}

	public static int totalOperations(String s1, int s1Length, String s2, int s2Length) {

		if (s1.length() == 0) {
			return s2.length();
		} else if (s2.length() == 0) {
			return s1.length();
		}

		if(s1.charAt(s1Length) == s2.charAt(s2Length)){
			String str1 = s1.substring(0, s1Length);
			String str2 = s2.substring(0, s2Length);
			return totalOperations(str1, str1.length()-1, str2, str2.length()-1);
		}
		else{
			char ch = s2.charAt(s2Length);
			int op1 = 1 + totalOperations(s1+ch, s1Length+1, s2, s2Length);
			int op2 = 1 + totalOperations(s1.substring(0, s1Length), s1Length-1, s2, s2Length);
			int op3 = 1 + totalOperations(s1.substring(0, s1Length)+ch, s1Length, s2, s2Length);
			return Math.min(Math.min(op1, op2), op3);
		}
	}
}