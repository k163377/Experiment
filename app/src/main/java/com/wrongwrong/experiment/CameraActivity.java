package com.wrongwrong.experiment;

import android.app.Activity;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.KeyEvent;
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

        //上から
        //ナビゲーションバーを隠す
        //一定時間経過で再度隠す
        //ステータスバーを隠す
        glsv.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
        );
    }

    @Override
    protected void onPause() {
        if(null != glsv) glsv.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        if(null != glsv) glsv.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy(){
        if(null != glsv) glsv = null;
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //nullを代入してActivityを終了
            if(null != glsv) glsv = null;
            this.finish();
            return true;
        }
        return false;
    }
}