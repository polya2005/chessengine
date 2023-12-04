package chessengine.src.main;

/**
 * The class representing the player, either {@code WHITE} or {@code BLACK}.
 */
public enum Player {
    WHITE((short)0),
    BLACK((short)1);

    private short playerNo;
    private Player(short playerNo){
        this.playerNo = playerNo;
    }

    /**
     * @return  {@code 0} for white and {@code 1} for black
     */
    public short toPlayerNo(){
        return playerNo;
    }

    /**
     * @return  {@code Pieces.WHITE} or {@code Pieces.BLACK}, depending on the player
     * @see Pieces
     */
    public int toPieceColor(){
        return playerNo << 3;
    }

    /**
     * @param playerNo
     * @return  {@code Player.WHITE} if {@code playerNo} is 0 and {@code Player.BLACK}
     * if {@code playerNo} is 1
     */
    public static Player fromPlayerNo(short playerNo){
        return (playerNo == 0) ? WHITE : BLACK;
    }
    
    /**
     * @param pieceColor
     * @return  {@code Player.WHITE} if {@code pieceColor} is {@code Pieces.WHITE} and {@code Player.BLACK}
     * if {@code pieceColor} is {@code Pieces.BLACK}
     * @see Pieces
     */
    public static Player fromPieceColor(int pieceColor){
        return (pieceColor == 0) ? WHITE : BLACK;
    }
}
