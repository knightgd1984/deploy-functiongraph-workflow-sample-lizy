package com.huaweicloud.function.demo;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.huawei.services.runtime.Context;
import com.huawei.services.runtime.entity.apig.APIGTriggerEvent;
import com.huawei.services.runtime.entity.apig.APIGTriggerResponse;
import com.huawei.services.runtime.entity.dis.DISTriggerEvent;
import com.huawei.services.runtime.entity.dms.DMSTriggerEvent;
import com.huawei.services.runtime.entity.lts.LTSTriggerEvent;
import com.huawei.services.runtime.entity.smn.SMNTriggerEvent;
import com.huawei.services.runtime.entity.timer.TimerTriggerEvent;

public class TriggerDemo {
    public APIGTriggerResponse apigTest(APIGTriggerEvent event, Context context){
    	context.getLogger().log(event.toString());
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        return new APIGTriggerResponse(200, headers, event.toString());
    }

    public String smnTest(SMNTriggerEvent event, Context context){
    	context.getLogger().log(event.toString());
        return "ok";
    }

    public String dmsTest(DMSTriggerEvent event, Context context){
    	context.getLogger().log(event.toString());
        return "ok";
    }

    public String timerTest(TimerTriggerEvent event, Context context){
    	context.getLogger().log(event.toString());
        return "ok";
    }

    public String disTest(DISTriggerEvent event, Context context) throws UnsupportedEncodingException{
    	context.getLogger().log(event.toString());
        System.out.println(event.getMessage().getRecords()[0].getRawData());
        return "ok";
    }

    public String ltsTest(LTSTriggerEvent event, Context context) throws UnsupportedEncodingException {
    	context.getLogger().log(event.toString());
        System.out.println("raw data: " + event.getLts().getRawData());
        return "ok";
    }
}
