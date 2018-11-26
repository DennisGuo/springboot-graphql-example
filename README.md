# springboot-graphql-example
A demo project using springboot with graphql.

## how to run 

```bash
build -x test
java -jar build/libs/graphql-api.jar
```
Then open the browser and visit `http://localhost:7070/graphiql` .

## schema

The schema file is defined in /src/main/resources/graphql/schema.graphqls

```graphqls
type Post {
    id: ID!
    title: String!
    content: String!
    category: String
    author: User!
}
type User {
    username: ID!
    password: String!
    name: String!
    phone: String!
    posts: [Post]!
}
# The Root Query for the application
type Query {
    getUsers(page: Int, size: Int): [User]!
}

# The Root Mutation for the application
type Mutation {
    createUser(username: String!, password: String!, phone: String, name: String) : User!
}
```


