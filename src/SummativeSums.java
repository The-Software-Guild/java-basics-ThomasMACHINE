public class SummativeSums {

    public static void main(String[] args) {
        int[] arr1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 },
                arr2 = { 999, -60, -77, 14, 160, 301},
                arr3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
                        140, 150, 160, 170, 180, 190, 200, -99 };

        System.out.println("Arr1 sum: " + sumArray(arr1));
        System.out.println("Arr2 sum: " + sumArray(arr2));
        System.out.println("Arr3 sum: " + sumArray(arr3));
    }

    public static int sumArray(int[] arr){
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

}
