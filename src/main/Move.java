package chessengine.src.main;
import chessengine.src.main.exceptions.NotPromotionException;

public class Move {

    /**
     * Class containing constants for move flags
     */
    public static class MoveFlag {
        public static final short NONE = 0;
        public static final short EN_PASSANT = 1;
        public static final short PAWN_TWO_STEPS = 2;
        public static final short CASTLING = 3;
        public static final short PROMOTE_TO_KNIGHT = 4;
        public static final short PROMOTE_TO_BISHOP = 5;
        public static final short PROMOTE_TO_ROOK = 6;
        public static final short PROMOTE_TO_QUEEN = 7;
    }

    private static String[] moveFlagNames = {"None", "En Passant", "Pawn 2 steps", "Castling", "Knight Promotion", "Bishop Promotion", "Rook Promotion", "Queen Promotion"};

    /*
     * b0-b5: from square
     * b6-b11: to square
     * b12-b14: move flag
     * b15: player
     */
    private short move16bit;

    /**
     * Creates the Move object
     * @param fromSquare  initial square of the move (0-63)
     * @param toSquare  final square of the move (0-63)
     * @param flag  3-bit value flag for move type
     * @param player  0 for white and 1 for black
     * @see MoveFlag
     */
    public Move(short fromSquare, short toSquare, short flag, Player player){
        move16bit = (short)(fromSquare | (toSquare << 6) | (flag << 12) | (player.toPlayerNo() << 15));
    }

    /**
     * @return  the initial square of the move
     */
    public short getFromSquare(){
        return (short)(move16bit & 0x003f); //0x003f is the bit mask for from square
    }

    /**
     * @return  the final square of the move
     */
    public short getToSquare(){
        return (short)((move16bit & 0x0fc0) >> 6); //0x0fc0 is the bit mask for to square
    }

    /**
     * @return  the flag for move type
     * @see MoveFlag
     */
    public short getMoveFlag(){
        return (short)((move16bit & 0x7000) >> 12); //0x7000 is the bit mask for move flag
    }

    /**
     * @return  Player who played the move
     * @see Player
     */
    public Player getPlayer(){
        return Player.fromPlayerNo((short)((move16bit & 0x8000) >> 15));
    }

    /**
     * @return  if the move is promotion
     */
    public boolean isPromotion(){
        return (move16bit & 0x4000) != 0; //move16bit & 0x4000 extracts the 14th bit, which is one only for promotion.
    }

    /**
     * @return  the piece id of the piece promoted
     * @see Pieces
     */
    public int piecePromoted() throws NotPromotionException{
        if(!isPromotion())
            throw new NotPromotionException(this);
        return (move16bit & 0xb000) >> 12 + Pieces.KNIGHT;
    }

    public String toString(){
        return Board.squareIndexToName(getFromSquare()) + Board.squareIndexToName(move16bit) + " (Flag: " + moveFlagNames[getMoveFlag()] + ")";
    }
}
