package sample.database;

import com.google.inject.persist.PersistService;

import javax.inject.Inject;

public class JPAInitializer {
    @Inject
    JPAInitializer(PersistService service) {
        service.start();
        // At this point JPA is started and ready.
    }
}
