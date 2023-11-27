package chessengine.src.main;

public class CastlingRights {
    public static int NO_CASTLING = 0;

    public static int WHITE_KING = 1;
    public static int WHITE_QUEEN = 2;
    public static int BLACK_KING = 4;
    public static int BLACK_QUEEN = 8;

    public static int KINGSIDE = WHITE_KING | BLACK_KING;
    public static int QUEENSIDE = WHITE_QUEEN | BLACK_QUEEN;
    public static int WHITE_BOTH = WHITE_KING | WHITE_QUEEN;
    public static int BLACK_BOTH = BLACK_KING | BLACK_QUEEN;

    public static int ALL = KINGSIDE | QUEENSIDE;
}
