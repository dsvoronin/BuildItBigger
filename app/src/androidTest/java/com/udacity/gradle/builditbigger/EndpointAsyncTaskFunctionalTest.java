package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

public class EndpointAsyncTaskFunctionalTest extends AndroidTestCase {

    public void testVerifySuccessResponse() {
        String joke = new EndpointsAsyncTask(getContext()).doInBackground();
        assertFalse(joke.isEmpty());
    }
}