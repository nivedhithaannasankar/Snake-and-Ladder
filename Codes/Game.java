package game;

import board.Board;
import coordinates.Coordinates;
import dice.Dice;
import player.Player;
import jumper.Jumper;

public class Game {
     Board board;
     Player[] players;
     boolean[] allowed;
     int turn;
     Dice dice;
     Coordinates[] places;
  
     public Game(Board board, Player[] players, Dice dice){
        this.board=board;
        this.players=players;
        this.dice=dice;
        turn =0;
        allowed =new boolean [players.length];
        places =new Coordinates[players.length];

        for(int i=0;i<players.length;i++){
            places[i]=new Coordinates(board.getsize()-1,0);
        }
     }

     public void play(){
        while(true){
            int n=dice.diceroll();
            System.out.println(players[turn].getplayername() + " rolled -> " + n +" ["+places[turn].getrow()+","+places[turn].getcol()+"]");

            if(!allowed[turn]){
                if(n!=1){
                    turn = 1-turn;
                    //turn = 1 =>1-1=0;
                    //turn = 0 =>1-0 =1;
                    continue;
                }
                else{
                    allowed[turn]=true;
                }
            }

            Coordinates newCoordinates = getNewCoordinates(places[turn], n);
            if(newCoordinates.getrow() < 0) {
                System.out.println(players[turn].getplayername()+ "  has won");
                return;
            }

            places[turn]=newCoordinates;
            turn = 1- turn;

        }
     }

     private Coordinates getNewCoordinates(Coordinates oldCoordinates ,int  n){
        int row = oldCoordinates.getrow();
        int col = oldCoordinates.getcol();

        while(n>0){
            if(row%2==0){
                if(col == board.getsize()-1){
                    row--;
                }
                else{
                    col++;
                }
            }
            else{
               if(col==0 ){
                row--;
               }
               else{
                col--;
               }
            }
            n--;
        }
     
     if(row<0){
         return new Coordinates(row,col);
     }

     if(checkIfJumperExists(row,col)){
        Jumper jumper =board.jumpers.get(board.board[row][col]);
        return jumper.end;
    } 

     return new Coordinates(row,col);
    }

    private boolean checkIfJumperExists(int row, int col){
        return board.jumpers.containsKey(board.board[row][col]);
    }

}
