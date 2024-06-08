package com.coevolution;

public class Tuple<A, B> {
    private A first;
    private B second;

    public Tuple() {
    }

    public Tuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A newFirst) {
        this.first = newFirst;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B newSecond) {
        this.second = newSecond;
    }
}
