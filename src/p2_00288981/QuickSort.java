package p2_00288981;

public class QuickSort {

    private Card[] nums;

    public QuickSort(Card[] hand) {
        this.nums = hand;
    }

    private void quicksort(int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivot = partition(lowIndex, highIndex);
        quicksort(lowIndex, pivot - 1);
        quicksort(pivot + 1, highIndex);

    }

    public Card[] sort() {
        quicksort(0, nums.length - 1);

        return nums;
    }

    private void elementSwitch(int x, int y) {
        Card z = nums[x];
        nums[x] = nums[y];
        nums[y] = z;
    }

    private int partition(int lowIndex, int highIndex) {
        int pivotIndex = (lowIndex + highIndex) / 2;
        elementSwitch(pivotIndex, highIndex);
        int z = lowIndex;

        for (int i = lowIndex; i < highIndex; i++) {
            if (nums[i].getFace() >= nums[highIndex].getFace()) {
                elementSwitch(z, i);
                z++;

            }

        }
        elementSwitch(z, highIndex);

        return z;
    }

}
