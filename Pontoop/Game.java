package Pontoop;

public class Game {
	
	private Deck mDeck;				//Object deck - which has the array of the deck, along with other parts to create the array and contents
	private Dealer mDealer;			//Dealer player
	private User mUser;				//User player
	private String mResult;			//Stores the result of the game to be returned later
	
	public Game() {					
		
		mDeck = new Deck();											
		mDealer = new Dealer(mDeck.getCard(), mDeck.getCard());	//dealer gets a random value card twice to initialise the dealers hand with 2 cards
		mUser = new User();											
		giveCard();					
	}
	
	public void giveCard() {
		mUser.addCard(mDeck.getCard());
	}
	
	/*
	Decides whether a win, draw or loss, displaying this to the user
	Also alters the result member variable - to be returned in getResult() 
	*/
	public void decideResult() {
		
		if (mUser.getHandValue() < 22 && mUser.getHandValue() > mDealer.getHandValue()) {
			mResult = "win";
		}else if(mUser.getHandValue() < 22 && mUser.getHandValue() == mDealer.getHandValue()) {
			mResult = "draw";
		}else {
			mResult = "lose";
		}
		
	}
	
	public String getResult() {
		return mResult;
	}
	
	public User getUser() {
		return mUser;
	}
	
	public Dealer getDealer() {
		return mDealer;
	}

}
