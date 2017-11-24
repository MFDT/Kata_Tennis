package com.tennis.service;



import com.tennis.score.Player;

public interface TennisGame {

    Player getPlayerByName(String playerName);

    String getCurrentGameScore();

    String getSetScore();

    String getTieBreakScore();

}