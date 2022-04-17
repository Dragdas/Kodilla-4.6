package com.kodilla.rps.engine;

import com.kodilla.rps.player.Player;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class HumanInteractionHandler {



    //Używany do pobrania od gracza inputu w formie INT w określonym zakresie
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

    //Metoda używana do pobrania od gracza inputu w czasie rozgrywania rundy.
    // Zwraca wartosci 1-5 dla możliwych ruchów
    // -1 dla wyjścia z gry
    // -2 dla zrestartowania gry
    public static int getInRoundPlayerInput(Player p){
        List<Integer>rangeOfIntAnswers = IntStream.range(1, 6).boxed().toList();

        Scanner sc = new Scanner(System.in);
        String playerInput;
        int result = 0;
        String msg = p.getName() + " it is your turn.\n" +
                "Please use:\n" +
                "1. to play rock\n" +
                "2. to play paper\n" +
                "3. to play scissors\n" +
                "4. to play spock\n" +
                "5. to play lizard\n" +
                "x - to quit the game\n" +
                "n - to start new game\n";

        while (true){
            System.out.println(msg);
            playerInput = sc.nextLine();
            System.out.flush();

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
