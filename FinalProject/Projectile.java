import java.awt.Graphics;
import java.awt.Color;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Projectile {
    private double x, y;
    private int height, width;
    private Color color;
    private boolean visibility;
    private boolean dead;

    public Projectile(int x, int y) {
        this.dead = true;
        this.x = x;
        this.y = y;
        this.width = 10;
        this.height = 10;
        this.visibility = false;
        this.color = new Color(128, 0, 0);
    }

    public void checkCollision(Projectile enemy) {
        // return (Math.hypot(this.x-enemy.x, this.y-enemy.y)<=20.0);
        if (x + width >= enemy.getX() && x <= enemy.getX() + enemy.getWidth() && y + height >= enemy.getY()
                && y <= enemy.getY() + enemy.getHeight())
            dead = true;
    }

    public void drawMe(Graphics g) {
        if (!dead && visibility) {
            g.setColor(color);
            g.fillOval((int) (Math.round(x)), (int) (Math.round(y)), width, height);
        }
    }

    public void moveUp() {
        if (visibility) {
            y -= 10;
            if (y <= 0) {
                visibility = false;
                BossEnemy.hitStatus = true;// allow for the boss to be hit again
                // dead = true;
            }

        }

    }

    public void setVisible(boolean visible) {
        visibility = visible;
    }

    public boolean getDead() {
        return dead;
    }

    public void setPosition(int x, int y) {
        dead = false;
        if (!visibility) {
            playLaserSound();// play the shooting sound whenever the user fires the laser
            visibility = true;
            this.x = x;
            this.y = y;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // public int getPX() { return }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setVisibility(boolean value) {
        visibility = value;
    }

    private void playLaserSound() {// plays laser sound

        try {
            URL url = this.getClass().getClassLoader().getResource("Sound/laser.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}