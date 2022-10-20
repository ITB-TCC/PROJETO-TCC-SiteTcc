package com.itb.tcc.amazbook.amazbook.modules.file.controller;

import com.itb.tcc.amazbook.amazbook.modules.file.model.FilesBook;
import com.itb.tcc.amazbook.amazbook.modules.file.repository.FileRepository;
import com.itb.tcc.amazbook.amazbook.modules.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {


    private final FileService fileService;

    private final FileRepository fileRepository;


    @PostMapping("/upload")

    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("image byte" + file.getBytes().length);

        FilesBook filesBook = new FilesBook(file.getOriginalFilename(), file.getContentType(), compressBytes(file.getBytes()));


        fileRepository.save(filesBook);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");

    }

    @GetMapping("/get/{image}")
    public FilesBook getImage(@PathVariable("image") String image) {

        final Optional<FilesBook> filesBook = fileRepository.findByName(image);
        FilesBook img = new FilesBook(filesBook.get().getName(), filesBook.get().getType(), decompressBytes(filesBook.get().getPicByte()));

        return img;

    }


    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();
    }

    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }


}
