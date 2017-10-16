package com.wrongwrong.experiment;

import android.app.Activity;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class CameraActivity extends Activity{
    GLSurfaceView glsv;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        //System.out.println(intent.getStringExtra("Shader"));

        Renderer r = new Renderer(this);
        glsv = new GLSurfaceView(this);
        glsv.setEGLContextClientVersion(3);
        glsv.setRenderer(r);

        setContentView(glsv);
    }

}
