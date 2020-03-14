package cn.attachie.exam.exam.mapper;

import cn.attachie.exam.common.core.persistence.CrudMapper;
import cn.attachie.exam.exam.api.module.Knowledge;
import org.apache.ibatis.annotations.Mapper;

/**
 * 知识库Mapper
 *
 * @author tangyi
 * @date 2019/1/1 15:03
 */
@Mapper
public interface KnowledgeMapper extends CrudMapper<Knowledge> {
}
