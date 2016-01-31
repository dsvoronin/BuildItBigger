package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokesApi.JokesApi;
import com.udacity.gradle.builditbigger.lib.JokeActivity;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    private static JokesApi myApiService = null;
    private final Context context;

    EndpointsAsyncTask(Context context) {
        this.context = context;

        if (myApiService == null) {  // Only do this once
            JokesApi.Builder builder = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(),
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
    }

    @Override
    protected String doInBackground(Void... params) {
        try {
            return myApiService.getJoke().execute().getContents();
        } catch (IOException e) {
            Log.e("EndpointsAsyncTask", "Error loading joke", e);
            return "";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        context.startActivity(JokeActivity.showJokeActivity(context, result));
    }
}