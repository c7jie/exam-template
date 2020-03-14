package cn.attachie.exam.common.core.vo;


import cn.attachie.exam.common.core.model.Log;
import cn.attachie.exam.common.core.persistence.BaseEntity;
import lombok.Data;

/**
 * logVo
 *
 * @author tangyi
 * @date 2019-01-05 17:07
 */
@Data
public class LogVo extends BaseEntity<LogVo> {

    private Log log;

    private String username;
}
