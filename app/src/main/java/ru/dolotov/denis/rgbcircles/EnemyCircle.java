package ru.dolotov.denis.rgbcircles;

import android.graphics.Color;

import java.util.Random;

public class EnemyCircle extends SimpleCircle {

    public static final int MIN_RADIUS = 10;
    public static final int MAX_RADIUS = 110;
    public static final int ENEMY_CIRCLE_COLOR = Color.RED;
    public static final int FOOD_CIRCLE_COLOR = Color.rgb(0, 200, 0);
    public static final int MAX_SPEED = 10;
    public static final int MIN_SPEED = 1;
    private int dx;
    private int dy;

    public EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    public static EnemyCircle getEnemyCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int dx = MIN_SPEED + random.nextInt(MAX_SPEED);
        int dy = MIN_SPEED + random.nextInt(MAX_SPEED);
        int radius = MIN_RADIUS + random.nextInt(MAX_RADIUS - MIN_RADIUS);
        return new EnemyCircle(x, y, radius, dx, dy);
    }

    public void setEnemyOrFoodColorDependsOn(MainCircle mainCircle) {
        if(isSmallerThen(mainCircle)){
            setColor(FOOD_CIRCLE_COLOR);
        }else {
            setColor(ENEMY_CIRCLE_COLOR);
        }
    }

    private boolean isSmallerThen(MainCircle mainCircle) {
        return getRadius()<mainCircle.getRadius();
    }

    public void moveOneStep() {
        x += dx;
        y += dy;
    }
}
