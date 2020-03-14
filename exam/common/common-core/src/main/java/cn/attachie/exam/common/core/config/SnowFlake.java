package cn.attachie.exam.common.core.config;


import cn.attachie.exam.common.core.properties.SnowflakeProperties;
import cn.attachie.exam.common.core.utils.SnowflakeIdWorker;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ID生成配置
 *
 * @author tangyi
 * @date 2019/4/26 11:17
 */
@Configuration
@AllArgsConstructor
public class SnowFlake {

    private final SnowflakeProperties snowflakeProperties;

    @Bean
    public SnowflakeIdWorker initTokenWorker() {
        return new SnowflakeIdWorker(Integer.parseInt(snowflakeProperties.getWorkId()),
                Integer.parseInt(snowflakeProperties.getDataCenterId()));
    }
}
