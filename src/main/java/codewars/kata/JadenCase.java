package codewars.kata;


public class JadenCase {

	public String toJadenCase(String phrase) {
		if (phrase == null || phrase.length() == 0)
			return null;

		char[] array = phrase.toCharArray();

		// array[0] = Character.toUpperCase(array[0]);
		// for (int i = 1; i < array.length - 1; i++) {
		// if (array[i] == ' ') {
		// array[i + 1] = Character.toUpperCase(array[i + 1]);
		// }
		// }
		for (int x = 0; x < array.length; x++) {
			if (x == 0 || array[x - 1] == ' ') {
				array[x] = Character.toUpperCase(array[x]);
			}
		}

		return new String(array);
	}

}