package com.ly.verify;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpVerifyTest {
	public static void main(String[] args) {
		String url = "http://192.168.199.120:8080/MyTest/hello";
		Map<String,String> map = new HashMap<>();
		
		StringBuffer sb = new StringBuffer();
		try {
			URL u = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) u.openConnection();

			connection.setReadTimeout(10000);
			connection.setConnectTimeout(10000);

			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			StringBuffer params = new StringBuffer();

			if (map != null) {
				for (Map.Entry<String, String> element : map.entrySet()) {
					params.append(element.getKey());
					params.append("=");
					params.append(element.getValue());
					params.append("&");
				}
				if (params.length() > 0) {
					params.deleteCharAt(params.length() - 1);
				}
			}

			connection.setRequestProperty("Content-Length", String.valueOf(params.length()));

			connection.connect();
			PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
			;
			printWriter.write(params.toString());
			printWriter.flush();

			int responseCode = connection.getResponseCode();
			System.out.println("responseCode ===="+responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader responseReader;
				responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
				String line = "";
				while ((line = responseReader.readLine()) != null) {
					sb.append(line);
				}
				responseReader.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
