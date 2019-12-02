package com.bawei.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @包名 com.bawei.myapplication
 * @mengxuan
 * @日期2019/12/2
 * @日期2019 : 12:02
 * @项目名CombatSample20191130
 * @类名Netutil
 **/
public class Netutil {
    static Netutil netutil= new Netutil();

    public Netutil() {

    }

    public static Netutil getInstance() {
        return netutil;
    }
    public void getBitmap(final String s, final ImageView imageView){

        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected void onPostExecute(Bitmap bitmap) {
               imageView.setImageBitmap(bitmap);
            }

            @Override
            protected Bitmap doInBackground(Void... voids) {
                Bitmap bitmap=null;
                HttpURLConnection httpURLConnection=null;
                InputStream inputStream=null;
                try {
                    URL url = new URL(s);
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    if (httpURLConnection.getResponseCode()==200){
                        inputStream=httpURLConnection.getInputStream();
                        bitmap = io2bitmap(inputStream);
                    }else {

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                return bitmap;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private Bitmap io2bitmap(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }

    @SuppressLint("StaticFieldLeak")
   public void get(final String s, final MyChback myChback){
        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPostExecute(String s) {
                myChback.Doget(s);
            }

            @Override
            protected String doInBackground(Void... voids) {
                String json=null;
                HttpURLConnection httpURLConnection=null;
                InputStream inputStream=null;
                try {
                    URL url = new URL(s);
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    if (httpURLConnection.getResponseCode()==200){
                        inputStream=httpURLConnection.getInputStream();
                       json = io2String(inputStream);
                    }else {
                        myChback.Failure("失败");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                return json;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }

    private String io2String(InputStream inputStream) {
        String json=null;
        byte[] bytes = new byte[1024];
        int type=-1;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
          while ((type=inputStream.read(bytes))!=-1){
              byteArrayOutputStream.write(bytes,0,type);
          }

          json=new String(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }


    interface   MyChback{
        void Doget(String s);
        void Failure(String e);
  }
}
