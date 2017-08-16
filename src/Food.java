/**
 * Created by daymond on 31.08.2016.
 */
import java.util.*;

public class Food extends Point{
    Random random = new Random();
    GameSnake gameSnake;
    public Food(GameSnake gameSnake) {
        super(-1,-1);
        this.gameSnake = gameSnake;
        this.color = GameSnake.FOOD_COLOR;
    }

    void eat() {
        this.setXY(-1,-1);
    }
    boolean isEaten() {
        return this.getX() == -1;
    }

    void next() {
        int x, y;
        do {
            x = random.nextInt(GameSnake.FIELD_WIDTH);
            y = random.nextInt(GameSnake.FIELD_HEIGHT);

        }while(gameSnake.snake.isInsideSnake(x, y)||gameSnake.poison.isInsidePoison(x, y));
        this.setXY(x, y);
    }
    boolean isInsideFood(int x, int y) {
        if(this.x == x && this.y == y)
            return true;
        else
            return false;
    }
}
