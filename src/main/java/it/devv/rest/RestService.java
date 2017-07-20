package it.devv.rest;

import it.devv.data.Data;
import it.devv.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by oleg on 7/20/17
 * <br/>
 *
 * Rest endpoint for search engine
 *
 */
@RestController
@RequestMapping("/api")
public class RestService {
    private final SearchService searchService;

    @Autowired
    public RestService(SearchService searchService) {
        this.searchService = searchService;
    }


    /**
     * @param query search string
     * @return set of data which search service find in our data base
     */
    @GetMapping
    @RequestMapping("/search")
    public Set<Data> search(@PathParam("query") Optional<String> query) {
        return query.map(searchService::search).orElse(new HashSet<>());
    }
}
