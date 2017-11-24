package com.tennis.score;



/**
 * @author Manel
 *
 */
public class EndTieBreakDisplayScore extends DisplayScore {

    public EndTieBreakDisplayScore(Player player1, Player player2) {
        super(player1, player2);
    }

    public boolean checkCondition() {
        return firstPlayer.hasWinSetAgainst(secondPlayer) || secondPlayer.hasWinSetAgainst(firstPlayer);
    }

    public String display() {
        return firstPlayer.getTieBreakScore() > secondPlayer.getTieBreakScore() ?
                   formatScore(WIN_SET_MESSAGE, String.valueOf(secondPlayer.getTieBreakScore())) :
                   formatScore(String.valueOf(firstPlayer.getTieBreakScore()), WIN_SET_MESSAGE);

    }
}