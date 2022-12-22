package cn.tyrone.apache.commons.lang3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String name;

    private int age;

    private List<Role> roleList;

    @Override
    public String toString() {

        // 自定义属性输出
        // return new ToStringBuilder(this).append(name).toString();

        // 默认格式输出
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
