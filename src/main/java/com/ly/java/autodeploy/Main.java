package com.ly.java.autodeploy;

import java.nio.channels.ShutdownChannelGroupException;

public class Main {
	
	private static final String CONFIG_PATH = "config.xml";
	
	public static void main(String args[]) {
//		try {
//			AutoDeployManager.getInstance(CONFIG_PATH).start();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		if(args.length == 0){
			show_help();
		}else{
			switch (args[0]) {
			case "-i":
				break;
			default:
				break;
			}
		}
		
	}
	
	public static void  show_help(){
		println();
		println("usage: autoDeploy [Options]");
		println();
		println( "Options：");
		println(  " -v                                    版本号与项目信息");
		println(  " -i                                    根据配置文件进行初始化");
		println(  " -c                                    clean 工程");
	    println(  " -du  [ -l ]                           跳过编译步骤直接上传已存在war包到本地服务器");
        println( " -du -r <server_flag>                  跳过编译步骤直接上传已存在war包到指定的远程服务器");
	    println( " -h                                    帮助");
	    println( " -l                                    自动编译打包本地部署");
	    println( " -lstop                                关闭本地服务器");
	    println( " -r <server_flag>                      自动编译打包远程部署到指定的远程服务器");
	    println( " -r <server_flag> -his                 查看指定的远程服务器上备份历史");
	    println( " -r <server_flag> -rb <backup_version> 将指定服务器web应用回滚到指定版本");
	}
	
	public static void println(){
		System.out.println();
	}
	public static void print(String str){
		System.out.print(str);
	}
	
	public static void println(String str){
		System.out.println(str);
	}

}
