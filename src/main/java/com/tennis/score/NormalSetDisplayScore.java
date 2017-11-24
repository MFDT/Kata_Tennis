package com.tennis.score;

/**
 * @author Manel
 *
 */
public class NormalSetDisplayScore extends DisplayScore{

    public NormalSetDisplayScore(Player player1, Player player2) {
        super(player1, player2);
    }

    public boolean checkCondition() {
        return !firstPlayer.hasWinSetAgainst(secondPlayer) && !secondPlayer.hasWinSetAgainst(firstPlayer);
    }

    public String display() {
        return formatScore(String.valueOf(firstPlayer.getSetScore()), String.valueOf(secondPlayer.getSetScore()));
    }
}