package com.spe.ClassroomManagementSystem.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spe.ClassroomManagementSystem.Repository.InternshipRepository;

@Component
public class DataClearScheduler {

	
	private final InternshipRepository repository;

    public DataClearScheduler(InternshipRepository repository) {
        this.repository = repository;
    }

//    @Scheduled(cron = "0 */2 * * * *") // Runs every 2 minutes
//    @Scheduled(cron = "0 */5 * * * *") // Runs every 5 minutes
//    @Scheduled(cron = "0 0 0 * * *") // Runs every day at midnight
//    @Scheduled(cron = "0 0 0 */2 * *") // Runs every 2 days at midnight
 //   @Scheduled(cron = "0 0 0 * * SUN") // Runs at midnight on Sunday
//    @Scheduled(cron = "0 0 0 1 * *")   // Runs monthly


    @Scheduled(cron = "0 */10 * * * *") // Runs every 5 minutes
    public void clearData() {
        repository.deleteAll();
    }
	
}
