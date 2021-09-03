package me.youm.demo.tempo.user.client;

import lombok.AllArgsConstructor;
import me.youm.demo.tempo.api.UserClient;
import me.youm.demo.tempo.model.UserInfo;
import me.youm.demo.tempo.user.domain.User;
import me.youm.demo.tempo.user.domain.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youta
 */
@RestController
@AllArgsConstructor
public class UserFeign implements UserClient {


    private final UserRepo userRepo;

    @Override
    @GetMapping(FIND_USER_INFO)
    @ResponseBody
    public UserInfo findByUserId(@RequestParam("userId") String userId) {
        User user = userRepo.findByUserId(userId)
                .orElse(userRepo.save(User.builder()
                        .userId(userId)
                        .email("youtaqiu@gmail.com")
                        .userName("youtaqiu")
                        .phone("13000000000")
                        .build()));
        var  userInfo = new UserInfo();
        BeanUtils.copyProperties(user,userInfo);
        return userInfo;
    }
}
