import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Ball {
    
    GamePanel gp;

    Random rand = new Random();

    public final int radius = 5;
    public final int diameter = radius * 2;

    int xPos;
    int yPos;

    int speed;

    public int xDirection;
    public int yDirection;

    public Ball(GamePanel gp){
        this.gp = gp;

        setDefaultValues();
    }

    public void setDefaultValues(){
        xPos = gp.screenWidth/2 -radius;
        yPos = gp.screenHeight/2 -radius;
        speed = 2;
        xDirection = rand.nextBoolean() ? 1:-1;
        yDirection = 1;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillOval(xPos, yPos, diameter, diameter);
    }

    public void update(){
        xPos+=speed*xDirection;
        yPos+=speed*yDirection;
    }

    public void resetBall(){
        setDefaultValues();
    }

    public int getXpos(){
        return xPos;
    }

    public int getYpos(){
        return yPos;
    }
}
