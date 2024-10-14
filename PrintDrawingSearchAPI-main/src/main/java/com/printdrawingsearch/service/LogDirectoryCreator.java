package com.printdrawingsearch.service;

import java.io.File;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LogDirectoryCreator implements ApplicationListener<ApplicationReadyEvent> {

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		createLogDirectory();
	}

	private void createLogDirectory() {
		File logDir = new File("./logs");
		if (!logDir.exists()) {
			boolean created = logDir.mkdirs();
			if (created) {
				System.out.println("Log directory created at ./logs");
			} else {
				System.err.println("Failed to create log directory at ./logs");
			}
		}
	}
}
