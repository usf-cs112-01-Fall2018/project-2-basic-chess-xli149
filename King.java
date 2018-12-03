public class King extends ChessPiece {
    private String name;
    //constructor
    public King(){
        name = "-K-";
    }
    //take the initial value and pass the object and the initial value to super class ChessBoard
    public void initial(String move) {
        super.initialMove(move,  this);
    }
    //take the the move value and check if it is a legal move, if it is, then pass it to super class, else
    //return some specific integer according to different exception.
    public int move(String move) {
        int k = Integer.parseInt(move.trim().substring(0, 1));
        int l = Integer.parseInt(move.trim().substring(1, 3).trim());
        int i = Integer.parseInt(move.trim().substring(3, 5).trim());
        int j = Integer.parseInt(move.trim().substring(5).trim());
        if (super.checkOutOfBound(move)) {
            return 0;
        }
        else {
            if (Math.abs(k-i) == Math.abs(l-j) && Math.abs(k-i) == 1 && Math.abs(l-j) == 1) {
                if(k > i && l > j) {
                        if(!super.getValue(i,j).toString().equals("---")) {
                            return 1;
                    }
                    super.addMove(move, this);
                }
                else if(k < i && l < j){
                        if(!super.getValue(i,j).toString().equals("---")) {
                            return 1;
                        }
                    super.addMove(move, this);
                }
                else if(k > i && l < j){
                        if(!super.getValue(i,j).toString().equals("---")){
                            return 1;
                        }

                    super.addMove(move, this);
                }
                else if(k < i && l > j){
                        if(!super.getValue(i,j).toString().equals("---")){
                            return 1;
                        }
                    super.addMove(move, this);
                }
            }
            else{
                return 2;
            }
        }
        return -1;
    }
    public String toString(){
        return name;
    }
}
