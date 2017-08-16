/**
 * Created by daymond on 31.08.2016.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameSnake {
    final static String TITLE_OF_PROGRAM = "Game Snake";
    final static String GAME_OVER_MSG = "GAME OVER";
    final static int POINT_RADIUS = 15;
    final static int FIELD_HEIGHT = 30;
    final static int FIELD_WIDTH = 40;
    final static int FIELD_DX = 6;
    final static int FIELD_DY = 28;
    final static int START_LOCATION = 200;
    final static int START_SNAKE_SIZE = 6;
    final static int START_SNAKE_X = 10;
    final static int START_SNAKE_Y = 10;
    final static int SHOW_DELAY = 100;
    final static int LEFT = 37;
    final static int RIGHT = 39;
    final static int UP = 38;
    final static int DOWN = 40;
    final static int START_DIRECTION = RIGHT;
    final static Color DEFAULT_COLOR = Color.black;
    final static Color FOOD_COLOR = Color.blue;
    final static Color HEAD_COLOR = Color.red;
    final static Color POISON_COLOR = Color.green;
     Snake snake;
     Food food;
     JFrame frame;
     Poison poison;
    Canvas canvasPanel;
    static boolean gameOver = false;

    void go() {
        frame = new JFrame(TITLE_OF_PROGRAM + " : " + START_SNAKE_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FIELD_WIDTH * POINT_RADIUS + FIELD_DX, FIELD_HEIGHT * POINT_RADIUS + FIELD_DY);
        frame.setLocation(START_LOCATION, START_LOCATION);
        frame.setResizable(false);

        canvasPanel = new Canvas(this);
        canvasPanel.setBackground(Color.white);






        frame.getContentPane().add(BorderLayout.CENTER, canvasPanel);
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
                ifNewGame(e.getKeyCode());

            }
        });




        frame.setVisible(true);

        while(true) {
            if (!gameOver)
                isNewGame();
            try {
               Thread.sleep(500);
            }catch(InterruptedException e) {
               e.printStackTrace();
             }
        }







    }

    void isNewGame() {
        snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, START_DIRECTION, this);
        food = new Food(this);
        poison = new Poison(this);

        while (!gameOver) {

            snake.move();
            if (food.isEaten()) {
                food.next();
                poison.next();

            }
            canvasPanel.repaint();
            try {
                Thread.sleep(SHOW_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

        void ifNewGame(int keyCode) {
            if (keyCode == 32)
                gameOver = false;
        }

}
