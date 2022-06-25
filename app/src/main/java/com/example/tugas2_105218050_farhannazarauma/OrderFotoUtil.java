package com.example.tugas2_105218050_farhannazarauma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class OrderFotoUtil {

    private static List<KerajangBelanjaListener> kbListeners;

    private static List<OrderFoto> orderFotoList;
    private static HashMap<String, Double> hargaMap;
    private static double totalHarga;

    public static void initHargaMap() {
        hargaMap = new HashMap<>();
        hargaMap.put("R3" ,800.0) ;
        hargaMap.put("R4",1000.0);
        hargaMap.put("R8",2000.0);
        hargaMap.put("R10",2500.0);
    }

    public static void init(){
        orderFotoList = new ArrayList<>();
        initHargaMap();
        kbListeners = new ArrayList<>();
    }

    public static void addkbListener(KerajangBelanjaListener listener){
        kbListeners.add(listener);
    }

    public static int getOrderCount(){
        return orderFotoList.size();
    }

    public static OrderFoto getOrderAt(int i){
        return orderFotoList.get(i);
    }

    private static void updateKeranjangBelanja(){
        totalHarga=0.0;
        for(OrderFoto order:orderFotoList){
            totalHarga += order.getHargasubtotal();
        }
        for(KerajangBelanjaListener listener:kbListeners){
            listener.OrderChanged();
        }
    }

    public static double getTotalHarga(){
        return totalHarga;
    }

    private static double getHarga(String ukuran){
        Double hargaSatuan = hargaMap.get(ukuran);
        if(hargaMap.get(ukuran)==null)
            hargaSatuan=0.0;
        return  hargaSatuan;
    }

    public static void addOrder(KatalogFoto foto, String ukuran){
            orderFotoList .add(new OrderFoto(foto, 1,ukuran, getHarga(ukuran)));
            updateKeranjangBelanja();
    }

    public static void removeOrderAt(int i){
        orderFotoList.remove(i);
        updateKeranjangBelanja();
    }

    public static void addoneToOrder(int i){
        OrderFoto order = orderFotoList.get(i);
        order.setNumOrder(order.getNumOrder()+1);
        order.setHargaSubtotal(order.getHargaSubtotal() + getHarga(order.getUkuran()));
        updateKeranjangBelanja();
    }
    public static boolean minoneToOrder(int i){
        OrderFoto order = orderFotoList.get(i);
        if(order.getNumOrder()==1)
            return false;

        order.setNumOrder(order.getNumOrder()-1);
        order.setHargaSubtotal(order.getHargaSubtotal() - getHarga(order.getUkuran()));
        updateKeranjangBelanja();
        return true;

    }
}
