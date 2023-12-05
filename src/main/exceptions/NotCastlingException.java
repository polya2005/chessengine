package chessengine.src.main.exceptions;

import chessengine.src.main.Move;

/**
 * The exception {@code NotCastlingException} signals that the move with CASTLING flad is
 * not really castling.
 */
public class NotCastlingException extends CastlingException {
    /**
     * Constructs a {@code NotCastlingException} with the specified move.
     * @param move  the move flagged CASTLING that is not a castling
     */
    public NotCastlingException(Move move){
        super(move, "this move is not castling, but the move flag says so.");
    }
}
