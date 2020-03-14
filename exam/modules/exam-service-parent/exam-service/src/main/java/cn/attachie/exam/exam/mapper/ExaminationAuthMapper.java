package cn.attachie.exam.exam.mapper;

import cn.attachie.exam.common.core.persistence.CrudMapper;
import cn.attachie.exam.exam.api.module.ExaminationAuth;
import org.apache.ibatis.annotations.Mapper;

/**
 * 考试权限Mapper
 *
 * @author tangyi
 * @date 2019-07-16 14:03
 */
@Mapper
public interface ExaminationAuthMapper extends CrudMapper<ExaminationAuth> {
}
