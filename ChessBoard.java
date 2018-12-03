public class ChessBoard {
    public static final int Rows = 9;
    public static final int Cols = 9;
    //create a 2D array of type ChessPiece
    private static ChessPiece[][] board = new ChessPiece[Rows][Cols];
    //constructor
    public ChessBoard() {


    }
    //build up an empty board, type ChessPiece
    public void build(){
        int n1 = 7, n2 = 0;
        for (int i = 0; i < Rows - 1; i++) {
            for (int j = 1; j < Cols; j++) {
                initialBoard slot = new initialBoard("---");
                board[i][j] = slot;
            }
        }
        for (int v = 0; v < 8; v++) {
            initialBoard slot = new initialBoard("=" + n1 + "=");
            board[v][0] = slot;
            n1--;
        }
        for (int h = 1; h < 9; h++) {
            initialBoard slot = new initialBoard("=" + n2 + "=");
            board[8][h] = slot;
            n2++;
        }
        initialBoard slot = new initialBoard("===");
        board[8][0] = slot;

    }

    public void initialMove(String move, ChessPiece piece){

        int i = Integer.parseInt(move.trim().substring(0, 1));
        int j = Integer.parseInt(move.trim().substring(1).trim());
        if (board[7-j][i+1].toString().equals("---"))
            board[7-j][i+1] = piece;
    }
    public void addMove(String move, ChessPiece piece){
        int k = Integer.parseInt(move.trim().substring(0, 1));
        int l = Integer.parseInt(move.trim().substring(1, 3).trim());
        int i = Integer.parseInt(move.trim().substring(3, 5).trim());
        int j = Integer.parseInt(move.trim().substring(5, 7).trim());
        initialBoard slot = new initialBoard("---");
        board[7 - l][k + 1] = slot;
        board[7 - j][i + 1] = piece;

    }

    public ChessPiece getValue(int i, int j){
        return board[7-j][i+1];
    }

    public ChessPiece[][] getBoard(){
       return board;
    }


}
