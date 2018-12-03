import java.lang.*;
public abstract class ChessPiece extends ChessBoard{
    public boolean checkOutOfBound(String move){
        int k = Integer.parseInt(move.trim().substring(0, 1));
        int l = Integer.parseInt(move.trim().substring(1, 3).trim());
        int i = Integer.parseInt(move.trim().substring(3, 5).trim());
        int j = Integer.parseInt(move.trim().substring(5).trim());
        if(i > 7 || i < 0 || j > 7 || j < 0) {
            return true;
        }
        return false;
    }
    public abstract String toString();
    public abstract void initial(String move);
    public abstract int move(String move);
}
