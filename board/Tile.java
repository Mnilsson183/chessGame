package board;
import pieces.Piece;

public class Tile {

    private final int row;
    private final int column;
    private Piece piece;

    public Tile(){
        this.row = 0;
        this.column = 0;
    }

    public Tile(int x, int y){
        this.row = x;
        this.column = y;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }

    public boolean isDiagonal(Tile tile){
        if((this.getRow() - tile.getRow()) == (this.getColumn() - tile.getColumn())) return true;
        else return false;
    }

    public boolean isStraight(Tile tile){
        if(this.getRow() == tile.getRow() ^ this.getColumn() == tile.getColumn()) return true;
        else return false;
    }

    public Piece getBoardPiece(){
        return this.piece;
    }

    public void setBoardPiece(Piece piece){
        this.piece = piece;
    }

    public boolean isValidMove(Tile tile, Board board){
        return this.getBoardPiece().isValidMove(this.getRow(), this.getColumn(), tile.getRow(), tile.getColumn(), board);
    }

    public char getSide(){
        return this.getBoardPiece().getSide();
    }

    public boolean isEmpty(){
        return this.getBoardPiece().getType() == ' ';
    }

}
