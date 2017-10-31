package com.wrongwrong.experiment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;

import com.wrongwrong.experiment.FragmentShaders.TestNoiseShader;

import java.util.EnumMap;

public class MainActivity extends AppCompatActivity {
    private ScrollView mScrollView;
    private LinearLayout mLinearLayout;
    private Button mButton;
    private RadioGroup mRadioGroup;

    //フラグメントシェーダを渡して処理開始
    protected void startCameraActivity(){
        //データを渡してActivity開始
        Intent intent = new Intent(getApplication(), CameraActivity.class);
        //intent.putExtra("Shader", Enums.getShader(Enums.getEnums(mRadioGroup.getCheckedRadioButtonId())));
        intent.putExtra("Shader", Enums.getEnums(mRadioGroup.getCheckedRadioButtonId()));
        startActivity(intent);
    }

    //カメラのランタイムパーミッション
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: { //ActivityCompat#requestPermissions()の第2引数で指定した値
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {//許可された場合
                    startCameraActivity();
                }else{//拒否された場合の処理
                    //とりあえず終了しておく
                    MainActivity.this.finish();
                }
                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mScrollView = new ScrollView(this);

        //縦のリニアレイアウト
        mLinearLayout = new LinearLayout(this);
        mLinearLayout.setOrientation(LinearLayout.VERTICAL);

        //ラジオボタンの設定
        mRadioGroup = new RadioGroup(this);
        //チェックされているidがノイズから受け取る番号
        for(Enums e : Enums.ShaderTitle.keySet()){
            RadioButton rb = new RadioButton(this);
            rb.setTextSize(50.0f);
            rb.setText(Enums.getTitle(e));
            rb.setId(e.ordinal());
            mRadioGroup.addView(
                    rb,
                    new RadioGroup.LayoutParams(
                            RadioGroup.LayoutParams.MATCH_PARENT,
                            RadioGroup.LayoutParams.WRAP_CONTENT
                    )
            );
        }
        //初期状態では0番をチェック
        mRadioGroup.check(0);

        //遷移のボタンを設定
        mButton = new Button(this);
        mButton.setText("Start");
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //カメラ権限の確認とアクティビティーのスタート
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED) {//権限がまだ無い場合
                    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CAMERA)) {//明示的に権限が拒否されていた時
                        //拒否されていた時の処理、なんかしらのメッセージを出すと良いと思われる、今は何も考えずにパーミッションを聞いておく
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 1);
                    } else {//まだ聞いてなかったとき
                        //与えても良いか聞く、onRequestPermissionsResultが答えを受ける
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 1);
                    }
                }else {//権限がある場合
                    startCameraActivity();
                }
            }
        });

        //リニアレイアウトに追加
        mLinearLayout.addView(mButton);
        mLinearLayout.addView(mRadioGroup);

        mScrollView.addView(
                mLinearLayout,
                new ScrollView.LayoutParams(
                        ScrollView.LayoutParams.MATCH_PARENT,
                        ScrollView.LayoutParams.MATCH_PARENT
                )
        );

        setContentView(mScrollView);
    }
}