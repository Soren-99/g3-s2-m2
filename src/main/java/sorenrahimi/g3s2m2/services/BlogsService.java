package sorenrahimi.g3s2m2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sorenrahimi.g3s2m2.entities.Author;
import sorenrahimi.g3s2m2.entities.BlogPost;
import sorenrahimi.g3s2m2.exceptions.NotFoundException;
import sorenrahimi.g3s2m2.payloads.NewBlogPostPayload;
import sorenrahimi.g3s2m2.repositories.AuthorsRepository;
import sorenrahimi.g3s2m2.repositories.BlogsRepository;


import java.util.*;

@Service
public class BlogsService {
    @Autowired
    private BlogsRepository blogsRepository;
    @Autowired
    private AuthorsService authorsService;


    public BlogPost save(NewBlogPostPayload body) {
        Author author = authorsService.findById(body.getAuthorId());
        BlogPost newBlogPost = new BlogPost();
        newBlogPost.setReadingTime(body.getReadingTime());
        newBlogPost.setContent(body.getContent());
        newBlogPost.setTitle(body.getTitle());
        newBlogPost.setAuthor(author);
        newBlogPost.setCategory(body.getCategory());
        newBlogPost.setCover("http://picsum.photos/200/300");
        return blogsRepository.save(newBlogPost);
    }


    public List<BlogPost> getBlogs() {
        return blogsRepository.findAll();
    }

    public BlogPost findById(int id) {
        return blogsRepository.findById(id).orElseThrow(()-> new
                NotFoundException(id));
    }

    public void findByIdAndDelete(int id){
        BlogPost found = this.findById(id);
        blogsRepository.delete(found);
    }

    public BlogPost findByIdAndUpdate(int id, NewBlogPostPayload body){
        BlogPost found = this.findById(id);

        found.setReadingTime(body.getReadingTime());
        found.setContent(body.getContent());
        found.setTitle(body.getTitle());
        found.setCategory(body.getCategory());

        if (found.getAuthor().getId() != body.getAuthorId()) {
            Author newAuthor = authorsService.findById(body.getAuthorId());
            found.setAuthor(newAuthor);
        }
        return blogsRepository.save(found);
    }
    public List<BlogPost> findByAuthor(int authorId){
        Author author = authorsService.findById(authorId);
        return blogsRepository.findByAuthor(author);
    }
}
