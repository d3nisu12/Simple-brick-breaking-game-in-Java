import java.awt.Rectangle;

public class CollisionHandler {
    
    Player player;
    Bricks bricks;
    Ball ball;
    GamePanel gp;
    Score sc;

    CollisionHandler(Player player, Bricks bricks, Ball ball,GamePanel gp, Score sc){
        this.player = player;
        this.bricks = bricks;
        this.ball = ball;
        this.gp = gp;
        this.sc = sc;
    }

    public void checkForCollision(){
        checkBallBrickCollision();
        checkBallPlayerCollision();
        checkBallScreenBoundsCollision();
        checkBallOffScreen();
    }

    private void checkBallOffScreen(){
        if(ball.yPos>= gp.getHeight()){
            ball.resetBall();
            bricks.resetMap();
        }
    }

    private void checkBallScreenBoundsCollision(){
        if(ball.xPos + ball.radius > gp.screenWidth || ball.xPos < 0){
            ball.xDirection *= -1;
        }

        if(ball.yPos + ball.radius < 0){
            ball.yDirection *= -1;
        }
    }

    private void checkBallPlayerCollision(){
        Rectangle ballRect = new Rectangle(ball.getXpos(),ball.getYpos(),ball.diameter,ball.diameter);
        Rectangle playerRect = new Rectangle(player.getPlayerX(),player.getPlayerY(),player.playerWidth,player.playerHeight);

        if(ballRect.intersects(playerRect)){
            ball.yDirection *= -1;
        }
    }

    private void checkBallBrickCollision(){
        Rectangle ballRect = new Rectangle(ball.getXpos(),ball.getYpos(),ball.diameter,ball.diameter);

        for (int i = 0; i < bricks.row; i++) {
            for (int j = 0; j < bricks.col; j++) {
                if (bricks.isBrickPresent(i, j)) {
                    int brickX = j * bricks.sizeX + bricks.sizeX/2;
                    int brickY = i * bricks.sizeY + bricks.sizeY/2;
                    int brickWidth = bricks.sizeX;
                    int brickHeight = bricks.sizeY;

                    Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight);

                    if (ballRect.intersects(brickRect)) {
                        sc.increaseScore();
                        bricks.setBrickValue(0, i, j);

                        if (ball.getXpos() + ball.diameter - 1 <= brickRect.x || ball.getXpos() + 1 >= brickRect.x + brickRect.width) {
                            ball.xDirection *= -1;
                        } else {
                            ball.yDirection *= -1;
                        }
                        
                    }
                }
            }
        }
    }


}
