package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GuestList {
    private Path pathToFile;

    public GuestList(Path pathToFile) {
        this.pathToFile = pathToFile;
    }

    public GuestList() {
        this.pathToFile = Path.of("guests.txt");
    }

    public void setGuests(List<String> guests) throws IOException {
        Files.write(pathToFile, guests);
    }

    public void addGuest(String guest) throws IOException {
        List<String> currentGuests = Files.readAllLines(pathToFile);
        currentGuests.add(guest);
        Files.write(pathToFile, currentGuests);
    }

    public List<String> getGuests() throws IOException {
        if (Files.exists(pathToFile)) {
            return Files.readAllLines(pathToFile);
        } else {
            throw new IOException("File not found");
        }
    }
}
