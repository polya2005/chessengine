package chessengine.src.main;

public class CastlingRights {
    public static final int NO_CASTLING = 0;

    public static final int WHITE_KING = 1;
    public static final int WHITE_QUEEN = 2;
    public static final int BLACK_KING = 4;
    public static final int BLACK_QUEEN = 8;

    public static final int KINGSIDE = WHITE_KING | BLACK_KING;
    public static final int QUEENSIDE = WHITE_QUEEN | BLACK_QUEEN;
    public static final int WHITE_BOTH = WHITE_KING | WHITE_QUEEN;
    public static final int BLACK_BOTH = BLACK_KING | BLACK_QUEEN;

    public static final int ALL = KINGSIDE | QUEENSIDE;
}
