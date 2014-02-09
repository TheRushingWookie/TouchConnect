package com.example.touchconnect;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.audiofx.Equalizer;
import android.media.audiofx.Visualizer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.Menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import edu.emory.mathcs.jtransforms.fft.DoubleFFT_1D;
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private void startRecording() {
		
		MediaRecorder mmRecorder = new MediaRecorder();
        mmRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mmRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mmRecorder.setOutputFile(Environment.getExternalStorageDirectory().getAbsolutePath() + "/test.wav");
        mmRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mmRecorder.prepare();
            mmRecorder.start();
        } catch (IOException e) {
            Log.e("blah", "prepare() failed");
        }
    }
	
}
