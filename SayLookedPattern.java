// Find the n’th term in Look and say (Or Count and Say) Sequence. 
// The look-and-say sequence is the sequence of the below integers: 
// 1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211, … 
// Input: n = 3
// Output: 21

// Input: n = 5
// Output: 111221

import java.io.*;
import java.util.*;

class SayLookedPattern {
    static String generator(String str) {
	    String ans = "";
	    HashMap<Character, Integer>tempCount = new HashMap<>();

	    for (int i = 0; i < str.length() + 1; i++) {
	        if (i == str.length() || tempCount.containsKey(str.charAt(i)) == false && i > 0) {
	            ans += String.valueOf(tempCount.get(str.charAt(i-1))) + str.charAt(i-1);
		        tempCount.clear();
	        }

	        if(i == str.length()){
		        tempCount.put(null, 1);
	        }
	        else {
		        if(tempCount.containsKey(str.charAt(i))){
		            tempCount.put(str.charAt(i), tempCount.get(str.charAt(i))+1);
		        }
		    else {
		        if(i != str.length())tempCount.put(str.charAt(i), 1);
		       }
	            
	        }
	    }
	    return ans;
    }

    static String countnndSay(int n) {
	    String res = "1";
	    for (int i = 1; i < n; i++) {
	        res = generator(res);
	    }

	       return res;
}

public static void main(String args[]) {
	int N = 3;
	System.out.println(countnndSay(N));
}
}

