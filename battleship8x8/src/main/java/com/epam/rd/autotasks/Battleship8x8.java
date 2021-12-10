package com.epam.rd.autotasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        String temp = Long.toBinaryString(this.ships);
        if(temp.length() == 63){
            temp = String.valueOf(new StringBuffer(temp).insert(0, "0"));
        }
        String[] shootsMap = temp.split("");
        String[] coordinates = shot.split("");
        List<String> alphabets = List.of("A", "B", "C", "D", "E", "F", "G", "H");
        int shotIndex = alphabets.indexOf(coordinates[0]);
        int index = 8 * (Integer.parseInt(coordinates[1]) - 1) + shotIndex;
        this.shots |= 1L << 63 - index;
        return Objects.equals(shootsMap[index], "1");
    }

    public String state() {
        String map = Long.toBinaryString(ships);
        if(map.length() == 63){
            map = String.valueOf(new StringBuffer(map).insert(0, "0"));
        }
        String[] mapAfter = map.split("");
        String temp = Long.toBinaryString(shots);
        if(temp.length() < 64){
            StringBuilder addZero = new StringBuilder(temp);
            for(int i = 0; i < 64-temp.length(); i++){
                addZero.insert(0, "0");
            }
            temp = String.valueOf(addZero);
        }
        String[] shotsMap = temp.split("");
        for(int i = 0; i < shotsMap.length; i++){
            if(shotsMap[i].equals("1")){
                if (shotsMap[i].equals(mapAfter[i])){
                    mapAfter[i] = "☒";
                }else{
                    mapAfter[i] = "×";
                }
            }
        }
        String str = String.join("", mapAfter);
        str = str.replaceAll("0", ".");
        str = str.replaceAll("1", "☐");
        String[] arr = str.split("");
        System.out.println("");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i % 8 == 7){
                System.out.print("\n");
            }
        }
        StringBuilder sb = new StringBuilder(str);
        for(int i = 0; i < str.length(); i++){
            if(i % 9 == 8){
                sb.insert(i, "\n");
            }
        }
        str = String.valueOf(sb);
        return str;
    }
}
