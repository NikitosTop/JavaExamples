package com.epam.rd.autocode.startegy.cards;

import com.epam.rd.autocode.Named;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class CardDealingStrategies{



    public static CardDealingStrategy texasHoldemCardDealingStrategy() {

        return new CardDealingStrategy() {
            Map<String, List<Card>> resultCardMap = new LinkedHashMap<>();
            @Override
            public Map<String, List<Card>> dealStacks(Deck deck, int players) {
                List<Card> list = new LinkedList<>(deck.restCards());
                List<Card> remaining = list.stream().filter(x -> list.indexOf(x) >= (2 * players) + 5).collect(Collectors.toList());
                List<Card> community = list.stream().filter(x -> list.indexOf(x) < (2 * players) + 5).filter(x -> list.indexOf(x) >= (2 * players)).collect(Collectors.toList());
                List<Card> playersCards = list.stream().filter(x -> list.indexOf(x) < (2 * players)).collect(Collectors.toList());
                resultCardMap.put("Community", community);
                for(int i = 0; i < players; i++){
                    List<Card> temp = List.of(playersCards.get(i), playersCards.get(i + (players)));
                    resultCardMap.put("Player " + (i + 1), temp);
                }
                resultCardMap.put("Remaining", remaining);
                return resultCardMap;
            }
        };
    }

    public static CardDealingStrategy classicPokerCardDealingStrategy() {
        return new CardDealingStrategy() {
            Map<String, List<Card>> resultCardMap = new LinkedHashMap<>();
            @Override
            public Map<String, List<Card>> dealStacks(Deck deck, int players) {
                List<Card> list = new LinkedList<>(deck.restCards());
                List<Card> remaining = list.stream().filter(x -> list.indexOf(x) >= (5 * players)).collect(Collectors.toList());
                List<Card> playersCards = list.stream().filter(x -> list.indexOf(x) < (5 * players)).collect(Collectors.toList());
                for(int i = 0; i < players; i++){
                    List<Card> temp = new LinkedList<>();
                    for (int j = i; j < playersCards.size(); j += players){
                        temp.add(playersCards.get(j));
                    }
                    resultCardMap.put("Player " + (i + 1), temp);
                }
                resultCardMap.put("Remaining", remaining);
                return resultCardMap;
            }
        };
    }

    public static CardDealingStrategy bridgeCardDealingStrategy(){
        return (deck, players) -> {
            Map<String, List<Card>> resultCardMap = new LinkedHashMap<>();
            List<Card> playersCard = new ArrayList<>(deck.restCards());
            for(int i = 0; i < players; i++){
                List<Card> pairCard = new ArrayList<>();
                for(int j = 0; j < playersCard.size()/players; j++){
                    pairCard.add(playersCard.get(i+players*j));
                }
                resultCardMap.put("Player " + (i + 1), pairCard);
            }
            return resultCardMap;
        };
    }

    public static CardDealingStrategy foolCardDealingStrategy(){
        return (deck, players) -> {
            Map<String, List<Card>> resultCardMap = new LinkedHashMap<>();
            List<Card> playersCard = new ArrayList<>();
            for (int i = 0; i < players*6; i++){
                playersCard.add(deck.dealCard());
            }
            for(int i = 0; i < players; i++){
                List<Card> pairCard = new ArrayList<>();
                for(int j = 0; j < 6; j++){
                    pairCard.add(playersCard.get(i+players*j));
                    resultCardMap.put("Player " + (i + 1), pairCard);
                }
            }
            List<Card> trump = List.of(deck.dealCard());
            List<Card> remaining = new ArrayList<>(deck.restCards());
            resultCardMap.put("Remaining", remaining);
            resultCardMap.put("Trump card", trump);
            return resultCardMap;
        };
    }

}
