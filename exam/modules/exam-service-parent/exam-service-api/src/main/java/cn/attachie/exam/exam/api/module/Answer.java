package cn.attachie.exam.exam.api.module;

import cn.attachie.exam.common.core.persistence.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 答题
 *
 * @author tangyi
 * @date 2018/11/8 20:59
 */
@Data
public class Answer extends BaseEntity<Answer> {

    /**
     * 考试记录id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long examRecordId;

    /**
     * 题目ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subjectId;

    /**
     * 题目类型
     */
    private Integer type;

    /**
     * 答案
     */
    private String answer;

    /**
     * 答题类型，0：正确，1：错误
     */
    private Integer answerType;

    /**
     * 得分
     */
    private Double score;

    /**
     * 批改状态
     */
    private Integer markStatus;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;
}
