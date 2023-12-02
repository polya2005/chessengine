package chessengine.src.main.exceptions;
import chessengine.src.main.Move;

/**
 * The exception {@code IncorrectPlayerToMoveException} signals that a move being attempted 
 * is made by the wrong player.
 */
public class IncorrectPlayerToMoveException extends IllegalMoveException {
    /**
     * Constructs an {@code IncorrectPlayerToMoveException} with the specified move.
     * @param move  the move played by incorrect player
     */
    public IncorrectPlayerToMoveException(Move move){
        super(move, "it is not " + move.getPlayer() + "'s turn.");
    }
}
