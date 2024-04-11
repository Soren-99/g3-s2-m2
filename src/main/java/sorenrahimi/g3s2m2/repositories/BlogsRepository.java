package sorenrahimi.g3s2m2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sorenrahimi.g3s2m2.entities.Author;
import sorenrahimi.g3s2m2.entities.BlogPost;

import java.util.List;
import java.util.UUID;

@Repository
public interface BlogsRepository extends JpaRepository<BlogPost, Integer> {
    List<BlogPost> findByAuthor(Author author);
}
