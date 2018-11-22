package Pontoop;

public class Card {
	
	private int mValue;
	private String mName;
	private String mImagePath;
	
	public Card(int value, String name, String image) {
		mValue = value;
		mName = name;
		mImagePath = image;
	}
	
	public void setValue(int value) {
		mValue = value;
	}
	
	public int getValue() {
		return mValue;
	}
	
	public String getName() {
		return mName;
	}
	
	public String getPath() {
		return mImagePath;
	}
	
}
