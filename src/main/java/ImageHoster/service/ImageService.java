package ImageHoster.service;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import ImageHoster.repository.ImageRepository;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CommentRepository commentRepository;

    //Call the getAllImages() method in the Repository and obtain a List of all the images in the database
    public List<Image> getAllImages() {
        return imageRepository.getAllImages();
    }


    //The method calls the createImage() method in the Repository and passes the image to be persisted in the database
    public void uploadImage(Image image) {
        imageRepository.uploadImage(image);
    }


    //The method calls the getImageByTitle() method in the Repository and passes the title of the image to be fetched
    public Image getImageByTitle(String title) {
        return imageRepository.getImageByTitle(title);
    }

    //The method calls the getImageByIdTitle() method in the Repository and passes the imageId and title of the image to be fetched
    public Image getImageByIdTitle(int imageId, String title) {
        return imageRepository.getImageByIdTitle(imageId, title);
    }

    //The method calls the getImage() method in the Repository and passes the id of the image to be fetched
    public Image getImage(Integer imageId) {
        return imageRepository.getImage(imageId);
    }

    //The method calls the updateImage() method in the Repository and passes the Image to be updated in the database
    public void updateImage(Image updatedImage) {
        imageRepository.updateImage(updatedImage);
    }

    //The method calls the deleteImage() method in the Repository and passes the Image id of the image to be deleted in the database
    public void deleteImage(Integer imageId) {
        imageRepository.deleteImage(imageId);
    }

    //The method calls the getCommentByImage method in the Repository and passes the id of the image for which comments to be fetched
    public List<Comments> getComments(Integer imageId) {
        return commentRepository.getCommentByImage(imageId);
    }

}
