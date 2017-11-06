package com.wrongwrong.experiment.FragmentShaders;

public class ConstNoisePShaders {
    public static final String ConstNoiseP8 = NoiseGenerators.constNoiseP+
            "void main() {\n" +
            "  vec4 v = texture2D(texture, fitting(texcoordVarying));" +
            "  v.xyz = ConstNoiseP(v.xyz, 0.8);" +
            "  gl_FragColor = v;" +
            "}\n";

    public static final String ConstNoiseP6 = NoiseGenerators.constNoiseP+
            "void main() {\n" +
            "  vec4 v = texture2D(texture, fitting(texcoordVarying));" +
            "  v.xyz = ConstNoiseP(v.xyz, 0.6);" +
            "  gl_FragColor = v;" +
            "}\n";

    public static final String ConstNoiseP4 = NoiseGenerators.constNoiseP+
            "void main() {\n" +
            "  vec4 v = texture2D(texture, fitting(texcoordVarying));" +
            "  v.xyz = ConstNoiseP(v.xyz, 0.4);" +
            "  gl_FragColor = v;" +
            "}\n";
}
