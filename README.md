# Spring Boot with Redis as Message Broker

Redis is an open source in-memory data structure store, used as a database, cache and message broker

It supports data structures such as strings, hashes, lists, sets, sorted sets, etc

For this example, we will create a simple spring boot project and add the spring boot starter data Redis and redis-client jedis dependencies


# POM.xml
    You need to add this Redis client Jedis dependency or else your app might result in an error and won’t start. 
    This is because this a version mismatch between spring boot starter packs and the Redis itself

# Jedis connection factory
    Spring Data Redis integrates with Lettuce and Jedis, two popular open-source Java libraries for Redis. 
    These two provide an improved connection property than that redis connection factory is officially supported

You don’t have to mention the host and port details here, reds automatically registers the app in it, 
if they are in the same host. but for production you need to configure them using properties. Also, spring boot provides you with auto configuration properties for your redis host and port details

# RedisTemplate
    Is the central class of the Redis module, due to its rich feature set. 
    The template offers a high-level abstraction for Redis interactions. 

# StringRedisTemplate
    You can also use StringRedisTemplate, StringRedisTemplate is a convenient one-stop solution for 
    intensive String operations

Implement the Message Listener and map the receiver class with the topic

TaskExecutor - for asynchronous method execution, with a fixed thread pool of 4.

Sender Class - auto wires the redis template and the channel topic. Uses the convertAndSend() to send the message to the topic

Receiver Class - Implements the Message Listener, and will receive the message from the topic in the Message Object

# Redis Use Cases
Use Redis,
1. If you want just send a message and forget about the system which is going to receive all the messages that you produce.
2. messages are delivered instantly to consumers. reds is very fast, as it is an in-memory data structure
3. If you  don’t care about data loss, because, if the server goes down, you would loose your data. but for this redis has a solution.  you can form a cluster, and you can use a redis sentinel to prevent data loss if you loose a node
4. If you don't want your system to hold the message that has been sent (this is a major difference between kafka and reds, kafka zookeeper has a copy of ur messages every after consumed by the consumer)
5. If the amount of data that is gonna be dealt is not huge.


