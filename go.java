import java.util.Scanner;


public class go {
    static int[][] board; 
    static int N;
    public go(int n){
        board = new int[n][n];
        N = n;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                board[i][j] = 0;
            }
        }
    }
    public static void display(){
        System.out.print("  ");
        for(int k = 0; k < N; k++){
            System.out.printf("%4s",k);
        }
        System.out.println("");
        System.out.print(" ");
        
        System.out.println();
        for(int i = 0; i < N; i++){
            System.out.printf("%3s",i);
            System.out.print("  ");
            for(int j = 0; j < N; j++){
                if(board[i][j] == 0) System.out.print("+"); else System.out.print(board[i][j]);
                //System.out.print(board[i][j]);
                if(j < N-1){
                    System.out.print(" - ");
                }
                
            }
            System.out.println();
            System.out.print("  ");
            if(i < N-1){
                for(int k = 0; k < N; k++){
                    System.out.printf("%4s","|");
                }
            }
            
            System.out.println();
            
        }
    }
    public static boolean placeStone(int x, int y, int player){ //player is either 1 or 2, and thus shows who it is, boolen returns whether the placement was sucessful
        if(player != 1 && player != 2 ){
            throw new java.lang.IndexOutOfBoundsException("Player was passed in as something other then 1 or 2 in the placeStone function");
        }
        try{
            if(board[x][y] == 0){
                board[x][y] = player;
                return true;
            }else{
                return false;
            }
        } catch(Exception IndexOutOfBoundsException){
            return false;
        }
        
    }


    /*
     * outline of method, when someone places a piece, it checks the neighbors of that piece, if one is of the oppsiete color, it considers 
     * have i been captured?
     * have i captured that block/s?
     * 
     */
    public static boolean isStonecaptured(int x, int y){
        // 1 is white 2 is black
        int liberties;
        if(x == 0 || y == 0 && x != y){ //along one of the rows
            liberties = 3;
        }
        
        int otherColor = 0;
        if(board[x][y] == 1) otherColor = 2; else otherColor = 1;
        if(x > 0 && x < N - 1 && y > 0 && x < N - 1){
            if(board[x][y+1] == otherColor) liberties--;
            if(board[x][y-1] == otherColor) liberties--;
            if(board[x+1][y] == otherColor) liberties--;
            if(board[x-1][y] == otherColor) liberties--;
        }
        if(liberties == 0){
            return false;
        }
        if(board[x][y+1])
    }

    public static void main(String[] args){

        go nG = new go(10);
        nG.display();
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        while(true){
            int moveX = scan.nextInt();
            int moveY = scan.nextInt();
            while(!placeStone(moveX, moveY, 1)){
                System.out.println("You cant place a piece there!");
                moveX = scan.nextInt();
                moveY = scan.nextInt();
            }
            
            nG.display();
            counter++;
            if(counter > 20){
                break;
            }
        }
        scan.close();
        nG.display();
    }



}