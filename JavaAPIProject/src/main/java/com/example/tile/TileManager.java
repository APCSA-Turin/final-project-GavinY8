package com.example.tile;

import com.example.tutorial.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        getTileImage();
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tile/im never touching this.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
