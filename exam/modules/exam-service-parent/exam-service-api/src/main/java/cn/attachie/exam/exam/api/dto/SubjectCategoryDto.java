package cn.attachie.exam.exam.api.dto;

import cn.attachie.exam.common.core.persistence.TreeEntity;
import cn.attachie.exam.exam.api.module.SubjectCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author tangyi
 * @date 2018/12/4 22:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SubjectCategoryDto extends TreeEntity<SubjectCategoryDto> {

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类描述
     */
    private String categoryDesc;

    /**
     * 父分类id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    public SubjectCategoryDto(SubjectCategory subjectCategory) {
        this.id = subjectCategory.getId();
        this.categoryName = subjectCategory.getCategoryName();
        this.categoryDesc = subjectCategory.getCategoryDesc();
        this.parentId = subjectCategory.getParentId();
        this.sort = subjectCategory.getSort();
    }

    @Override
    public Long getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
