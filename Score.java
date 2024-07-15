import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Score {
    
    public int score;

    public Score(){
        initializeVariables();
    }


    private void initializeVariables(){
        score = 0;
    }

    public void resetScore(){
        initializeVariables();
    }

    public void increaseScore(){
        score+=5;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial",Font.BOLD,24));
        g2.drawString("score:"+score, 5, 15);
    }
}
