/**
 * Created by daymond on 31.08.2016.
 */
import java.awt.*;
import javax.swing.*;


public class Canvas extends JPanel {

    GameSnake gameSnake;
    public Canvas(GameSnake gameSnake) {
        this.gameSnake = gameSnake;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        gameSnake.snake.paint(g);
        gameSnake.food.paint(g);
        gameSnake.poison.paint(g);
        if(GameSnake.gameOver) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics fm = g.getFontMetrics();
            g.drawString(GameSnake.GAME_OVER_MSG, (GameSnake.FIELD_WIDTH * GameSnake.POINT_RADIUS + GameSnake.FIELD_DX - fm.stringWidth(GameSnake.GAME_OVER_MSG))/2,
                    (GameSnake.FIELD_HEIGHT * GameSnake.POINT_RADIUS + GameSnake.FIELD_DY)/2);

        }
    }
}
