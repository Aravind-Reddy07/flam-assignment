package com.particles;

public class Particle {
    float x, y, vx, vy, age, life;

    Particle() {
        reset();
    }

    void reset() {
        x = y = 0;
        vx = (float)(Math.random() - 0.5f);
        vy = (float)(Math.random() - 0.5f);
        life = (float)(Math.random() * 100 + 50);
        age = 0;
    }

    void update() {
        x += vx * 0.01;
        y += vy * 0.01;
        age++;
        if (age > life) reset();
    }
}
