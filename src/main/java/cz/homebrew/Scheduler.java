package cz.homebrew;

import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;

@Singleton
public class Scheduler {

    @Scheduled(fixedDelay = "5s")
    public void scheduledTask() {
        System.out.println("Scheduled task executed.");
    }

}
