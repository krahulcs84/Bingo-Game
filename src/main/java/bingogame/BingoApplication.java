package bingogame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BingoApplication {



    public static void main(String[] args) {

        System.out.println("*******Lets Play Housie*******");

        System.out.println("Press Q to exit any time");
        System.out.println("Enter the number range(1-n)");
        Scanner  scanner= new Scanner(System.in);
        String numberRange = scanner.next();
        int minRange =1;
        int maxRange = Integer.parseInt(numberRange);
        System.out.println("numberRange :"+numberRange);

        System.out.println("Enter the Number of players playing the game");
        String playerNum = scanner.next();
        System.out.println("playerNum :"+playerNum);

        System.out.println("Enter Ticket Size");
        String ticketSize = scanner.next();
        System.out.println("ticketSize :"+ticketSize);
        String[] ticket = ticketSize.split("\\*");
        int row = Integer.parseInt(ticket[0]);
        int col = Integer.parseInt(ticket[1]);

        System.out.println("Enter numbers per row");
        String numberPerRow = scanner.next();
        System.out.println("numberPerRow :"+numberPerRow);

        System.out.println("Ticket Created Successfully");

        BingoGame bingoGame = new BingoGame();
        bingoGame.generateBoard(Integer.parseInt(playerNum),row,col,minRange,maxRange);
        List<Player> playerList = bingoGame.getPlayerList();

        System.out.println("Press N to Generate Random Number");
        List<Integer> numberlist = new ArrayList<Integer>();
        BingowinCheckbyEarlyfive bingowinCheckbyEarlyfive= new BingowinCheckbyEarlyfive();
        BingowinCheckbyFullhouse bingowinCheckbyFullhouse = new BingowinCheckbyFullhouse();
        BingowinCheckbyTopline bingowinCheckbyTopline= new BingowinCheckbyTopline();

        while (scanner.hasNext() == true ) {
            String keyword =  scanner.next();
            if(keyword.equalsIgnoreCase("N")){
                final int number  = (int) Math.floor(Math.random()*(maxRange-minRange+1)+minRange);
                System.out.println("Next Number is : " +number);
                numberlist.add(number);
                playerList.stream().forEach(player -> {
                    player.markMatchNumber(number);
                });
                System.out.println(numberlist);
                if(numberlist.size() >=5){
                  playerList.stream().forEach(player -> {
                      bingowinCheckbyEarlyfive.winCheck(player);
                      bingowinCheckbyFullhouse.winCheck(player);
                      bingowinCheckbyTopline.winCheck(player);
                  });
                }
                if(bingowinCheckbyEarlyfive.earlyFiveCheck && bingowinCheckbyFullhouse.winCheckFullHouse && bingowinCheckbyTopline.wincheckByTopLine){
                    System.out.println("*****GAME OVER*********");
                    System.out.println("SUMMARY");
                    System.out.println(bingowinCheckbyEarlyfive.summary);
                    System.out.println(bingowinCheckbyFullhouse.summary);
                    System.out.println(bingowinCheckbyTopline.summary);
                    System.exit(0);
                }
            }
        }


    }
    private  static String exitCallMethod(){
        System.exit(0);
        return "Exited Successfully";
    }
}
