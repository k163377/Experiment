package com.wrongwrong.experiment;

public class RendererResource {
    public static final class Mat{
        //farrell2色覚系の変換行列、長谷論文より
        public static final String Fp =
                "const mat3 Fp = mat3("+
                        "0.0, 1.3924, -0.2652,"+
                        "0.0, 1.0, 0.0,"+
                        "0.0, 0.0, 1.0);\n";
        public static final String Fd =
                "const mat3 Fd = mat3(" +
                        "1.0, 0.0, 0.0," +
                        "0.6918, 0.0, 0.2439," +
                        "0.0, 0.0, 1.0);\n";
    }

    public static final class Func{
        //二乗
        public static final String sqr =
                "float sqr(float f){ return f * f; }\n";
        //0 〜 1.0の範囲を返す乱数、引数は何かしらランダムな数
        public static final String rand =
                "float rand(vec2 co) {\n"+
                        "  highp float a = 12.9898;\n"+
                        "  highp float b = 78.233;\n"+
                        "  highp float c = 43758.5453;\n"+
                        "  highp float dt= dot(co.xy ,vec2(a,b));\n"+
                        "  highp float sn= mod(dt, 3.14);\n"+
                        "  return fract(sin(sn) * c);\n"+
                        "}\n";
        //ボックス・ミューラー法、平均ave, 分散covを返す一様乱数、引数はrandと同じく何かしらランダムな数
        public static final String normal_dsitribution =
                "float normal_distribution(float ave, float cov, vec2 co) {\n" +
                        "  const float dPi = 3.1415927410125732421875 * 2.0;\n"+
                        "  float x = rand(co);\n" +
                        "  float y = rand(vec2(co[1], co[0]));\n" +
                        "  float f = sqrt(-2.0 * log(x)) * sin(dPi * y);\n" +
                        "  return (f * cov) + ave;\n" +
                        "}\n";
        //0を中心とした双峰ガウス分布　normal distributionに峰同士の間隔をくわえる処理有り、とりあえず1/2倍を加えたり引いたりする
        public static final String dual_peak_normal_distribution =
                "float dual_peak_normal_distribution(float cov, float interval, vec2 co) {\n"+
                        "  float f = normal_distribution(0.0, cov, co);" +

                        "  if(rand(vec2(co.x + co.y, co.x * co.y)) < 0.5) f -= (interval * 0.5);\n" +
                        "  else f += (interval * 0.5);\n" +

                        "  return f;\n"+
                        "}";
        //rgbからhsvへの変換関数
        public static final String tcolor_rgbtohsv =
                "vec3 tcolor_rgbtohsv(vec3 rgb){\n" +
                        "float min = min(rgb[0], min(rgb[1], rgb[2]));\n"+
                        "float max = max(rgb[0], max(rgb[1], rgb[2]));\n"+
                        "vec3 hsv = vec3(60.0/(max - min), max-min, max);\n" +

                        "if(min == rgb[0]) hsv[0] = (hsv[0] * (rgb[2] - rgb[1])) + 180.0;\n"+
                        "else if(min == rgb[1]) hsv[0] = (hsv[0] * (rgb[0] - rgb[2])) + 300.0;\n"+
                        "else hsv[0] = (hsv[0] * (rgb[1] - rgb[0])) + 60.0;\n" +
                        "return hsv;\n" +
                        "}\n";
        public static final String tcolor_hsvtorgb =
                "vec3 tcolor_hsvtorgb(vec3 hsv){\n" +
                        "vec3 rgb = (hsv[2] - hsv[1]) * vec3(1.0);\n" +
                        "hsv[0] /= 60.0;\n" +
                        "float X = hsv[1] * (1.0 - abs(mod(hsv[0], 2.0) - 1.0));\n" +

                        "if(hsv[0] < 1.0) rgb.xy += vec2(hsv[1], X);\n" +
                        "else if(hsv[0] < 2.0) rgb.xy += vec2(X, hsv[1]);\n" +
                        "else if(hsv[0] < 3.0) rgb.yz += vec2(hsv[1], X);\n" +
                        "else if(hsv[0] < 4.0) rgb.yz += vec2(X, hsv[1]);\n" +
                        "else if(hsv[0] < 5.0) rgb.xz += vec2(X, hsv[1]);\n" +
                        "else rgb.xz += vec2(hsv[1], X);\n" +

                        "return rgb;\n" +
                        "}\n";
        //rgbのどれかへのノイズ加算
        //ノイズを加算したい変数、分散、オフセットを判断するための距離、乱数用のvec2を要求
        public static final String add_noise_rgb =
                "float add_noise_rgb(float target, float cov, float dist, vec2 co){\n" +
                        "target = normal_distribution(target, cov, co);\n" +

                        "if(dist > 0.0) target += cov;\n" +
                        "else target -= cov;\n" +

                        "return target;" +
                        "}\n";
    }
}