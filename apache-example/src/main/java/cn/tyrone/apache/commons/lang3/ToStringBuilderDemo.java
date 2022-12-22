package cn.tyrone.apache.commons.lang3;

import cn.tyrone.apache.commons.lang3.entity.Role;
import cn.tyrone.apache.commons.lang3.entity.User;

import java.util.Arrays;
import java.util.List;

public class ToStringBuilderDemo {

    public static void main(String[] args) {

        Role role = Role.builder()
                .id(1L)
                .name("管理员")
                .build();
        Role role1 = Role.builder()
                .id(1L)
                .name("行政")
                .build();
        List<Role> roleList = Arrays.asList(role, role1);
        User user = User.builder()
                .id(123456L)
                .age(30)
                .name("Jack Ma")
                .roleList(roleList)
                .build();
        String userString = user.toString();
        System.out.println(userString);

    }

}
