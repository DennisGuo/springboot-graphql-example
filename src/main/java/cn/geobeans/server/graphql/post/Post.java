package cn.geobeans.server.graphql.post;

import cn.geobeans.server.graphql.common.EntityUuid;
import cn.geobeans.server.graphql.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Post extends EntityUuid {

    private String title;
    private String category;
    @Column(columnDefinition = "text")
    private String content;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User author;
}
