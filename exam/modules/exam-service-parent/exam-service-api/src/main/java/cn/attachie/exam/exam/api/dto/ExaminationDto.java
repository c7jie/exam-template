package cn.attachie.exam.exam.api.dto;

import cn.attachie.exam.exam.api.module.Course;
import cn.attachie.exam.exam.api.module.Examination;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author tangyi
 * @date 2018/11/20 22:02
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ExaminationDto extends Examination {

    private Course course;

}
