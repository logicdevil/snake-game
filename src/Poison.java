/**
 * Created by daymond on 01.09.2016.
 */
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class Poison {
    ArrayList<Point> poison = new ArrayList<Point>();
    Random random = new Random();
    GameSnake gameSnake;
    public Poison(GameSnake gameSnake) {
        this.gameSnake = gameSnake;
    }




    void next() {
        int x, y;
        do {
            x = random.nextInt(GameSnake.FIELD_WIDTH);
            y = random.nextInt(GameSnake.FIELD_HEIGHT);

        }while(gameSnake.snake.isInsideSnake(x, y)||gameSnake.food.isInsideFood(x, y));
        Point point = new Point (x, y,GameSnake.POISON_COLOR);
        poison.add(point);
    }


    void paint(Graphics q) {
        for(Point point : poison) {
            point.paint(q);
        }
    }
    boolean isInsidePoison(int x, int y) {
        for(Point point : poison)
        {
            if(point.getX() == x && point.getY() == y)
                return true;
        }
        return false;
    }
    boolean isEatenPoison(int x, int y) {
        for(Point point : poison)
        {
            if(point.getX() == x && point.getY() == y)
                return true;
        }
        return false;
    }
}
