/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 *
 * @author Manohar
 */
public class TicTacToe {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        char[][] gameBoard = board(); 
        printBoard(gameBoard);
        System.out.println("select symbol: \n1. 'X'  \n2. 'O'");
        int symbolnum = in.nextInt();
        char symbol = (symbolnum == 1)? 'X': 'O';
        char oppSymbol = (symbol == 'X')? 'O': 'X';
        boolean won = false; 
        List<Integer> list = new ArrayList<Integer>();
        int cnt1 = 0, cnt2 = 0;
        while(!won) {
            if(cnt1 >= 5 && cnt2 >= 4) {
                System.out.println("game draw!");
                break;
            }
            System.out.println("enter position:");
            int position = in.nextInt();
            while(position > 9 || position < 1) { 
                System.out.println("please enter a valid position: ");
                position = in.nextInt();
            }
            while(list.contains(position)) {
                System.out.println("Position already taken! please enter new position:");
                position = in.nextInt();
            }
            setPosition(gameBoard, position, symbol);
            list.add(position);
            printBoard(gameBoard);
            won = winner(gameBoard, symbol);
            if(won) break;
            cnt1++;
            
            Random random = new Random();
            int oppPosition = random.nextInt(9) + 1;
            while(list.contains(oppPosition)) {
               oppPosition = random.nextInt(9) + 1;
            }
            System.out.println("CPU's turn");
            setPosition(gameBoard, oppPosition, oppSymbol);
            list.add(oppPosition);
            printBoard(gameBoard);
            won = winner(gameBoard, oppSymbol);
            cnt2++;
        }

    }

    private static boolean winner(char[][] gameBoard, char symbol) {
        if(gameBoard[0][0] != ' ' && gameBoard[0][0] == gameBoard[0][2] && gameBoard[0][2] == gameBoard[0][4]) {
            System.out.println(symbol + " WINS!!");
            return true;
        } 
        else if(gameBoard[2][0] != ' ' && gameBoard[2][0] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[2][4]) {
            System.out.println(symbol + " WINS!!");
            return true;
        } 
        else if(gameBoard[4][0] != ' ' && gameBoard[4][0] == gameBoard[4][2] && gameBoard[4][2] == gameBoard[4][4]) {
            System.out.println(symbol + " WINS!!");
            return true;
        } 
        else if(gameBoard[0][0] != ' ' && gameBoard[0][0] == gameBoard[2][0] && gameBoard[2][0] == gameBoard[4][0]) {
            System.out.println(symbol + " WINS!!");
            return true;
        } 
        else if(gameBoard[0][2] != ' ' && gameBoard[0][2] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[4][2]) {
            System.out.println(symbol + " WINS!!");
            return true;
        } 
        else if(gameBoard[0][4] != ' ' && gameBoard[0][4] == gameBoard[2][4] && gameBoard[2][4] == gameBoard[4][4]) {
            System.out.println(symbol + " WINS!!");
            return true;
        } 
        else if(gameBoard[0][0] != ' ' && gameBoard[0][0] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[4][4]) {
            System.out.println(symbol + " WINS!!");
            return true;
        } 
        else if(gameBoard[4][0] != ' ' && gameBoard[4][0] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[0][4]) {
            System.out.println(symbol + " WINS!!");
            return true;
        } 
        return false;
    }

    private static void setPosition(char[][] gameBoard, int positon, char symbol) {
        if(positon == 1) 
            gameBoard[0][0] = symbol;
        else if(positon == 2) 
            gameBoard[0][2] = symbol;
        else if(positon == 3) 
            gameBoard[0][4] = symbol;
        else if(positon == 4) 
            gameBoard[2][0] = symbol;
        else if(positon == 5) 
            gameBoard[2][2] = symbol;
        else if(positon == 6) 
            gameBoard[2][4] = symbol;
        else if(positon == 7) 
            gameBoard[4][0] = symbol;
        else if(positon == 8) 
            gameBoard[4][2] = symbol;
        else if(positon == 9) 
            gameBoard[4][4] = symbol;
    }

    private static void printBoard(char[][] gameBoard) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++){
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
    
    }

    private static char[][] board() {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'}, 
        {' ', '|', ' ', '|', ' '}, 
        {'-', '+', '-', '+', '-'}, 
        {' ', '|', ' ', '|', ' '}};
        return gameBoard;
    }

}
