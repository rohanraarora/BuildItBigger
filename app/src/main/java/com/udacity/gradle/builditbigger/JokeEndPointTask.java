package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.rohanarora.myapplication.backend.jokeApi.JokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by rohanarora on 02/10/16.
 */

public class JokeEndPointTask extends AsyncTask<JokeEndPointTask.CallBack,Void,String> {


    private JokeApi myApiService;


    private CallBack mCallBack;
    private Context mContext;

    @Override
    protected String doInBackground(CallBack... params) {

        mCallBack = params[0];

        if(myApiService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.tellJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    interface CallBack {
        void onJokeLoaded(String joke);
    }

    @Override
    protected void onPostExecute(String s) {
        if(mCallBack!=null){
            mCallBack.onJokeLoaded(s);
        }
    }
}
