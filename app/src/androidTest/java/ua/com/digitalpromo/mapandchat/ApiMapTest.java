package ua.com.digitalpromo.mapandchat;

import android.content.Context;
import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import ua.com.digitalpromo.map.chat.activity.SplashActivity;

/**
 * Created by ales_san on 9/9/14.
 */
public class ApiMapTest extends ActivityUnitTestCase<SplashActivity> {


    private SplashActivity mSplashActivity;

    public ApiMapTest() {
        super(SplashActivity.class);
    }

    @Override
    public void setActivityContext(Context activityContext) {
        super.setActivityContext(activityContext);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // Starts the MainActivity of the target application
        Intent intent = new Intent(getInstrumentation().getTargetContext(), SplashActivity.class);
        startActivity(intent, null, null);

        // Getting a reference to the MainActivity of the target application
        mSplashActivity = (SplashActivity) getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @SmallTest
    public void testRegistration() throws Exception {
//        ApiMap.registration("Shcerbinin1a@gmail.com", "111", new ApiRequest.RequestListener() {
//            @Override
//            public void onStart() {
//
//                super.onStart();
//            }
//
//            @Override
//            public void onComplete(ApiModel response) {
//                super.onComplete(response);
//                Assert.assertTrue(false);
//            }
//
//            @Override
//            public void onError(ApiError error) {
//                super.onError(error);
//                Assert.assertTrue(false);
//            }
//
//            @Override
//            public void onFinish() {
//                super.onFinish();
//            }
//        });
    }
}
