package bingogame;

public class BingowinCheckbyFullhouse  implements BingowinCheck{

    public boolean winCheckFullHouse = Boolean.FALSE;

    public String summary;

    public void winCheck(Player player) {

        int[][] board = player.getBoard();
        if(!winCheckFullHouse){
            if(checkAllMarked(board)){
                System.out.println(player.getName()+" has won 'Full House' winning Combination");
                summary = player.getName()+ ":" +"Full House";
            }
        }
    }
    private boolean checkAllMarked(int[][] board){
        int row = board.length;
        int col = board[0].length;

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(board[i][j] != -1 && board[i][j] != 0){
                    return false;
                }
            }
        }
        winCheckFullHouse=Boolean.TRUE;
      return true;
    }
}
