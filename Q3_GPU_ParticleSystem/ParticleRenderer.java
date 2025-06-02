package com.particles;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import java.nio.*;
import java.util.*;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class ParticleRenderer implements GLSurfaceView.Renderer {
    Context context;
    FloatBuffer buf;
    int handle;
    List<Particle> points = new ArrayList<>();

    public ParticleRenderer(Context ctx) {
        context = ctx;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig cfg) {
        GLES20.glClearColor(0f, 0f, 0f, 1f);
        ShaderUtil.prepare(context);
        for (int i = 0; i < 500; i++) {
            points.add(new Particle());
        }
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int w, int h) {
        GLES20.glViewport(0, 0, w, h);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        float[] coords = new float[points.size() * 2];
        int p = 0;
        for (Particle pt : points) {
            pt.update();
            coords[p++] = pt.x;
            coords[p++] = pt.y;
        }
        buf = ByteBuffer.allocateDirect(coords.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        buf.put(coords).position(0);
        GLES20.glUseProgram(ShaderUtil.program);
        int loc = GLES20.glGetAttribLocation(ShaderUtil.program, "vPosition");
        GLES20.glEnableVertexAttribArray(loc);
        GLES20.glVertexAttribPointer(loc, 2, GLES20.GL_FLOAT, false, 0, buf);
        GLES20.glDrawArrays(GLES20.GL_POINTS, 0, points.size());
        GLES20.glDisableVertexAttribArray(loc);
    }
}
