package demo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import util.DBUtil;

public class JsonTestDemo {
    @Test
    public void test() {
        createObject();
    }

    public static void main(String[] args) {
        DBUtil db = DBUtil.getDBUtil();
        db.executeQuery()
    }


    public void createObject(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", "张三");
            jsonObject.put("age", 29);
            jsonObject.put("major", new String[]{"111", "222", "333"});
            System.out.println(jsonObject.getInt("age"));
            System.out.println(jsonObject.toString());
            JSONArray jsonArray = new JSONArray(jsonObject.get("major"));
            System.out.println(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
