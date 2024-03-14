package board;
import java.util.Scanner;

import controls.ChessGameCursor;
import pieces.Receipt;
import utils.utils;
import controls.Controller;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * The Player class represents a player in the chess game.
 * It manages the player's side (color) and provides methods for making moves.
 */
public class Player {

    /** The side (color) of the player. */
    char side;

    /** 
     * A flag indicating whether the player's king is currently in check. 
     * Initialized as false.
     */
    boolean isChecked;

    /**
     * Constructs a new Player object with the specified side.
     * @param side The side (color) of the player. 'w' - White, 'b' - Black.
     */
    public Player(char side){
        this.side = side;
    }
    
    /**
     * Makes a move on the board based on the player's input.
     * @param board The chess board on which the move is to be made.
     * @return A receipt object containing information about the move.
     */
    public Receipt makeMove(Board board, ChessGameCursor cursor){
        switch (this.getSide()) {
            case 'w':
                System.out.print("White ");
                break;
        
            case 'b':
                System.out.print("Black ");
                break;
        }

        Console console = System.console();

        if (console == null) {
            System.out.println("Console is not available");
            System.exit(1);
        }

        try {
            boolean set = false;
            while (true) {
                // Read input from the user
                int key = console.reader().read();

                if (key == -1) {
                    break; // End of input
                } else if (key == 'q') {
                    if(!set){
                        cursor.stash();
                    } else {
                        break; // Quit on 'q'
                    }
                } else if (key == 27) {
                    int arrowKey = console.reader().read();
                    if (arrowKey == '[') {
                        arrowKey = console.reader().read();
                        switch (arrowKey) {
                            case 'A':
                                cursor.moveCursorU();
                                break;
                            case 'B':
                                cursor.moveCursorD();
                                break;
                            case 'C':
                                cursor.moveCursorR();
                                break;
                            case 'D':
                                cursor.moveCursorL();
                                break;
                        }
                        ((ui.ChessGameTui)Controller.chessGameUi).renderChessBoard(Controller.board);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading from user");
            System.exit(0);
        }

        Receipt receipt = board.movePiece(cursor.getStashedRow(),cursor.getStashedColumn(),cursor.getRow(),cursor.getColumn(), this.side);
        return receipt;
    }

    /**
     * Gets the player's side (color).
     * @return The side of the player. 'w' - White, 'b' - Black.
     */
    public char getSide(){
        return side;
    }
}
