package history;

import java.util.Vector;
import pieces.Receipt;


/**
 * The History class maintains the history of moves made in the chess game.
 * It stores receipts of each move and provides methods to access and print the history.
 * This class is immutable except for additions (adding new receipts).
 */
public class History {

    /** The list of receipts representing the history of moves. */
    private Vector<Receipt> receipts;

    /**
     * Constructs a new History object with an empty list of receipts.
     */
    public History() {
        this.receipts = new Vector<>();
    }

    /**
     * Constructs a new History object with the given list of receipts.
     * @param history The list of receipts representing the history of moves.
     */
    public History(Vector<Receipt> history) {
        this.receipts = new Vector<>(history);
    }

    /**
     * Constructs a new History object with the given array of receipts.
     * @param receipts The array of receipts representing the history of moves.
     */
    public History(Receipt[] receipts) {
        for(int i = 0; i < receipts.length; i++){
            this.receipts.add(receipts[i]);
        }
    }

    /**
     * Adds a new receipt representing a move to the history.
     * @param receipt The receipt representing the move to be added.
     */
    public void add(Receipt receipt) {
        this.receipts.add(receipt);
    }

    /**
     * Retrieves the initial row index of the specified receipt.
     * @param receiptNumber The index of the receipt in the history.
     * @return The initial row index of the receipt.
     */
    public int getReceiptInitialRow(int receiptNumber) {
        return receipts.get(receiptNumber).getInitialRow();
    }

    /**
     * Retrieves the initial column index of the specified receipt.
     * @param receiptNumber The index of the receipt in the history.
     * @return The initial column index of the receipt.
     */
    public int getReceiptInitialColumn(int receiptNumber) {
        return receipts.get(receiptNumber).getInitialColumn();
    }

    /**
     * Retrieves the final row index of the specified receipt.
     * @param receiptNumber The index of the receipt in the history.
     * @return The final row index of the receipt.
     */
    public int getReceiptFinalRow(int receiptNumber) {
        return receipts.get(receiptNumber).getFinalRow();
    }

    /**
     * Retrieves the final column index of the specified receipt.
     * @param receiptNumber The index of the receipt in the history.
     * @return The final column index of the receipt.
     */
    public int getReceiptFinalColumn(int receiptNumber) {
        return receipts.get(receiptNumber).getFinalColumn();
    }

    /**
     * Finds the index of the first occurrence of the specified receipt in the history.
     * @param receipt The receipt to search for.
     * @return The index of the receipt if found; otherwise, -1.
     */
    public int findReceipt(Receipt receipt) {
        return receipts.indexOf(receipt);
    }

    /**
     * Prints the entire history of moves.
     */
    public void printHistory() {
        printHistory(0, receipts.size());
    }

    /**
     * Prints a range of receipts in the history.
     * @param startRange The starting index of the range (inclusive).
     * @param endRangeExclusive The ending index of the range (exclusive).
     */
    public void printHistory(int startRange, int endRangeExclusive) {
        for (int i = startRange; i < endRangeExclusive; i++) {
            receipts.get(i).printReceipt();
        }
    }

    /**
     * Prints a specific receipt in the history.
     * @param history The index of the receipt to print.
     */
    public void printHistory(int history) {
        receipts.get(history).printReceipt();
    }

    /**
     * Retrieves the most recent receipt in the history.
     * @return The most recent receipt.
     */
    public Receipt getRecentReceipt() {
        return receipts.lastElement();
    }

    /**
     * Prints the most recent receipt in the history.
     */
    public void printReceipt() {
        getRecentReceipt().printReceipt();
    }
}
