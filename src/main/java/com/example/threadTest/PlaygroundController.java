package com.example.threadTest;
 
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
 
@RestController
@AllArgsConstructor
@RequestMapping("/PlaygroundController")
public class PlaygroundController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
 
    private void doSomeThing() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("done doing");
    }
 
    @PostMapping("/customer-list")
    public ResponseEntity getCustomerList(@RequestBody RequestModelApi requestModel) throws InterruptedException {
        Thread.sleep(10000);
        return new ResponseEntity<>(HttpStatus.OK);
    }
 
    @GetMapping("/do-completeable-future")
    public void doCompleteAbleFuture() {
        CompletableFuture.runAsync(() -> {
            try {
                logger.info("start CompletableFuture doing");
                doSomeThing();
            } catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
            }
        });
    }
}