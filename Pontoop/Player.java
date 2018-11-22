package Pontoop;

import java.util.ArrayList;

public abstract class Player {
	
	protected ArrayList <Card> mHand;			//Arraylist that holds card objects for the player's hand
	
	public Player() {
		mHand = new ArrayList<Card>();			//Always initialise with an empty hand
	}
	
	//Adds a card to the player's hand, with a card object as the parameter for the function
	public void addCard(Card newCard) {			
		mHand.add(newCard);
	}
	
	//Returns the numerical value of the player's hand (remember - cards have a name "Ace of Spades" and value - 11
	public int getHandValue() {
		int handValue = 0;
		for(int i = 0; i < mHand.size(); i++) {
			handValue = handValue + mHand.get(i).getValue();		//goes through each index of arraylist, accesses object at i, and gets value for that object
		}
		return handValue;
	}
	
	//Return the actual array of the player's hand
	public ArrayList returnHand() {
		return mHand;
	}

}
