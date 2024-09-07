package com.example.distributed_lock;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LockedResourceService {

    @Autowired
    private RedissonClient redissonClient;

    public void accessCriticalSection() {
        var lock = redissonClient.getLock("myLock");
        try {
            // Acquire the lock
            boolean isLocked = lock.tryLock();

            if (isLocked) {
                try {
                    // Critical section code goes here
                    System.out.println("Accessing the critical section");
                    // Simulate some work
                    Thread.sleep(5000);
                } finally {
                    // Ensure the lock is released even if an exception occurs
                    lock.unlock();
                }
            } else {
                System.out.println("Could not acquire the lock");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
