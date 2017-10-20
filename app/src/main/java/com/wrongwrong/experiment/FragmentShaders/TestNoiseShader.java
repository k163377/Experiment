package com.wrongwrong.experiment.FragmentShaders;

public class TestNoiseShader {
    public static final String testNoise = MainHeader.mainHeader+
            "void main() {\n" +
            "  gl_FragColor = texture2D(texture, texcoordVarying);\n" +
            "}\n";
}
