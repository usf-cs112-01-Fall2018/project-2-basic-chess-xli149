public class Pawn extends ChessPiece{
    private String name;
    //check if the object has already moved. if it is, then it's not allow to move 2 space. Otherwise it can be moved 2
    //spaces.
    private int countTwoSpaces = 0;
    //constructor
    public Pawn(){
        name = "-p-";
    }
    //take the initial value and pass the object and the initial value to super class ChessBoard
    public void initial(String move){
        super.initialMove(move,this);
    }
    //take the the move value and check if it is a legal move, if it is, then pass it to super class, else
    //return some specific integer according to different exception.
    public int move(String move){
        int k = Integer.parseInt(move.trim().substring(0, 1));
        int l = Integer.parseInt(move.trim().substring(1, 3).trim());
        int i = Integer.parseInt(move.trim().substring(3, 5).trim());
        int j = Integer.parseInt(move.trim().substring(5).trim());

        if(super.checkOutOfBound(move)){
            return 0;
        }
        else{
            if(k != i || Math.abs(l-j) > 2){
                return 2;
            }
            else if(countTwoSpaces != 0 && Math.abs(l-j) == 2 ){
                return 2;
            }
            else {
                    countTwoSpaces++;
                    if (j > l) {
                        if (!super.getValue(k, l + 1).toString().equals("---")) {
                            return 1;
                        }
                        super.addMove(move, this);
                    } else if (j < l) {
                        if (!super.getValue(k, l - 1).toString().equals("---")) {
                            return 1;
                        }
                        super.addMove(move, this);

                    }

                }
            }
        return 3;
    }
    public String toString(){
        return name;
    }

}
