package cn.geobeans.server.graphql.user;

import cn.geobeans.server.graphql.post.Post;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    private String username;
    private String name;
    private String password;
    private String phone;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Post> posts;
}
