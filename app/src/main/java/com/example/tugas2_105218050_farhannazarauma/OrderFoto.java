package com.example.tugas2_105218050_farhannazarauma;

public class OrderFoto {
    private KatalogFoto katalogFoto;
    private String ukuran;

    private int numOrder;
    private double hargaSubtotal;

    public OrderFoto(KatalogFoto _katalogFoto, int _numOrder, String _ukuran,
                     double _hargaSubtotal){
        katalogFoto = _katalogFoto;
        setNumOrder(_numOrder);
        ukuran = _ukuran;
        setHargaSubtotal(_hargaSubtotal);

    }

    public KatalogFoto getKatalogFoto(){
        return katalogFoto;
    }

    public int getNumOrder() {
        return numOrder;
    }

    public String getUkuran() {
        return ukuran;
    }

    public double getHargasubtotal() {
        return getHargaSubtotal();
    }

    public void setNumOrder(int numOrder) {
        this.numOrder = numOrder;
    }

    public double getHargaSubtotal() {
        return hargaSubtotal;
    }

    public void setHargaSubtotal(double hargaSubtotal) {
        this.hargaSubtotal = hargaSubtotal;
    }
}
