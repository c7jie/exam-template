package cn.attachie.exam.user.mapper;

import cn.attachie.exam.common.core.persistence.CrudMapper;
import cn.attachie.exam.common.core.vo.UserVo;
import cn.attachie.exam.user.api.module.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户mapper接口
 *
 * @author tangyi
 * @date 2018-08-25 15:27
 */
@Mapper
public interface UserMapper extends CrudMapper<User> {

    /**
     * 查询用户数量
     *
     * @param userVo userVo
     * @return Integer
     */
    Integer userCount(UserVo userVo);
}
