public class Pawn extends Piece{
    boolean firstMove;
    
    public Pawn(char side){
        super(side);
        this.firstMove = true;
        this.setType('p');
    }

    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column) {
        boolean isValid = false;
        if(this.getSide() == 'w'){
            if(my_row - 1 == end_row && my_column == end_column) isValid = true;
            if(my_row - 2 == end_row && my_column == end_column && isFirstMove(my_row)) isValid = true;
        } else if(this.getSide() == 'b'){
            if(my_row + 1 == end_row && my_column == end_column) isValid = true;
            if(my_row + 2 == end_row && my_column == end_column && isFirstMove(my_row)) isValid = true;
        }

        return isValid;
    }

    private boolean isFirstMove(int my_row){
        if(this.getSide() == 'w'){
            if(my_row == 6){
                return true;
            }
        } else if(this.getSide() == 'b'){
            if(my_row == 1){
                return true;
            }
        }

        return false;
    }

    public boolean isBlocked(int initialRow, int initialColumn, int finalRow, int finalColumn, Board board){
        for(int offset = 0; initialColumn + offset < finalColumn; offset++){
            if(!board.isEmpty(initialRow, offset + initialColumn)){
                return false;
            }
        }
        return true;
    }
}