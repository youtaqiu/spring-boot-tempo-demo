package me.youm.demo.tempo.api;

import me.youm.demo.tempo.model.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static me.youm.demo.tempo.api.UserClient.API_PREFIX;


/**
 * @author youta
 */
@FeignClient(
        value = API_PREFIX
)
public interface UserClient {

    String API_PREFIX = "user";
    String FIND_USER_INFO = API_PREFIX + "/userId";

    /**
     * 通过userId获取用户信息
     * @param userId 用户id
     * @return {@link UserInfo}
     */
    @GetMapping(FIND_USER_INFO)
    @ResponseBody
    UserInfo findByUserId(@RequestParam("userId") String userId);

}
