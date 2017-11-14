package com.wrongwrong.experiment;

import android.app.Activity;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class CameraActivity extends Activity{
    GLSurfaceView glsv;
    Enums m;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //シェーダーを取得して開始
        Intent intent = getIntent();
        m = (Enums)intent.getSerializableExtra("Shader");
        Renderer r = new Renderer(this, m);

        glsv = new GLSurfaceView(this);
        glsv.setEGLContextClientVersion(3);
        glsv.setRenderer(r);

        setContentView(glsv);

        //上のフルスク
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //下のフルスク
        glsv.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    @Override
    protected void onPause() {
        glsv.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        glsv.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}