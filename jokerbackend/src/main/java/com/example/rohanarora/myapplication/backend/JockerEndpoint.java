/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.rohanarora.myapplication.backend;

import com.example.Joker;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.rohanarora.example.com",
                ownerName = "backend.myapplication.rohanarora.example.com",
                packagePath = ""
        )
)
public class JockerEndpoint {

    /**
     * A simple endpoint method that returns a joke
     */
    @ApiMethod(name = "tellJoke")
    public Joke tellJoke() {

        Joker joker = new Joker();
        Joke response = new Joke();
        response.setJoke(joker.tellJoke());
        return response;
    }

}
