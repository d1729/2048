package com.debarshi.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int height = 4;
    private int width = 4;

    List<List<Tile>> tiles;

    public Board() {
        tiles = new ArrayList<>();
        for(int i = 0; i < height; ++i) {
            tiles.add(new ArrayList<>());
            for(int j = 0; j < width; ++j)
                tiles.get(i).add(new Tile());
        }
    }

    public  int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<List<Tile>> getTiles() {
        return tiles;
    }

    public void setTiles(List<List<Tile>> tiles) {
        this.tiles = tiles;
    }
}
