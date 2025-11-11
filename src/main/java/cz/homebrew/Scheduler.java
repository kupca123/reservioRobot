package cz.homebrew;

import cz.homebrew.service.RobotPerformer;
import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class Scheduler {
    private final RobotPerformer robotPerformer;

    @Scheduled(fixedDelay = "5m")
    public void scheduledTask() throws Exception {
        System.out.println("Executing scheduled task...");
//        String eventLink = robotPerformer.findEventLink("16.11.");
        robotPerformer.performBooking();
//        System.out.println("Found event link: " + eventLink);
        System.out.println("Scheduled task executed.");
    }

}
