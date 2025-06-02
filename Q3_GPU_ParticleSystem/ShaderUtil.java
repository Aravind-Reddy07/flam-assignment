package com.particles;

import android.content.Context;
import android.opengl.GLES20;

public class ShaderUtil {
    public static int program;

    public static void prepare(Context ctx) {
        String vSrc = "attribute vec2 vPosition; void main() { gl_Position = vec4(vPosition, 0.0, 1.0); gl_PointSize = 5.0; }";
        String fSrc = "precision mediump float; void main() { gl_FragColor = vec4(1.0, 0.5, 0.0, 1.0); }";

        int vertex = load(GLES20.GL_VERTEX_SHADER, vSrc);
        int frag = load(GLES20.GL_FRAGMENT_SHADER, fSrc);
        program = GLES20.glCreateProgram();
        GLES20.glAttachShader(program, vertex);
        GLES20.glAttachShader(program, frag);
        GLES20.glLinkProgram(program);
    }

    static int load(int type, String code) {
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, code);
        GLES20.glCompileShader(shader);
        return shader;
    }
}
