package com.team.azusa.yiyuan.callback;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Response;
import com.team.azusa.yiyuan.bean.ProductDto;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Delete_exe on 2016/3/29.
 */
public abstract class DaoJiShiCallback extends Callback<ArrayList<ProductDto>> {

    @Override
    public ArrayList<ProductDto> parseNetworkResponse(Response response) throws IOException {
        String respon = response.body().string();
        ArrayList<ProductDto> list;
        String list_response = null;
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(respon);
            list_response = jsonObject.get("daojishi").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        list = mapper.readValue(list_response, new TypeReference<ArrayList<ProductDto>>() {
        });
        return list;
    }
}
