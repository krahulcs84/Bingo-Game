package bingogame;

public class Player {

   private String name;
   private int[][] board;

    public Player(String name, int[][] board) {
        this.name = name;
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void markMatchNumber(int number){
        int[][] board = this.getBoard();
        int row = board.length;
        int col = board[0].length;

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(board[i][j] == number){
                    board[i][j]=-1;
                }
            }
        }
    }

}
