package life.majiang.community.dto;

import lombok.Data;

@Data
public class NotificationDTO {
    private long id;
    private long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private String typeName;
    private String type;
}
