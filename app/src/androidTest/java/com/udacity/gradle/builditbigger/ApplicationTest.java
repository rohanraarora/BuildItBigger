package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.InstrumentationTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Test
    public void testEndpoint(){

        JokeEndPointTask task = new JokeEndPointTask();
        task.execute(new JokeEndPointTask.CallBack() {
            @Override
            public void onJokeLoaded(String joke) {
                assertEquals(joke,"Funny Joke");
            }
        });

    }
}