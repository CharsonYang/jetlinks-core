package org.jetlinks.core.message.property;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import org.jetlinks.core.message.CommonDeviceMessageReply;
import org.jetlinks.core.message.MessageType;

import java.util.Map;

/**
 * @author zhouhao
 * @since 1.0.0
 */
@Getter
@Setter
public class WritePropertyMessageReply extends CommonDeviceMessageReply<WritePropertyMessageReply> {

    private Map<String, Object> properties;

    public static WritePropertyMessageReply create() {
        WritePropertyMessageReply reply = new WritePropertyMessageReply();

        reply.setTimestamp(System.currentTimeMillis());

        return reply;
    }

    @Override
    public void fromJson(JSONObject jsonObject) {
        super.fromJson(jsonObject);
        this.properties = jsonObject.getJSONObject("properties");
    }

    public MessageType getMessageType() {
        return MessageType.WRITE_PROPERTY_REPLY;
    }

}
