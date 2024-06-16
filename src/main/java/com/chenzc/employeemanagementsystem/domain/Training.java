package com.chenzc.employeemanagementsystem.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Training {
    private Integer TrainingId;
    private Integer empId;
    private String trainingName;
    private Integer trainingDate;
    private String result;
}
