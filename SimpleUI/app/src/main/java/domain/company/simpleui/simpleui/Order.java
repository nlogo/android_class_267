package domain.company.simpleui.simpleui;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by user on 2016/6/6.
 */

@ParseClassName("Order")

public class Order extends ParseObject{
//    String note;
//    String menuResults;
//    String storeInfo;

    public String getNote(){return getString("note");}
    public void setNote(String note){put("note", note);}

    public String getMenuResults(){return getString("menuResults");}
    public void setMenuResults(String note){put("menuResults", note);}

    public String getStoreInfo(){return getString("storeInfo");}
    public void setStoreInfo(String note){put("storeInfo", note);}

    public JSONObject getJsonObject()
    {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("note", getNote());
            jsonObject.put("menuResults", getMenuResults());
            jsonObject.put("storeInfo", getStoreInfo());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static Order newInstanceWithData(String data)
    {
        try {
            JSONObject jsonObject = new JSONObject(data);
            Order order = new Order();
            order.setNote(jsonObject.getString("note"));
            order.setMenuResults(jsonObject.getString("menuResults"));
            order.setStoreInfo(jsonObject.getString("storeInfo"));
            return order;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
