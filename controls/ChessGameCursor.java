package controls;

public class ChessGameCursor {
   private int row;
   private int column;
   int rowMax;
   int columnMax;
   public ChessGameCursor(){
      row = 0;
      column = 0;
      columnMax = 8;
      rowMax = 8;
   }
   public ChessGameCursor(int rowMax, int columnMax){
      row = 0;
      column = 0;
      this.rowMax = rowMax;
      this.columnMax = columnMax;
   }

   public void moveCursorU(){
      if(column + 1 >= columnMax){
            return;
      } column++;
   }

   public void moveCursorD(){
      if(column - 1 < 0){
            return;
      } column--;
   }
   
   public void moveCursorR(){
      if(row + 1 >= rowMax){
            return;
      } row++;
   }

   public void moveCursorL(){
      if(row - 1 >= rowMax){
            return;
      } row--;
   }

   public int getRow(){
      return this.row;
   }

   public int getColumn(){
      return this.column;
   }
}
