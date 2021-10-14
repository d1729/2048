package com.debarshi.controller;

import com.debarshi.model.Board;
import com.debarshi.service.BoardService;
import com.debarshi.service.BoardServiceImpl;

public class GameController {


    public static void main(String[] args) {
        BoardService service = new BoardServiceImpl();
        Board board = service.initializeGame();
        service.printBoard(board);
        while(!service.isGameLost(board) || !service.isGameWon(board)) {
            service.getInput(board);
            int[] randomCell = service.getEmptyRandomEmptyCell(board);
            board.getTiles().get(randomCell[0]).get(randomCell[1]).setValue(2);
            service.printBoard(board);
        }
        if(service.isGameWon(board))
            System.out.println("Congratulations");
        else
            System.out.println("Game Over");


    }
}
