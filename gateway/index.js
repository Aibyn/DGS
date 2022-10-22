const { ApolloGateway } = require("@apollo/gateway")
const { ApolloServer} = require("apollo-server")

const gateway = new ApolloGateway( {
    serviceList: [
        { name: 'product', url: 'http://localhost:8080/graphql' },
        { name: 'inventory', url: 'http://localhost:8081/graphql' },
    ]
})
const server = new ApolloServer({gateway: gateway, subscription: false})

server.listen(4000).then((url) => {
    console.log('Gateway running on at' + url)
})