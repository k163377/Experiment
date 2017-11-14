package com.wrongwrong.experiment.FragmentShaders;

public class TestNoiseShader {
    public static final String testNoise = NoiseGenerators.quadraticNoiseP+
            "void main() {\n" +
            "  vec4 v = texture2D(texture, fitting(texcoordVarying));\n" +
            "  v.xyz = QuadraticNoiseP(v.xyz, 1.0, 0.0, 0.0);\n" +
            "  gl_FragColor = v;\n" +
            "}\n";
}
