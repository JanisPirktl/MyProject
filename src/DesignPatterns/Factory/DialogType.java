package DesignPatterns.Factory;

public enum DialogType {

  WINDOWS("WIN"),
  CONSOLE("CONS");

  final String type;

  DialogType(String type) {
    this.type = type;
  }
}
