package cn.attachie.exam.user.service;

import cn.attachie.exam.common.core.model.Log;
import cn.attachie.exam.common.core.service.CrudService;
import cn.attachie.exam.user.mapper.LogMapper;
import org.springframework.stereotype.Service;

/**
 * 日志service
 *
 * @author tangyi
 * @date 2018/10/31 20:43
 */
@Service
public class LogService extends CrudService<LogMapper, Log> {
}
