package com.wrongwrong.experiment.FragmentShaders;

public class SingleNoiseShader {
    //Pnoiseのみで定数のノイズを掛けるシェーダー
    public static final String singleNoise = MainHeader.mainHeader+
            "void main() {\n" +
            "  vec4 v = texture2D(texture, fitting(texcoordVarying));" +
            "  float Pnoise = abs(calc_LL1(v.xyz))/1.297286;" +
            "  if(Pnoise > rand(vec2(v.x + v.y, v.y + v.z))) {" +
            "    gl_FragColor = vec4(0.0, 0.2, 0.0, 0.0);" +
            "  } else gl_FragColor = vec4(0.0);\n" +
            "}\n";
}
