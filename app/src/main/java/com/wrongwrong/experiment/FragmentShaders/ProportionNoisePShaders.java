package com.wrongwrong.experiment.FragmentShaders;

public class ProportionNoisePShaders {
    public static final String ProportionNoiseP10_0 = NoiseGenerators.proportionNoiseP+
            "void main() {\n" +
            "  vec4 v = texture2D(texture, fitting(texcoordVarying));" +
            "  v.xyz = ProportionNoiseP(v.xyz, 1.0, 0.0);" +
            "  gl_FragColor = v;" +
            "}\n";

    public static final String ProportionNoiseP5_5 = NoiseGenerators.proportionNoiseP+
            "void main() {\n" +
            "  vec4 v = texture2D(texture, fitting(texcoordVarying));" +
            "  v.xyz = ProportionNoiseP(v.xyz, 0.5, 0.5);" +
            "  gl_FragColor = v;" +
            "}\n";

    public static final String ProportionNoiseP20__10 = NoiseGenerators.proportionNoiseP+
            "void main() {\n" +
            "  vec4 v = texture2D(texture, fitting(texcoordVarying));" +
            "  v.xyz = ProportionNoiseP(v.xyz, 2.0, -1.0);" +
            "  gl_FragColor = v;" +
            "}\n";
}
