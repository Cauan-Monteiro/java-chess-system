import application.UI;
import boardgame.Board;
import chess.ChessMatch;

void main() {
    ChessMatch chessMatch = new ChessMatch();
    UI.printBoard(chessMatch.getPieces());
}
