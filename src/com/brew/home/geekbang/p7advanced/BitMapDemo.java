package com.brew.home.geekbang.p7advanced;

public class BitMapDemo {

    public static void main(String[] args) {

    }
}


class BitMap { // Java中char类型占16bit，也即是2个字节
    private char[] bytes;
    private int nbits;

    public BitMap(int nbits) {
        this.nbits = nbits;
        this.bytes = new char[nbits/16+1];
    }

    public void set(int k) {
        if (k > nbits) return;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        // 完整的写法是：bytes[byteIndex] = bytes[byteIndex] | (1 << bitIndex);
        //坑，1 << bitIndex是说1左移bitIndex位... 服了我这脑子
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k) {
        if (k > nbits) return false;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }
}
