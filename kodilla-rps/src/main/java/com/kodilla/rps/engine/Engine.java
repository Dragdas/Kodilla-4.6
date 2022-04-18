package com.kodilla.rps.engine;

import com.kodilla.rps.moves.Move;
import com.kodilla.rps.moves.Moves;
import com.kodilla.rps.player.AIPlayer;
import com.kodilla.rps.player.HumanPlayer;
import com.kodilla.rps.player.Player;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.kodilla.rps.engine.HumanInteractionHandler.*;

public class Engine {

    private Player player1;
    private Player player2;

    private int maxScore = 0;

    private boolean playerWantsToTerminateProgram = false;
    private boolean playerWantsToRestartGame = false;
    private boolean someoneWon = false;



    public void play(){
        //Loops until player wants to play
        while (!playerWantsToTerminateProgram) {
            //initialize game parameters
            clearSettings();
            initializeGame();

            //Loop rounds until someone wins or quits
            while (!playerWantsToTerminateProgram && !playerWantsToRestartGame && !someoneWon) {
                clearScreen();
                displayScore();
                List<Move> playersMoves = new ArrayList<>();

                //Player 1 turn
                //getInRoundPlayerInput returns 1-5 for possible moves, -1 if player wants to quit, -2 if player wants to restart
                //TODO
                // remove redundant code
                int player1Input = getInRoundPlayerInput(player1);
                if (player1Input == -1) {
                    playerWantsToTerminateProgram = true;
                    break;
                }else if (player1Input == -2){
                    playerWantsToRestartGame = true;
                    break;
                }else{
                    playersMoves.add(player1.generateMove(player1Input));
                }
                clearScreen();

                //Player 2 turn
                if(player2.getClass() == AIPlayer.class){
                    int valueOfOpponentMove = Moves.getValueOf(player1.getLastMove().getMove());
                    Move aiGeneratedMove = player2.generateMove( valueOfOpponentMove );
                    playersMoves.add( aiGeneratedMove);
                }else{
                    int player2Input = getInRoundPlayerInput(player2);
                    if (player2Input == -1) {
                        playerWantsToTerminateProgram = true;
                        break;
                    }else if (player2Input == -2){
                        playerWantsToRestartGame = true;
                        break;
                    }else{
                        playersMoves.add(player2.generateMove(player2Input));
                    }
                }

                //find winner & reward winner
                Collections.sort(playersMoves);
                boolean draw = true;
                if(!playersMoves.get(0).equals(playersMoves.get(1)) ){
                    playersMoves.get(0).getPlayer().addPoint();
                    draw = false;
                }

                //Display players choices
                System.out.println(player1.getName() + " played: " + player1.getLastMove() );
                System.out.println(player2.getName() + " played: " + player2.getLastMove());
                String m = draw ? "Its a draw!" : playersMoves.get(0).getPlayer().getName() + " wins!";
                System.out.println(m);
                System.out.println("Press any key");
                Scanner sc = new Scanner(System.in);
                sc.nextLine();
                clearScreen();

                // check for victory
                if( (player1.getScore() >= maxScore) || (player2.getScore() >= maxScore) ){
                    someoneWon = true;
                    Player winner = player1.getScore() >= player2.getScore() ? player1 : player2;
                    displayScore();
                    System.out.println("Congratulations to " + winner.getName());


                    String msg = "Do you want to play again?\n1.Yes \n2.No";
                    int playerInput =  getIntInput(msg,List.of(1,2));
                    if(playerInput == 2)
                        playerWantsToTerminateProgram=true;
                }

            }
        }
    }


    private void initializeGame(){

        //Set up players settings
        System.out.println("Hi! ");
        player1 = new HumanPlayer();
        System.out.println("Nice to meet you " + player1.getName());

        String msg = "Do you want to play against friend or AI? \n1 - for human player \n2 - for AI opponent ";
        int playerInput = getIntInput(msg, List.of(1,2));
        player2 = playerInput == 1 ? new HumanPlayer() : new AIPlayer();

        System.out.println();
        System.out.println("Player1: " + player1.getName());
        System.out.println("Player2: " + player2.getName());
        System.out.println();

        //set up max score
        msg = "Please state win condition. \nEnter integer from 1 to 10";
        List<Integer> rangeOfAnswers = IntStream.range(1, 11).boxed().collect(Collectors.toList());
        maxScore = getIntInput(msg,rangeOfAnswers);

    }

    private void displayScore(){
        clearScreen();
        System.out.println("########################");
        System.out.println("Player1: " + player1.getName() + " Score: " + player1.getScore());
        System.out.println("Player2: " + player2.getName() + " Score: " + player2.getScore());
        System.out.println("########################");
    }

    private void clearSettings(){
        player1 = null;
        player2 = null;
        maxScore = 0;
        playerWantsToTerminateProgram = false;
        playerWantsToRestartGame = false;
        someoneWon = false;
    }

    public static void clearScreen(){
        for ( int i = 0 ; i < 10 ; i++){
            System.out.println("");
        }
    }




}
