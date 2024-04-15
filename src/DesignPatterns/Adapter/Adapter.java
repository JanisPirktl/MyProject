package DesignPatterns.Adapter;

public class Adapter implements IPasswordGenerator{
    @Override
    public String generatePassword() {
        return new FancyPasswordGeneratorFromLibrary().createPassword();
    }
}
