package com.space.sns.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlarmArgument {
    private Integer fromUserId;
    private Integer targetId;

}
