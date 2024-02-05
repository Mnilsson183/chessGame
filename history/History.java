package history;

import java.util.Vector;
import pieces.Receipt;

// immutable excluding additions
public class History {
    private Vector<Receipt> receipts;

    public History(){
        this.receipts = new Vector<Receipt>();
    }

    public History(Vector<Receipt> history){
        this.receipts = history;
    }

    public History(Receipt[] receipts){
        for(int i = 0; i < receipts.length; i++){
            this.receipts.add(receipts[i]);
        }
    }

    public void add(Receipt receipt){
        this.receipts.add(receipt);
    }

    public int getReceiptInitialRow(int receiptNumber){
        return receipts.get(receiptNumber).getInitialRow();
    }

    public int getReceiptInitialColumn(int receiptNumber){
        return receipts.get(receiptNumber).getInitialColumn();
    }

    public int getReceiptFinalRow(int receiptNumber){
        return receipts.get(receiptNumber).getFinalRow();
    }

    public int getReceiptFinalColumn(int receiptNumber){
        return receipts.get(receiptNumber).getFinalColumn();
    }

    // will only return the first instance that this move happened on
    // is flawed TODO fix this behavior
    public int findReceipt(Receipt receipt){   
        for(int i = 0; i < receipts.size(); i++){
            if(receipts.get(i).equals(receipt)){
                return i;
            }
        }
        return -1;
    }

    public void printHistory(){

    }

    private void
}
