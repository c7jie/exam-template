package cn.attachie.exam.exam.utils;

import cn.attachie.exam.exam.handler.AnswerHandleResult;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 工具类
 *
 * @author tangyi
 * @date 2019/12/8 22:42
 */
public class AnswerHandlerUtil {

    private static final String REGEX_COMMA = "^,*|,*$";

    public static AnswerHandleResult addAll(List<AnswerHandleResult> results) {
        AnswerHandleResult result = new AnswerHandleResult();
        int score = 0;
        int correctNum = 0;
        int inCorrectNum = 0;
        for (AnswerHandleResult tempResult : results) {
            if (tempResult != null) {
                score += tempResult.getScore();
                correctNum += tempResult.getCorrectNum();
                inCorrectNum += tempResult.getInCorrectNum();
            }
        }
        result.setScore(score);
        result.setCorrectNum(correctNum);
        result.setInCorrectNum(inCorrectNum);
        return result;
    }

    /**
     * 替换收尾的逗号
     *
     * @param str str
     * @return String
     */
    public static String replaceComma(String str) {
        if (StringUtils.isNotBlank(str)) {
            str = str.replaceAll(REGEX_COMMA, "");
        }
        return str;
    }
}
