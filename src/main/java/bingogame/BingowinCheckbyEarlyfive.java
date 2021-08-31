package bingogame;

/**
 * The type Bingowin checkby earlyfive.
 */
public class BingowinCheckbyEarlyfive implements BingowinCheck {

    public boolean earlyFiveCheck = Boolean.FALSE;

    public String summary;

    public void winCheck(Player player) {
      int[][] board = player.getBoard();
      if(!earlyFiveCheck){
          int count =checkFirstFiveMarked(board);
          if(count == 5){
              System.out.println(player.getName()+" has won 'First Five' winning Combination");
              summary = player.getName()+ ":" +"First Five";
          }
      }
    }

    private int checkFirstFiveMarked(int[][] board){
        int row = board.length;
        int col = board[0].length;
        int markCount = 0;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(board[i][j] == -1){
                    markCount++;
                    if(markCount==5){
                        earlyFiveCheck=Boolean.TRUE;
                        break;
                    }
                }
            }
        }
        return markCount;
    }
}
