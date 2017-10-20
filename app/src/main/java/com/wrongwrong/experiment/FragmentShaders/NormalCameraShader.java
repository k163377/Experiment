package com.wrongwrong.experiment.FragmentShaders;

//ただのカメラシェーダー
public class NormalCameraShader {
    public static final String NormalCamera =
            "#extension GL_OES_EGL_image_external : require\n" +
                    "precision mediump float;\n" +
                    "varying vec2 texcoordVarying;\n" +
                    "uniform samplerExternalOES texture;\n" +
                    "void main() {\n" +
                    "  gl_FragColor = texture2D(texture, texcoordVarying);\n" +
                    "}\n";
}
