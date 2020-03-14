package cn.attachie.exam.user.mapper;

import cn.attachie.exam.common.core.model.Log;
import cn.attachie.exam.common.core.persistence.CrudMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 日志
 *
 * @author tangyi
 * @date 2018/10/31 20:38
 */
@Mapper
public interface LogMapper extends CrudMapper<Log> {
}
