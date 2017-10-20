package com.wrongwrong.experiment.FragmentShaders;

public class Mats {
    //現状使っていないが、取り敢えず置いておく

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
