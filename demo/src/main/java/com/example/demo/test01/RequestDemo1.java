package com.example.demo.test01;

import java.util.ArrayList;
import java.util.List;

/**
 * RequestDemo
 *
 * @author jasonxu
 */
public class RequestDemo1 {

//    public static void main(String[] args) {
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
//    }
}
