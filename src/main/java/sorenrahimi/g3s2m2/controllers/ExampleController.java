package sorenrahimi.g3s2m2.controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/examples")
public class ExampleController {
    @GetMapping("/getexample") // Qua definisco il metodo da utilizzare e la parte finale dell'URL
    public String getExample() {
        // Per contattare questo endpoint dovrò mandare una richiesta GET a http://localhost:numerodiporta/examples/getexample
        return "Ciao io rispondo alle richieste GET";
    }

    @PostMapping("/postexample")
    public String postMapping() {
        // Per contattare questo endpoint dovrò mandare una richiesta POST a http://localhost:numerodiporta/examples/postexample
        return "Ciao io rispondo alle richieste POST";
    }

    @PutMapping("/putexample")
    public String putExample() {
        // Per contattare questo endpoint dovrò mandare una richiesta PUT a http://localhost:numerodiporta/examples/putexample
        return "Ciao io rispondo alle richieste PUT";
    }

    @DeleteMapping("/deleteexample")
    public String deleteExample() {
        // Per contattare questo endpoint dovrò mandare una richiesta DELETE a http://localhost:numerodiporta/examples/deleteexample
        return "Ciao io rispondo alle richieste DELETE";
    }

    @GetMapping("/")
    public String get() {
        // Per contattare questo endpoint dovrò mandare una richiesta GET a http://localhost:numerodiporta/examples/
        return "GET";
    }

    @PostMapping("/")
    public String post() {
        // Per contattare questo endpoint dovrò mandare una richiesta POST a http://localhost:numerodiporta/examples/
        return "POST";
    }

    @PatchMapping("/")
    public String patch() {
        // Per contattare questo endpoint dovrò mandare una richiesta PATCH a http://localhost:numerodiporta/examples/
        return "PATCH";

    }
}
