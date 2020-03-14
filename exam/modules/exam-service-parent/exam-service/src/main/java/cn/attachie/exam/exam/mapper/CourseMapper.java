package cn.attachie.exam.exam.mapper;

import cn.attachie.exam.common.core.persistence.CrudMapper;
import cn.attachie.exam.exam.api.module.Course;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程Mapper
 *
 * @author tangyi
 * @date 2018/11/8 21:10
 */
@Mapper
public interface CourseMapper extends CrudMapper<Course> {
}
