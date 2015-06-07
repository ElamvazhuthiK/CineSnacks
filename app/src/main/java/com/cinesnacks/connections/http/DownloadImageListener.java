package com.cinesnacks.connections.http;

import android.graphics.Bitmap;

/**
 * Created by ElamvazhuthiK on 5/18/15.
 */
public interface DownloadImageListener
{
    public void gotImage(Bitmap bitmap);

    public void gotError();
}
