package Pontoop;
import java.util.ArrayList;

public class Deck {

	private ArrayList <Card> mGameDeck;					//Holds the full deck
	private ArrayList <String> mNameArray;				//Holds the names diamonds, hearts, clubs, spades
	private ArrayList <String> mFaceArray;				//Holds face card names - jack, queen, king, ace
	
	public Deck() {
		
		mGameDeck = new ArrayList<Card>();				//Create empty deck arraylist
		mNameArray = new ArrayList<String>();			//Create empty name (diamonds, spades) arraylist
		mFaceArray = new ArrayList<String>();			//Create empty face (king, queen) arraylist
		this.setFaces();									//fill face arraylist
		this.setNames();									//fill name arraylist
		this.makeDeck();									//fill deck arraylist
		
	}
	
	public void makeDeck() {
		//To get 1 of diamonds, hearts etc, 2 of diamonds hearts etc
		for(int i = 1; i < 11; i++) {					
			mGameDeck.add(new Card(i, i+" of Clubs", i+"C"));
			mGameDeck.add(new Card(i, i+" of Diamonds",i+"D"));
			mGameDeck.add(new Card(i, i+" of Hearts",i+"H"));
			mGameDeck.add(new Card(i, i+" of Spades",i+"S"));
		}
		
		//To get Jack Queen King of diamonds, hearts etc all equal to 10 
		for(int i = 0; i < 3; i++) {					
				mGameDeck.add(new Card(10, mFaceArray.get(i)+" of Clubs",mFaceArray.get(i)+"C"));
				mGameDeck.add(new Card(10, mFaceArray.get(i)+ " of Diamonds",mFaceArray.get(i)+"D"));
				mGameDeck.add(new Card(10, mFaceArray.get(i)+ " of Hearts",mFaceArray.get(i)+"H"));
				mGameDeck.add(new Card(10, mFaceArray.get(i)+ " of Spades",mFaceArray.get(i)+"S."));
		}
		
		//to get ace of diamonds, hearts etc all equal to 11 (Aces High)
		for(int i = 0; i < mNameArray.size(); i++) {
			String aceName = mFaceArray.get(3) + " of " + mNameArray.get(i);
			String imgName = mFaceArray.get(3) + "of" + mNameArray.get(i);
			mGameDeck.add(new Card(11, aceName,imgName));
		}

	}
	
	public void setNames() {
		mNameArray.add("Clubs");
		mNameArray.add("Diamonds");
		mNameArray.add("Hearts");
		mNameArray.add("Spades");
	}
	
	public void setFaces() {
		mFaceArray.add("Jack");
		mFaceArray.add("Queen");
		mFaceArray.add("King");
		mFaceArray.add("Ace");	
	}
	
	public void printDeck() {
		//for each card object in the deck array
		for(int i = 0; i < mGameDeck.size(); i++) {
			
			String cardName = mGameDeck.get(i).getName();
			System.out.println(cardName);
			
		}
	}
	
	public ArrayList getDeck() {
		return mGameDeck;
	}
	
	//Gets a random card from the deck, to return, to be given to the user
	public Card getCard() {
		boolean cardSuccess = false;					//set card successfully drawn as false
		Card drawnCard = null;							//placeholder Card variable has nothing to begin with
		while(!cardSuccess){							
			int i = (int)(Math.random()*52)+1;			//get a random number to use for an index
			if(i < mGameDeck.size()){					//if the random number is < the size of the deck, then take the card
				drawnCard = mGameDeck.get(i);			//get the card and placeholder card is equal to that card
				mGameDeck.remove(i);					//then remove the original card from the arraylist
				cardSuccess = true;						//we have successfully drawn a card!
			}
		}
		return drawnCard;								//return the placeholder card to be given to the user
	}
	
}
