package cn.attachie.exam.common.core.utils.excel.converter;

import cn.attachie.exam.common.core.enums.GenderEnum;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;


/**
 * 性别转换
 *
 * @author tangyi
 * @date 2019/12/10 14:16
 */
public class GenderConverter implements Converter<Integer> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Integer convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
                                     GlobalConfiguration globalConfiguration) throws Exception {
        return GenderEnum.matchByName(cellData.getStringValue()).getValue();
    }

    @Override
    public CellData<String> convertToExcelData(Integer value, ExcelContentProperty contentProperty,
                                               GlobalConfiguration globalConfiguration) throws Exception {
        return new CellData<>(GenderEnum.matchByValue(value).getName());
    }
}
