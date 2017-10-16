package com.wrongwrong.experiment;

public class FragmentShaders {
    public static final String FRAGMENT_SHADER =
            "#extension GL_OES_EGL_image_external : require\n" +
            "precision mediump float;\n" +
            "varying vec2 texcoordVarying;\n" +
            "uniform samplerExternalOES texture;\n" +
            "void main() {\n" +
            "  gl_FragColor = texture2D(texture, texcoordVarying);\n" +
            "}\n";

}
