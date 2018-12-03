//class for build up a empty board.
public class initialBoard extends ChessPiece{
    private String name;
    public initialBoard(String name){
        this.name = name;
    }
    public void initial(String move){

    }
    //if user is trying to move any empty object, then return 2 to throw illegal move exception.
    public int move(String move){
        return 2;
    }
    public String toString(){
        return this.name;
    }
}
