package chessengine.src.main;

public class Board {
    private static Board instance = null;
    
    /*
     * a1=0, b1=1, c1=2, ..., a2=8,...
     */
    private long[] bitBoards;
    private Player toPlay;
    private int castlingRights;
    private int enPassantSquareIndex;
    private int reversibleHalfMoves;
    private int moveNumber;

    /**
     * Constructor for Board class
     * Private because Board is singleton
     * Initializes values
     */
    private Board(){
        this.bitBoards = new long[16];
        this.toPlay = Player.WHITE;
        this.castlingRights = CastlingRights.ALL;
        this.enPassantSquareIndex = -1;
        this.reversibleHalfMoves = 0;
        this.moveNumber = 1;
    }

    /**
     * Returns the only Board object
     * @return  Board object
     */
    public static Board getBoard(){
        if(instance == null)
            instance = new Board();
        return instance;
    }

    /**
     * Loads standard FEN string to the board
     * @param fen  Standard FEN string
     */
    public void loadFEN(String fen){
        int squareIndex = 56;
        String[] fenParts = fen.split(" ");
        //1st part: position of pieces
        for(char ch : fenParts[0].toCharArray()){
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
                bitBoards[player | piece] |= (1l << squareIndex);
                bitBoards[player | Pieces.ALL] |= (1l << squareIndex);
                squareIndex++;
            }
        }

        //2nd part: next player
        if (fenParts[1].equals("w"))
            toPlay = Player.WHITE;
        else
            toPlay = Player.BLACK;

        //3rd part: castling rights
        if(fenParts[2].contains("K"))
            castlingRights = CastlingRights.WHITE_KING;
        if(fenParts[2].contains("Q"))
            castlingRights |= CastlingRights.WHITE_QUEEN;
        if(fenParts[2].contains("k"))
            castlingRights |= CastlingRights.BLACK_KING;
        if(fenParts[2].contains("q"))
            castlingRights |= CastlingRights.BLACK_QUEEN;

        //4th part: en passant target square
        if(fenParts[3].equals("-"))
            enPassantSquareIndex = -1;
        else {
            char[] squareName = fenParts[3].toCharArray();
            enPassantSquareIndex = (squareName[0] - 'a') | ((squareName[1] - '1') << 3);
        }

        //5th part: halfmoves after last pawn move/ capture
        reversibleHalfMoves = Integer.parseInt(fenParts[4]);

        //6th part: move number
        moveNumber = Integer.parseInt(fenParts[5]);
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
                char piece = (char)( ((bitBoards[Pieces.BLACK | Pieces.ROOK] >> squareIndex) & 1l) * 'r' +
                                    ((bitBoards[Pieces.BLACK | Pieces.KNIGHT] >> squareIndex) & 1l) * 'n' +
                                    ((bitBoards[Pieces.BLACK | Pieces.BISHOP] >> squareIndex) & 1l) * 'b' +
                                    ((bitBoards[Pieces.BLACK | Pieces.QUEEN] >> squareIndex) & 1l) * 'q' +
                                    ((bitBoards[Pieces.BLACK | Pieces.KING] >> squareIndex) & 1l) * 'k' +
                                    ((bitBoards[Pieces.BLACK | Pieces.PAWN] >> squareIndex) & 1l) * 'p' +
                                    ((bitBoards[Pieces.WHITE | Pieces.ROOK] >> squareIndex) & 1l) * 'R' +
                                    ((bitBoards[Pieces.WHITE | Pieces.KNIGHT] >> squareIndex) & 1l) * 'N' +
                                    ((bitBoards[Pieces.WHITE | Pieces.BISHOP] >> squareIndex) & 1l) * 'B' +
                                    ((bitBoards[Pieces.WHITE | Pieces.QUEEN] >> squareIndex) & 1l) * 'Q' +
                                    ((bitBoards[Pieces.WHITE | Pieces.KING] >> squareIndex) & 1l) * 'K' +
                                    ((bitBoards[Pieces.WHITE | Pieces.PAWN] >> squareIndex) & 1l) * 'P' );
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
