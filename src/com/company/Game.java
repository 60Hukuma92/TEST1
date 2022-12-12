package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private boolean gameEnded;

    private final Cell[][] gameField;
    private MovementVector direction;

    private int headX;
    private int headY;

    private Random rnd = new Random();

    public Game() {
        gameField = initField(Settings.DEFAULT_FIELD_SIZE, Settings.DEFAULT_SNAKE_LENGTH);
        addAppleToField();
        printField(gameField);

    }

    private void addAppleToField() {
        List<Point> freePoints = new ArrayList<>();
        for (int row = 0; row < gameField.length; row++) {
            for (int col = 0; col < gameField[row].length; col++) {
                if (gameField[row][col].getCellType() == CellType.FREE) {
                    freePoints.add(new Point(col, row));
                }
            }
        }
        if (freePoints.size() == 0) {
            //обработка победы
        }
        Point applePoint = freePoints.get(rnd.nextInt(freePoints.size()));
        gameField[applePoint.y][applePoint.x] = new Cell(CellType.APPLE);
    }

//    public Game(Settings settings) {
//        this.gameField = initField(settings.getFieldSize(), settings.getFieldSize());
//        this.gameEnded = false;
//        this.direction = settings.getDirection();
//    }


    private Cell[][] initField(int fieldSize, int length) {
        headX = fieldSize / 2;
        headY = fieldSize / 2;

        Cell[][] field = new Cell[fieldSize][fieldSize];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (row == 0 || row == fieldSize - 1 || col == 0 || col == fieldSize - 1) {
                    field[row][col] = new Cell(CellType.WALL);
                } else {
                    field[row][col] = new Cell(CellType.FREE);
                }
            }
        }
        initSnake(field, length);
        return field;
    }

    private void printField(Cell[][] field) {

    }

    private void initSnake(Cell[][] field, int snakeLength) {
        field[headY][headX] = new Cell(CellType.SNAKE, snakeLength);
        for (int curLength = 1; curLength < snakeLength; curLength++) {
            snakeLength--;
            field[headY][headX - curLength] = new Cell(CellType.SNAKE, snakeLength);
        }
        public void move() {
            int newHeadX = headX, newHeady = headY;
            switch (direction) {
                case RIGHT:
                    newHeadX++;
                    break;
                case DOWN:
                    newHeady--;
                    break;
                case UP:
                    newHeady++;
                    break;
                case LEFT:
                    newHeadX--;
                    break;
            }
            Cell newHeadCell = gameField[newHeady][newHeadX];
            if (newHeadCell.getCellType() == CellType.SNAKE || newHeadCell.getCellType() ==) {
                //обработка поражения
            }
            if (newHeadCell.getCellType() == CellType.APPLE) {
                //тут еще какая-то херня с плеером
            } else {
                for (int row = 0; row < gameField.length; row++) {
                    for (int col = 0; col < gameField[row].length; col++) {
                        if (gameField[row][col].getCellType() == CellType.SNAKE) {

                        }

                    }

                }
            }
        }
    }
}
