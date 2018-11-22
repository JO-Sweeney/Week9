package Pontoop;

public class GameTracker {
		
	private int mWin;
	private int mDraw;
	private int mLoss;
	
	//takes the result from a game (see rungame - Game.getResult() method) and alters the member variables dependent on the condition 
	public void addResult(String result) {
		if (result.equalsIgnoreCase("win")) {
			mWin++;
		}else if(result.equalsIgnoreCase("draw")) {
			mDraw++;
		}else if(result.equalsIgnoreCase("lose")) {
			mLoss++;
		}
	}
	
	//prints the full results from each game's result combined 
	public String showResults() {
		String result = "Wins = "+ mWin +"\nDraws = "+ mDraw + "\nLosses = " + mLoss;
		return result;
	}

}
