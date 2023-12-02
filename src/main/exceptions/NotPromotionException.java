package chessengine.src.main.exceptions;
import chessengine.src.main.Move;

/**
 * The exception {@code NotPromotionException} signals that the requirement that the 
 * move is promotion is not met.
 */
public class NotPromotionException extends Exception{
    
    /**
     * Constructs a {@code NotPromotionException} with the specified move.
     * @param move  the move that is not a promotion
     */
    public NotPromotionException(Move move){
        super("The move " + move + " is not promotion.");
    }
}