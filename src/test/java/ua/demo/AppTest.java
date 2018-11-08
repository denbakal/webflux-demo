package ua.demo;

import org.junit.Test;

import java.util.List;

public class AppTest {
    @Test
    public void doTest() {
        List<String> args = List.of("id=123&");

        String attachmentId = args.stream()
                .filter(s -> s.startsWith("id"))
                .findFirst().map(id -> id.replaceFirst(".*[=]", ""))
                .orElse(null);
        System.out.println("attachmentId = " + attachmentId);
    }
}
