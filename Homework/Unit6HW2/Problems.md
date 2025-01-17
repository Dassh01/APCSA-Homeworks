# Unit6HW2 Answers
## Exercise R7.6:
There is no error, syntax or logic present in this problem
## Exercise R7.7:
### Problem A)
```java
import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] intArr = new int[10];
        int index = -1;
        for (int input = 1; input < intArr.length+1; ++input) {
            ++index;
            intArr[index] = input;
        }
        System.out.println(Arrays.toString(intArr));
    }
}
```
### Problem B)
```java
import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] intArr = new int[11];
        int input = -2;
        for (int index = 0; index < intArr.length; ++index) {
            input+=2;
            intArr[index] = input;
        }
        System.out.println(Arrays.toString(intArr));
    }
}
```
### Problem C)
```java
import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] intArr = new int[10];
        int input = 0;
        for (int index = 0; index < intArr.length; ++index) {
            input+=(index*2)+1;
            intArr[index] = input;
        }
        System.out.println(Arrays.toString(intArr));
    }
}
```
### Problem D)
```java
import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] intArr = new int[10];
        int input = 0;
        for (int index = 0; index < intArr.length; ++index) {
            input+=0;
            intArr[index] = input;
        }
        System.out.println(Arrays.toString(intArr));
    }
}
```
## Exercise R7.8:
```java
import java.util.Arrays;
import java.util.Random;

class Scratch {
    public static void main(String[] args) {
        Random random = new Random();
        int[] intArr = new int[10];
        int lowerBound = 1;
        int upperBound = 100;
        for (int index = 0; index < intArr.length; ++index) {
            int input = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            intArr[index] = input;
        }
        System.out.println(Arrays.toString(intArr));
    }
}
```
## Exercise 7.9:
The loop will try to access a position outside of the bounds of the array,
this can be fixed by changing the loop's conditional to cut the loop before the array's bounds are exceeded or
breaking the loop at ```i == data.length-1;```

## Exercise 7.10:
Elements in an integer array without an assigned value will have the default value of 0

## Exercise 7.11:
### Problem A)
```java
for (int i = 0; i < (data.length-1); ++i) { sum = sum + data[i]; }
```
### Problem B)
```java
for (int i = 0; i < (data.length-1); ++i) {
        if(data[i]==target){
            return true;
        }
}
```
### Problem C)
```java
int i = 0;
for (int i = 0; i < (data.length-1); ++i) {
    this.i = i;
        }
```

