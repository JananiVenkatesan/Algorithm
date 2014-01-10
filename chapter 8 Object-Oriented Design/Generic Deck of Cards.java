/*  
	Design the data structures for a generic deck of cards. 
Explain how you would subclass the data structures to 
implement blackjack.

the deck is a standard 52-card set

https://github.com/gaylemcd/ctci/tree/master/java/Chapter%208/Question8_1
*/

public enum Suit{
	Club(0), Diamond(1), Heart(2), Spade(3);
	private int value;
	private Suit(int v){
		value = v;
	}
	public int getValue(){
		return value;
	}
	public static Suit getSuitFromValue(int value){
		switch (value) {
            case 0:
                return Suit.Club;
            case 1:
                return Suit.Diamond;
            case 2:
                return Suit.Heart;
            case 3: 
                return Suit.Spade;
            default:
                return null;
        }
	}
}

/*
    implemented Card as an abstract class, since 
methods like value() don't make much sense without 
a specific game attached to them.
*/
public abstract class Card{
	private boolean available = true;

	/*
	number or face that's on card - a number 2 through 10, 
	or 11 for Jack, 12 for Queen, 13 for King, or 1 for Ace 
	*/
	protected int faceValue;
	protected Suit suit;

	public Card(int c, Suit s){
		faceValue = c;
		suit = s;
	}

	public abstract int value();

	public Suit suit(){
		return suit;
	}

	/* Checks if the card is available to be given out to someone */
	public boolean isAvailable(){
		return available;
	}
	public void markUnavailable(){
		available = false;
	}
	public void markAvaible(){
		available = true;
	}

	public void print(){
        String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        System.out.print(faceValues[faceValue - 1]);
        switch (suit) {
            case Club:
                System.out.print("c");
                break;
            case Heart:
                System.out.print("h");
                break;
            case Diamond:
                System.out.print("d");
                break;
            case Spade:
                System.out.print("s");
                break;                        
        }
        System.out.print(" ");
    }
}

/*
	implemented Deck with generics but restricted 
the type of T to Card
*/
public class Deck <T extends Card> {
	private ArrayList<T> cards;  // all cards, dealt or not
	private int dealtIndex = 0; // marks first undealt card

	public void setDeckOfCards(ArrayList<T> deckOfCards){
		cards = deckOfCards;
	}

	public void shuffle(){  // 洗牌
		for (int i = 0; i < cards.size(); i++) {
            int j = AssortedMethods.randomIntInRange(i, cards.size() - i - 1);
            T card1 = cards.get(i);
            T card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
	}
	public int remainingCards(){
		return cards.size() - dealtIndex;
	}
	public T[] dealHand(int number){
		if (remainingCards() < number) {
            return null;
        }
                
        T[] hand = (T[]) new Card[number];
        int count = 0;
        while (count < number) {
            T card = dealCard();
            if (card != null) {
                hand[count] = card;
                count++;
            
        }
                
        return hand;
	}
	public T dealCard(){
		if (remainingCards() == 0) {
            return null;
        }
                
        T card = cards.get(dealtIndex);
        card.markUnavailable();
        dealtIndex++;
        
        return card;
	}
	public void print() {
        for(Card card : cards){
            card.print();
        }
    }
}

public class Hand <T extends Card>{
	protected ArrayList<T> cards = new ArrayList<T>();

	public int score(){
		int score = 0;
		for(T card : cards){
			score += card.value();
		}
		return score;
	}

	public void addCard(T card){
		cards.add(card);
	}
	public void print() {
        for(Card card : cards){
            card.print();
        }
    }
}







