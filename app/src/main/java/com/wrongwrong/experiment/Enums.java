package com.wrongwrong.experiment;

import com.wrongwrong.experiment.FragmentShaders.ConstNoisePShaders;
import com.wrongwrong.experiment.FragmentShaders.TestNoiseShader;

import java.util.EnumMap;

public enum Enums {
    TestNoise,
    ConstantPNoise6,
    ConstantPNoise8,
    ConstantPNoise10;

    public static final EnumMap<Enums, String> ShaderTitle;
    static{
        ShaderTitle = new EnumMap<Enums, String>(Enums.class);
        ShaderTitle.put(Enums.TestNoise, "TestNoise");
        ShaderTitle.put(Enums.ConstantPNoise6, "ConstantPNoise6");
        ShaderTitle.put(Enums.ConstantPNoise8, "ConstantPNoise8");
        ShaderTitle.put(Enums.ConstantPNoise10, "ConstantPNoise10");
    }
    public static String getTitle(Enums e){
        return ShaderTitle.get(e);
    }

    private static final EnumMap<Enums, String> Shader;
    static{
        Shader = new EnumMap<Enums, String>(Enums.class);
        Shader.put(Enums.TestNoise, TestNoiseShader.testNoise);
        Shader.put(Enums.ConstantPNoise6, ConstNoisePShaders.ConstNoiseP6);
        Shader.put(Enums.ConstantPNoise8, ConstNoisePShaders.ConstNoiseP8);
        Shader.put(Enums.ConstantPNoise10, ConstNoisePShaders.ConstNoiseP10);
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
