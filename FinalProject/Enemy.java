import java.awt.Graphics;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.awt.Graphics2D;

public class Enemy {
    private int x, y, width, height;
    private Color color;
    private boolean dead = false;
    public boolean scoreCount = false;
    private BufferedImage zombie;
    private boolean moveLeft;
    private int speed;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 40;
        this.color = new Color(255, 0, 0);
        this.speed = 0;// initialize to some value
        moveLeft = false;
        try {
            zombie = resize(ImageIO.read(new File("Graphics/Enemy.png")), 50, 50);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void checkCollision(Projectile p) {
        if (x + width >= p.getX() && x <= p.getX() + p.getWidth() && y + height >= p.getY()
                && y <= p.getY() + p.getHeight()) {
            dead = true;
            playDeathSound();
        } else if (x + width >= p.getX() && x <= p.getX() + p.getWidth() && y + height >= p.getY()
                && y <= p.getY() + p.getHeight()) {
            dead = true;
            playDeathSound();
        }
    }

    public void checkCollision(Fighter f) {
        if (x + width >= f.getX() && x <= f.getX() + f.getWidth() && y + height >= f.getY()
                && y <= f.getY() + f.getHeight()) {
            if (!this.dead) {
                f.setDead(true);
                // this.dead = true;
            }

        } else if (x + width >= f.getX() && x <= f.getX() + f.getWidth() && y + height >= f.getY()
                && y <= f.getY() + f.getHeight()) {
            if (!this.dead) {
                f.setDead(true);
                // this.dead = true;
            }
        }
    }

    public boolean getDead() {
        return dead;
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void drawMe(Graphics g) {
        if (!dead) {
            g.drawImage(zombie, x, y, null);
        }
    }

    public void move() {
        if (!(y >= 500)) {
            if (!moveLeft) {
                moveRight();
                if (x >= 750) {
                    moveLeft = true;
                    moveDown();
                }
            }
            if (moveLeft) {
                moveLeft();
                if (x <= 0) {
                    moveLeft = false;
                    moveDown();
                }
            }
        } else {
            this.dead = true;
        }
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    private static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    private void playDeathSound()// plays the death sound when the player kills the zombie
    {
        try {
            URL url = this.getClass().getClassLoader().getResource("Sound/Minecraft-zombiedeath.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}