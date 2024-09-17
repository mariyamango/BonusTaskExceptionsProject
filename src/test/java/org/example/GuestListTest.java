package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GuestListTest {

    private static final Path FILE_PATH = Path.of("guests.txt");
    private static final Path NOT_EXISTING_FILE_PATH = Path.of("nonexistent.txt");

    @BeforeEach
    public void setup() throws IOException {
        Files.deleteIfExists(FILE_PATH);
        Files.deleteIfExists(NOT_EXISTING_FILE_PATH);
    }

    @AfterEach
    public void cleanup() throws IOException {
        Files.deleteIfExists(FILE_PATH);
        Files.deleteIfExists(NOT_EXISTING_FILE_PATH);
    }

    @Test
    public void shouldBeEmptyInitially() throws IOException {
        GuestList guestList = new GuestList();
        guestList.setGuests(List.of());
        List<String> guests = guestList.getGuests();
        assertTrue(guests.isEmpty());
    }

    @Test
    public void shouldReadSameGuestsAsWrittenBefore() throws IOException {
        GuestList guestList = new GuestList();
        guestList.setGuests(List.of("Karl", "Ute"));
        List<String> guests = guestList.getGuests();
        assertEquals(List.of("Karl", "Ute"), guests);
    }

    @Test
    public void shouldWriteToFileSystem() throws IOException {
        GuestList guestList = new GuestList();
        guestList.setGuests(List.of("Theodor", "Anette"));
        Path pathToFile = Path.of("guests.txt");
        Files.write(pathToFile, guestList.getGuests());
        List<String> fileContents = Files.readAllLines(pathToFile);
        assertEquals(List.of("Theodor", "Anette"), fileContents);
    }

    @Test
    public void shouldReadFromFileSystem() throws IOException {
        Path filePath = Path.of("guests.txt");
        Files.write(filePath, List.of("Stephan", "Max"));
        GuestList guestList = new GuestList(filePath);
        List<String> guests = guestList.getGuests();
        assertEquals(List.of("Stephan", "Max"), guests);
    }

    @Test
    public void shouldThrowExceptionWhenFileDoesNotExist() throws IOException {
        Path filePath = Path.of("nonexistent.txt");
        assertThrows(IOException.class, () -> {
            GuestList guestList = new GuestList(filePath);
            guestList.getGuests();
        });
    }

    @Test
    public void shouldAddGuestToExistingFile() throws IOException {
        GuestList guestList = new GuestList();
        guestList.setGuests(List.of("Karl"));
        guestList.addGuest("Ute");
        Files.write(Path.of("guests.txt"), guestList.getGuests());
        List<String> guests = Files.readAllLines(Path.of("guests.txt"));
        assertEquals(List.of("Karl", "Ute"), guests);
    }
}