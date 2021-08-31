package bingogame;

public class BingowinCheckbyTopline implements BingowinCheck {

    public boolean wincheckByTopLine = Boolean.FALSE;

    public String summary;

    public void winCheck(Player player) {
        if(!wincheckByTopLine){
            if(checkTopLineMark(player.getBoard())){
                System.out.println(player.getName()+" has won 'Top Line' winning Combination");
                summary = player.getName()+ ":" +"Top Line";
            }
        }
    }

    private boolean checkTopLineMark(int[][] board){
        int row =0;
        int col = board[0].length;
        for(int i = 0 ; i <= row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(board[i][j] != -1 && board[i][j] != 0){
                    return false;
                }
            }}
        wincheckByTopLine=Boolean.TRUE;
        return true;
    }
}
