package DesignPatterns.Adapter;

// You get the request to replace the SimplePasswordGenerator
// with the FancyPasswordGeneratorFromLibrary.
// To do this, you must not touch the CreateUserAccountCommand.
// However, the FancyPasswordGeneratorFromLibrary class
// is from a library and the interface IPasswordGenerator isn't implemented.
public class Program {
    public static void main(String[] args) {
        CreateUserAccountCommand command = new CreateUserAccountCommand(new Adapter());
        command.execute();
    }
}
// ------------ Part of a library ------------
class FancyPasswordGeneratorFromLibrary {
    public String createPassword() {
        return "fancy";
    }
}
// -------------------------------------------
class CreateUserAccountCommand {
    private IPasswordGenerator generator;
    public CreateUserAccountCommand(IPasswordGenerator generator) {
        this.generator = generator;
    }
    public void execute(){
        String password = this.generator.generatePassword();
        System.out.println( "Created: " + password ) ;
        // Create User...
    }
}


interface IPasswordGenerator {
    String generatePassword();
}

class SimplePasswordGenerator implements IPasswordGenerator {
    @Override
    public String generatePassword(){
        return "simple";
    }
}