package cn.geobeans.server.graphql.graphql;

import cn.geobeans.server.graphql.user.User;
import cn.geobeans.server.graphql.user.UserService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private final UserService userService;

    @Autowired
    public Query(UserService userService) {
        this.userService = userService;
    }

    public List<User> getUsers(Integer page,Integer size){
        page = page == null || page <0 ? 0 : page;
        size = size == null || size <0 ? 5 : size;
        PageRequest pageRequest = PageRequest.of(page,size);
        return userService.page(pageRequest);
    }
}
