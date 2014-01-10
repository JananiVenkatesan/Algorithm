// https://github.com/gaylemcd/ctci/tree/master/java/Chapter%208/Question8_1

public class BlackJackCard extends Card{
	public BlackJackCard(int c, Suit s){
		super(c, s);
	}
	public int value(){
		if(isAce())  // Ace
			return 1;
		else if(faceValue >= 11 && faceValue <= 13)  // Face card
			return 10;
		else  // Number card
			return faceValue;
	}
	public int minValue(){
		if(isAce())
			return 1;
		else
			return value();
	}
	public int maxValue(){
		if(isAce())
			return 11;
		else
			return value();
	}
	public boolean isAce(){
		return faceValue == 1;
	}
	public boolean isFaceCard(){
		return faceValue >= 11 && faceValue <= 13;
	}
}


public class BlackJackHand extends Hand<BlackJackCard>{
	/* There are multiple possible scores for a blackjack hand,
	 * since aces have multiple values. Return the highest possible
	 * score that's under 21, or the lowest score that's over. */
	public int score(){
		ArrayList<Integer> scores = possibleScores();
		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;
		for(int score : scores){
			if(score > 21 && score < minOver){
				minOver = score;
			}else if(score <= 21 && score > maxUnder){
				maxUnder = score;
			}
		}
		return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
	}
	/* return a list of all possible scores this hand could have
	 * (evaluating each ace as both 1 and 11 */
	private ArrayList<Integer> possibleScores(){
		ArrayList<Integer> scores = new ArrayList<Integer>();
        if (cards.size() == 0) {
            return scores;
        }
        for (BlackJackCard card : cards) {
            addCardToScoreList(card, scores);
        }
        return scores;
	}
	private void addCardToScoreList(BlackJackCard card, ArrayList<Integer> scores) {
        if (scores.size() == 0) {
            scores.add(0);
        } 
        int length = scores.size();
        for (int i = 0; i < length; i++) {
            int score = scores.get(i);
            scores.set(i, score + card.minValue());
            if(card.minValue() != card.maxValue()){
                scores.add(score + card.maxValue());
            }
        }
    }

	public boolean busted(){
		return score() > 21;
	}
	public boolean is21(){
		return score() == 21;
	}
	public boolean isBlackJack(){
		if (cards.size() != 2) {
            return false;
        }
        BlackJackCard first = cards.get(0);
        BlackJackCard second = cards.get(1);
        return (first.isAce() && second.isFaceCard()) || (second.isAce() && first.isFaceCard());
	}
}


public class BlackJackGameAutomator {
    private Deck<BlackJackCard> deck;
    private BlackJackHand[] hands;
    private static final int HIT_UNTIL = 16;
        
    public BlackJackGameAutomator(int numPlayers) {
        hands = new BlackJackHand[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            hands[i] = new BlackJackHand();
        }
    }
        
    public boolean dealInitial() {
        for (BlackJackHand hand : hands) {
            BlackJackCard card1 = deck.dealCard();
            BlackJackCard card2 = deck.dealCard();
            if (card1 == null || card2 == null) {
                return false;
            }
            hand.addCard(card1);
            hand.addCard(card2);        
        }
        return true;
    }
        
    public ArrayList<Integer> getBlackJacks() {
        ArrayList<Integer> winners = new ArrayList<Integer>();
        for (int i = 0; i < hands.length; i++) {
            if (hands[i].isBlackJack()) {
                winners.add(i);
            }
        }
        return winners;
    }
        
    public boolean playHand(int i) {
        BlackJackHand hand = hands[i];
        return playHand(hand);
    }
        
    public boolean playHand(BlackJackHand hand) {
        while (hand.score() < HIT_UNTIL) {
            BlackJackCard card = deck.dealCard();
            if (card == null) {
                return false;
            }
            hand.addCard(card);
        }
        return true;
    }        
        
    public boolean playAllHands() {
        for (BlackJackHand hand : hands) {
            if (!playHand(hand)) {
                return false;
            }
        }
        return true;
    }
        
    public ArrayList<Integer> getWinners() {
        ArrayList<Integer> winners = new ArrayList<Integer>();
        int winningScore = 0;
        for (int i = 0; i < hands.length; i++) {
            BlackJackHand hand = hands[i];
            if (!hand.busted()) {
                if (hand.score() > winningScore) {
                    winningScore = hand.score();
                    winners.clear();
                    winners.add(i);
                } else if (hand.score() == winningScore) {
                    winners.add(i);
                }
            }
        }
        return winners;
    }
        
    public void initializeDeck() {
        ArrayList<BlackJackCard> cards = new ArrayList<BlackJackCard>();
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j <= 3; j++) {
                Suit suit = Suit.getSuitFromValue(j);
                BlackJackCard card = new BlackJackCard(i, suit);
                cards.add(card);
            }
        }
                
        deck = new Deck<BlackJackCard>();
        deck.setDeckOfCards(cards);
        deck.shuffle();        
    }
        
    public void printHandsAndScore() {
        for (int i = 0; i < hands.length; i++) {
            System.out.print("Hand " + i + " (" + hands[i].score() + "): ");
            hands[i].print();
            System.out.println("");
        }
    }
}



