package com.example.demo.test01;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * RequestDemo
 *
 * @author jasonxu
 */
public class RequestDemo {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();


//        String url = "http://192.168.16.209:8080/default/restful/worklist/manager/query/finish/biz/sysadmin/sysadmin";
        String url = "http://192.168.16.209:8080/default/restful/worklist/manager/query/finish/biz/sysadmin/sysadmin?" +
                "scope=ALL&" +
                "includeHistory=false&" +
                "bizTableName=LEAVEMASTER" +
//                "&" +
//                "bizSql=SELECT * FROM LEAVEMASTER&" +
//                "wiSql=SELECT USER_ID FROM cap_user&" +
//                "wiBindList=1&" +
//                "bizBindList=1" +
                "";


//        Object result = restTemplate.postForObject(url);



//        List<Object> wiBindList = new ArrayList<Object>();
//        List<Object> bizBindList = new ArrayList<Object>();
//        wiBindList.add(activityInstList.get(0).getCurrentState());
//        wiBindList.add(activityInstList.get(0).getActivityInstID());
//
//        bizBindList.add(workItemList.get(0).getCurrentState());
//        bizBindList.add(workItemList.get(0).getWorkItemID());
//
//        FormBody body = new FormBody.Builder()
//                .add("scope", "DELEG")
//                .add("forHistory", "true")
//                .add("bizTableName", "wfbiz_var_inst")
//                .add("wiSql", "")
//                .add("bizSql", "")
//                .add("wiBindList", JSON.toJSONString(wiBindList))
//                .add("bizBindList", JSON.toJSONString(bizBindList))
//                .add("pageCond", JSON.toJSONString(new PageCond()))
//                .build();
//
//        String url = "restful/worklist/manager/query/entrust/finish/biz/" + Common.userId + "/" + Common.userOperatorId;
//        String requestUrl = null;
//        JSONObject jsonObject = null;
//        try {
//            requestUrl = CommonUtils.getHttpQueryUrl(url);
//            System.out.println(requestUrl);
//            OkHttpClient client = new OkHttpClient();
//            Request request = new Request.Builder()
//                    .url(requestUrl)
//                    .post(body)
//                    .addHeader("Content-Type", "application/json").build();
//            Response response = client.newCall(request).execute();
//            if (response.isSuccessful()) {
//                ResponseBody responseBody = response.body();
//                jsonObject = JSONObject.parseObject(responseBody.string());
//                System.out.println(jsonObject);
//            } else {
//                System.out.println(response);
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }
    }
}
