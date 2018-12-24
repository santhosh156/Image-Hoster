package ImageHoster.repository;

import ImageHoster.model.Comments;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentRepository {
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    //The method receives the comment object to be persisted in the database
    //Creates an instance of EntityManager
    //Starts a transaction
    //The transaction is committed if it is successful
    //The transaction is rolled back in case of unsuccessful transaction
    public Comments createComment(Comments comment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return comment;
    }

    //The method creates an instance of EntityManager
    //Executes JPQL query to fetch the comment from the database for the corresponding image id
    //Returns the image in case the image is found in the database
    //Returns null if no comment is found in the database
    public List<Comments> getCommentByImage(int imageId) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Comments> query = em.createQuery("SELECT c from Comments c", Comments.class);
            List<Comments> resultList = query.getResultList();

            List<Comments> tempList = new ArrayList<Comments>();
            for(Comments comment : resultList){
                if(comment.getImage().getId() == imageId){
                    tempList.add(comment);
                }
            }
            return tempList;
        } catch(NoResultException e) {
            return null;
        }

    }
}
