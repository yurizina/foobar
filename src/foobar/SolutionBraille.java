package foobar;

public class SolutionBraille {
    public static String solution(String s) {
    // Attributes - every letter has a correspondent in Braille language
		String a = "100000";
		String b = "110000";
		String c = "100100";
		String d = "100110";
		String e = "100010";
		String f = "110100";
		String g = "110110";
		String h = "110010";
		String i = "010100";
		String j = "010110";
		String k = "101000";
		String l = "111000";
		String m = "101100";
		String n = "101110";
		String o = "101010";
		String p = "111100";
		String q = "111110";
		String r = "111010";
		String ss = "011100";
		String t = "011110";
		String u = "101001";
		String v = "111001";
		String w = "010111";
		String x = "101101";
		String y = "101111";
		String z = "101011";
		String capitalLetter = "000001";

		// Split the phrase given to every character being transformed to Braille
		String[] splitPhrase = null;

		// Returning braille translation
		String braille = "";

		for (int ini = 0; ini < s.length(); ini++) {

			// Populate the array splitPhrase to every character using .split method
			splitPhrase = s.split("");

			// All conditions to add for braille phrase
			// If letter is equals to the assigned hard code, it will add the letter in
			// Braille
			// If any letter is capital letter, will return a capitalization in Braille
			// 0000001;
			// If empty space, will return last else if - String - 000000
			if (splitPhrase[ini].equalsIgnoreCase("a")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + a;
				} else {
					braille = braille + a;
				}

			} else if (splitPhrase[ini].equalsIgnoreCase("b")) {

				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + b;
				} else {
					braille = braille + b;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("c")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + c;
				} else {
					braille = braille + c;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("d")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + d;
				} else {
					braille = braille + d;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("e")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + e;
				} else {
					braille = braille + e;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("f")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + f;
				} else {
					braille = braille + f;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("g")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + g;
				} else {
					braille = braille + g;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("h")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + h;
				} else {
					braille = braille + h;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("i")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + i;
				} else {
					braille = braille + i;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("j")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + j;
				} else {
					braille = braille + j;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("k")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + k;
				} else {
					braille = braille + k;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("l")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + l;
				} else {
					braille = braille + l;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("m")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + m;
				} else {
					braille = braille + m;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("n")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + n;
				} else {
					braille = braille + n;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("o")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + o;
				} else {
					braille = braille + o;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("p")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + p;
				} else {
					braille = braille + p;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("q")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + q;
				} else {
					braille = braille + q;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("r")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + r;
				} else {
					braille = braille + r;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("s")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + ss;
				} else {
					braille = braille + ss;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("t")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + t;
				} else {
					braille = braille + t;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("u")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + u;
				} else {
					braille = braille + u;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("v")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + v;
				} else {
					braille = braille + v;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("w")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + w;
				} else {
					braille = braille + w;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("x")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + "000001" + x;
				} else {
					braille = braille + x;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("y")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + y;
				} else {
					braille = braille + y;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase("z")) {
				if (splitPhrase[ini].matches("[A-Z+]")) {
					braille = braille + capitalLetter + z;
				} else {
					braille = braille + z;
				}
			} else if (splitPhrase[ini].equalsIgnoreCase(" ")) {
				braille = braille + "000000";
			}

		}
     //return String with all Braille translation
		return braille;

    }
}