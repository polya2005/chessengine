package chessengine.src.main.exceptions;
import chessengine.src.main.Move;;

/**
 * The exception {@code IllegalMoveException} signals that a move being attempted 
 * to make is illegal.
 */
public class IllegalMoveException extends Exception{
    /**
     * Constructs an {@code IllegalMoveException} with the specified move.
     * @param move  the illegal move
     */
    public IllegalMoveException(Move move){
        super("The move " + move + " is illegal.");
    }
}