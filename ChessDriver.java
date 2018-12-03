import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;
public class ChessDriver {
    public static void main(String[] args) throws FileNotFoundException {
        //Find the file, if not, throw an FileNotFoundException
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        //build up a board
        ChessBoard board = new ChessBoard();
        board.build();
        String line;
        String[] lineSegment;
        //initialBoard
        Knight knight;
        Pawn pawn;
        Rook rook;
        Bishop bishop;
        Queen queen;
        King king;
        //A flag to control print
        int count = 0;
        //read the file
        while(scan.hasNextLine()) {
            line = scan.nextLine();
            lineSegment = line.split(" ");
            //detect the length of array. If it is 3, then it's initial. If it is 5, then it's a move.
            if (lineSegment.length == 3) {
                //initial the board
                if (lineSegment[0].equals("knight")) {
                    knight  = new Knight();
                    knight.initial(lineSegment[1] + " " + lineSegment[2]);
                } else if (lineSegment[0].equals("pawn")) {
                    pawn = new Pawn();
                    pawn.initial(lineSegment[1] + " " + lineSegment[2]);
                } else if (lineSegment[0].equals("rook")) {
                    rook = new Rook();
                    rook.initial(lineSegment[1] + " " + lineSegment[2]);
                } else if (lineSegment[0].equals("bishop")) {
                    bishop = new Bishop();
                    bishop.initial(lineSegment[1] + " " + lineSegment[2]);
                } else if (lineSegment[0].equals("queen")) {
                    queen = new Queen();
                    queen.initial(lineSegment[1] + " " + lineSegment[2]);
                } else if (lineSegment[0].equals("king")) {
                    king = new King();
                    king.initial(lineSegment[1] + " " + lineSegment[2]);
                }
            }
            else if (lineSegment.length == 5){
                int n = Integer.parseInt(lineSegment[1]);
                int m = Integer.parseInt(lineSegment[2]);
                //set up a flag to print the board before anything was moved.
                if(count == 0) {
                    for (int i = 0; i < ChessBoard.Rows; i++) {
                        for (int j = 0; j < ChessBoard.Cols; j++) {
                            System.out.print(board.getBoard()[i][j].toString());
                            System.out.print(" ");
                        }
                        System.out.println();
                    }
                }
                count++;
                try{
                    if(lineSegment[0].equals("move")){
                        //read move
                        //ex is a return value to detect if the move is legal or not
                        int ex;
                        System.out.print(board.getValue(n,m).toString() + ": (" + lineSegment[1] +", " + lineSegment[2] + ") ("
                                        + lineSegment[3] + ", " + lineSegment[4] + ")");
                        System.out.println();
                        ex = board.getValue(n,m).move(lineSegment[1] + " " + lineSegment[2] + " " + lineSegment[3]
                                        + " " + lineSegment[4]);
                        if(ex == 0){
                            throw new outOfBoardException("Invalid move, out of bound.");
                        }
                        else if(ex == 1){
                            throw new PathwayException("Invalid move, there is another chess piece on the way");
                        }
                        else if(ex == 2){
                            throw new illegalChessMoveException("Invalid move, against the rule of moving");
                        }
                        else { System.out.print("Moved" + ": (" + lineSegment[1] +", " + lineSegment[2] + ") ("
                                + lineSegment[3] + ", " + lineSegment[4] + ")");
                                System.out.println();
                            System.out.println("===================================");
                        }
                    }
                    else{
                        System.out.println("Wrong input, try again.");
                    }

                }catch (PathwayException ep){
                    System.out.println(ep.toString());

                }catch(outOfBoardException eo){
                    System.out.println(eo.toString());

                }catch(illegalChessMoveException ei){
                    System.out.println(ei.toString());
                }
                finally{
                    for (int i = 0; i < ChessBoard.Rows; i++) {
                        for (int j = 0; j < ChessBoard.Cols; j++) {
                            System.out.print(board.getBoard()[i][j].toString());
                            System.out.print(" ");
                        }
                        System.out.println();
                    }
                }

            }
        }
    }
}

