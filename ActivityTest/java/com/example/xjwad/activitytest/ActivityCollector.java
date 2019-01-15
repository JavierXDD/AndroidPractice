package com.example.xjwad.activitytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

//活动管理器
public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();
    //新增活动
    public static void addActivity (Activity activity){
        activities.add(activity);
    }
    //结束活动
    public static  void removeActivity(Activity activity){
        activities.remove(activity);
    }
    //结束所有活动
    public  static void finshAll(){
        for (Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
