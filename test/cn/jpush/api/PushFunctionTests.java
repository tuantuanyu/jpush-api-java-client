package cn.jpush.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.Notification;

public class PushFunctionTests {
    private static final String appKey ="dd1066407b044738b6479275";
    private static final String masterSecret = "2b38ce69b1de2a7fa95706ea";
    
    private static final String TAG = "tag_api";
    private static final String ALIAS = "alias_api";
    private static final String ALERT = "JPush Test - alert";
    private static final String MSG_CONTENT = "JPush Test - msgContent";
    private static final int SUCCEED_RESULT_CODE = 0;
	
    private JPushClient _client = null;
    
    @Before
    public void before() {
        _client = new JPushClient(masterSecret, appKey);
    }
	
	
	@Test
    public void sendSimpleNotificationAll() {
	    PushPayload payload = PushPayload.notificationAlertAll(ALERT);
		PushResult result = _client.sendPush(payload);
		assertEquals(0, result.getErrorCode());
	}
	
    @Test
    public void sendSimpleNotification_android() {
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.alert("alert"))
                        .build())
                .build();
        PushResult result = _client.sendPush(payload);
        assertEquals(0, result.getErrorCode());
    }
    

	
	
}
