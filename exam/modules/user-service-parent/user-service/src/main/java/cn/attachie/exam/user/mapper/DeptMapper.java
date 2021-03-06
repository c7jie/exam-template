package cn.attachie.exam.user.mapper;

import cn.attachie.exam.common.core.persistence.CrudMapper;
import cn.attachie.exam.user.api.module.Dept;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜单mapper
 *
 * @author tangyi
 * @date 2018/8/26 22:34
 */
@Mapper
public interface DeptMapper extends CrudMapper<Dept> {
}
