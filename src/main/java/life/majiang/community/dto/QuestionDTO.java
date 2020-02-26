package life.majiang.community.dto;

import life.majiang.community.model.User;
import lombok.Data;
@Data
public class QuestionDTO {

    private long id;
    private String title;
    private String description;
    private String tag;
    private long gmtCreate;
    private long gmtModified;
    private long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}


