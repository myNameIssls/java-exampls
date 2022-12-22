package cn.tyrone.apache.commons.lang3.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Role {

    private Long id;

    private String name;

}
