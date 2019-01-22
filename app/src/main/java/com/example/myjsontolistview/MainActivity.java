package com.example.myjsontolistview;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList <Student> list = new ArrayList<Student>();
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lv=(ListView)this.findViewById(R.id.listview1);
        this.adapter=new ItemAdapter(this,list);
        this.lv.setAdapter(adapter);
        /// allow another execution that is not controlled by the current program.
        /// in other words, a separate thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //connect to data server, using http connection

        try {
//            URL url = new URL("http://192.168.43.61/review/db/getall.php"); //instead of localhost, use 10.0.2.2
            URL url = new URL("http://192.168.43.61/review/db/getall.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // low level access
           InputStream is = conn.getInputStream();
           StringBuffer data = new StringBuffer();
           int ch=0;
           while ((ch=is.read())!=-1){
                data.append((char)ch);
           }

            is.close();
            conn.disconnect();

            //System.out.println(data.toString());

            //Toast.makeText(getApplicationContext(),data.toString(), Toast.LENGTH_SHORT).show();
            Log.d("JSON_RESPONSE:", data.toString());
            //BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            //String data = br.readLine();
            //System.out.println(data);

            JSONObject json = new JSONObject(data.toString());
            JSONArray array = json.getJSONArray("students");
                for (int i=0; i<array.length(); i++){
                    JSONObject student = array.getJSONObject(i);
                    ///
                    String idno = student.getString("idno");
                    String lastname = student.getString("lastname");
                    String firstname = student.getString("firstname");
                    String course = student.getString("course");
                    String level = student.getString("level");
                    ///
                    Student s = new Student(idno,lastname,firstname,course,level);
                    list.add(s);
                    adapter.notifyDataSetChanged();
                }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
