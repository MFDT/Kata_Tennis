package com.tennis.score;

/**
 * @author Manel
 *
 */
public class NormalGameDisplayScore extends DisplayScore{

    public NormalGameDisplayScore(Player player1, Player player2) {
        super(player1, player2);
    }

    public boolean checkCondition() {
        return firstPlayer.getGameScore() <=3 && secondPlayer.getGameScore()<=3 && !firstPlayer.isDeuceRuleActivated(secondPlayer);
    }

    public String display() {
        return formatScore(scoreMap.get(firstPlayer.getGameScore()), scoreMap.get(secondPlayer.getGameScore()));
    }
}