package com.tennis.score;

/**
 * @author Manel
 *
 */
public class Player {

	private String name;
	private int gameScore;
	private int setScore;
	private int tieBreakScore;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getName();
	}

	/**
	 * @return the gameScore
	 */
	public int getGameScore() {
		return gameScore;
	}

	/**
	 * @param gameScore
	 *            the gameScore to set
	 */
	public void setGameScore(int gameScore) {
		this.gameScore = gameScore;
	}

	/**
	 * @return the setScore
	 */
	public int getSetScore() {
		return setScore;
	}

	/**
	 * @param setScore
	 *            the setScore to set
	 */
	public void setSetScore(int setScore) {
		this.setScore = setScore;
	}

	/**
	 * @return the tieBreakScore
	 */
	public int getTieBreakScore() {
		return tieBreakScore;
	}

	/**
	 * @param tieBreakScore
	 *            the tieBreakScore to set
	 */
	public void setTieBreakScore(int tieBreakScore) {
		this.tieBreakScore = tieBreakScore;
	}

	public void winPoint() {
		this.gameScore = getGameScore() + 1;
	}

	public void winTieBreakPoint() {
		this.tieBreakScore = getTieBreakScore() + 1;
	}

	public void loosePoint() {
		this.gameScore = getGameScore() - 1;
	}

	public void winSetGame() {
		this.setScore = getSetScore() + 1;
	}

	public boolean hasWinGameAgainst(Player scondPlayer) {
		return this.gameScore == 4 && scondPlayer.gameScore < 3;
	}

	public boolean hasWinSetAgainst(Player scondPlayer) {
		if (this.setScore == 6 && scondPlayer.setScore <= 4) {
			return true;
		}
		if (this.tieBreakScore >= 6 && this.tieBreakScore > scondPlayer.tieBreakScore
				&& (this.tieBreakScore - scondPlayer.tieBreakScore >= 2)) {
			return true;
		}
		return false;
	}

	public boolean hasAdvantageAgainst(Player scondPlayer) {
		return this.gameScore == 4 && scondPlayer.gameScore == 3;
	}

	public boolean isDeuceRuleActivated(Player scondPlayer) {
		return this.gameScore == 3 && scondPlayer.getGameScore() == this.gameScore;
	}

	public boolean isTieBreakRuleActivated(Player scondPlayer) {
		return this.setScore == 6 && scondPlayer.getSetScore() == 6;
	}

}