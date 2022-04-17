package com.kodilla.rps.moves;

import com.kodilla.rps.player.Player;

import java.util.List;
import java.util.Objects;

public class Move implements Comparable<Move> {

    private final Moves move;
    private final Player player;

    public Move(Moves move, Player player) {
        this.move = move;
        this.player = player;
    }

    public Moves getMove() {
        return move;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return move.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Move)) return false;
        Move move1 = (Move) o;
        return move == move1.move;
    }

    @Override
    public int hashCode() {
        return Objects.hash(move);
    }


    @Override
    public int compareTo(Move otherMove) {
        if(this.equals(otherMove))
            return 0;
        List<Moves> winConditions = Moves.winConditions.get(move);

        if(winConditions.contains(otherMove.getMove()))
            return -1;


        return 1;
    }
}
