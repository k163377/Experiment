package com.wrongwrong.experiment.FragmentShaders;

public class TestNoiseShader {
    public static final String testNoise = MainHeader.mainHeader+
            NoiseGenerators.exponential_noise+
            "void main() {\n" +
            "  vec4 v = texture2D(texture, fitting(texcoordVarying));" +
            "  float Pnoise = abs(calc_LL1(v.xyz))/1.297286;" +
            "  if(Pnoise > rand(vec2(v.x + v.y, v.y + v.z))) {" +
            "    gl_FragColor = vec4(0.0, exponential_noise(v.xyz), 0.0, 0.0);" +
            "  } else gl_FragColor = vec4(0.0);\n" +
            "}\n";
}
