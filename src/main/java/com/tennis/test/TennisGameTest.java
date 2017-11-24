package com.tennis.test;


import com.tennis.score.Player;
import com.tennis.service.TennisGame;
import com.tennis.service.impl.TennisGameImpl;

public class TennisGameTest{
	
	private static TennisGame tennisGame;
    private static Player player1;
    private static Player player2;
    
        
	
	public static void main(String[] args){
		tennisGame = new TennisGameImpl("Manel", "Ons");
        player1 = tennisGame.getPlayerByName("Manel");
        player2 = tennisGame.getPlayerByName("Ons");
        //first User Story
        System.out.println("Game Score");
        for(int i=0; i<3; i++){
        	player1.winPoint();
        	System.out.println(tennisGame.getCurrentGameScore());
        	
        }
        player2.winPoint();
        System.out.println(tennisGame.getCurrentGameScore());
       	
        player1.winPoint();
        System.out.println(tennisGame.getCurrentGameScore());
        for(int i=0; i<3; i++){
        	player2.winPoint();
        System.out.println(tennisGame.getCurrentGameScore());

        }
        // activate DEUCE rule
        for(int i=0; i<3; i++){
        	player1.winPoint();
        	System.out.println(tennisGame.getCurrentGameScore());
        }
        // Display Advantage
        player2.winPoint();
        System.out.println(tennisGame.getCurrentGameScore());
        player1.setSetScore(6);
        player2.setSetScore(6);
        //Tie Break Rule Activated
        System.out.println("Tie Break Score") ;
     // activate DEUCE rule
        for(int i=0; i<3; i++){
        	player1.winTieBreakPoint();
        	System.out.println(tennisGame.getTieBreakScore());
        }
        System.out.println(tennisGame.getTieBreakScore());
        player1.setTieBreakScore(6);
        player2.setTieBreakScore(2);
        System.out.println("Tie Break Score") ;
        System.out.println(tennisGame.getTieBreakScore());
	}
}