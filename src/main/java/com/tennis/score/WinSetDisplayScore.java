package com.tennis.score;

/**
 * @author Manel
 *
 */
public class WinSetDisplayScore extends DisplayScore {

	public WinSetDisplayScore(Player player1, Player player2) {
		super(player1, player2);
	}

	public boolean checkCondition() {
		return firstPlayer.hasWinSetAgainst(secondPlayer) || secondPlayer.hasWinSetAgainst(firstPlayer);
	}

	public String display()
	{
		return firstPlayer.getSetScore() > secondPlayer.getSetScore()
				&& !firstPlayer.isTieBreakRuleActivated(secondPlayer)
						? formatScore(WIN_SET_MESSAGE, String.valueOf(secondPlayer.getSetScore()))
						: formatScore(String.valueOf(firstPlayer.getSetScore()), WIN_SET_MESSAGE);
	}
}