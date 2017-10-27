package com.wrongwrong.experiment.FragmentShaders;

public class NoiseGenerators {
    //正規分布で絶対値を取った値をノイズとして返す
    //テストとして分散は0.3とする
    public static final String abs_normal_noise =
            "float abs_normal_noise(vec3 rgb) {" +
                    "  return abs(normal_distribution(0.0, 0.3, vec2(rgb.x + rgb.z, rgb.x)));" +
                    "}";

    //指数分布、テストでラムダは0.2
    public static final String exponential_noise =
            "float exponential_noise(vec3 rgb) {" +
                    "  return exponential_distribution(5.0, vec2(rgb.x + rgb.z, rgb.x));" +
                    "}";
}
