package com.ly.java.autodeploy.deploy;

import java.util.List;
import java.util.Map;

import com.ly.java.autodeploy.http.HttpMethod;

public interface IAutoDeployBuilder {
    void setServerInfo(String host,String usrName,String password);
    void setUploadFileInfo(Map<String,String> mapInfo);
    void setCommands(List<String> commandList);
    void setVerifyApi(List<HttpMethod> apis);
}
