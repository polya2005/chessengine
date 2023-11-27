package chessengine.src.test;
import chessengine.src.main.Board;

public class Test {
    public static void main(String[] args) {
        Board board = Board.getBoard();
        board.loadFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        System.out.println(board);
    }
}
