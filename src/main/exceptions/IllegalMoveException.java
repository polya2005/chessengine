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

    /**
     * Constructs an {@code IllegalMoveException} with the specified move and 
     * detail.
     * @param move  the illegal move
     * @param details  the explanation of how the move is illegal
     */
    public IllegalMoveException(Move move, String details){
        super("The move " + move + " is illegal: " + details);
    }
}