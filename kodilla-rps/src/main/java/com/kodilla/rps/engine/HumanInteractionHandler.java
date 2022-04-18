package com.kodilla.rps.engine;

import com.kodilla.rps.moves.Moves;
import com.kodilla.rps.player.Player;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static com.kodilla.rps.engine.Engine.*;
import static com.kodilla.rps.moves.Moves.*;

public class HumanInteractionHandler {

    //Accepts input from user in INT format, input must be in given range
    public static int getIntInput(String msg, List<Integer> acceptableRangeOfAnswers){

        Scanner sc = new Scanner(System.in);
        String playerInput;
        int result = 0;

        while (true){
            System.out.println(msg);
            playerInput = sc.nextLine();
            try {
                result = Integer.parseInt(playerInput);
            }catch (NumberFormatException ex){
                System.out.println("Please enter numerical value.");
            }
            if (acceptableRangeOfAnswers.contains(result) ){
                return result;
            }
        }
    }


    //Method used to get player input during round
    //return int value:
    // in range of 1-5 (possible moves) or
    // -1 if player wants to quit the game or
    // -2 if player wants to restart the game
    public static int getInRoundPlayerInput(Player p){
        List<Integer>rangeOfIntAnswers = IntStream.range(1, values().length).boxed().toList();

        Scanner sc = new Scanner(System.in);
        String playerInput;
        int result = 0;
        String msg = p.getName() + " it is your turn.\n" +
                "Please use:\n" +
                "1. to play " + getMove(1) + "\n" + //Rock
                "2. to play " + getMove(2) + "\n" + //Paper
                "3. to play " + getMove(3) + "\n" + //Scissors
                "4. to play " + getMove(4) + "\n" + //Spock
                "5. to play " + getMove(5) + "\n" + //Lizard
                "x - to quit the game\n" +
                "n - to start new game\n";

        while (true){
            System.out.println(msg);
            playerInput = sc.nextLine();
            clearScreen();

            if(playerInput.equals("x")){
                String m = "Do you really want to quit game? \n1. Yes\n2. No";
                int confirmation = getIntInput(m,List.of(1,2));
                if (confirmation == 1)
                    return -1;
                else playerInput = "run this sequence again";
            }
            if(playerInput.equals("n")){
                String m = "Do you really want to restart the game? \n1. Yes\n2. No";
                int confirmation = getIntInput(m,List.of(1,2));
                if (confirmation == 1)
                    return -2;
                else playerInput = "run this sequence again";
            }
            try {
                result = Integer.parseInt(playerInput);
            }catch (NumberFormatException ex){
                System.out.println("Please enter one of acceptable values");
            }
            if ( rangeOfIntAnswers.contains(result))
                return result;
        }
    }

}
