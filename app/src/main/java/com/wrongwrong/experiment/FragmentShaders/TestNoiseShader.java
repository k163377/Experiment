package com.wrongwrong.experiment.FragmentShaders;

public class TestNoiseShader {
    public static final String testNoise = NoiseGenerators.proportionNoiseP+
            "void main() {\n" +
            "  vec4 v = texture2D(texture, fitting(texcoordVarying));" +
            "  v.xyz = ProportionNoiseP(v.xyz, 1.0, 0.0);" +
            "  gl_FragColor = v;" +
            "}\n";
}
