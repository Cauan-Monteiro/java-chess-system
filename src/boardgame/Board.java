package boardgame;

public class Board {
    private int rows;
    private int cols;
    private Piece[][] pieces;

    public Board(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            try {
                throw new BoardException("Error creating board: there must be at leat 1 row and 1 column");
            } catch (BoardException e) {
                throw new RuntimeException(e);
            }
        }
        this.rows = rows;
        this.cols = cols;
        pieces = new Piece[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Piece piece (int row, int col) {
        if (!positionExists(row, col)) {
            try {
                throw new BoardException("Position not on the board");
            } catch (BoardException e) {
                throw new RuntimeException(e);
            }
        }
        return pieces[row][col];
    }

    public Piece piece(Position position) {
        if (!positionExists(position)) {
            try {
                throw new BoardException("Position not on the board");
            } catch (BoardException e) {
                throw new RuntimeException(e);
            }
        }
        return pieces[position.getRow()][position.getCol()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            try {
                throw new BoardException("There is already a piece on position "+ position);
            } catch (BoardException e) {
                throw new RuntimeException(e);
            }
        }
        pieces[position.getRow()][position.getCol()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getCol());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            try {
                throw new BoardException("Position not on the board");
            } catch (BoardException e) {
                throw new RuntimeException(e);
            }
        }
        return piece(position) != null;
    }
}
