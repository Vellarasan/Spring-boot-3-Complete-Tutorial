package vels.io.spring.boot3.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import vels.io.spring.boot3.model.Content;
import vels.io.spring.boot3.model.Status;
import vels.io.spring.boot3.model.Type;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contents = new ArrayList<>();

    public ContentCollectionRepository() {
        // Empty public Constructor
    }

    public List<Content> findAll() {
        return contents;
    }

    public Optional<Content> findById(Integer id) {
        return contents.stream().filter(eachContent -> eachContent.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contents.removeIf(eachContent -> eachContent.id().equals(content.id()));
        contents.add(content);
    }

    public boolean existById(Integer id) {
        return contents.stream().anyMatch(eachContent -> eachContent.id().equals(id));
    }

    public void delete(Integer id) {
        contents.removeIf(eachContent -> eachContent.id().equals(id));
    }

    @PostConstruct
    private void init() {
        Content content = new Content(1,
                "Hello World",
                "First Content to be published",
                Status.TO_DO,
                Type.TEXT,
                LocalDateTime.now(),
                null,
                "");
        contents.add(content);
    }
}
