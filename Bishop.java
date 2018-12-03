public class Bishop extends ChessPiece {
    private String name;
    public Bishop(){
        name = "-b-";
    }
    public void initial(String move){
        super.initialMove(move, this);
    }
    public int move (String move){
        int k = Integer.parseInt(move.trim().substring(0, 1));
        int l = Integer.parseInt(move.trim().substring(1, 3).trim());
        int i = Integer.parseInt(move.trim().substring(3, 5).trim());
        int j = Integer.parseInt(move.trim().substring(5).trim());
        if(super.checkOutOfBound(move)){
            return 0;
        }
        else {
            if (Math.abs(k-i) == Math.abs(l-j)) {
                if(k > i && l > j) {
                    for(int n = k - 1, m = l - 1; n >= i; n--, m--){
                        if(!super.getValue(n,m).toString().equals("---")) {
                           return 1;
                        }
                    }
                    super.addMove(move, this);
                }
                else if(k < i && l < j){
                    for(int n = k + 1, m = l + 1; n <= i; n++, m++){
                        if(!super.getValue(n,m).toString().equals("---")){
                            return 1;
                        }
                    }
                    super.addMove(move, this);
                }
                else if(k > i && l < j){
                    for(int n = k - 1, m = l + 1; n >= i; n--, m++){
                        if(!super.getValue(n,m).toString().equals("---")){
                            return 1;
                        }
                    }
                    super.addMove(move, this);
                }
                else if(k < i && l > j){
                    for(int n = k + 1, m = l - 1; n <= i; n++, m--){
                        if(!super.getValue(n,m).toString().equals("---")){
                            return 1;
                        }
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
