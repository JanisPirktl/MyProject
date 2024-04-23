package DesignPatterns.Adapter.anothaAdapta;

public class Main {
    public static void main(String[] args) {
        XmlData xmlData = new XmlData("Im XmlData");

        AppInterface app = new App();
        app.displayData(xmlData);

        AppInterface adapter = new FancyAppAdapter();
        adapter.displayData(xmlData);
    }
}


class App implements AppInterface {
    @Override
    public void displayData(XmlData xmlData) {
        System.out.println(xmlData.getData());
    }
}
class FancyApp {
    public void displayData(JsonData jsonData) {
        System.out.println(jsonData.getData());
    }
}

class FancyAppAdapter implements AppInterface {
    private final FancyApp fancyApp;
    public FancyAppAdapter() {
        fancyApp = new FancyApp();
    }
    @Override
    public void displayData(XmlData xmlData) {
        JsonData jsonData = convertXmlToJson(xmlData);
        fancyApp.displayData(jsonData);
    }
    private JsonData convertXmlToJson(XmlData xmlData) {
        return new JsonData(xmlData.getData());
    }
}

interface AppInterface {
    void displayData(XmlData xmlData);
}

class XmlData {
    private final String data;
    public XmlData(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }
}

class JsonData {
    private final String data;
    public JsonData(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }
}
