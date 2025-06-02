attribute vec2 vPosition;
void main() {
    gl_Position = vec4(vPosition, 0.0, 1.0);
    gl_PointSize = 5.0;
}
