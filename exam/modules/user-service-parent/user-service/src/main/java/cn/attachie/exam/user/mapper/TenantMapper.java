package cn.attachie.exam.user.mapper;

import cn.attachie.exam.common.core.persistence.CrudMapper;
import cn.attachie.exam.user.api.module.Tenant;
import org.apache.ibatis.annotations.Mapper;

/**
 * 租户Mapper
 *
 * @author tangyi
 * @date 2019/5/22 22:50
 */
@Mapper
public interface TenantMapper extends CrudMapper<Tenant> {

    /**
     * 根据租户标识获取
     *
     * @param tenantCode tenantCode
     * @return Tenant
     * @author tangyi
     * @date 2019/05/26 10:29
     */
    Tenant getByTenantCode(String tenantCode);

    /**
     * 查询租户数量
     *
     * @return Integer
     */
    Integer tenantCount();
}
