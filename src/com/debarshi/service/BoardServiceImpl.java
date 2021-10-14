package com.debarshi.service;

import com.debarshi.model.Board;
import com.debarshi.model.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardServiceImpl implements BoardService{

    @Override
    public void printBoard(Board board) {
        int height = board.getHeight();
        int width = board.getWidth();
        List<List<Tile>> tiles = board.getTiles();
        for(int i = 0; i < height; ++i) {
            for(int j = 0; j < width; ++j) {
                Integer value = tiles.get(i).get(j).getValue();
                if(value == 0)
                    System.out.print('_');
                else
                    System.out.print(value);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean isGameWon(Board board) {
        int height = board.getHeight();
        int width = board.getWidth();
        List<List<Tile>> tiles = board.getTiles();
        for(int i = 0; i < height; ++i) {
            for(int j = 0; j < width; ++j) {
                Integer value = tiles.get(i).get(j).getValue();
                if(value != 0 && value == 2048)
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean isGameLost(Board board) {
        int height = board.getHeight();
        int width = board.getWidth();
        List<List<Tile>> tiles = board.getTiles();
        for(int i = 0; i < height; ++i) {
            for(int j = 0; j < width; ++j) {
                Integer value = tiles.get(i).get(j).getValue();
                if(value == 0 || value == 2048)
                    return false;
            }
        }
        return true;
    }

    @Override
    public Board initializeGame() {
        Board board = new Board();
        int[] rows = Helper.generateTwoRandom(board.getHeight());
        int[] cols = Helper.generateTwoRandom(board.getHeight());
        board.getTiles().get(rows[0]).get(cols[0]).setValue(2);
        board.getTiles().get(rows[1]).get(cols[1]).setValue(2);
        return board;
    }

    @Override
    public void makeMove(Board board, int input) {
        switch (input) {
            case 0:
                moveLeft(board);
                break;
            case 1:
                moveRight(board);
                break;
            case 2:
                moveUp(board);
                break;
            case 3:
                moveDown(board);
                break;
            default:
                getInput(board);
                break;
        }
    }

    private void moveLeft(Board board) {
        int height = board.getHeight();
        int width = board.getWidth();
        int index = 0;
        for(int i = 0; i < height; ++i) {
            List<Tile> tiles = board.getTiles().get(i);
            while (index < width) {
                boolean flag = true;
                for(int j = index + 1; j < width; ++j) {
                    if(tiles.get(j).getValue() != 0) {
                        flag = false;
                        if(tiles.get(index).getValue() == tiles.get(j).getValue()) {
                            tiles.get(index).setValue(tiles.get(index).getValue() << 1);
                            tiles.get(j).setValue(0);
                            ++index;
                        } else {
                            if(tiles.get(index).getValue() == 0) {
                                tiles.get(index).setValue(tiles.get(j).getValue());
                                tiles.get(j).setValue(0);
                            }
                            else {
                                tiles.get(index + 1).setValue(tiles.get(j).getValue());
                                ++index;
                            }
                        }
                        break;
                    }
                }
                if(flag)
                    break;
            }
        }
    }

    private void moveRight(Board board) {
        int height = board.getHeight();
        int width = board.getWidth();
        int index = width - 1;
        for(int i = 0; i < height; ++i) {
            List<Tile> tiles = board.getTiles().get(i);
            while (index > 0) {
                boolean flag = true;
                for(int j = index - 1; j >= 0; --j) {
                    if(tiles.get(j).getValue() != 0) {
                        flag = false;
                        if(tiles.get(index).getValue() == tiles.get(j).getValue()) {
                            tiles.get(index).setValue(tiles.get(index).getValue() << 1);
                            tiles.get(j).setValue(0);
                            --index;
                        } else {
                            if(tiles.get(index).getValue() == 0) {
                                tiles.get(index).setValue(tiles.get(j).getValue());
                                tiles.get(j).setValue(0);
                            }
                            else {
                                --index;
                            }
                        }
                        break;
                    }
                }
                if(flag)
                    break;
            }
        }
    }

    private void moveDown(Board board) {
        int width = board.getWidth();
        int height = board.getHeight();
        List<List<Tile>> tiles = board.getTiles();
        int index = height - 1;
        for(int i = 0; i < width; ++i) {
            while (index > 0) {
                boolean flag = true;
                for(int j = index - 1; j >= 0; --j) {
                    if(tiles.get(j).get(i).getValue() != 0) {
                        flag = false;
                        if(tiles.get(index).get(i).getValue() == tiles.get(j).get(i).getValue()) {
                            tiles.get(index).get(i).setValue(tiles.get(index).get(i).getValue() << 1);
                            tiles.get(j).get(i).setValue(0);
                            --index;
                        } else {
                            if(tiles.get(index).get(i).getValue() == 0) {
                                tiles.get(index).get(i).setValue(tiles.get(j).get(i).getValue());
                                tiles.get(j).get(i).setValue(0);
                            }
                            else {
                                --index;
                            }
                        }
                        break;
                    }
                }
                if(flag)
                    break;
            }
        }
    }

    private void moveUp(Board board) {
        int width = board.getWidth();
        int height = board.getHeight();
        List<List<Tile>> tiles = board.getTiles();
        int index = 0;
        for(int i = 0; i < width; ++i) {
            while (index < height) {
                boolean flag = true;
                for(int j = index + 1; j < height; ++j) {
                    if(tiles.get(j).get(i).getValue() != 0) {
                        flag = false;
                        if(tiles.get(index).get(i).getValue() == tiles.get(j).get(i).getValue()) {
                            tiles.get(index).get(i).setValue(tiles.get(index).get(i).getValue() << 1);
                            tiles.get(j).get(i).setValue(0);
                            ++index;
                        } else {
                            if(tiles.get(index).get(i).getValue() == 0) {
                                tiles.get(index).get(i).setValue(tiles.get(j).get(i).getValue());
                                tiles.get(j).get(i).setValue(0);
                            }
                            else {
                                ++index;
                            }
                        }

                        break;
                    }
                }
                if(flag)
                    break;
            }
        }
    }

    @Override
    public void getInput(Board board) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        makeMove(board, input);
    }

    private List<Integer> getEmptyTiles(Board board) {
        List<Integer> ans = new ArrayList<>();
        int height = board.getHeight();
        int width = board.getWidth();
        List<List<Tile>> tiles = board.getTiles();
        for(int i = 0; i < height; ++i) {
            for(int j = 0; j < width; ++j) {
                if(tiles.get(i).get(j).getValue() == 0)
                    ans.add(i * width + j);
            }
        }
        return ans;
    }

    private int[] convertToCell(Board board, int num) {
        int width = board.getWidth();
        int row = num / width;
        int col = num % width;
        return new int[] {row, col};
    }

    @Override
    public int[] getEmptyRandomEmptyCell(Board board) {
        List<Integer> emptyCells = getEmptyTiles(board);
        return convertToCell(board, Helper.generateSingleRandom(emptyCells));
    }
}
