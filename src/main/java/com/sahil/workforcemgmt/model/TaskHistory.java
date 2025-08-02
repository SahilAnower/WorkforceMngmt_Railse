package com.sahil.workforcemgmt.model;

import com.sahil.workforcemgmt.model.enums.Action;
import com.sahil.workforcemgmt.model.enums.Fields;
import lombok.Data;

@Data
public class TaskHistory {
    private Long id;
    private Long taskId;
    private Action action;
    private Fields changedField;
    private String oldValue;
    private String newValue;
    private Long timestamp;
}
