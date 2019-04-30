package com.kwapp.push;

import android.app.Notification;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.entity.UMessage;

import org.android.agoo.huawei.HuaWeiRegister;
import org.android.agoo.xiaomi.MiPushRegistar;

import java.util.HashMap;
import java.util.Map;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

public class FlutterPushPlugin implements MethodCallHandler {

    public static final String CHANNEL = "Umeng";

    private static Registrar registrar;

    private static MethodChannel channel;

    public static String deviceToken;

    public static FlutterPushPlugin instance = new FlutterPushPlugin();

    /**
     * 插件注册
     *
     * @param registrar
     */
    public static void registerWith(Registrar registrar) {
        final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_push");
        channel.setMethodCallHandler(new FlutterPushPlugin(registrar, channel));
    }

    public FlutterPushPlugin(Registrar registrar, MethodChannel channel) {
        this.registrar = registrar;
        this.channel = channel;

        Log.e("FlutterPushPlugin", "init");
    }

    public FlutterPushPlugin() {
    }

    @Override
    public void onMethodCall(MethodCall call, Result result) {
        if (call.method.equals("setUp")) {

            if (channel == null) return;

            HashMap<String, Object> map = new HashMap<>();

            map.put("deviceToken", deviceToken);

            channel.invokeMethod("getDeviceToken", map);
        }
    }

    /**
     * 推送初始化
     *
     * @param context
     * @param appKey
     * @param secret
     */
    public void init(Context context, String appKey, String secret, String xiaomi_id, String xiaomi_key) {
        UMConfigure.init(context,
                appKey, CHANNEL, UMConfigure.DEVICE_TYPE_PHONE, secret);

        PushAgent mPushAgent = PushAgent.getInstance(context);

        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                Log.e("push","deviceToken:" + deviceToken);
                FlutterPushPlugin.deviceToken = deviceToken;

                if (channel == null) return;

                HashMap<String, Object> map = new HashMap<>();

                map.put("deviceToken", deviceToken);

                channel.invokeMethod("getDeviceToken", map);
            }

            @Override
            public void onFailure(String s, String s1) {
            }
        });

        UmengMessageHandler messageHandler = new UmengMessageHandler() {

            @Override
            public Notification getNotification(Context context, UMessage msg) {
                return super.getNotification(context, msg);
            }

            @Override
            public void dealWithNotificationMessage(Context context, UMessage uMessage) {
                super.dealWithNotificationMessage(context, uMessage);

            }
        };

        PushAgent.getInstance(context).setMessageHandler(messageHandler);

        HuaWeiRegister.register(context);

        MiPushRegistar.register(context, xiaomi_id, xiaomi_key);

        UmengNotificationClickHandler notificationClickHandler = new UmengNotificationClickHandler() {

            @Override
            public void dealWithCustomAction(Context context, UMessage msg) {

                String message = msg.custom;

                new Handler(context.getMainLooper()).post(() -> channel.invokeMethod("getPushMessage", message));

            }
        };

        PushAgent.getInstance(context).setNotificationClickHandler(notificationClickHandler);
    }
}
