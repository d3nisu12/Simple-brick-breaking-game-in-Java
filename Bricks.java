import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Bricks {
    
    GamePanel gp;
    Player player;

    public final int sizeX = 70;
    public final int sizeY = 32;

    public final int row = 3;
    public final int col = 10;

    public int map[][];

    public Bricks(GamePanel gp, Player player){
        this.gp=gp;
        this.player = player;

        buildArray();
    }

    public void draw(Graphics2D g2){

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    g2.setColor(Color.white);
                    g2.fillRect(j * sizeX + (sizeX/2), i * sizeY + (sizeY/2), sizeX, sizeY);
                    
                    g2.setStroke(new BasicStroke(3));
                    g2.setColor(Color.black);
                    g2.drawRect(j * sizeX + (sizeX/2), i * sizeY + (sizeY/2), sizeX, sizeY);
                }
            }
        }

    }

    public void buildArray(){

        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = 1;
            }
        }
        
    }

    public void setBrickValue(int value, int row, int col){
        map[row][col] = value;
    }

    public boolean isBrickPresent(int i, int j){
        if(map[i][j]==0){
            return false;
        }
        return true;
    }

    public void resetMap(){
        buildArray();
    }

}
