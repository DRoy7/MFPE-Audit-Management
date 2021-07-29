export const Microservices : {[key: string]: string} = {
    // give like this : 
    // "ms-name" : "http://localhost:[port-no.]/[context-root]"
    "auth"      : "http://localhost:8100/auth",
    "benchmark" : "http://localhost:8150/benchmark"
    //...populate
}