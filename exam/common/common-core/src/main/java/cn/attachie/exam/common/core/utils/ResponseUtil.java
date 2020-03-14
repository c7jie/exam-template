package cn.attachie.exam.common.core.utils;


import cn.attachie.exam.common.core.constant.ApiMsg;
import cn.attachie.exam.common.core.model.ResponseBean;

/**
 * @author tangyi
 * @date 2019-10-08 12:03
 */
public class ResponseUtil {

    private ResponseUtil() {
    }

    /**
     * 是否成功
     *
     * @param responseBean responseBean
     * @return boolean
     */
    public static boolean isSuccess(ResponseBean<?> responseBean) {
        return responseBean != null && responseBean.getCode() == ApiMsg.KEY_SUCCESS;
    }
}
