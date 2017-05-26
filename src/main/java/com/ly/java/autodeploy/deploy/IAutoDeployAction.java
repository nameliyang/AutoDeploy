package com.ly.java.autodeploy.deploy;

public interface IAutoDeployAction {
    void connect ()throws Exception;
    void upload()throws Exception;
    void download()throws Exception;
    void command()throws Exception;
    void verifyApi() throws Exception;
    void close()throws Exception;
}
