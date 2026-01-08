import processing.core.PApplet;

public class Bubble {
    private int x;
    private int y;
    private int size;
    private PApplet canvas;
    private int speed;
    private int color;
    private int health;

    public Bubble(int xPos, int yPos, PApplet c) {
        x = xPos;
        y = yPos;
        size = 250;
        canvas = c;
        speed = 5;
        color = canvas.color(0, 255, 0);
        health = 3;
    }

    public void display() {
        canvas.fill(color);
        canvas.circle(x, y, size);
        if (health == 2) {
            color = canvas.color(255, 255, 0);

        } else if (health == 1) {
            color = canvas.color(255, 0, 0);
        }
    }

    public void update() {
        x += speed;
        if (x + size / 2 > canvas.width || x - size / 2 < 0) {
            speed = -speed;
        }
    }

    public int randomColor() {
        return color = canvas.color(canvas.random(255), canvas.random(255), canvas.random(255));
    }

    public int getSize() {
        return size;
    }

    public boolean checkTouch(int mouseX, int mouseY) {
        float distanceFromCenter = canvas.dist(x, y, mouseX, mouseY);

        if (distanceFromCenter < size / 2) {
            health--;
        }

        if (health > 0) {
            return true;
        }

        else {
            return false;
        }
    }
}
