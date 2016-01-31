package com.udacity.gradle.builditbigger;

public class JokesSourceImpl implements JokesSource {

    @Override
    public Joke getRandomJoke() {
        return new Joke("library level derp");
    }
}
