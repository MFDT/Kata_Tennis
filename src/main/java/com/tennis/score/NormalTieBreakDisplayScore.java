package com.tennis.score;


/**
 * @author Manel
 *
 */
public class NormalTieBreakDisplayScore extends DisplayScore{


    public NormalTieBreakDisplayScore(Player player1, Player player2) {
        super(player1, player2);
    }

    public boolean checkCondition() {
        return firstPlayer.isTieBreakRuleActivated(secondPlayer)
                && !firstPlayer.hasWinSetAgainst(secondPlayer)
                && !secondPlayer.hasWinSetAgainst(firstPlayer);
    }

    public String display() {
        return formatScore(String.valueOf(firstPlayer.getTieBreakScore()), String.valueOf(secondPlayer.getTieBreakScore()));
    }
}