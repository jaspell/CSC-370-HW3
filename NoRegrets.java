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

	private static final List<Action> MOVES = 
		Collections.unmodifiableList(Arrays.asList(Action.values()));
	private static final int TRACEBACK = 30;

	private double[] regretTotal, strategyTotal;
	private double[] myStrat, actionUtility;//, opStrat // these arrays persist but their values are continually reset.
	// FOR ALL ARRAYS: 0 = Rock, 1 = Paper, 2 = Scissors
	//private List<Action> opHist;
	private Action last;
	//private int moves;


	/** Constructor for NoRegrets.
	  *
	  *	Parameters:
	  * 	None
	  *
	  * Returns:
	  * 	None
	  */
	public NoRegrets() {
		this.regretTotal = new double[3];
		this.strategyTotal = new double[3];
		this.myStrat = new double[3];
		this.actionUtility = new double[3];
		//this.opStrat = { .3, .3, .3 };
		//this.myHist = new ArrayList<Action>();
		//this.opHist = new ArrayList<Action>();
		//moves = 0;
		this.last = Action.ROCK;
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
		/*this.opHist.add(lastOpponentMove);
		this.moves++;*/

		int myAction, otherAction;
		//Rock is 0
		if(this.last == PAPER) myAction = 1;
		else if(this.last == SCISSORS) myAction = 2;
		if(lastOpponentMove == PAPER) otherAction = 1;
		else if(this.last == SCISSORS) otherAction = 2;

		actionUtility[otherAction] = 0;
		actionUtility[otherAction == 2 ? 0 : otherAction + 1] = 1;
		actionUtility[otherAction == 0 ? 2 : otherAction - 1] = -1;

		for(int i = 0; i < 3; i++)
			regretTotal[i] += actionUtility[i] - actionUtility[myAction];


		//get new strategy and return next move
		this.updateStrategy();
		double d = Math.random();
		double cumulativeProb = 0;
		int i;
		for(i = 0; i < 2 && d >= cumulativeProb; i++)
			cumulativeProb += this.myStrat[i];
		if(d < cumulativeProb) i--;
		if(i == 0) this.last = Action.ROCK;
		else if(i == 1) this.last = Action.PAPER;
		else this.last = Action.SCISSORS;
		return last;
	}

	/** Updates the bot's mixed strategy.
	  *
	  *	Parameters:
	  * 	None
	  *
	  * Returns:
	  * 	None
	  */
	private void updateStrategy() {
		double normalizingSum = 0;
		for(int i = 0; i < 3; i++) {
			if(this.regretTotal[i] > 0)
				this.myStrat[i] = regretTotal[i];
			else this.myStrat[i] = 0;
			normalizingSum += this.myStrat[i];
		}
		for(int i = 0; i < 3; i++) {
			if(normalizingSum > 0)
				this.myStrat[i] /= normalizingSum;
			else this.myStrat[i] = 1.0 / 3;
			this.strategyTotal[i] += this.myStrat[i];
		}
	}

	/** Updates the opponent's mixed strategy.
	  *
	  *	Parameters:
	  * 	None
	  *
	  * Returns:
	  * 	None
	  */
	/*private void updateOpStrategy() {
		if(this.moves >= TRACEBACK) {
			double rock = 0.0;
			double paper = 0.0;
			double scissors = 0.0;
			for(int i = this.moves - 1; i >= this.moves - TRACEBACK; i--) {
				Action a = opHist.get(i);
				if(a == ROCK) rock++;
				else if(a == PAPER) paper++;
				else scissors++;
			}
			this.opStrat = { rock / TRACEBACK, paper / TRACEBACK, scissors / TRACEBACK };
		}
	}*/

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