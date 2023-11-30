package chessengine.src.main;

public enum Player {
    WHITE((short)0),
    BLACK((short)1);

    private short playerNo;
    private Player(short playerNo){
        this.playerNo = playerNo;
    }

    public short toPlayerNo(){
        return playerNo;
    }

    public int toPieceColor(){
        return playerNo << 3;
    }

    public static Player fromPlayerNo(short playerNo){
        return (playerNo == 0) ? WHITE : BLACK;
    }
    
    public static Player fromPieceColor(int pieceColor){
        return (pieceColor == 0) ? WHITE : BLACK;
    }
}
