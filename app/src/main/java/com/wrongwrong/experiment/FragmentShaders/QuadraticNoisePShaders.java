package com.wrongwrong.experiment.FragmentShaders;

public class QuadraticNoisePShaders {
    public static final String QuadraticNoiseP10_0_0 = NoiseGenerators.quadraticNoiseP+
            "void main() {\n" +
            "  vec4 v = texture2D(texture, fitting(texcoordVarying));\n" +
            "  v.xyz = QuadraticNoiseP(v.xyz, 1.0, 0.0, 0.0);\n" +
            "  gl_FragColor = v;\n" +
            "}\n";

}
