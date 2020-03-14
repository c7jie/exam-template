package cn.attachie.exam.auth.service;

import cn.attachie.exam.auth.api.module.OauthClientDetails;
import cn.attachie.exam.auth.mapper.OauthClientDetailsMapper;
import cn.attachie.exam.common.core.service.CrudService;
import org.springframework.stereotype.Service;

/**
 * Oauth2客户端Service
 *
 * @author tangyi
 * @date 2019/3/30 16:48
 */
@Service
public class OauthClientDetailsService extends CrudService<OauthClientDetailsMapper, OauthClientDetails> {
}
