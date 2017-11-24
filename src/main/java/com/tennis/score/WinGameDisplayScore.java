package com.tennis.score;


/**
 * @author Manel
 *
 */
public class WinGameDisplayScore extends DisplayScore{

    public WinGameDisplayScore(Player player1, Player player2) {
        super(player1, player2);
    }

    public boolean checkCondition() {
        return firstPlayer.hasWinGameAgainst(secondPlayer) || secondPlayer.hasWinGameAgainst(firstPlayer);
    }

    public String display() {
        boolean isPlayer1WinTheGame = firstPlayer.getName().equals(wishPlayerHaveBigScore().getName());
        String score = isPlayer1WinTheGame ?
                formatScore(WIN_GAME_MESSAGE, scoreMap.get(secondPlayer.getGameScore())) :
                formatScore(scoreMap.get(firstPlayer.getGameScore()), WIN_GAME_MESSAGE);
        initScore();
        if(isPlayer1WinTheGame){
            firstPlayer.winSetGame();
        }else{
            secondPlayer.winSetGame();
        }
        return score;
    }

    private void initScore() {
        firstPlayer.setGameScore(0);
        secondPlayer.setGameScore(0);
    }
}