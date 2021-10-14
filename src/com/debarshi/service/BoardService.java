package com.debarshi.service;

import com.debarshi.model.Board;

public interface BoardService {

    public void printBoard(Board board);

    public boolean isGameWon(Board board);

    public boolean isGameLost(Board board);

    public Board initializeGame();

    public void makeMove(Board board, int input);

    public void getInput(Board board);

    public int[] getEmptyRandomEmptyCell(Board board);
}
