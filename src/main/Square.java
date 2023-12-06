package chessengine.src.main;

public enum Square {
    A1, B1, C1, D1, E1, F1, G1, H1,
    A2, B2, C2, D2, E2, F2, G2, H2,
    A3, B3, C3, D3, E3, F3, G3, H3,
    A4, B4, C4, D4, E4, F4, G4, H4,
    A5, B5, C5, D5, E5, F5, G5, H5,
    A6, B6, C6, D6, E6, F6, G6, H6,
    A7, B7, C7, D7, E7, F7, G7, H7,
    A8, B8, C8, D8, E8, F8, G8, H8;

    private static String[] rankStrings = {"a", "b", "c", "d", "e", "f", "g", "h"};

    /**
     * Extracts the rank (row) data from square index.
     * @param squareIndex  square index
     * @return  the rank of the square, from 1 to 8 inclusive
     */
    public static short getRank(short squareIndex){
        return (short)(squareIndex/8 + 1);
    }

    /**
     * Extracts the file (column) data from square index.
     * @param squareIndex  square index
     * @return  the file of the square, from 1 to 8 inclusive
     */
    public static short getFile(short squareIndex){
        return (short)(squareIndex % 8 + 1);
    }

    /**
     * Converts square index to algebraic notation
     * @param squareIndex  the index of the square
     * @return  algebraic notation of the square, e.g. c4
     */
    public static String squareIndexToName(short squareIndex){
        return rankStrings[getFile(squareIndex) - 1] + getRank(squareIndex);
    }

    public static Square fromSquareIndex(short squareIndex){
        return Square.values()[squareIndex];
    }

    /**
     * Extracts the rank (row) data from square index.
     * @return  the rank of the square, from 1 to 8 inclusive
     */
    public short getRank(){
        return getRank((short)this.ordinal());
    }
    
    /**
     * Extracts the file (column) data from square index.
     * @return  the file of the square, from 1 to 8 inclusive
     */
    public short getFile(){
        return getFile((short)this.ordinal());
    }

    public String toString(){
        return squareIndexToName((short)this.ordinal());
    }
}
