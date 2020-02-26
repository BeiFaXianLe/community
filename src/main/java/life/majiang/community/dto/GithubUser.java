package life.majiang.community.dto;

import lombok.Data;

/**
 * @anthor zxy
 * @date 2019/8/15 17:24
 **/
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
