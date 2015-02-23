
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/** Ben and Jackson's Rock Paper Scissors player submission.
  *
  * @author Jackson Spell, Ben Wiley
  */

// We should implement an algorithm switcher that, when it gets to the point that playing by 
// the current algorithm will let the opponent win if they guess correctly, we switch 
// algorithms to change it up so their algorithm stops being accurate.

public class TotallyNotACheaterBot implements RoShamBot {

	List<Action> myHist;
	List<Action> opHist;

	private static final List<Action> MOVES = 
		Collections.unmodifiableList(Arrays.asList(Action.values()));

	/** Constructor for TotallyNotACheaterBot.
	  *
	  *	Parameters:
	  * 	None
	  *
	  * Returns:
	  * 	None
	  */
	public TotallyNotACheaterBot() {
		myHist = new ArrayList<Action>();
		opHist = new ArrayList<Action>();
	}

	/** Returns the bot's next move.
	  *
	  *	Parameters:
	  * @param lastOpponentMove - Action - opponent's previous move
	  *
	  * Returns:
	  * @return Action - the bot's move
	  */
	public Action getNextMove(Action lastOpponentMove) {

		opHist.add(lastOpponentMove);

		// Random randIntGen = new Random();
		// Action myMove = MOVES.get(randIntGen.nextInt(3));

		Action myMove = lookBack(4, 200);

		myHist.add(myMove);
		return myMove;
	}

	/** Returns move based on opponent's most likely move historically.
	  *
	  *	Parameters:
	  * @param steps - int - number of previous steps to look back
	  * @param maxLookBack - int - max number of historical moves to check
	  *
	  * Returns:
	  * @return Action - move choice
	  */
	public Action lookBack(int steps, int maxLookBack) {

		return Action.ROCK;
	}
}