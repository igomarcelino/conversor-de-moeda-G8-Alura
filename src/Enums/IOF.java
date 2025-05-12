package Enums;

public enum IOF {
    DINHEIRO(1.0110),
    CARTAO(1.0338);

    private final double taxa;

    IOF(double taxa) {
        this.taxa = taxa;
    }

    public double getTaxa() {
        return taxa;
    }
}
