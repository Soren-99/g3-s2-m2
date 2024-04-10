package sorenrahimi.g3s2m2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sorenrahimi.g3s2m2.entities.Author;
import sorenrahimi.g3s2m2.services.AuthorsService;


@RestController
@RequestMapping("/authors")
public class AuthorsController {
    @Autowired
    AuthorsService authorsService;

    @GetMapping
    public Page<Author> getAuthors(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size,
                           @RequestParam(defaultValue = "id") String sortBy) {
        return authorsService.getAuthors(page, size, sortBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author body) throws Exception{
        return authorsService.save(body);
    }

    @GetMapping("/{authorId}")
    public Author findById(@PathVariable int authorId){
    return authorsService.findById(authorId);
    }

    @PutMapping("/{authorId}")
    private Author findUserByIdAndUpdate(@PathVariable int authorId, @RequestBody Author body){
        return authorsService.findByIdAndUpdate(authorId, body);
    }

    // 5. DELETE http://localhost:3001/blogPosts/{userId}
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findByIdAndDelete(@PathVariable int authorId){
        authorsService.findByIdAndDelete(authorId);
    }
}

