package codewars.kata;

/**
 * Everyone knows passphrases. One can choose passphrases from poems, songs,
 * movies names and so on but frequently they can be guessed due to common
 * cultural references. You can get your passphrases stronger by different
 * means. One is the following:
 * 
 * choose a text in capital letters including or not digits and non alphabetic
 * characters,
 * 
 * shift each letter by a given number but the transformed letter must be a
 * letter (circular shift), replace each digit by its complement to 9, keep such
 * as non alphabetic and non digit characters, downcase each letter in odd
 * position, upcase each letter in even position (the first character is in
 * position 0), reverse the whole result. #Example:
 * 
 * your text: "BORN IN 2015!", shift 1
 * 
 * 1 + 2 + 3 -> "CPSO JO 7984!"
 * 
 * 4 "CpSo jO 7984!"
 * 
 * 5 "!4897 Oj oSpC"
 * 
 * With longer passphrases it's better to have a small and easy program. Would
 * you write it?
 * 
 * https://en.wikipedia.org/wiki/Passphrase
 * 
 * @author liubin10
 * @date 2017年9月21日 下午8:24:58
 */
public class PlayPass {

	public static String playPass(String s, int n) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				if (i % 2 == 0) {
					c = String.valueOf(c).toUpperCase().charAt(0);
					if (c + n > 90)
						c += n - 26;
					else
						c += n;
				} else {
					c = String.valueOf(c).toLowerCase().charAt(0);
					if (c + n > 122)
						c += n - 26;
					else
						c += n;
				}
				result.append(c);
			} else if (Character.isDigit(c))
				result.append(9 - Integer.parseInt(String.valueOf(c)));
			else
				result.append(c);
		}
		return result.reverse().toString();
	}

}