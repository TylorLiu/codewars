package codewars.kata;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * eoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and
 * carries the "instructions" for the development and functioning of living
 * organisms.
 * 
 * If you want to know more http://en.wikipedia.org/wiki/DNA
 * 
 * In DNA strings, symbols "A" and "T" are complements of each other, as "C" and
 * "G". You have function with one side of the DNA (string, except for Haskell);
 * you need to get the other complementary side. DNA strand is never empty or
 * there is no DNA at all (again, except for Haskell).
 * 
 * DnaStrand.makeComplement("ATTGC") // return "TAACG"
 * 
 * DnaStrand.makeComplement("GTAT") // return "CATA"
 * 
 * @author liubin10
 * @date 2017年9月21日 下午5:08:16
 */
public class DnaStrand {
	private static HashMap<Character, Character> map2 = new HashMap<>(4);
	static {
		map2.put('A', 'T');
		map2.put('T', 'A');
		map2.put('C', 'G');
		map2.put('G', 'C');
	}

	public static String makeComplement(String dna) {
		return dna.chars().parallel().mapToObj(c -> String.valueOf(map2.get((char) c))).collect(Collectors.joining());
//		StringBuilder sBuilder = new StringBuilder();
//		
//		for(int i =0 ;i<dna.length();i++){
//			switch ( dna.charAt(i)) {
//			case 'A':
//				sBuilder.append('T');
//				break;
//			case 'T':
//				sBuilder.append('A');
//				break;
//			case 'C':
//				sBuilder.append('G');
//				break;
//			case 'G':
//				sBuilder.append('C');
//				break;
//			default:
//				break;
//			}
//		}
//		return sBuilder.toString();
	}

}
