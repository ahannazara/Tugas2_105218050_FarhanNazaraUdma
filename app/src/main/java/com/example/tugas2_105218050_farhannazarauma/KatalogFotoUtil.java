package com.example.tugas2_105218050_farhannazarauma;

import java.util.ArrayList;
import java.util.List;

public class KatalogFotoUtil {
    private static int[] ridArray = {
            R.drawable.food1,
            R.drawable.food2,
            R.drawable.food3,
            R.drawable.food4,
            R.drawable.food5,
            R.drawable.food6,
            R.drawable.food7,
            R.drawable.food8,
            R.drawable.food9,
            R.drawable.food10
    };

    private static String[] filenameArray ={
            "food1",
            "food2",
            "food3",
            "food4",
            "food5",
            "food6",
            "food7",
            "food8",
            "food9",
            "food10",
    };

    private static List<KatalogFoto> katalogFotoList;

    public static void init(){
        katalogFotoList = new ArrayList<>();
        int nArray = ridArray.length;
        for(int i=0;i<nArray;i++){
            katalogFotoList.add(new KatalogFoto(ridArray[i],filenameArray[i]));
        }
    }

    public static List<KatalogFoto> getKatalogFotoList(){

            return katalogFotoList;

    }

    public static KatalogFoto getKatalogFotoAt(int i){
        return katalogFotoList.get(i);
    }

}
