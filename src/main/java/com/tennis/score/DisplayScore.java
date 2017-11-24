package com.tennis.score;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Manel
 *
 */
public abstract class DisplayScore {

    protected static String WIN_SET_MESSAGE = "Win match";
    protected static String WIN_GAME_MESSAGE = "Win game";
    protected static String DEUCE_GAME_MESSAGE = "Deuce";
    protected static String ADVANTAGE_GAME_MESSAGE = "Advantage";
    protected Map<Integer, String> scoreMap = new HashMap<Integer, String>(5);


    public Player firstPlayer;
    public Player secondPlayer;

    public DisplayScore(Player player1, Player player2) {
        this.firstPlayer = player1;
        this.secondPlayer = player2;
        initScoreMap();
    }

    public abstract boolean checkCondition();

    public abstract String display();

    protected String formatScore(String playerOneScore, String playerTwoScore) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s : %s", firstPlayer, playerOneScore));
        sb.append("\n");
        sb.append(String.format("%s : %s", secondPlayer, playerTwoScore));
        return sb.toString();
    }

    protected Player wishPlayerHaveBigScore(){
    	if(firstPlayer.getGameScore() > secondPlayer.getGameScore())
    	{
    		return firstPlayer;
    	}
    	else
    	{
        return secondPlayer;
    	}
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
}