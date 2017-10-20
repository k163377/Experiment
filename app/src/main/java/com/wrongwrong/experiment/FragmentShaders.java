package com.wrongwrong.experiment;

public class FragmentShaders {
    //無処理
    public static final String FRAGMENT_SHADER =
            "#extension GL_OES_EGL_image_external : require\n" +
            "precision mediump float;\n" +
            "varying vec2 texcoordVarying;\n" +
            "uniform samplerExternalOES texture;\n" +
            "void main() {\n" +
            "  gl_FragColor = texture2D(texture, texcoordVarying);\n" +
            "}\n";

    public static final String Noise1 =
            "#extension GL_OES_EGL_image_external : require\n" +
                    "precision highp float;\n" +
                    "varying vec2 texcoordVarying;\n" +
                    "uniform samplerExternalOES texture;\n" +
                    //0から1の乱数
                    RendererResource.Func.rand +
                    //hsvへの変換関連
                    RendererResource.Func.tcolor_rgbtohsv+
                    RendererResource.Func.tcolor_hsvtorgb+
                    //正規分布
                    RendererResource.Func.normal_dsitribution+
                    RendererResource.Func.dual_peak_normal_distribution+
                    //その他関数
                    RendererResource.Func.add_noise_rgb+

                    //双峰ガウス分布によるノイズを乗せる関数
                    //ノイズの分散は40/255(demoプログラムの数値と脇本論文を参考に)
                    "vec3 compute_wnoise_Vp(vec3 rgb){\n" +
                    "  const float cov = 0.15686274509;\n" +
                    "  float l = rgb[0] * 0.972556 +" +
                    "            rgb[1] * 2.76508 +" +
                    "            rgb[2] * 0.225836;\n" +
                    "  float l1 = rgb[0] * 0.0553282 +" +
                    "             rgb[1] * 3.69494 " +
                    "             - rgb[2] * 0.154222;\n" +
                    "  float ll1 = l - l1;\n" +

                    //正規化した発生確率, 絶対値が最大になるのは、0.0, 1.0, 0.0の場合
                    "  float Pnoise = abs(ll1) / 1.297286;\n" +

                    //0 ～ 1の一様乱数で、Pnoiseより小さな値が帰る確率を用いる
                    //ノイズを乗せるか判定
                    "  if(Pnoise > rand(vec2(rgb.x + rgb.y, rgb.y + rgb.z))){\n" +
                    //LL1によって対応を変える
                    "    if(ll1 > 0.0){" +
                    //"      rgb[1] = (rgb[1] + dual_peak_normal_distribution(cov, Pnoise, vec2(rgb.x + rgb.z, rgb.x)));" +
                    "      rgb[1] = (rgb[1] + dual_peak_normal_distribution(cov, Pnoise, vec2(rgb.x + rgb.z, rgb.x))) * Pnoise * 2.0;" +
                    "      rgb[0] = 0.0;" +
                    "      rgb[2] = 0.0;" +
                    "    }else {" +
                    "      vec3 hsv = tcolor_rgbtohsv(rgb);\n" +
                    "      hsv[2] += dual_peak_normal_distribution(cov, cov, vec2(rgb.y + rgb.z, rgb.x + rgb.y));\n" +
                    //"      rgb = tcolor_hsvtorgb(hsv);" +
                    "      rgb = tcolor_hsvtorgb(hsv) * Pnoise;" +
                    "    }"+
                    "  }\n"+

                    "  return rgb;\n" +
                    "}\n" +

                    //画面位置合わせ
                    "vec2 fitting(vec2 txcrdV){\n" +
                    "  const float scale = 0.27;\n" +
                    "  vec2 v = vec2(txcrdV.x*scale + (1.0-scale)*0.5 + 0.01, txcrdV.y*scale + (1.0-scale)*0.5);\n" +
                    "  return v;\n" +
                    "}\n" +

                    "void main(){\n" +
                    //実態に合わせて拡大、詳細なパラメータは後で調整
                    "  vec2 txcrdV = fitting(texcoordVarying);\n"+
                    "  vec4 v = texture2D(texture, txcrdV);\n" +
                    "  vec4 v_ = v;\n"+
                    "  v.xyz = compute_wnoise_Vp(v.xyz);\n" +
                    //ノイズが乗ったか否か判定し、載っていなければ透過
                    "  if(v == v_) gl_FragColor = vec4(0.0);\n"+
                    "  else gl_FragColor = v;\n" +
                    //"  gl_FragColor = v;\n" +
                    "}";

    //モニタ確認用、LL1が正なら緑、負なら紫になる
    public static final String TestNoise =
            "#extension GL_OES_EGL_image_external : require\n" +
                    "precision highp float;\n" +
                    "varying vec2 texcoordVarying;\n" +
                    "uniform samplerExternalOES texture;\n" +
                    //0から1の乱数
                    RendererResource.Func.rand +
                    //hsvへの変換関連
                    RendererResource.Func.tcolor_rgbtohsv+
                    RendererResource.Func.tcolor_hsvtorgb+
                    //正規分布
                    RendererResource.Func.normal_dsitribution+
                    RendererResource.Func.dual_peak_normal_distribution+
                    //その他関数
                    RendererResource.Func.add_noise_rgb+

                    //双峰ガウス分布によるノイズを乗せる関数
                    //ノイズの分散は40/255(demoプログラムの数値と脇本論文を参考に)
                    "vec3 compute_wnoise_Vp(vec3 rgb){\n" +
                    "  const float cov = 0.15686274509;\n" +
                    "  float l = rgb[0] * 0.972556 +" +
                    "            rgb[1] * 2.76508 +" +
                    "            rgb[2] * 0.225836;\n" +
                    "  float l1 = rgb[0] * 0.0553282 +" +
                    "             rgb[1] * 3.69494 " +
                    "             - rgb[2] * 0.154222;\n" +
                    "  float ll1 = rgb[1]*0.929857 - rgb[0]*0.917228 - rgb[2]*0.380058;\n" +

                    //正規化した発生確率, 絶対値が最大になるのは、0.0, 1.0, 0.0の場合
                    "  float Pnoise = abs(ll1) / 1.297286;\n" +

                    //0 ～ 1の一様乱数で、Pnoiseより小さな値が帰る確率を用いる
                    //ノイズを乗せるか判定
                    "  if(Pnoise > rand(vec2(rgb.x + rgb.y, rgb.y + rgb.z))){\n" +
                    //LL1によって対応を変える
                    "    if(ll1 > 0.0){" +
                    "      rgb[1] = 1.0;" +
                    "      rgb[0] = 0.0;" +
                    "      rgb[2] = 0.0;" +
                    "    }else {" +
                    "      rgb[1] = 0.0;" +
                    "      rgb[0] = 1.0;" +
                    "      rgb[2] = 1.0;" +
                    "    }"+
                    "  }\n"+

                    "  return rgb;\n" +
                    "}\n" +

                    //画面位置合わせ
                    "vec2 fitting(vec2 txcrdV){\n" +
                    "  const float scale = 0.27;\n" +
                    "  vec2 v = vec2(txcrdV.x*scale + (1.0-scale)*0.5 + 0.01, txcrdV.y*scale + (1.0-scale)*0.5);\n" +
                    "  return v;\n" +
                    "}\n" +

                    "void main(){\n" +
                    //実態に合わせて拡大、詳細なパラメータは後で調整
                    "  vec2 txcrdV = fitting(texcoordVarying);\n"+
                    "  vec4 v = texture2D(texture, txcrdV);\n" +
                    "  vec4 v_ = v;\n"+
                    "  v.xyz = compute_wnoise_Vp(v.xyz);\n" +
                    //ノイズが乗ったか否か判定し、載っていなければ透過
                    "  if(v == v_) gl_FragColor = vec4(0.0);\n"+
                    "  else gl_FragColor = v;\n" +
                    //"  gl_FragColor = v;\n" +
                    "}";
}
