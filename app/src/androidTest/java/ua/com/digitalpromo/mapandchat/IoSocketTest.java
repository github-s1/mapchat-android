package ua.com.digitalpromo.mapandchat;

import android.util.Log;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.json.JSONException;
import org.json.JSONObject;

import ua.com.digitalpromo.map.chat.App;

/**
 * Created by ales_san on 9/9/14.
 */
public class IoSocketTest extends TestCase {
    private static final String LOG_TAG = App.LOG_TAG + "." +
            IoSocketTest.class.getSimpleName();
    private boolean error = false;

    public void testIoSocketConnection2() throws Exception {
        final Socket socket = IO.socket("http://188.40.107.79:3000");
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.d(LOG_TAG, "EVENT_CONNECT ");
                socket.emit("join", "79");
                error = true;
//                socket.disconnect();
            }

        }).on(Socket.EVENT_CONNECT_TIMEOUT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.d(LOG_TAG, "EVENT_CONNECT_TIMEOUT" + args.toString());
            }

        }).on(Socket.EVENT_MESSAGE, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.d(LOG_TAG, "EVENT_MESSAGE" + ((JSONObject) args[0]).toString());
            }

        }).on("hello", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                Log.d(LOG_TAG, "hello" + args.toString());
            }

        }).on("onJoin", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                Log.d(LOG_TAG, "on onJoin " + ((JSONObject) args[0]).toString());
            }

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                Log.d(LOG_TAG, "EVENT_DISCONNECT " + ((JSONObject) args[0]).toString());
            }

        }).on(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                error = false;
                Log.d(LOG_TAG, "EVENT_CONNECT_ERROR " + ((JSONObject) args[0]).toString());
            }

        }).on(Socket.EVENT_ERROR, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                error = false;
                try {
                    Log.d(LOG_TAG, "EVENT_ERROR " + ((JSONObject) args[0]).toString(3));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        });
        socket.connect();
        Log.d(LOG_TAG, "start_connect");

        for (int i = 0; i < 1000; i++) {
            Thread.sleep(100);
        }

        Assert.assertTrue(error);

    }
}
