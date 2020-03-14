package cn.attachie.exam.user.excel.listener;

import cn.attachie.exam.common.core.utils.excel.AbstractExcelImportListener;
import cn.attachie.exam.user.api.dto.UserInfoDto;
import cn.attachie.exam.user.excel.model.UserExcelModel;
import cn.attachie.exam.user.service.UserService;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理导入用户数据
 *
 * @author tangyi
 * @date 2019/12/10 16:34
 */
public class UserImportListener extends AbstractExcelImportListener<UserExcelModel> {

    private UserService userService;

    public UserImportListener(UserService userService) {
        this.userService = userService;
    }

    /**
     * 存储到数据库
     */
    @Override
    public void saveData(List<UserExcelModel> userExcelModels) {
        logger.info("SaveData size: {}", userExcelModels.size());
        List<UserInfoDto> userInfoDtoList = new ArrayList<>(userExcelModels.size());
        userExcelModels.forEach(data -> {
            UserInfoDto userInfoDto = new UserInfoDto();
            BeanUtils.copyProperties(data, userInfoDto);
            userInfoDtoList.add(userInfoDto);
        });
        userService.importUsers(userInfoDtoList);
    }
}
