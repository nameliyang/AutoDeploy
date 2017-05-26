package com.ly.java.autodeploy;

import com.ly.java.autodeploy.util.ZipFileUtils;

public class Test {

    public static void main(String args[]){


        String path = "G:\\tmp\\test\\aaa";

        try {
            ZipFileUtils.zipDir(path,ZipFileUtils.getZipName(path));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
