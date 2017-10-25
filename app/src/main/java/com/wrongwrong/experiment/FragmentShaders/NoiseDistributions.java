package com.wrongwrong.experiment.FragmentShaders;

public class NoiseDistributions {
    //0 〜 1.0の範囲を返す乱数、引数は何かしらランダムな数
    //パターンが出てしまっている気がする、要確認
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
                    "  return (f * sqrt(cov)) + ave;\n" +
                    "}\n";
    //0を中心とした双峰ガウス分布　normal distributionに峰同士の間隔をくわえる処理有り、とりあえず1/2倍を加えたり引いたりする
    public static final String dual_peak_normal_distribution =
            "float dual_peak_normal_distribution(float cov, float interval, vec2 co) {\n"+
                    "  float f = normal_distribution(0.0, cov, co);" +

                    "  if(rand(vec2(co.x + co.y, co.x * co.y)) < 0.5) f -= (interval * 0.5);\n" +
                    "  else f += (interval * 0.5);\n" +

                    "  return f;\n"+
                    "}";
    //指数分布 http://www.ishikawa-lab.com/montecarlo/4shou.html Math.random()は0から1 書いてある式がおかしく、logが抜けてる
    public static final String exponential_distribution =
            "float exponential_distribution(float lambda, vec2 co) {" +
                    "  return (-1.0) / (lambda * log(1.0 - rand(co)));" +
                    "}";


    //このファイルのノイズ関連の関数をまとめたString
    public static final String noiseDistributions = rand +
            normal_dsitribution +
            dual_peak_normal_distribution+
            exponential_distribution;
}
