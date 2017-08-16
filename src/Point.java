/**
 * Created by daymond on 31.08.2016.
 */
import java.awt.*;

public class Point {
    int x, y;
    Color color = GameSnake.DEFAULT_COLOR;

    public Point(int x, int y) {
        this.setXY(x,y);
    }
    public Point(int x, int y, Color color) {
        this.setXY(x,y);
        this.color = color;
    }

    void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x*GameSnake.POINT_RADIUS, y*GameSnake.POINT_RADIUS, GameSnake.POINT_RADIUS, GameSnake.POINT_RADIUS);
    }

    void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {return x;}
    int getY() {return y;}
}
