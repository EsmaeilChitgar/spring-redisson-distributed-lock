package com.example.distributed_lock;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private LockedResourceService lockedResourceService;

    @GetMapping("/test-lock")
    public String testLock() {
        lockedResourceService.accessCriticalSection();
        return "Check the console output2";
    }
}
