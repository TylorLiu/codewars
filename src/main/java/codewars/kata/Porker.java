package codewars.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author liubin10  2017/11/11
 */
public class Pokerer
{
  public enum Result { TIE, WIN, LOSS }

  private static char[] valArr = new char[] {'2','3','4','5','6','7','8','9','T','J','Q','K','A'};
  private static Map<Character,Integer> valueMap = new HashMap<Character,Integer>();
  static { for (int n = 0 ; n < valArr.length ; n++) valueMap.put(valArr[n], n); }

  private double rank;

  public PokerHand(String hand) {

    Map<Integer,Integer>   valCount   = new HashMap<Integer,Integer>();
    Map<Character,Integer> colorCount = new HashMap<Character,Integer>();
    Set<Integer> suiteSet   = new HashSet<Integer>();

    for (String card: hand.split(" ")) {
      int valKard    = valueMap.get(card.charAt(0));
      char colorKard = card.charAt(1);

      valCount.put(   valKard,   1 + valCount.getOrDefault(valKard, 0));
      colorCount.put( colorKard, 1 + colorCount.getOrDefault(colorKard, 0));
    }

    List<Integer> Keys_SortedByValues = new ArrayList<Integer>(valCount.keySet());
    int p = 0;
    rank = 0;
    Keys_SortedByValues.sort( (k1, k2) -> valCount.get(k1) - valCount.get(k2) == 0 ? k1 - k2 : valCount.get(k1) - valCount.get(k2) );
    for (int k: Keys_SortedByValues) rank += k * Math.pow(14, p++);

    int minVal = Collections.min(valCount.keySet());
    for (int n = 0 ; n < 5 ; n++) suiteSet.add(minVal + n);
    boolean isSuite = valCount.keySet().equals(suiteSet);

    if (colorCount.containsValue(5) && isSuite )                         rank += 8 * Math.pow(14, 5);  // straight flush
    else if (valCount.containsValue(4))                                  rank += 7 * Math.pow(14, 5);  // carre
    else if (valCount.containsValue(3) && valCount.containsValue(2))     rank += 6 * Math.pow(14, 5);  // full
    else if (colorCount.containsValue(5))                                rank += 5 * Math.pow(14, 5);  // couleur
    else if (isSuite)                                                    rank += 4 * Math.pow(14, 5);  // suite
    else if (valCount.containsValue(3))                                  rank += 3 * Math.pow(14, 5);  // brelan
    else if (valCount.containsValue(2) && valCount.keySet().size() == 3) rank += 2 * Math.pow(14, 5);  // 2 paires
    else if (valCount.containsValue(2) && valCount.keySet().size() == 4) rank += 1 * Math.pow(14, 5);  // 1 paire
    else                                                                 rank += 0;                     // 1 carte
  }

  public double getHandValue() { return rank; }

  public Result compareWith(Pokerer hand) {
    double other = hand.getHandValue();
    return rank < other ? Result.LOSS : rank == other ? Result.TIE : Result.WIN;
  }
}