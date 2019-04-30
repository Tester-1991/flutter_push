#import "FlutterPushPlugin.h"
#import <flutter_push/flutter_push-Swift.h>

@implementation FlutterPushPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterPushPlugin registerWithRegistrar:registrar];
}
@end
