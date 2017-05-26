package com.ly.java.autodeploy.http;

import java.util.Map;

public class HttpPost extends HttpMethod {
    Map<String,String> map;
    
    @Override
    public String execute() {
        return HttpClient.post(mUrl,map);
    }

    @Override
    public void setUrl(String url) {

        mUrl = url;
    }

    public void setParams(Map<String,String> params){
        map = params;
    }

    public Map<String,String> getParams(){
        return map;
    }
}
