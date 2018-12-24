package ImageHoster.service;

import ImageHoster.model.Tag;
import ImageHoster.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    //The method calls the getTagByName() method in the Repository and passes the id of the image for which comments to be fetched
    public Tag getTagByName(String title) {
        return tagRepository.findTag(title);
    }

    //The method calls the createTag() method in the Repository and passes the tag to be persisted in the database
    public Tag createTag(Tag tag) {
        return tagRepository.createTag(tag);
    }
}
