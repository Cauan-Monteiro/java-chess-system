import application.UI;
import boardgame.Board;
import boardgame.BoardException;
import chess.ChessMatch;

void main(){
    ChessMatch chessMatch = new ChessMatch();
    UI.printBoard(chessMatch.getPieces());
}
