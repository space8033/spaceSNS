package com.space.sns.model.event;

import com.space.sns.model.AlarmArgument;
import com.space.sns.model.AlarmType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlarmEvent {
    private Integer receiverUserId;
    private AlarmType type;
    private AlarmArgument args;
}
