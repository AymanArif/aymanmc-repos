package cleancoderscom.fixtures;

import cleancoderscom.Codecast;
import cleancoderscom.Context;
import cleancoderscom.MockGateway;

import java.util.ArrayList;
import java.util.List;

public class CodecastPresentation { // Fitenesse fixtures

  public CodecastPresentation() {
    Context.gateway = new MockGateway();
  }

  public boolean addUser(String username){
    Context.gateway.addUser(username);
    return true;
  }

  public boolean loginUser(String username) {
    return false;
  }

  public boolean createLicenseForViewing(String user, String codecast) {
    return false;
  }

  public String presentationUser() {
    return "LOSER!";
  }
  public boolean clearCodecasts() {
    List<Codecast> codecasts = Context.gateway.findAllCodeCasts(); // gateway aka database
    for (Codecast codecast : new ArrayList<Codecast>(codecasts)){
        Context.gateway.deleteOne(codecast);
    }
    return ( Context.gateway.findAllCodeCasts().size() == 0 );
  }

  public int countOfCodecastsPresented() {
    return 0;
  }
}
