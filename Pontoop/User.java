package Pontoop;

public class User extends Player{
	
	public User() {
		super();
	}
	
	//Add a card similar to superclass method - but always display that card to the user
	//This method means we get a new card passed in from the deck via the game which gets it from the deck
	public void addCard(Card newCard) {
		mHand.add(newCard);
	}
	
	//take the new card (see above method) and display its name (eg. ace of spades) and value (eg.11)
	public String displayNewCard() {
		Card newCard = mHand.get(mHand.size()-1);
		String drawnCard = "You got a " + newCard.getName() + "\nYour hand is " + this.getHandValue();
		return drawnCard;
	} 
	
	public String getImg() {
		Card newCard = mHand.get(mHand.size()-1);
		String imgPath = "resources/img/" + newCard.getPath() + ".jpg";
		return imgPath;
	}
	
}
