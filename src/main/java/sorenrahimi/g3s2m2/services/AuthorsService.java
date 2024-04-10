package sorenrahimi.g3s2m2.services;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sorenrahimi.g3s2m2.entities.Author;
import sorenrahimi.g3s2m2.exceptions.NotFoundException;
import sorenrahimi.g3s2m2.repositories.AuthorsRepository;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AuthorsService {
    @Autowired
    private AuthorsRepository authorsRepository;

    public Author save(Author body) {
        authorsRepository.findByEmail(body.getEmail()).ifPresent(user -> {
            try {
                throw new BadRequestException("L'email " + body.getEmail() +
                        "è gia stata utilizzata");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        });
        body.setAvatar("https://ui-avatars.com/api/?name=" +
                body.getNome().charAt(0) + "+" + body.getCognome().charAt(0));
        return authorsRepository.save(body);
    }

    public Page<Author> getAuthors(int page, int size, String sort) {
       Pageable pageable = (Pageable) PageRequest.of(page, size, Sort.by(sort));
       return authorsRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }

    public Author findById(int id) {
        return authorsRepository.findById(id).orElseThrow(() -> new
                NotFoundException(id));
    }

    public Author findByIdAndUpdate(int id, Author body) {
        Author found = this.findById(id);
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setEmail(body.getEmail());
        found.setDataDiNascita(body.getDataDiNascita());
        found.setAvatar(body.getAvatar());
        return authorsRepository.save(found);
    }

        public void findByIdAndDelete(int id){
            Author found = this.findById(id);
            authorsRepository.delete(found);
        }
    }

