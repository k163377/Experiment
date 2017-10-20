package com.wrongwrong.experiment.FragmentShaders;

//メイン関数で利用する関数等を纏めたもの
public class MainHeader {
    //メイン関数で利用する関数等を纏めたもの
    public static final String mainHeader =
            "#extension GL_OES_EGL_image_external : require\n" +
                    "precision highp float;\n" +
                    "varying vec2 texcoordVarying;\n" +
                    "uniform samplerExternalOES texture;\n" +
                    //分布類
                    NoiseDistributions.noiseDistribution +
                    //その他関数
                    OtherFuncs.otherFuncs;
}
