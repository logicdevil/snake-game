/**
 * Created by daymond on 31.08.2016.
 */
import java.awt.*;
import java.util.*;

public class Snake {
        ArrayList<Point> snake = new ArrayList<Point>();
        int direction;
    GameSnake gameSnake;
        public Snake(int x, int y, int length, int direction, GameSnake gameSnake) {
            for(int i = 0; i < length; i++) {
                Point point = new Point (x-i, y);
                snake.add(point);
            }
            this.direction = direction;
            this.gameSnake = gameSnake;
        }

        void paint(Graphics q) {
            for(Point point : snake) {
                point.paint(q);
            }
        }

        boolean ifFood(Point food) {
            return ((snake.get(0).getX() == food.getX()) && (snake.get(0).getY() == food.getY()));
        }



        void move() {
            int x = snake.get(0).getX();  // Получаем координаты головы змеи
            int y = snake.get(0).getY();

            if(direction == GameSnake.LEFT) x--;		//получаем координаты новой головы
            if(direction == GameSnake.RIGHT) x++;
            if(direction == GameSnake.UP) y--;
            if(direction == GameSnake.DOWN) y++;

            if(x > GameSnake.FIELD_WIDTH - 1) x = 0;   //при выходе за пределы экрана -
            if(y > GameSnake.FIELD_HEIGHT - 1) y = 0;   // телепортируем на другую сторону
            if(x < 0) x = GameSnake.FIELD_WIDTH - 1;
            if(y < 0) y = GameSnake.FIELD_HEIGHT - 1;

            GameSnake.gameOver = isInsideSnake(x, y);

            snake.add(0, new Point(x, y, GameSnake.HEAD_COLOR));  //рисуем новую голову
            snake.get(1).color = gameSnake.DEFAULT_COLOR;
            if(ifFood(gameSnake.food)) {
                gameSnake.food.eat();
                gameSnake.frame.setTitle(GameSnake.TITLE_OF_PROGRAM + " : " + snake.size());
            }
            else
            if(gameSnake.poison.isEatenPoison(x, y))
                GameSnake.gameOver = true;

            else {
                snake.remove(snake.size()-1);	// удаляем хвост
            }




        }

        boolean isInsideSnake(int x, int y) {
            for(Point point : snake) {
                if(point.getX() == x && point.getY() == y)
                    return true;
            }
            return false;
        }

        void setDirection(int direction) {
            if(direction >= GameSnake.LEFT && direction <= GameSnake.DOWN) {
                if(Math.abs(this.direction - direction) != 2) {
                    this.direction = direction;
                }

            }
        }



}
