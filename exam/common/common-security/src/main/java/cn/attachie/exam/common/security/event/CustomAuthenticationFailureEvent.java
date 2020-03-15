package cn.attachie.exam.common.security.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 登录失败事件
 *
 * @author tangyi
 * @date 2019-11-11 23:46
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomAuthenticationFailureEvent extends ApplicationEvent {

    private UserDetails userDetails;

    public CustomAuthenticationFailureEvent(Authentication authentication, UserDetails userDetails) {
        super(authentication);
        this.userDetails = userDetails;
    }

}
