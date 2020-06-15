package cci.data.structures;

import java.util.Arrays;

public class StringBuilder
{
    private static final int DEFAULT_CAPACITY = 16;

    private char[] arr;

    private int size;

    public StringBuilder()
    {
        arr = new char[DEFAULT_CAPACITY];
    }

    public StringBuilder(int size)
    {
        arr = new char[size];
    }

    public StringBuilder(String str)
    {
        arr = new char[str.length() + DEFAULT_CAPACITY];
        this.append(str);
    }

    public StringBuilder(CharSequence str)
    {
        arr = new char[str.length() + DEFAULT_CAPACITY];
        this.append(str);
    }

    public void append(String str)
    {
        if (str == null)
        {
            appendNull();
        }
        else
        {
            int var2 = str.length();
            this.ensureCapacityInternal(this.size + var2);
            str.getChars(0, str.length(), arr, size);
            size += var2;
        }
    }

    public void append(char ch)
    {
        append(new char[] { ch });
    }

    public void append(CharSequence str)
    {
        if (str == null)
        {
            appendNull();
        }
        else if (str instanceof String)
        {
            this.append((String) str);
        }
        else
        {
            this.append((CharSequence) str, 0, str.length());
        }
    }

    private void append(CharSequence str, int i, int length)
    {
        for (int j = i; j < length; j++)
        {
            append(str.charAt(j));
        }
    }

    public void append(int str)
    {
        append(String.valueOf(str));
    }

    public void append(double str)
    {
        append(String.valueOf(str));
    }

    public void append(char[] arr)
    {
        if (arr == null)
        {
            appendNull();
        }
        else
        {
            int var2 = arr.length;
            this.ensureCapacityInternal(this.size + var2);
            for (int i = 0; i < arr.length ; i++)
            {
                this.arr[size++] = arr[i];
            }
            this.size += var2;
        }
    }

    public String toString()
    {
        return new String(arr);
    }

    private void add(char[] newString)
    {
        for (int i = size; i < newString.length + size; i++)
        {
            arr[size] = newString[newString.length - size - i];
        }
    }

    private void ensureCapacity(int var1)
    {
        if (var1 > 0)
        {
            this.ensureCapacityInternal(var1);
        }

    }

    private void ensureCapacityInternal(int var1)
    {
        if (var1 - this.arr.length > 0)
        {
            this.arr = Arrays.copyOf(this.arr, this.newCapacity(var1));
        }

    }

    private int newCapacity(int var1)
    {
        int var2 = (this.arr.length << 1) + 2;
        if (var2 - var1 < 0)
        {
            var2 = var1;
        }

        return var2 > 0 && 2147483639 - var2 >= 0 ? var2 : this.hugeCapacity(var1);
    }

    private int hugeCapacity(int var1)
    {
        if (2147483647 - var1 < 0)
        {
            throw new OutOfMemoryError();
        }
        else
        {
            return var1 > 2147483639 ? var1 : 2147483639;
        }
    }

    private void appendNull()
    {
        append(new char[] { 'N', 'u', 'l', 'l' });
    }
}