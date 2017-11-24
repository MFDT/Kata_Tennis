package com.tennis.score;

/**
 * @author Manel
 *
 */
public class AdvantageDisplayScore extends DisplayScore {

    public AdvantageDisplayScore(Player player1, Player player2) {
        super(player1, player2);
    }

    public boolean checkCondition() {
        return firstPlayer.hasAdvantageAgainst(secondPlayer) || secondPlayer.hasAdvantageAgainst(firstPlayer);
    }

    public String display() {
        return  firstPlayer.getName().equals(wishPlayerHaveBigScore().getName())?
                formatScore(ADVANTAGE_GAME_MESSAGE, scoreMap.get(secondPlayer.getGameScore())) :
                formatScore(scoreMap.get(firstPlayer.getGameScore()), ADVANTAGE_GAME_MESSAGE);
    }
}
