package com.wrongwrong.experiment.FragmentShaders;

public class OtherFuncs {
    public static final String sqr =
            "float sqr(float f){ return f * f; }\n";



    //色変換
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

    public static final String otherFuncs= sqr +
            tcolor_hsvtorgb +
            tcolor_rgbtohsv;
}
