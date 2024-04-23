package DesignPatterns.Factory;

public enum DialogType {
  SWING("WIN"),
  CONSOLE("CONS");
  final String type;
  DialogType(String type) {
    this.type = type;
  }
}
