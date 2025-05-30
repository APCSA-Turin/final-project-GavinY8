package com.example.tutorial;

import com.example.entity.Entity;
import com.example.tutorial.*;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker (GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.x + entity.solidArea.x;
        int entityRightWorldX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.y + entity.solidArea.y;
        int entityBottomWorldY = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1 = 0, tileNum2 = 0;

        if (gp.m.up) {
            entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
            tileNum1 = gp.tm.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = gp.tm.mapTileNum[entityRightCol][entityTopRow];
        }
        if (gp.m.left) {
            entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
            tileNum1 = gp.tm.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = gp.tm.mapTileNum[entityLeftCol][entityBottomRow];
        }
        if (gp.m.down) {
            entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
            tileNum1 = gp.tm.mapTileNum[entityLeftCol][entityBottomRow];
            tileNum2 = gp.tm.mapTileNum[entityRightCol][entityBottomRow];
        }
        if (gp.m.right) {
            entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
            tileNum1 = gp.tm.mapTileNum[entityRightCol][entityTopRow];
            tileNum2 = gp.tm.mapTileNum[entityRightCol][entityBottomRow];
        }

        if (gp.tm.tile[tileNum1].collision || gp.tm.tile[tileNum2].collision) {
            entity.collisionOn = true;
        }

    }
}
