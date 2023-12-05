package chessengine.src.main.exceptions;

import chessengine.src.main.Move;

/**
 * The exception {@code NoCastlingRightsException} signals that the player does not
 * have the required rights to castle.
 */
public class NoCastlingRightsException extends CastlingException{
    /**
     * Constructs a {@code NoCastlingRightsException} with the specified move.
     * @param move  the move that requires nonexistent castling rights
     */
    public NoCastlingRightsException(Move move){
        super(move, "the player doesn't have the required castling rights for this move.");
    }
}
