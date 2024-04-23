package DesignPatterns.Command;

public class Main {
    public static void main(String[] args) {

        Room livingRoom = new LivingRoom(25);

        livingRoom.setCommand(
                new SwitchLightsCommand(
                        new Light(true)));

        livingRoom.executeCommand();
    }
}

interface Command {
    void execute();
}

class SwitchLightsCommand implements Command {
    private Light light;
    public SwitchLightsCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.switchLights();
    }
}

class Light {
    private boolean isOn;
    public Light(boolean isOn) {
        this.isOn = isOn;
    }
    public void switchLights() {
        isOn = !isOn;
    }
}

abstract class Room {
    private Command command;
    private final int size;
    protected Room(int size) {
        this.size = size;
    }
    public void setCommand(Command command) {
        this.command = command;
    }
    public void executeCommand() {
        command.execute();
    }
}

class LivingRoom extends Room {
    public LivingRoom(int size) {
        super(size);
    }
}
