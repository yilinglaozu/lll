package net;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.google.common.io.ByteStreams;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author：刘京源
 * @E-mail： 1179348728@qq.com
 * @Date： 2019/4/15 9:44
 * @Description：描述信息
 */
public class AsyncTaskk {
    private static final AsyncTaskk ourInstance = new AsyncTaskk();

    public static AsyncTaskk getInstance() {
        return ourInstance;
    }

    private AsyncTaskk() {
    }

    public  void  getData(String service_url, final AsyncCallback callback){
        new AsyncTask<String,Void,String>(){
            @Override
            protected String doInBackground(String... strings) {
                return getDataFromServer(strings[0]);
            }
            @Override
            protected void onPostExecute(String s) {
                if (TextUtils.isEmpty(s)){
                    callback.onError(2002,"没有数据");
                }else{
                    callback.onSuccess(s);
                }
            }
        }.execute(service_url);

    }
    public interface AsyncCallback{
        void onError(int code, String msg);

        void onSuccess(String result);

    }

    public  static  String  getDataFromServer(String string){
        HttpURLConnection connection;
        try {
            URL url=new URL(string);
            connection= (HttpURLConnection) url.openConnection();
            //连接 读取 超时
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            if (connection.getResponseCode()==HttpURLConnection.HTTP_OK){
                InputStream inputStream=connection.getInputStream();
                return inputStream2String(inputStream);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
      return null;
    }
    public  static  String inputStream2String(InputStream inputStream) throws IOException {
        return  new String(ByteStreams.toByteArray(inputStream));
    }
}
