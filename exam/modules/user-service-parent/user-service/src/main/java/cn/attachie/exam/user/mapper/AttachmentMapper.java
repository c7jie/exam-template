package cn.attachie.exam.user.mapper;

import cn.attachie.exam.common.core.persistence.CrudMapper;
import cn.attachie.exam.user.api.module.Attachment;
import org.apache.ibatis.annotations.Mapper;

/**
 * 附件mapper
 *
 * @author tangyi
 * @date 2018/10/30 20:55
 */
@Mapper
public interface AttachmentMapper extends CrudMapper<Attachment> {
}
