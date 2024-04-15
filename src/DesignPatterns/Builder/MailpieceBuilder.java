package DesignPatterns.Builder;

import java.util.ArrayList;
import java.util.List;

class MailpieceBuilder {

    private String identifier = "11111";
    private List<Barcode> barcodes = new ArrayList<>(List.of(new Barcode("QR", "222344822"),
            new Barcode("Matrix", "114848")));
    private boolean isLetter = false;

    public MailpieceBuilder setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public MailpieceBuilder setBarcodes(List<Barcode> barcodes) {
        this.barcodes = barcodes;
        return this;
    }

    public MailpieceBuilder setIsLetter(boolean isLetter) {
        this.isLetter = isLetter;
        return this;
    }

    public Mailpiece build() {
        return new Mailpiece(identifier, barcodes, isLetter);
    }
}
