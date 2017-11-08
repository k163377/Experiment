package com.wrongwrong.experiment;

import com.wrongwrong.experiment.FragmentShaders.ConstNoisePShaders;
import com.wrongwrong.experiment.FragmentShaders.ProportionNoisePShaders;
import com.wrongwrong.experiment.FragmentShaders.TestNoiseShader;

import java.util.EnumMap;

public enum Enums {
    TestNoise,
    ConstantPNoise4,
    ConstantPNoise6,
    ConstantPNoise8,
    ProportionNoiseP10_0,
    ProportionNoiseP5_5,
    ProportionNoiseP20__10;

    public static final EnumMap<Enums, String> ShaderTitle;
    static{
        ShaderTitle = new EnumMap<Enums, String>(Enums.class);
        ShaderTitle.put(Enums.TestNoise, "TestNoise");
        ShaderTitle.put(Enums.ConstantPNoise4, "ConstantPNoise4");
        ShaderTitle.put(Enums.ConstantPNoise6, "ConstantPNoise6");
        ShaderTitle.put(Enums.ConstantPNoise8, "ConstantPNoise8");
        ShaderTitle.put(Enums.ProportionNoiseP10_0, "ProportionNoiseP10_0");
        ShaderTitle.put(Enums.ProportionNoiseP5_5, "ProportionNoiseP5_5");
        ShaderTitle.put(Enums.ProportionNoiseP20__10, "ProportionNoiseP20__10");
    }
    public static String getTitle(Enums e){
        return ShaderTitle.get(e);
    }

    private static final EnumMap<Enums, String> Shader;
    static{
        Shader = new EnumMap<Enums, String>(Enums.class);
        Shader.put(Enums.TestNoise, TestNoiseShader.testNoise);
        Shader.put(Enums.ConstantPNoise4, ConstNoisePShaders.ConstNoiseP4);
        Shader.put(Enums.ConstantPNoise6, ConstNoisePShaders.ConstNoiseP6);
        Shader.put(Enums.ConstantPNoise8, ConstNoisePShaders.ConstNoiseP8);
        Shader.put(Enums.ProportionNoiseP10_0, ProportionNoisePShaders.ProportionNoiseP10_0);
        Shader.put(Enums.ProportionNoiseP5_5, ProportionNoisePShaders.ProportionNoiseP5_5);
        Shader.put(Enums.ProportionNoiseP20__10, ProportionNoisePShaders.ProportionNoiseP20__10);
    }
    public static String getShader(Enums e){
        return Shader.get(e);
    }

    public static Enums getEnums(int ordinal){
        for(Enums e : ShaderTitle.keySet()) {
            if(e.ordinal() == ordinal) return e;
        }
        return null;
    }
}
