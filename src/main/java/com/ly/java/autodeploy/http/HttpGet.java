package com.ly.java.autodeploy.http;

public class HttpGet extends HttpMethod {


    @Override
    public String execute() {
        return HttpClient.get(mUrl);
    }

    @Override
    public void setUrl(String url) {
        mUrl = url;
    }
}

