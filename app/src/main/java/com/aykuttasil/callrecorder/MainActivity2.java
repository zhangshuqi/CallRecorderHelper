package com.aykuttasil.callrecorder;

import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.aykuttasil.callrecord.CallRecord;
import com.aykuttasil.callrecord.helper.LogUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

public class MainActivity2 extends FragmentActivity {

    private CallRecord callRecord;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //callRecord = CallRecord.init(this);
        int source = MediaRecorder.AudioSource.VOICE_COMMUNICATION;
        if (Build.VERSION.SDK_INT >= 29) source = MediaRecorder.AudioSource.VOICE_RECOGNITION;
        callRecord = new CallRecord.Builder(this)
                .setRecordFileName("RecordPangPang")
                .setRecordDirName("mobilePangPang")
                .setRecordDirPath(Environment.getExternalStorageDirectory().getAbsolutePath())
                .setAudioEncoder(MediaRecorder.AudioEncoder.AMR_WB)
                .setOutputFormat(MediaRecorder.OutputFormat.AMR_WB)
                .setAudioSource(source)
                .setLogEnable(true)
                .setShowSeed(true)
                .setShowPhoneNumber(true)
                .build();

    }
    public void StartCallRecordClick(View view) {
        LogUtils.i("MainActivity2", "StartCallRecordClick");
        callRecord.startCallReceiver();

        //callRecord.enableSaveFile();
        //callRecord.changeRecordDirName("NewDirName");
    }

    public void StopCallRecordClick( View view) {
        LogUtils.i("MainActivity2", "StopCallRecordClick");
        callRecord.stopCallReceiver();

        //callRecord.disableSaveFile();
        //callRecord.changeRecordFileName("NewFileName");
    }
}
