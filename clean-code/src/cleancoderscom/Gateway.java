package cleancoderscom;

import java.util.List;

public interface Gateway {
    List<Codecast> findAllCodeCasts();
    void deleteOne(Codecast codecast);

    void saveCodeCast(Codecast codecast);

    void addUser(String username);

    void save(User user);
}
