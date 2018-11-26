package cn.geobeans.server.graphql.graphql;

import cn.geobeans.server.graphql.user.User;
import cn.geobeans.server.graphql.user.UserService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final UserService userService;

    @Autowired
    public Mutation(UserService userService) {
        this.userService = userService;
    }


    public User createUser(String username,String password,String phone,String name){
        return userService.save(username,password,phone,name);
    }
}
