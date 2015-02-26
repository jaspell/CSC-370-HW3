import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.*;

/** Ben and Jackson's Rock Paper Scissors player submission.
  *
  * @author Jackson Spell, Ben Wiley
  */

// We should implement an algorithm switcher that, when it gets to the point that playing by 
// the current algorithm will let the opponent win if they guess correctly, we switch 
// algorithms to change it up so their algorithm stops being accurate.

public class NoRegrets implements RoShamBot {

	/** Constructor for NoRegrets.
	  *
	  *	Parameters:
	  * 	None
	  *
	  * Returns:
	  * 	None
	  */
	public NoRegrets() {
		
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


		return myMove;
	}

	/** Returns move that will beat given move.
	  *
	  *	Parameters:
	  * @param move - Action - move to beat
	  *
	  * Returns:
	  * @return Action - move that beats input
	  */
	public Action beatThis(Action move) {
		if (move == Action.ROCK) return Action.PAPER;
		else if (move == Action.PAPER) return Action.SCISSORS;
		else return Action.ROCK;
	}
}