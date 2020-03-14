package cn.attachie.exam.exam.mapper;

import cn.attachie.exam.common.core.persistence.CrudMapper;
import cn.attachie.exam.exam.api.module.SubjectCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目分类Mapper
 *
 * @author tangyi
 * @date 2018/12/4 21:48
 */
@Mapper
public interface SubjectCategoryMapper extends CrudMapper<SubjectCategory> {
}
