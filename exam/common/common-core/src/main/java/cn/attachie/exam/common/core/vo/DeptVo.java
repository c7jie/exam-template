package cn.attachie.exam.common.core.vo;


import cn.attachie.exam.common.core.persistence.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门vo
 *
 * @author tangyi
 * @date 2018/12/31 22:02
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DeptVo extends BaseEntity<DeptVo> {

    private String deptName;
}
