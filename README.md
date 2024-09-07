# spring-redisson-distributed-lock

first run the redis server using docker by the following command:

$ docker run --name my-redis -p 6379:6379 -d redis:latest

Then run the project and open multiple browser tabs and paste the

http://localhost:8080/test-lock

in the address bar.

You'll see each tab releases the lock after 5 seconcds and the next tab gets the lock.
