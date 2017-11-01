package com.wrongwrong.experiment.FragmentShaders;

public class NoiseGenerators {
    //メイン関数で利用する関数等を纏めたもの
    public static final String mainHeader =
            "#extension GL_OES_EGL_image_external : require\n" +
                    "precision highp float;\n" +
                    "varying vec2 texcoordVarying;\n" +
                    "uniform samplerExternalOES texture;\n"+
                    NoiseDistributions.rand+
                    OtherFuncs.fitting;

    //定数ノイズ
    public static final String constNoiseP = mainHeader+
            OtherFuncs.calc_LL1+
            "vec3 ConstNoiseP(vec3 rgb, float level){\n" +
            "  float Pnoise = abs(calc_LL1(rgb))/1.297286;\n" +
            "  if(Pnoise > rand(vec2(rgb.x + rgb.y, rgb.y + rgb.z))) {\n" +
            "    rgb = vec3(Pnoise * level);\n"+
            "  } else rgb = vec3(0.0);\n" +
            "  return rgb;\n" +
            "}\n";
    //比例ノイズ
    public static final String proportionNoiseP = mainHeader+
            OtherFuncs.calc_LL1+
            OtherFuncs.linear_function+
            "vec3 ProportionNoiseP(vec3 rgb, float slope, float intercept){\n" +
            "  float Pnoise = abs(calc_LL1(rgb))/1.297286;\n" +
            "  if(Pnoise > rand(vec2(rgb.x + rgb.y, rgb.y + rgb.z))) {\n" +
            "    rgb = vec3(linear_function(Pnoise, slope, intercept));\n"+
            "  } else rgb = vec3(0.0);\n" +
            "  return rgb;\n" +
            "}\n";
}
