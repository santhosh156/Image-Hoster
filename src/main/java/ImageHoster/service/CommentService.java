package ImageHoster.service;

import ImageHoster.model.Comments;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    //The method calls the getCommentByImage() method in the Repository and passes the id of the image for which comments to be fetched
    public List<Comments> getCommentByImage(int imageId) {
        return commentRepository.getCommentByImage(imageId);
    }

    //The method calls the createComment() method in the Repository and passes the comment to be persisted in the database
    public Comments createComment(Comments comment) {
        return commentRepository.createComment(comment);
    }
}
