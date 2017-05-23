package ua.com.digitalpromo.map.chat.global;

/**
 * Created by ales_san on 9/30/14.
 */
public class ChatObject {

    private static ChatObject chatObject;

    public static ChatObject getInitialization() {
        if (chatObject == null) chatObject = new ChatObject();
        return chatObject;
    }


}
