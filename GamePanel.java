import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    
    final int originalTileSize = 16;    // 16x16
    final int scale = 3;

    final int tileSize = originalTileSize  * scale;     //48x48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;    //768 pixels
    public final int screenHeight = tileSize *maxScreenRow;    //576 pixels

    int FPS = 60;

    Thread gameThread;
    KeyHandler keyH = new KeyHandler();

    Player player = new Player(this,keyH);

    Bricks bricks = new Bricks(this, player);

    Ball ball = new Ball(this);

    CollisionHandler colHandler = new CollisionHandler(player, bricks, ball,this);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS; // 0.01666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {

            update();

            repaint();

            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long)remainingTime);

                nextDrawTime += drawInterval;

            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    public void update(){
       player.update();
       ball.update();
       colHandler.checkForCollision();
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        
        player.draw(g2);
        bricks.draw(g2);
        ball.draw(g2);

        g2.dispose();
    }
}
