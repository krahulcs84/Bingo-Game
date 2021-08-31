package bingogame;

import java.util.*;

public class BingoGame {

    private  List<Player> playerList;
    Random random ;

    public BingoGame() {
        this.playerList = new ArrayList<Player>();
        this.random = new Random();
    }

    public  void generateBoard(int numPlayer, int row , int col,int min,int max){

        for(int i = 1 ; i <= numPlayer ; i++){
            int[][] board = ticketGenrate(row,col,min,max);
            Player player = new Player("Player#"+i,board);
            playerList.add(player);
            System.out.println("*******Player Information :"+player.getName()+"**************");
            print2DTicket(board);

        }
    }

    public int[][] ticketGenrate(int row, int col,int min,int max) {
        HashSet<Integer> visitedSet = new HashSet<Integer>();
        int[][] board = new int[row][col];
        for(int i = 0 ; i< row ;i++){
            int count=0;
            List<Integer> integerList = new ArrayList<Integer>();
            for(int j = 0 ; j < col ; j++){
                int colIndex=(int) Math.floor(Math.random()*(col-1-0+1)+0);
                int val = (int) Math.floor(Math.random()*(max-min+1)+min);
                if(!visitedSet.contains(val)) {
                    board[i][colIndex] = val;
                    visitedSet.add(val);
                    count++;
                    if(count ==5) break;
                    integerList.add(val);
                }
            }
        }
        return board;
    }


    public  void print2DTicket(int mat[][])
    {
        for (int[] row : mat)

            System.out.println(Arrays.toString(row));
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
