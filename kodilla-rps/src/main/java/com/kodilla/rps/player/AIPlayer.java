package com.kodilla.rps.player;

import com.kodilla.rps.moves.Move;


import java.util.concurrent.ThreadLocalRandom;
import com.kodilla.rps.moves.Moves;

import java.util.List;
import java.util.stream.Collectors;

import static com.kodilla.rps.engine.HumanInteractionHandler.getIntInput;

public class AIPlayer extends Player{

    private boolean hardModeOn;

    public AIPlayer() {
        this.name = "AI Player";
        String msg = "Do u want to enable hard mode?\n1- yes\n2- give me hope ";
        int playerInput = getIntInput(msg, List.of(1,2));
        this.hardModeOn = playerInput == 1 ? true : false;
    }

    @Override
    public String toString() {
        return "AIPlayer{" +
                "hardModeOn=" + hardModeOn +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public Move generateMove(int moveNo) {
        if(hardModeOn ){
            boolean aiWins = ThreadLocalRandom.current().nextInt(0, 2) == 0;
            boolean aiDrawOrLoose = ThreadLocalRandom.current().nextInt(0, 4) == 0;
            Moves opponentMove = Moves.getMove(moveNo);

            List<Moves> winningMoves = Moves.winConditions.entrySet().stream()
                    .flatMap(movesListEntry -> movesListEntry.getValue().stream())
                    .filter(move -> !Moves.winConditions.get(opponentMove).contains(move))
                    .filter(move -> !opponentMove.equals(move))
                    .collect(Collectors.toList());

            List<Moves> drawOrLoseMoves = Moves.winConditions.entrySet().stream()
                    .flatMap(movesListEntry -> movesListEntry.getValue().stream())
                    .filter(move -> Moves.winConditions.get(opponentMove).contains(move))
                    .collect(Collectors.toList());
            drawOrLoseMoves.add(opponentMove);


            if(aiWins){
                int randomMoveNo = ThreadLocalRandom.current().nextInt(0, winningMoves.size());
                Moves generatedMove = winningMoves.get(randomMoveNo);
                lastMove = new Move(generatedMove,this);
                return lastMove;
            }

            if(aiDrawOrLoose){
                int randomMoveNo = ThreadLocalRandom.current().nextInt(0, drawOrLoseMoves.size());
                Moves generatedMove = drawOrLoseMoves.get(randomMoveNo);
                lastMove = new Move(generatedMove,this);
                return lastMove;
            }



            int randomMoveNo = ThreadLocalRandom.current().nextInt(1, 6);
            lastMove = new Move(Moves.getMove(randomMoveNo),this);
            return lastMove;
        }
        else{
            int randomMoveNo = ThreadLocalRandom.current().nextInt(1, 6);
            lastMove = new Move(Moves.getMove(randomMoveNo),this);
            return lastMove;


        }






    }


}
