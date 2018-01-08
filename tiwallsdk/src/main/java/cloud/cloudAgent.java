package cloud;

import android.os.AsyncTask;

import com.nsun.tiwall.tiwallsdk.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by 110 on 07/01/2018.
 */

public class cloudAgent extends AsyncTask <String, Void, String> {
    public int timeout = R.integer.defaultTimeout;

    public interface TaskListener {
        public void onFinished(String result);
    }

    private final TaskListener reqManagerTaskListener;

    public cloudAgent(TaskListener reqManagerTaskListener) {
        this.reqManagerTaskListener = reqManagerTaskListener;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL getUrl = new URL(strings[0]);
            URLConnection urlConnection = getUrl.openConnection();
            urlConnection.setConnectTimeout(timeout);
            InputStream in = urlConnection.getInputStream();
//        if (isCancelled()) break;
            return convertInputStreamToString(in);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void onProgressUpdate() {
    }

    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (this.reqManagerTaskListener != null) {
            this.reqManagerTaskListener.onFinished(result);
        }

    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    private String convertInputStreamToString(InputStream in) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
            return out.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
