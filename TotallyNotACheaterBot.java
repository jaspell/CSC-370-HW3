
/** Ben and Jackson's Rock Paper Scissors player submission.
  *
  * @author Jackson Spell, Ben Wiley
  */

public class TotallyNotACheaterBot implements RoShamBot {

	/** Returns the bot's next move.
	  *
	  *	Parameters:
	  * @param lastOpponentMove - Action - opponent's previous move
	  *
	  * Returns:
	  * @return Action - the bot's move
	  */
	public Action getNextMove(Action lastOpponentMove) {


		// We should implement an algorithm switcher that, when it gets to the point that playing by 
		// the current algorithm will let the opponent win if they guess correctly, we switch 
		// algorithms to change it up so their algorithm stops being accurate.
	}

	/** Returns move based on opponent's most likely move historically.
	  *
	  *	Parameters:
	  * @param lastOpponentMove - Action - opponent's previous move
	  * @param steps - int - number of previous steps to look back
	  * @param maxLookBack - int - max number of historical moves to check
	  *
	  * Returns:
	  * @return Action - move choice
	  */
	public Action lookBack(Action lastOpponentMove, int steps, int maxLookBack) {

	}
}