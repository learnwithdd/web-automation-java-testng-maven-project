package com.lwdd.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String filePath = "screenshots/" + screenshotName + "_" + timestamp + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(filePath);

        try {
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dest.getAbsolutePath();
    }
}