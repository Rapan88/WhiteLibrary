package com.example.demo.models;

public class Count
{
    private int count;

    public Count()
    {
        count = -1;
    }

    public Count(int init)
    {
        count = init;
    }

    public int get()
    {
        return count;
    }

    public void clear()
    {
        count = 0;
    }

    public int incrementAndGet()
    {
        return ++count;
    }

    public String toString()
    {
        return ""+count;
    }
}
