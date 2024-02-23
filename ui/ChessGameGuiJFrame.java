package ui;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import board.Board;

import java.awt.*;

public class ChessGameGuiJFrame extends JFrame{
    private Board board;

    /**
     * Creates a GUI window for the chess game.
     * @param board The game board.
     */
    public ChessGameGuiJFrame(Board board){
        super("Chess Game");
        this.board = board;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        JPanel chessBoardJPanel = createBoardJPanel();
        add(chessBoardJPanel);
        setVisible(true);
    }

    /**
     * Creates the panel for the chess board.
     * @return The panel containing the chess board.
     */
    private JPanel createBoardJPanel(){
        JPanel chessBoardJPanel = new JPanel(new GridLayout(8, 8));
        
        for(int row = 0; row < 8; row++){
            for(int column = 0; column < 8; column++){
                JButton tileButton = createTileButton(row, column);
                chessBoardJPanel.add(tileButton);
            }
        }

        return chessBoardJPanel;
    }

    /**
     * Creates a button representing a tile on the chess board.
     * @param row The row of the tile.
     * @param column The column of the tile.
     * @return The button representing the tile.
     */
    private JButton createTileButton(int row, int column){
        JButton button = new JButton();
        button.setBackground((row + column) % 2 == 0 ? Color.white : Color.BLACK);
        button.addActionListener(e -> handleTileClick(row, column));
        return button;
    }

    /**
     * Handles the click event on a tile button.
     * @param row The row of the clicked tile.
     * @param column The column of the clicked tile.
     */
    private void handleTileClick(int row, int column){
        
    }

    /**
     * Renders the chess board on the GUI.
     * @param board The game board to render.
     */
    public void renderChessBoard(Board board){
        
    }

}
