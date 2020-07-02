package cci.chapters.tree8graph;

import java.util.function.Consumer;

public class Main
{

    static class FizzBuzz extends Thread
    {
        public static enum DIVISIBLE
        {THREE, FIVE, BOTH;}

        private DIVISIBLE divisible;

        private Consumer<Integer> consumer;

        private int n;

        FizzBuzz(DIVISIBLE divisible, int n)
        {
            this.n = n;
            this.divisible = divisible;
            initConsumer();
        }

        private void initConsumer()
        {
            switch (divisible)
            {
            case FIVE:
                consumer = divisibleByFive();
                return;
            case THREE:
                consumer = divisibleByThree();
                return;
            case BOTH:
                consumer = divisibleByBoth();
                return;
            }
        }

        public void run()
        {
            int i = 0;
            while (i <= n)
            {
                consumer.accept(i);
                i++;
            }
        }

        private Consumer<Integer> divisibleByFive()
        {
            return num ->
            {
                if (divisibleBy(num, 5) && !divisibleBy(num, 3))
                {
                    System.out.println("Buzz");
                }
            };
        }

        private Consumer<Integer> divisibleByThree()
        {
            return num ->
            {
                if (divisibleBy(num, 3) && !divisibleBy(num, 5))
                {
                    System.out.println("Fizz");
                }
            };

        }

        private Consumer<Integer> divisibleByBoth()
        {
            return num ->
            {
                if (divisibleBy(num, 3) && divisibleBy(num, 5))
                {
                    System.out.println("FizzBuzz");
                }
            };

        }

        private boolean divisibleBy(int num, int by)
        {
            return num % by == 0;
        }
    }

    public static void main(String[] args)
    {
        int n = 5;
        new FizzBuzz(FizzBuzz.DIVISIBLE.THREE, n).start();
        new FizzBuzz(FizzBuzz.DIVISIBLE.FIVE, n).start();
        new FizzBuzz(FizzBuzz.DIVISIBLE.BOTH, n).start();
    }
}
