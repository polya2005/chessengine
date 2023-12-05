package chessengine.src.main.exceptions;
import chessengine.src.main.Move;

public abstract class CastlingException extends IllegalMoveException {
    public CastlingException(Move move, String details){
        super(move, details);
    }
}
