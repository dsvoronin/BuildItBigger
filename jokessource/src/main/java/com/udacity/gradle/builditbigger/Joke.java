package com.udacity.gradle.builditbigger;

/**
 * The object model for the data we are sending through endpoints
 */
public class Joke {

    private final String contents;

    public Joke(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }
}