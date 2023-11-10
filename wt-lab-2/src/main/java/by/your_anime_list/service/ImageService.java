package by.your_anime_list.service;

import by.your_anime_list.service.exception.ServiceException;
import jakarta.servlet.http.Part;

public interface ImageService {
    String uploadImage(Part part, String directoryName, String fileName) throws ServiceException;
}
