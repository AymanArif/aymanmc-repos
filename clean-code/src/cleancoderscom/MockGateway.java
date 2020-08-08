package cleancoderscom;

import java.util.ArrayList;
import java.util.List;

public class MockGateway implements Gateway {


    private List<Codecast> codecasts;
    private List<User> users;

    public MockGateway(){
        codecasts = new ArrayList<>();
        users = new ArrayList<>();// FIXME: <User>
    }

    @Override
    public List<Codecast> findAllCodeCasts() {
        return codecasts;
    }

    @Override
    public void deleteOne(Codecast codecast) {
        codecasts.remove(codecast);
    }

    @Override
    public void saveCodeCast(Codecast codecast) {
        codecasts.add(codecast); // Add codecast to ArrayList
    }

    @Override
    public void addUser(String username) {
        User user = new User(username) ;
        save(user);
    }

    @Override
    public void save(User user){

    }

}
