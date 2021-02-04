package nk.gk.wyl.file.util.jxjson;

import com.alibaba.fastjson.JSONArray;
import nk.gk.wyl.file.util.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析json
 */
public class ReadJson {

    public static void main(String[] args) {
        String filePath = "E:\\golaxy\\label.json";

        List<JsonEntity> list = readJson(filePath);
        if(list ==null){
            System.out.println("未解析到数据");
        }
        List<JsonEntity> jsonEntities = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            getChild(list.get(i),jsonEntities);
        }
        for (int i = 0; i < jsonEntities.size(); i++) {
            System.out.println(jsonEntities.get(i).getUsername()+"-----------"+jsonEntities.get(i).getLabel()+"-------------"+jsonEntities.get(i).getParent());
        }
    }

    private static List<JsonEntity>  readJson(String filePath){
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            Reader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            String jsonStr = sb.toString();
            List<JsonEntity> list=JSONArray.parseArray(jsonStr,JsonEntity.class);
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void getChild(JsonEntity jsonEntity, List<JsonEntity> list){
        // 判断是否有下级几点
        if(jsonEntity.getChildren()!=null && jsonEntity.getChildren().size()>0){
            for (int i = 0; i < jsonEntity.getChildren().size(); i++) {
                jsonEntity.getChildren().get(i).setParent(Util.getResourceId());
                getChild(jsonEntity.getChildren().get(i),list);
            }
        }else{
            jsonEntity.setUsername(Util.getResourceId());
            if(jsonEntity.getParent()==null){
                jsonEntity.setParent("");
            }
            list.add(jsonEntity);

        }
    }
}
