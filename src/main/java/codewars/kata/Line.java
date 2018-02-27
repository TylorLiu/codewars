package codewars.kata;

/**
 * The new "Avengers" movie has just been released! There are a lot of people at
 * the cinema box office standing in a huge line. Each of them has a single 100,
 * 50 or 25 dollars bill. A "Avengers" ticket costs 25 dollars.
 * 
 * Vasya is currently working as a clerk. He wants to sell a ticket to every
 * single person in this line.
 * 
 * Can Vasya sell a ticket to each person and give the change if he initially
 * has no money and sells the tickets strictly in the order people follow in the
 * line?
 * 
 * Return YES, if Vasya can sell a ticket to each person and give the change.
 * Otherwise return NO.
 * 
 * ###Examples:
 * 
 * // *** Java ***
 * 
 * Line.Tickets(new int[] {25, 25, 50}) // => YES Line.Tickets(new int []{25,
 * 100}) // => NO. Vasya will not have enough money to give change to 100
 * dollars
 * 
 * @author liubin10
 * @date 2017年9月21日 下午7:55:31
 */
public class Line {
	public static String Tickets(int[] peopleInLine) {
		
		//count of 25 dollars bill
		int count1 = 0;
		//count of 50 dollars bill
		int count2 = 0;

		for (int i = 0; i < peopleInLine.length; i++) {
			switch (peopleInLine[i]) {
			case 50:
				// if (count1 == 0)
				// return "NO";
				count2++;
				count1--;
				break;
			case 25:
				count1++;
				break;
			case 100:
				// if (count1 == 0)
				// return "NO";
				// if (count1 < 3 && count2 == 0)
				// return "NO";

				if (count2 > 0) {
					count1--;
					count2--;
				} else {
					count1 = count1 - 3;
				}

				break;
			default:
				break;
			}
			if (count1 < 0 || count2 < 0)
				return "NO";
		}
		
		return "YES";
	}
}