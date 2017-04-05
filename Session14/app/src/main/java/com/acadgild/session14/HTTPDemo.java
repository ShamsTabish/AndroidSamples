package com.acadgild.session14;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HTTPDemo extends AppCompatActivity {
    URL myServerURL;
    HttpURLConnection myHttpConnection;
    InputStream myDataStream;

    TextView dataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpdemo);
        dataView = (TextView) findViewById(R.id.dataFromServer);
    }

    public void loadMyURL(View textView) {
        Toast.makeText(this, "Server data being downloaded..", Toast.LENGTH_SHORT).show();
        MyServerDataDownloader downloader = new MyServerDataDownloader();
        downloader.execute();
    }

    Person loadMyWebServiceData() {
        Person dataFromServer = null;
        try {
            myServerURL = new URL("http://www.thomas-bayer.com/sqlrest/CUSTOMER/18/");

            myHttpConnection = (HttpURLConnection) myServerURL.openConnection();

            myDataStream = myHttpConnection.getInputStream();

//            int availableByte = myDataStream.available();
//            StringBuffer myData=new StringBuffer();
//
//            int data=0;
//            while((data=myDataStream.read())>0){
//                myData.append((char)data);
//            }
//
//            dataFromServer = myData.toString();

            dataFromServer = parseXMLData(myDataStream);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (myDataStream != null)
                try {
                    myDataStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return dataFromServer;
    }

    Person parseXMLData(InputStream xmlStreamFromServer) {
        String fName = "", lName = "", address = "", id = "0", city = "";

        try {
            XmlPullParser myPersonParser = XmlPullParserFactory.newInstance().newPullParser();
            myPersonParser.setInput(xmlStreamFromServer, null);
            int xmlEvent = myPersonParser.getEventType();
            while (XmlPullParser.END_DOCUMENT != xmlEvent) {
                String tagName = myPersonParser.getName();
                String tagValue = "-";
                if (XmlPullParser.START_TAG == xmlEvent) {
                    myPersonParser.next();
                    xmlEvent = myPersonParser.getEventType();
                    if (XmlPullParser.TEXT == xmlEvent) {
                        tagValue = myPersonParser.getText();
                        Log.i("Debug---", "tagName  " + tagName + "  " + tagValue);
                        if (tagName.equals("FIRSTNAME")) {
                            fName = tagValue;
                        } else if (tagName.equals("LASTNAME")) {
                            lName = tagValue;
                        } else if (tagName.equals("STREET")) {
                            address = tagValue;
                        } else if (tagName.equals("ID")) {
                            id = tagValue;
                        } else if (tagName.equals("CITY")) {
                            city = tagValue;
                        }
                    }
                }
                myPersonParser.next();
                xmlEvent = myPersonParser.getEventType();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Person(fName, lName, city, address, Integer.parseInt(id));
    }


    class MyServerDataDownloader extends AsyncTask<String, Integer, Person> {
        @Override
        protected Person doInBackground(String... params) {
            Person data = new Person("-", "-", "-", "-", 0);
            data = loadMyWebServiceData();
            return data;
        }

        @Override
        protected void onPostExecute(Person resultdata) {
            super.onPostExecute(resultdata);
            dataView.setText("Data From Server:  " + resultdata+"\n\n\n"+"FullName:"+resultdata.getFullName());
        }
    }


    class Person {
        String firstName, lastName, city, address;
        int id;

        public Person(String firstName, String lastName, String city, String address, int id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.city = city;
            this.address = address;
            this.id = id;
        }

        String getFullName(){
            return firstName+" "+lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", city='" + city + '\'' +
                    ", address='" + address + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}
