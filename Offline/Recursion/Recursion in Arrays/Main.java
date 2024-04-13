class Main {
    public static int[] allOccurrences(int[] arr, int idx, int tar, int count){
        if(idx == arr.length){
            int[] ba = new int[count];
            return ba;
        }

        int[] ans;
        if(arr[idx] == tar){
            ans = allOccurrences(arr, idx + 1, tar, count + 1);
        } else {
            ans = allOccurrences(arr, idx + 1, tar, count);
        }

        if(arr[idx] == tar){
            ans[count] = idx;
        }

        return ans;
    }
    public static int LastOccurrence(int[] arr, int idx, int tar){
        if(idx == arr.length){
            return -1;
        }

        int lastOccurrenceValue = LastOccurrence(arr, idx+1, tar);

        if(lastOccurrenceValue == -1){
            if(arr[idx] == tar){
                return idx;
            }
        }

        return lastOccurrenceValue;
    }

    public static int firstOccurrence(int[] arr, int idx, int tar){
        if(idx == arr.length){
            return -1;
        }

        int furtherFirstOccurrence = firstOccurrence(arr, idx+1, tar);

        if(arr[idx] == tar){
            return idx;
        } 

        return furtherFirstOccurrence;
    }

    public static void printArrayReverse(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }

        printArrayReverse(arr, idx + 1);
        System.out.println(arr[idx]);
    }

    public static void printArray(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }

        System.out.println(arr[idx]);
        printArray(arr, idx + 1); 
    }

    public static void main(String[] args){
       int[] arr  = {5, 9, 10, 11, 8, 11, 11, 4, 5};
       System.out.println(LastOccurrence(arr,0,11));
    }
}