package chessengine.src.test;
import chessengine.src.main.Board;

public class Test {
    public static void main(String[] args) {
        Board board = Board.getBoard();
        board.loadFEN("rnbqkbnr/pp1ppppp/8/2p5/4P3/8/PPPP1PPP/RNBQKBNR w KQkq c6 0 2");
        System.out.println(board);
    }
}
