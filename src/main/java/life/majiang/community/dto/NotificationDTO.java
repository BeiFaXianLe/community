package life.majiang.community.dto;

import life.majiang.community.model.User;
import lombok.Data;

import javax.security.auth.message.callback.PrivateKeyCallback;

@Data
public class NotificationDTO {
    private long id;
    private long gmtCreate;
    private Integer status;
    private User notifier;
    private String outerTile;
    private String type;
}
