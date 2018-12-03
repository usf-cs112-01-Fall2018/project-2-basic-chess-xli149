public class Knight extends ChessPiece {
    private String name;
    //constructor
    public Knight(){
        name = "-h-";
    }
    //take the initial value and pass the object and the initial value to super class ChessBoard
    public void initial(String move){
        super.initialMove(move,this);
    }
    //take the the move value and check if it is a legal move, if it is, then pass it to super class, else
    //return some specific integer according to different exception.
    public int move (String move){
        int k = Integer.parseInt(move.trim().substring(0, 1));
        int l = Integer.parseInt(move.trim().substring(1, 3).trim());
        int i = Integer.parseInt(move.trim().substring(3, 5).trim());
        int j = Integer.parseInt(move.trim().substring(5).trim());
        //check bound
        if(super.checkOutOfBound(move)){
            return 0;
        }
        else{
            //check move
            if(Math.abs(k-i) == 1 && Math.abs(l-j) == 2 || Math.abs(k-i) == 2 && Math.abs(l-j) == 1){
                if(!super.getValue(i,j).toString().equals("---")){
                    return 1;
                }
                super.addMove(move, this);

            }
            else{
                return 2;
            }
        }
        return 3;
    }
    //return the name of the object.
    public String toString(){
        return name;
    }
}
