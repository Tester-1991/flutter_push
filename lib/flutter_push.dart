import 'package:flutter/services.dart';

typedef void GetDeviceToken(String deviceToken);

typedef void GetPushMessage(String message);

class FlutterPush {
  static const MethodChannel _channel = const MethodChannel('flutter_push');

  static String deviceToken;

  ///初始化
  static void setUp(
      GetDeviceToken _getDeviceToken, GetPushMessage _getPushMessage) {
    _channel.invokeMethod("setUp");
    _channel.setMethodCallHandler((call) async {
      var method = call.method;

      switch (method) {
        case "getDeviceToken":
          Map map = call.arguments;
          if (map.containsKey("deviceToken")) {
            deviceToken = map["deviceToken"];
            //获取deviceToken
            _getDeviceToken(map["deviceToken"]);
          }
          break;
        case "getPushMessage":
          //获取deviceToken
          String message = call.arguments;
          _getPushMessage(message);
          break;
      }
    });
  }
}
