package com.andy.trace.agent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class HighPerformanceFileWriter {
    private static final int QUEUE_CAPACITY = 10000;
    private static final String FILE_PATH = "D:\\tmp\\trace-anywhere-tmp\\received_messages.txt";
    private static final BlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

    static {
        startFileWriterThread();
    }

    public static void main(String[] args) {
        //startFileWriterThread();
        //startMessageReceiverThread();
    }

    public static void writeAsync(String message){
        try {
            messageQueue.put(message);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void startFileWriterThread() {
        Thread fileWriterThread = new Thread(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                while (true) {
                    String message = messageQueue.take();
                    writer.write(message);
                    writer.newLine();
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        fileWriterThread.start();
    }

    private static void startMessageReceiverThread() {
        // Simulate message receiving
        Thread messageReceiverThread = new Thread(() -> {
            while (true) {
                String message = generateMessage();
                try {
                    messageQueue.put(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        messageReceiverThread.start();
    }

    private static String generateMessage() {
        // Replace this with actual message receiving logic
        return "Received message at " + System.currentTimeMillis();
    }
}
