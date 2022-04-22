package com.kodilla.exception.io;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileReaderTestSuite {

    @Test
    void testReadFile() {

    FileReader fileReader = new FileReader();

    assertDoesNotThrow( () -> fileReader.readFile());
    }

    @Test
    void whenFileDosentExistsReadFileShouldThrowException(){
        FileReader fileReader = new FileReader();
        String fileName = "bs.txt";
        // when & then
        assertThrows(FileReaderException.class, () -> fileReader.readFile(fileName));
    }

    @Test
    public void testReadFileWithName() {
        // given
        FileReader fileReader = new FileReader();
        // when & then
        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile("nie_ma_takiego_pliku.txt")),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile(null)),
                () -> assertDoesNotThrow(() -> fileReader.readFile("names.txt"))
        );
    }


}
