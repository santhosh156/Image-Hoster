package ImageHoster.controller;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.ImageService;
import ImageHoster.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@Controller
public class CommentsController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    //This controller method is called when the request pattern is of type 'images/{imageId}/{imageTitle}' and also the incoming request is of POST type
    //The method receives all the details of the comment to be stored in the database, and now the comment will be sent to the business logic to be persisted in the database
    //After you get the comment, set the user of the comment by getting the logged in user from the Http Session
    //Set the date on which the comment is posted
    //After storing the comment, this method directs to the logged in user homepage displaying the image with the comment

    @RequestMapping(value = "/images/{imageId}/{imageTitle}", method = RequestMethod.POST)
    public String addImageComment(@RequestParam("comment") String comment, @PathVariable("imageId") Integer imageId, @PathVariable("imageTitle") String imageTitle, HttpSession session) throws IOException
    {
        try {
            Comments newComment = new Comments();
            Image image = imageService.getImageByIdTitle(imageId, imageTitle);

            User user = (User) session.getAttribute("loggeduser");
            newComment.setUser(user);
            newComment.setImage(image);
            newComment.setText(comment);
            newComment.setDate(LocalDate.now());
            newComment.setImage(image);
            commentService.createComment(newComment);

            System.out.println(newComment);

            return "redirect:/images/"+imageId+'/'+imageTitle;
        } catch(Exception e) {
            return null;
        }

    }
}
