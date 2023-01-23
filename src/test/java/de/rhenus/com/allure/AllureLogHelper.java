package de.rhenus.com.allure;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class AllureLogHelper {
    private static String pathToLogFile = "logs/testbed-app.log";

    private static File getLogFile() throws MalformedURLException {
        URL logUrl = Paths.get("target", pathToLogFile).toUri().toURL();
        return new File(logUrl.getPath());
    }

    static void attach() throws IOException {
        ByteArrayInputStream fileAsByteArrayIS = new ByteArrayInputStream(FileUtils.readFileToByteArray(getLogFile()));
        Allure.addAttachment("log4j log file", fileAsByteArrayIS);

        AllureLogHelper.clearLogFile();
    }

    private static void clearLogFile() throws FileNotFoundException, MalformedURLException {
        PrintWriter printWriter = new PrintWriter(getLogFile());
        printWriter.print("");
        printWriter.close();
    }
}
