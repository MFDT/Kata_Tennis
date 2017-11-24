package com.tennis.score;


/**
 * @author Manel
 *
 */
public class DeuceDisplayScore extends DisplayScore{

   public DeuceDisplayScore(Player player1, Player player2) {
        super(player1, player2);
    }

    public boolean checkCondition() {
        return firstPlayer.isDeuceRuleActivated(secondPlayer);
    }

    public String display() {
        return formatScore(DEUCE_GAME_MESSAGE, DEUCE_GAME_MESSAGE);
    }
}
