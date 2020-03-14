package cn.attachie.exam.user.excel.listener;

import cn.attachie.exam.common.core.utils.excel.AbstractExcelImportListener;
import cn.attachie.exam.user.api.module.Menu;
import cn.attachie.exam.user.excel.model.MenuExcelModel;
import cn.attachie.exam.user.service.MenuService;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单导入
 *
 * @author tangyi
 * @date 2019/12/10 17:22
 */
public class MenuImportListener extends AbstractExcelImportListener<MenuExcelModel> {

    private MenuService menuService;

    public MenuImportListener(MenuService menuService) {
        this.menuService = menuService;
    }

    @Override
    public void saveData(List<MenuExcelModel> menuExcelModels) {
        logger.info("SaveData size: {}", menuExcelModels.size());
        List<Menu> menuList = new ArrayList<>(menuExcelModels.size());
        menuExcelModels.forEach(data -> {
            Menu menu = new Menu();
            BeanUtils.copyProperties(data, menu);
            menuList.add(menu);
        });
        menuList.forEach(menu -> {
            if (menuService.update(menu) < 1)
                menuService.insert(menu);
        });
    }
}
