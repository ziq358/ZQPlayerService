package com.zq.zqplayer.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zq.zqplayer.model.live.RoomInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PythonUtil {
    public static List<RoomInfo> execDouYuPython(int offset, int limit){
        List<RoomInfo> result = new ArrayList<>();
        Process proc;
        try {
            proc = Runtime.getRuntime().exec(String.format("python3 python/douyu.py %s %s", offset, limit));// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            StringBuilder resultTxt = new StringBuilder();
            while ((line = in.readLine()) != null) {
                resultTxt.append(line);
            }
            Gson gson = new Gson();
            result = gson.fromJson(resultTxt.toString(), new TypeToken<ArrayList<RoomInfo>>() {}.getType());
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
