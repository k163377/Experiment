package com.wrongwrong.experiment.FragmentShaders;

public class TestNoiseShader {
    public static final String testNoise = NoiseGenerators.constNoiseP+
            OtherFuncs.fitting+
            "void main() {\n" +
            "  vec4 v = texture2D(texture, fitting(texcoordVarying));" +
            "  v.xyz = ConstNoiseP(v.xyz, 0.5);" +
            "  gl_FragColor = v;" +
            "}\n";
}
