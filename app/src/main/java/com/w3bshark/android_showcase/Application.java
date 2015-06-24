package com.w3bshark.android_showcase;

/**
 * Created by tmccraw on 6/21/2015.
 */
public class Application {
    int appId;
    String name;
    String description;
    int photoId;

    Application(int appId, String name, String description, int photoId) {
        this.appId = appId;
        this.name = name;
        this.description = description;
        this.photoId = photoId;
    }
}
