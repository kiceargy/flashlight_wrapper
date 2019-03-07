package com.android.systemui.qs.tiles;

import android.content.Context;
import android.hardware.Camera;
import android.widget.Toast;

/*
 * Project Listick 2019
 * Created by k1ceargy on 05.03.19 (macOS 10.12)
 * Flashlight Wrapper
 * k1ceargy x depesh1977
 * */
public class FlashlightWrapper {

    private Context context;
    private Camera camera;

    public FlashlightWrapper(Context context){
        this.context = context;
        this.camera = Camera.open();
    }

    public void toggleFlash(boolean state){
        if (state) {
            startFlash();
        }
        if (!state){
            stopFlash();
        }
    }
    
    public void startFlash(){
	camera = Camera.open();
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
        camera.startPreview();
        
        Toast.makeText(context, "project.listick (k1ceargy x depesh1977)", Toast.LENGTH_SHORT).show();
    }
    
   public void stopFlash(){
  	Toast.makeText(context, "disabling.", Toast.LENGTH_SHORT).show();
        camera.stopPreview();
	camera.release();
    }
}
