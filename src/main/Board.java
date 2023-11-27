package chessengine.src.main;

public class Board {
    private Board(){}

    private static Board instance = null;
    /**
     * Returns the only Board object
     * @return  Board object
     */
    public static Board getBoard(){
        if(instance == null){
            instance = new Board();
        }
        return instance;
    }

    /*
     * a1=0, b1=1, c1=2, ..., a2=8,...
     */
    private long[] bitBoards = new long[16];

    /**
     * Loads standard FEN string to the board
     * @param fen  Standard FEN string
     */
    public void loadFEN(String fen){
        int squareIndex = 56;
        for(char ch : fen.toCharArray()){
            //only loop until space
            if(ch == ' '){
                break;
            }

            //the slash means next rank
            if(ch == '/'){
                squareIndex = (squareIndex / 8 - 2) * 8;
                continue;
            }

            //skipping squares
            if(Character.isDigit(ch)){
                squareIndex += (ch - '0');
                continue;
            }

            if(Character.isUpperCase(ch) || Character.isLowerCase(ch)){
                int player = Character.isUpperCase(ch) ? Pieces.WHITE : Pieces.BLACK;
                int piece = 0;
                switch(Character.toLowerCase(ch)){
                    case 'r':
                        piece = Pieces.ROOK;
                        break;
                    case 'n':
                        piece = Pieces.KNIGHT;
                        break;
                    case 'b':
                        piece = Pieces.BISHOP;
                        break;
                    case 'q':
                        piece = Pieces.QUEEN;
                        break;
                    case 'k':
                        piece = Pieces.KING;
                        break;
                    case 'p':
                        piece = Pieces.PAWN;
                        break;
                }
                bitBoards[player | piece] |= (1 << squareIndex);
                bitBoards[player | Pieces.ALL] |= (1 << squareIndex);
            }
        }
    }

    public String toString(){
        String res = "";
        String hLine = "  +---+---+---+---+---+---+---+---+\n";
        for(int rank = 8; rank > 0; rank--){
            res += hLine;
            res += rank;
            for(int file = 0; file < 8; file++){
                res += " | ";
                int squareIndex = (rank - 1) * 8 + file;
                char piece = (char)( ((bitBoards[Pieces.BLACK | Pieces.ROOK] >> squareIndex) & 1) * 'r' +
                                    ((bitBoards[Pieces.BLACK | Pieces.KNIGHT] >> squareIndex) & 1) * 'n' +
                                    ((bitBoards[Pieces.BLACK | Pieces.BISHOP] >> squareIndex) & 1) * 'b' +
                                    ((bitBoards[Pieces.BLACK | Pieces.QUEEN] >> squareIndex) & 1) * 'q' +
                                    ((bitBoards[Pieces.BLACK | Pieces.KING] >> squareIndex) & 1) * 'k' +
                                    ((bitBoards[Pieces.BLACK | Pieces.PAWN] >> squareIndex) & 1) * 'p' +
                                    ((bitBoards[Pieces.WHITE | Pieces.ROOK] >> squareIndex) & 1) * 'R' +
                                    ((bitBoards[Pieces.WHITE | Pieces.KNIGHT] >> squareIndex) & 1) * 'N' +
                                    ((bitBoards[Pieces.WHITE | Pieces.BISHOP] >> squareIndex) & 1) * 'B' +
                                    ((bitBoards[Pieces.WHITE | Pieces.QUEEN] >> squareIndex) & 1) * 'Q' +
                                    ((bitBoards[Pieces.WHITE | Pieces.KING] >> squareIndex) & 1) * 'K' +
                                    ((bitBoards[Pieces.WHITE | Pieces.PAWN] >> squareIndex) & 1) * 'P' );
                if(piece == '\0')
                    piece = ' ';
                res += piece;
            }
            res += " |\n";
        }
        res += hLine;
        res += "    a   b   c   d   e   f   g   h";
        return res;
    }
}
