package cci.ch.recursion8dynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class TowersOfHanoi
{
/*    Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
    different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order
    of size from top to bottom (Le., each disk sits on top of an even larger one). You have the following
    constraints:
                       (1) Only one disk can be moved at a time.
                       (2) A disk is slid off the top of one tower onto another tower.
                       (3) A disk cannot be placed on top of a smaller disk.

    Write a program to move the disks from the first tower to the last using stacks.

    Hints: # 144, #224, #250, #272, #318
*/

    public void sol(int m, int n)
    {
        List<Stack<Integer>> towers = init(m, n);
        int lastEmptyTower = Integer.MAX_VALUE;

        while (!lastTowerIsFull(towers, n))
        {
            //  move Disks To closest Tower for every tower
            for (int i = 0; i < towers.size(); i++)
            {
                boolean towerIsEmpty = moveSmallestDisksToClosestTower(towers, i);
                if (towerIsEmpty && lastEmptyTower > i)
                {
                    handleEmptyTower(towers, i);
                    lastEmptyTower = i;
                    break;
                }
            }
        }

        for (int i = 0; i < towers.size(); i++)
        {
            System.out.println(towers.get(i));
        }
    }

    private boolean moveSmallestDisksToClosestTower(List<Stack<Integer>> towers, int towerIndex)
    {

        if (isLastTower(towerIndex, towers))
        {
            return false;
        }

        Stack<Integer> currTower = towers.get(towerIndex);
        for (int i = towerIndex + 1; i < towers.size(); i++)
        {

            Stack<Integer> closestTower = towers.get(i);
            int disk = currTower.peek();

            if (canPushDiskToTower(closestTower, disk))
            {
                closestTower.push(disk);
                currTower.pop();
            }
        }

        return currTower.isEmpty();
    }

    private void handleEmptyTower(List<Stack<Integer>> towers, int emptyTowerIndex)
    {
        int towerWithLargestTopDisk = findTowerWithLargestTopDisk(towers);

        if (towerWithLargestTopDisk < emptyTowerIndex)
        {
            moveDisk(towerWithLargestTopDisk, emptyTowerIndex, towers);
            moveSmallestDisksToFurthestTower(towers);
        }
        else
        {
            int towerIndex = towerWithSmallestTopDisk(towers);

            moveDisk(towerIndex, towerIndex + 1, towers);//moveSmallestDiskToFollowingTower
            moveDisk(towerIndex, towerIndex - 1, towers);//moveTheSecondSmallestDiskToPreviousTower
            moveDisk(towerIndex + 1, towerIndex - 1, towers);//moveSmallestDiskToFollowingTower
            moveDisk(towerIndex, towerIndex + 1, towers);// //moveTheSecondLargestDiskToFollowingTower
        }

    }

    private int findTowerWithLargestTopDisk(List<Stack<Integer>> towers)
    {
        return findTowerWithLargestOrSmallestTopDisk(towers, true);
    }

    private int towerWithSmallestTopDisk(List<Stack<Integer>> towers)
    {
        return findTowerWithLargestOrSmallestTopDisk(towers, false);
    }

    private void moveDisk(int from, int to, List<Stack<Integer>> towers)
    {
        Stack<Integer> toTower = towers.get(to);
        Stack<Integer> fromTower = towers.get(from);

        int disk = fromTower.pop();
        toTower.push(disk);
    }

    private void moveSmallestDisksToFurthestTower(List<Stack<Integer>> towers)
    {
        for (int i = towers.size() - 1; i >= 0; i--)
        {
            Stack<Integer> currTower = towers.get(i);
            for (int j = 0; j < towers.size(); j++)
            {
                Stack<Integer> furthestTower = towers.get(j);

                if (currTower.isEmpty() || furthestTower.isEmpty())
                {
                    break;
                }

                int disk = currTower.peek();

                if (canPushDiskToTower(furthestTower, disk))
                {
                    furthestTower.push(disk);
                    currTower.pop();
                }
            }
        }
    }

    private int findTowerWithLargestOrSmallestTopDisk(List<Stack<Integer>> towers, boolean largest)
    {
        return IntStream.range(0, towers.size())
                        .reduce((index, curr) -> {
                                    Stack<Integer> tower = towers.get(index);
                                    Stack<Integer> currTower = towers.get(curr);

                                    if (currTower.isEmpty() || tower.isEmpty())
                                    {
                                        return currTower.isEmpty() ? index : curr;
                                    }

                                    if (largest)
                                    {
                                        return currTower.peek() > tower.peek() ? curr : index;
                                    }
                                    return currTower.peek() < tower.peek() ? curr : index;
                                }
                        ).getAsInt();
    }

    private boolean canPushDiskToTower(Stack<Integer> tower, int disk)
    {
        if (tower.isEmpty())
        {
            return true;
        }

        int topDisk = tower.peek();
        return topDisk > disk;
    }

    private boolean isLastTower(int towerIndex, List<Stack<Integer>> towers)
    {
        return towers.size() - 1 == towerIndex;
    }

    private boolean lastTowerIsFull(List<Stack<Integer>> towers, int expectedSize)
    {

        int lastIndex = towers.size() - 1;
        Stack<Integer> lastTower = towers.get(lastIndex);
        System.out.println(lastTower.size());
        return lastTower.size() >= expectedSize;
    }

    private List<Stack<Integer>> init(int m, int n)
    {
        if (m < 3)
        {
            throw new IllegalArgumentException("Number of Tower has to be more than three");
        }
        List<Stack<Integer>> towers = createTowers(m);
        addDisksToFirstTower(towers.get(0), n);
        return towers;
    }

    private void addDisksToFirstTower(Stack<Integer> tower, int n)
    {
        for (int i = n; i > 0; i--)
        {
            tower.add(i);
        }

    }

    private List<Stack<Integer>> createTowers(int towerNum)
    {
        List<Stack<Integer>> stacks = new ArrayList<>();
        IntStream.range(0, towerNum).forEach(i -> stacks.add(new Stack<Integer>()));
        return stacks;
    }

    public static void main(String[] args)
    {
        new TowersOfHanoi().sol(3, 4);
    }
}
