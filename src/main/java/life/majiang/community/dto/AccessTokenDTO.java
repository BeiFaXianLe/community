package life.majiang.community.dto;

import lombok.Data;

/**
 * @anthor zxy
 * @date 2019/8/15 15:37
 **/
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
