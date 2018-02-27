package codewars.kata;

/**
 * @author liubin10  2017/11/11
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A famous casino is suddenly faced with a sharp decline of their revenues. They decide to offer Texas hold'em also online. Can you help them by writing an algorithm that can rank poker hands?

 Task:

 Create a poker hand that has a method to compare itself to another poker hand:
 Result PokerHand.compareWith(PokerHand hand);
 A poker hand has a constructor that accepts a string containing 5 cards:
 PokerHand hand = new PokerHand("KS 2H 5C JD TD");
 The characteristics of the string of cards are:
 A space is used as card seperator
 Each card consists of two characters
 The first character is the value of the card, valid characters are:
 2, 3, 4, 5, 6, 7, 8, 9, T(en), J(ack), Q(ueen), K(ing), A(ce)
 The second character represents the suit, valid characters are:
 S(pades), H(earts), D(iamonds), C(lubs)

 The result of your poker hand compare can be one of these 3 options:
 public enum Result
 {
 WIN,
 LOSS,
 TIE
 }
 Apply the Texas Hold'em rules for ranking the cards.
 There is no ranking for the suits.
 */
public class PokerHand implements  Comparable<PokerHand>
{


  public enum Result { TIE, WIN, LOSS }


  private Set<Character> set = new HashSet<>();

  boolean isSameColor=false;

  Integer parttern;

  private  List<Integer> valueList= new ArrayList<>(5);

  private Map<Integer,Integer> cardMap = new HashMap<>();

  public PokerHand(String hand) {
    String[] cards = hand.split(" ");

    for(String card : cards){
      assert (card!=null&&card.length()==2);
      set.add(Character.valueOf(card.charAt(1)));
      Integer val = null;
      if (Character.isDigit(card.charAt(0))){
        val = Integer.valueOf(card.substring(0,1));
      }else{
        switch (card.charAt(0)){
          case 'T':
            val = 10;
            break;
          case 'J':
            val=11;
            break;
          case 'Q':
            val=12;
            break;
          case 'K':
            val=13;
            break;
          case 'A':
            val=14;
            break;
          default:
            break;
        }
      }
      if(cardMap.containsKey(val)){
        cardMap.put(val,cardMap.get(val)+1);
      }else {
        cardMap.put(val,1);
      }
    }
    if (set.size()==1){
      isSameColor=true;
    }

    if (cardMap.size()<5){


     if (cardMap.containsValue(4)){
       parttern = 8;

       valueList.add(cardMap.keySet().stream().filter(key->cardMap.get(key)==4).findFirst().get());
       valueList.add(cardMap.keySet().stream().filter(key->cardMap.get(key)==1).findFirst().get());
     }else if(cardMap.containsValue(3)){
       valueList.add(cardMap.keySet().stream().filter(key->cardMap.get(key)==3).findFirst().get());
       if (cardMap.containsValue(2)){
         valueList.add(cardMap.keySet().stream().filter(key->cardMap.get(key)==2).findFirst().get());
         parttern = 7;
       }else {
         parttern = 4;
         List<Integer>  oneList = cardMap.keySet().stream().filter(key->cardMap.get(key)==1).mapToInt(key->key.intValue()).boxed().collect(
             Collectors.toList());
         oneList.sort(null);
         Collections.reverse(oneList);
         valueList.addAll(oneList);
       }
     }else {
       List<Integer>  twoList = cardMap.keySet().stream().filter(key->cardMap.get(key)==2).mapToInt(key->key.intValue()).boxed().collect(
           Collectors.toList());
       List<Integer>  oneList = cardMap.keySet().stream().filter(key->cardMap.get(key)==1).mapToInt(key->key.intValue()).boxed().collect(
           Collectors.toList());
       if (twoList.size()>1){
         twoList.sort(null);
         parttern = 3;
       }else {
         parttern=2;
       }
       oneList.sort(null);
       Collections.reverse(twoList);
       valueList.addAll(twoList);
       Collections.reverse(oneList);
       valueList.addAll(oneList);
     }


    }else{
      Set<Integer> set = cardMap.keySet();
      List<Integer> list = new ArrayList<>(5);
      list.addAll(set);
      Collections.sort(list);
      if ((list.get(list.size()-1)-list.get(0))==4){
          if (isSameColor){
            parttern=9;
          }else {
            parttern=5;
          }
        valueList.add(list.get(0));
      }else {
        if (isSameColor){
          parttern=6;
        }else {
          parttern=1;
        }
        Collections.reverse(list);
        valueList=list;
      }
    }


  }


  public Result compareWith(PokerHand hand) {
    int i = compareTo(hand);
    if (i==0){
      return Result.TIE;
    }else if (i==1){
      return Result.WIN;
    }

    return Result.LOSS;
  }
  @Override
  public int compareTo(PokerHand o) {
    if (this.parttern==o.parttern){
      for (int i=0;i<valueList.size();i++){
        int result = valueList.get(i).compareTo(o.valueList.get(i));
        if (result!=0){
          return  result;
        }
      }
      return 0;
    }
    return parttern.compareTo(o.parttern);
  }
}