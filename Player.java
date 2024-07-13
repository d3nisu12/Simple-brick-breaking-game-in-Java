import java.awt.Color;
import java.awt.Graphics2D;

public class Player {
    
    KeyHandler kh;
    GamePanel gp;

    public int playerX;
    int playerY;
    int playerSpeed;

    //Player size
    public final int playerWidth = 96;
    public final int playerHeight = 16;

    boolean canMoveLeft;
    boolean canMoveRight;

    Player(GamePanel gp, KeyHandler kh){
        this.gp = gp;
        this.kh = kh;

        setDefaultValues();
    }

    public void setDefaultValues(){
        //Initial position of the player
        playerX = 336;  //player is 2 tiles wide , we set his position on the middle 
        playerY = 550;  

        playerSpeed = 3;

        canMoveLeft = true;
        canMoveRight = true;

    }

    public void update(){
        checkIfCanMove();
        if(kh.leftPressed == true && canMoveLeft){
            playerX -= playerSpeed;
        }
        if(kh.rightPressed == true && canMoveRight){
            playerX += playerSpeed;
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(playerX,playerY, playerWidth , playerHeight);
    }

    private void checkIfCanMove(){
        if(playerX+playerWidth >= gp.screenWidth){
            canMoveRight = false;  
        }else{
            canMoveRight = true;
        }

        if(playerX <= 0){
            canMoveLeft = false;
        }else{
            canMoveLeft = true;
        }
    }

    public int getPlayerX(){
        return playerX;
    }

    public int getPlayerY(){
        return playerY;
    }
}
