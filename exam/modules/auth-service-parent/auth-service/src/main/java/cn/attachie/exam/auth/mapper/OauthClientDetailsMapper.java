package cn.attachie.exam.auth.mapper;

import cn.attachie.exam.auth.api.module.OauthClientDetails;
import cn.attachie.exam.common.core.persistence.CrudMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Oauth2客户端mapper
 *
 * @author tangyi
 * @date 2019/3/30 16:39
 */
@Mapper
public interface OauthClientDetailsMapper extends CrudMapper<OauthClientDetails> {
}
