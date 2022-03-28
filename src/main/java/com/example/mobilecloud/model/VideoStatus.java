package com.example.mobilecloud.model;

public class VideoStatus {

    public enum VideoState {
        READY, PROCESSING
    }

    private VideoState state;

    public VideoStatus(VideoState state) {
        super();
        this.state = state;
    }

    public VideoState getState() {
        return state;
    }

    public void setState(VideoState state) {
        this.state = state;
    }

}