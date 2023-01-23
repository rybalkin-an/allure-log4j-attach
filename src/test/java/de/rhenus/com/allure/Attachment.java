package de.rhenus.com.allure;

import org.junit.jupiter.api.AfterEach;

import java.io.IOException;

public interface Attachment {

    @AfterEach
    default void logAttachment() throws IOException {
        AllureLogHelper.attach();
    }
}
