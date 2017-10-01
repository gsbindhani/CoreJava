package com.coreJava.algorithm;

import java.util.Arrays;

import com.coreJava.utils.ArrayUtils;

public class LargestMultipleOf3FromArr {

	public static void main(String[] args) {

		int arr[] = { 4, 4, 3, 1, 1, 1 };
		largest3Multiple(arr, arr.length);
	}

	// Returns largest multiple of 3 that can be formed
	// using arr[] elements.
	static boolean largest3Multiple(int arr[], int n) {
		// Sum of all array element
		int sum = Arrays.stream(arr).sum();

		// Sum is divisible by 3 , no need to
		// delete an element
		if (sum % 3 == 0)
			return true;

		// Sort array element in increasing order
		Arrays.sort(arr);

		// Find reminder
		int remainder = sum % 3;

		// If remainder is '1', we have to delete either
		// one element of remainder '1' or two elements
		// of remainder '2'
		if (remainder == 1) {
			int rem_2[] = new int[2];
			rem_2[0] = -1;
			rem_2[1] = -1;

			// Traverse array elements
			for (int i = 0; i < n; i++) {
				// Store first element of remainder '1'
				if (arr[i] % 3 == 1) {
					ArrayUtils.removeAndPrintResult("Number divixible by 3", arr, false, new int[] { i });
					return true;
				}

				if (arr[i] % 3 == 2) {
					// If this is first occurrence of remainder 2
					if (rem_2[0] == -1)
						rem_2[0] = i;

					// If second occurrence
					else if (rem_2[1] == -1)
						rem_2[1] = i;
				}
			}

			if (rem_2[0] != -1 && rem_2[1] != -1) {
				ArrayUtils.removeAndPrintResult("Number divixible by 3", arr, false, rem_2);
				return true;
			}
		}

		// If remainder is '2', we have to delete either
		// one element of remainder '2' or two elements
		// of remainder '1'
		else if (remainder == 2) {
			int rem_1[] = new int[2];
			rem_1[0] = -1;
			rem_1[1] = -1;

			// traverse array elements
			for (int i = 0; i < n; i++) {
				// store first element of remainder '2'
				if (arr[i] % 3 == 2) {
					ArrayUtils.removeAndPrintResult("Number divixible by 3", arr, false, new int[] { i });
					return true;
				}

				if (arr[i] % 3 == 1) {
					// If this is first occurrence of remainder 1
					if (rem_1[0] == -1)
						rem_1[0] = i;

					// If second occurrence
					else if (rem_1[1] == -1)
						rem_1[1] = i;
				}
			}

			if (rem_1[0] != -1 && rem_1[1] != -1) {
				ArrayUtils.removeAndPrintResult("Number divixible by 3", arr, false, rem_1);
				return true;
			}
		}
		return false;
	}

}
