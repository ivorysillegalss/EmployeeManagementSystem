package com.chenzc.employeemanagementsystem.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Training {
    @TableId
    private Integer TrainingId;
    private Integer empId;
    private String trainingName;
    private Integer trainingDate;
    private String result;
}
