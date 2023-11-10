package by.your_anime_list.service.impl;

import by.your_anime_list.service.ImageService;
import by.your_anime_list.service.exception.ServiceException;
import com.google.common.io.Files;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageServiceImpl implements ImageService {
    private static final int N_READ_BYTES = 1024;

    private String getUploadFileName(Part part) {
        String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    @Override
    public String uploadImage(Part part, String directoryName, String fileName) throws ServiceException {
        String uploadFileName = getUploadFileName(part);
        if (uploadFileName == null) {
            throw new ServiceException("Error in getting upload file name!");
        }
        String fileExtension = Files.getFileExtension(uploadFileName);
        String fileNameWithExtension = (fileName + "." + fileExtension).toLowerCase();
        Path filePath = Paths.get(directoryName, fileNameWithExtension);
        try ( OutputStream out = new FileOutputStream(filePath.toFile());
             InputStream fileContent = part.getInputStream() ) {
            byte[] bytes = new byte[N_READ_BYTES];
            int read = fileContent.read(bytes);
            while (read != -1) {
                out.write(bytes, 0, read);
                read = fileContent.read(bytes);
            }
        } catch (IOException e) {
            System.out.println("Exception in file uploading");
            throw new ServiceException(e.getMessage());
        }

        return fileNameWithExtension;
    }
}
