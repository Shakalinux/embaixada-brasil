package br.com.embaixada.model;

public enum PassportStatus {
    BLOQUEADO("BLOQUEADO"),
    ATIVO("ATIVO");

    private final String displayName;
    PassportStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
