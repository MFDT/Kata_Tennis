package com.tennis.service.impl;

import com.tennis.service.TennisGame;

import com.tennis.score.Player;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Manel
 *
 */
public class TennisGameImpl implements TennisGame {

	private static String WIN_SET_MESSAGE = "Win the match";
	private static String WIN_GAME_MESSAGE = "Win the game";
	private static String DEUCE_GAME_MESSAGE = "Deuce";
	private static String ADVANTAGE_GAME_MESSAGE = "Advantage";

	private Player player1;
	private Player player2;
	private Map<Integer, String> scoreMap = new HashMap<Integer, String>(5);

	/**
	 * Tennis Game constructor
	 *
	 * @param playerOneName
	 * @param playerTwoName
	 */
	public TennisGameImpl(String playerOneName, String playerTwoName) {
		this.player1 = new Player(playerOneName);
		this.player2 = new Player(playerTwoName);
		initScoreMap();
	}

	@Override
	public Player getPlayerByName(String playerName) {
		return player1.getName().endsWith(playerName) ? player1 : player2;
	}

	/**
	 * Principal method to display the current players game score
	 *
	 * @return game score
	 */
	@Override
	public String getCurrentGameScore() 
	{
		String currentGameScore;
		if (player1.hasWinGameAgainst(player2))
		{
			currentGameScore = formatScore(WIN_GAME_MESSAGE, scoreMap.get(player2.getGameScore()));
			initScore();
			player1.winSetGame();
		} 
		else if (player2.hasWinGameAgainst(player1)) 
		{
			currentGameScore = formatScore(scoreMap.get(player1.getGameScore()), WIN_GAME_MESSAGE);
			initScore();
			player2.winSetGame();
		} else if (isDeuceRuleActivated()) 
		{
			currentGameScore = formatScore(DEUCE_GAME_MESSAGE, DEUCE_GAME_MESSAGE);
		} else if (player1.hasAdvantageAgainst(player2)) 
		{
			currentGameScore = formatScore(ADVANTAGE_GAME_MESSAGE, scoreMap.get(player2.getGameScore()));
		} 
		else if (player2.hasAdvantageAgainst(player1)) 
		{
			currentGameScore = formatScore(scoreMap.get(player1.getGameScore()), ADVANTAGE_GAME_MESSAGE);
		} else
		{
			currentGameScore = formatScore(scoreMap.get(player1.getGameScore()), scoreMap.get(player2.getGameScore()));
		}
		return currentGameScore;
	}

	private void initScore() {
		player1.setGameScore(0);
		player2.setGameScore(0);
	}

	/**
	 * Principal method to display the current players game score
	 *
	 * @return Set Score
	 */
	@Override
	public String getSetScore()
	{
		if (player1.hasWinSetAgainst(player2))
		{
			return formatScore(WIN_SET_MESSAGE, String.valueOf(player2.getSetScore()));
		} 
		else if (player2.hasWinSetAgainst(player1)) 
		{
			return formatScore(String.valueOf(player1.getSetScore()), WIN_SET_MESSAGE);
		}
		else
		{
			return formatScore(String.valueOf(player1.getSetScore()), String.valueOf(player2.getSetScore()));
		}
	}

	/**
	 *
	 * @return tieBreakScore
	 */
	@Override
	public String getTieBreakScore() 
	{
		if (isTieBreakRuleActivated()) 
		{
			if (player1.hasWinSetAgainst(player2))
			{
				return formatScore(WIN_SET_MESSAGE, String.valueOf(player2.getTieBreakScore()));
			} 
			else if (player2.hasWinSetAgainst(player1))
			{
				return formatScore(String.valueOf(player1.getTieBreakScore()), WIN_SET_MESSAGE);
			}
			else
			{
				return formatScore(String.valueOf(player1.getTieBreakScore()),String.valueOf(player2.getTieBreakScore()));
			}
		}
		return null;
	}

	/**
	 * format Score message
	 *
	 * @param playerOneScore
	 * @param playerTwoScore
	 */
	private String formatScore(String playerOneScore, String playerTwoScore) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s : %s", player1, playerOneScore));
		sb.append("\n");
		sb.append(String.format("%s : %s", player2, playerTwoScore));
		return sb.toString();
	}

	/**
	 * init the game score Map
	 */
	private void initScoreMap() {
		scoreMap.put(0, "0");
		scoreMap.put(1, "15");
		scoreMap.put(2, "30");
		scoreMap.put(3, "40");
	}

	/**
	 * Check if the Deuce rule is true
	 *
	 * @return true if the score of each player is 40
	 */
	public boolean isDeuceRuleActivated() {
		return player1.getGameScore() == 3 && player2.getGameScore() == 3;
	}

	/**
	 * Check if the Tie Break rule is true
	 *
	 * @return true if the set score of each player is 6
	 */
	public boolean isTieBreakRuleActivated() {
		return player1.getSetScore() == 6 && player2.getSetScore() == 6;
	}

}
