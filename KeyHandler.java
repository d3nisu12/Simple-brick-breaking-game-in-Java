import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean leftPressed, rightPressed,resetPressed;

    @Override
    public void keyTyped(KeyEvent e) {
       

    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }

        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }

        if(code == KeyEvent.VK_R){
            resetPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }

        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }

        if(code == KeyEvent.VK_R){
            resetPressed = false;
        }
    }
    
    
}
